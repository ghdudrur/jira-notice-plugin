package dev.jira.ao;

import java.util.Date;

import com.atlassian.jira.user.ApplicationUser;

import net.java.ao.Entity;

public interface Notice extends Entity{
    String getSubject();

    void setSubject(String subject);

    String getCreator();

    void setCreator(String string);

    String getContext();

    void setContext(String context);

    Date getUpdateDate();

    void setUpdateDate(Date updateDate);

    Date getCreateDate();

    void setCreateDate(Date createDate);
    
}
