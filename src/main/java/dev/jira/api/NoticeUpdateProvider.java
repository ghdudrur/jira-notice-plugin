package dev.jira.api;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.atlassian.jira.project.Project;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.plugin.PluginParseException;
import com.atlassian.plugin.servlet.PluginHttpRequestWrapper;
import com.atlassian.plugin.spring.scanner.annotation.imports.JiraImport;
import com.atlassian.plugin.web.ContextProvider;

import dev.jira.rest.NoticeDetailModel;
import dev.jira.rest.NoticeListModel;

public class NoticeUpdateProvider 
    implements ContextProvider
{

   private static final Logger LOGGER = Logger.getLogger(NoticeUpdateProvider.class);
  
  @JiraImport
  private final JiraAuthenticationContext jiraAuthenticationContext;

  
  public NoticeUpdateProvider(JiraAuthenticationContext jiraAuthenticationContext) {
     this.jiraAuthenticationContext = jiraAuthenticationContext;
  }


  
  public void init(Map<String, String> map) throws PluginParseException {}


  
  public Map<String, Object> getContextMap(Map<String, Object> map) {
    try {
      String projectKey;
       Project project = (Project)map.get("project");
       if (project != null) {
         projectKey = project.getKey();
      } else {
         projectKey = "";
      } 

      
//boolean managePermission = this.projectPropertiesUtil.isProjectPropertiesManager(project, this.jiraAuthenticationContext.getLoggedInUser());
      
       PluginHttpRequestWrapper request = (PluginHttpRequestWrapper)map.get("request");
       if (request != null) {
         Map parameterMap = request.getParameterMap();
         String[] noticeIdList = request.getParameterMap().get("id");
         String noticeId = noticeIdList[0];
         
         map.put("contextPath", request.getContextPath());
         map.put("notice", getDetail(noticeId));     
      }
      
       map.put("projectKey", projectKey);
//map.put("adminPerm", Boolean.valueOf(managePermission));
    }
     catch (Exception e) {
       LOGGER.error(e);
    } 
    
     return map;
  }

  public NoticeDetailModel getDetail(String id){
      int noticeId = Integer.parseInt(id);
      return new NoticeDetailModel(noticeId);
  }
}
