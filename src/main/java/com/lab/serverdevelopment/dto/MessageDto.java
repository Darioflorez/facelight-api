package com.lab.serverdevelopment.dto;

import com.lab.serverdevelopment.models.MessageType;

/**
 * Created by Dario on 2015-11-22.
 */
public class MessageDto {

    private String subject;
    private String content;
    private MessageType type;
    private Long sender;
    private Long receiver;

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
