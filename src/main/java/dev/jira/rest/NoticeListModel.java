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
        NoticeDetailModel notice = new NoticeDetailModel(123);
        NoticeDetailModel notice2 = new NoticeDetailModel(1);
        NoticeDetailModel notice3 = new NoticeDetailModel(3);
        
        this.list.add(notice);
        this.list.add(notice2);
        this.list.add(notice3);
    }
}