package com.example.bewerbungstest.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
;import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter
public class Message {
    private final String messageId;
    private final String messageText;
    private final OffsetDateTime messageDate;
    private final String messageAuthor;
    private final String messageReceiver;
    private final boolean messageEdited;
}
