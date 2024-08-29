package dev.jira.rest;

import javax.xml.bind.annotation.*;

import dev.jira.ao.Notice;

import java.text.SimpleDateFormat;
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
    public String date;

    public NoticeDetailModel(){
        
    }


    public NoticeDetailModel(Notice notice){
        this.id = notice.getID();
        this.title = notice.getSubject();
        this.context = notice.getContext();
        this.writer = notice.getCreator();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
        this.date = simpleDateFormat.format(notice.getCreateDate());
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
    
    public String getDate(){
        return this.date;
    }
}