package com.homework.lesson12;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.CommentThreadListResponse;
import com.google.api.services.youtube.model.VideoListResponse;
import lombok.Getter;
import lombok.ToString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.homework.lesson12.MyTube.getService;

@ToString
@Getter

public class MyTubeParser {
    private static final String DEVELOPER_KEY = "src/main/resources/dev.txt";
    private String videoId = "BiVLUgJ5UdY";
    private String videoTitle;
    private List<Comment> commentsList = new ArrayList<>();

    public void videoTitleParsing() throws IOException, GeneralSecurityException {
        String devKey = Files.lines(Paths.get(DEVELOPER_KEY)).reduce("", String::concat);

        YouTube youtubeService = getService();
        YouTube.Videos.List request = youtubeService.videos()
                .list("snippet");
        VideoListResponse response = request.setKey(devKey)
                .setId(videoId)
                .execute();
        videoTitle = response.getItems().get(0).getSnippet().getTitle();
    }

    public void commentsParsing() throws GeneralSecurityException, IOException {
        String devKey = Files.lines(Paths.get(DEVELOPER_KEY)).reduce("", String::concat);

        YouTube youtubeService = getService();
        YouTube.CommentThreads.List request = youtubeService.commentThreads()
                .list("snippet");
        CommentThreadListResponse response = request.setKey(devKey)
                .setVideoId(videoId)
                .execute();
        response.getItems().stream().map(commentThread ->
                commentThread.getSnippet().getTopLevelComment().getSnippet())
                .forEach(commentSnippet -> {
                    Comment comment = new Comment();
                    comment.setAuthorName(commentSnippet.getAuthorDisplayName());
                    comment.setTextMessage(commentSnippet.getTextDisplay());
                    comment.setCountLikes(commentSnippet.getLikeCount());
                    comment.setTimeLastChange(commentSnippet.getPublishedAt());
                    comment.isEdit(!Objects.equals(commentSnippet.getUpdatedAt(), commentSnippet.getPublishedAt()));
                    commentsList.add(comment);
                });

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(commentsList);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
