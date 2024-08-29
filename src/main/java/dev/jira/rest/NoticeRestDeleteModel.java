package dev.jira.rest;

import javax.xml.bind.annotation.*;
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class NoticeRestDeleteModel {

    @XmlElement(name = "value")
    private String message;
    private int noticeId;

    public NoticeRestDeleteModel() {
    }

    public NoticeRestDeleteModel(String message, int noticeId) {
        this.message = message;
        this.noticeId = noticeId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }
}