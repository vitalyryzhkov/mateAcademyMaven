package com.homework.lesson12;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ParseToJson {
    public void parseToJson() {
        MyTubeParser myTubeParser = new MyTubeParser();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(myTubeParser.getCommentsList());
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
