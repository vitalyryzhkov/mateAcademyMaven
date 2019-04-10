package com.homework.lesson12;

import com.google.api.client.util.DateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Comment {
    private String authorName;
    private String textMessage;
    private long countLikes;
    private DateTime timeLastChange;
    private boolean isEdit;
}
