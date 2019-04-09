package com.homework.lesson12;

import com.google.api.client.util.DateTime;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Comment {
    private String authorName;
    private String textMessage;
    private long countLikes;
    private DateTime timeLastChange;
    private boolean isEdit;

    public void isEdit(boolean b) {

    }
}
