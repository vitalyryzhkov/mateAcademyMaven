package com.homework.lesson12;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class MyTube {
    private static final Logger LOGGER = Logger.getLogger(MyTube.class);
    private static final String APPLICATION_NAME = "API code samples";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    public static void main(String[] args) {
        try {
            new MyTubeParser().videoTitleParsing();
            new MyTubeParser().commentsParsing();
        } catch (IOException | GeneralSecurityException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new YouTube.Builder(httpTransport, JSON_FACTORY, null)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
}
