package dev.jira.rest;

import javax.xml.bind.annotation.*;
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class NoticeRestModuleModel {

    @XmlElement(name = "value")
    private String message;

    public NoticeRestModuleModel() {
    }

    public NoticeRestModuleModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}