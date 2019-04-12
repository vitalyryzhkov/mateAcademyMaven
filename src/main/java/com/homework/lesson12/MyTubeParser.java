package com.homework.lesson12;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.CommentThreadListResponse;
import com.google.api.services.youtube.model.VideoListResponse;
import lombok.Getter;
import lombok.ToString;
import org.apache.log4j.Logger;

import java.io.File;
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
    private static final Logger LOGGER = Logger.getLogger(MyTubeParser.class);
    private static final String DEVELOPER_KEY = "src/main/resources/dev.txt";
    String devKey;
    YouTube youtubeService;
    private String videoId = "BiVLUgJ5UdY";
    private String videoTitle;
    private List<Comment> commentsList = new ArrayList<>();

    public MyTubeParser() throws IOException, GeneralSecurityException {
        devKey = Files.lines(Paths.get(DEVELOPER_KEY)).reduce("", String::concat);
        youtubeService = getService();
    }

    public void videoTitleParsing() throws IOException {
        YouTube.Videos.List request = youtubeService.videos()
                .list("snippet");
        VideoListResponse response = request.setKey(devKey)
                .setId(videoId)
                .execute();
        videoTitle = response.getItems().get(0).getSnippet().getTitle();
    }

    public void commentsParsing() throws IOException {
        YouTube.CommentThreads.List request = youtubeService.commentThreads()
                .list("snippet");
        CommentThreadListResponse response = request.setKey(devKey)
                .setVideoId(videoId)
                .execute();
        response.getItems().stream().map(commentThread ->
                commentThread.getSnippet().getTopLevelComment().getSnippet())
                .forEach(commentSnippet -> {
                    Comment comment = Comment.builder()
                            .authorName(commentSnippet.getAuthorDisplayName())
                            .textMessage(commentSnippet.getTextDisplay())
                            .countLikes(commentSnippet.getLikeCount())
                            .timeLastChange(commentSnippet.getPublishedAt())
                            .isEdit(!Objects.equals(commentSnippet.getUpdatedAt(), commentSnippet.getPublishedAt()))
                            .build();

                    commentsList.add(comment);
                });

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/parsejson.json"), commentsList);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
