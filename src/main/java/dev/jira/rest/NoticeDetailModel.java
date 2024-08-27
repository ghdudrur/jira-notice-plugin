package dev.jira.rest;

import javax.xml.bind.annotation.*;
import java.util.Date;
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class NoticeDetailModel {

    @XmlElement(name = "id")
    public int id;
    @XmlElement(name = "title")
    public String title;
    @XmlElement(name = "context")
    public String context;
    @XmlElement(name = "writer")
    public String writer;
    @XmlElement(name = "date")
    public Date date;

    public NoticeDetailModel(int id) {
        this.id = id;
        this.title = "제목";
        this.context = "내용";
        this.writer = "ryu";
        this.date = new Date();
    }

    public int getId(){
        return this.id;
    }

    public String getContext(){
        return this.context;
    }

    public String getWriter(){
        return this.writer;
    }

    public String getTitle(){
        return this.title;
    }
    
    public Date getDate(){
        return this.date;
    }
}