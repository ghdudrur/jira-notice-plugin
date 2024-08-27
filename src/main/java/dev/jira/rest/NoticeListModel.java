package dev.jira.rest;

import javax.xml.bind.annotation.*;
import java.util.*;
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class NoticeListModel {
    @XmlElement(name = "list")
    public List<NoticeDetailModel> list;
   

    public NoticeListModel() {
        this.list = new ArrayList();
        
    }
}