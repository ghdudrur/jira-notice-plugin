package dev.jira.api;

import com.atlassian.jira.project.Project;
import com.atlassian.plugin.spring.scanner.annotation.imports.JiraImport;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.plugin.PluginParseException;
import com.atlassian.plugin.servlet.PluginHttpRequestWrapper;
import com.atlassian.plugin.web.ContextProvider;
import java.util.Map;
import org.apache.log4j.Logger;

public class ProjectNoticeProvider 
    implements ContextProvider
{

   private static final Logger LOGGER = Logger.getLogger(ProjectNoticeProvider.class);
  
  @JiraImport
  private final JiraAuthenticationContext jiraAuthenticationContext;

  
  public ProjectNoticeProvider(JiraAuthenticationContext jiraAuthenticationContext) {
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
         map.put("contextPath", request.getContextPath());
      }
      
       map.put("projectKey", projectKey);
//map.put("adminPerm", Boolean.valueOf(managePermission));
    }
     catch (Exception e) {
       LOGGER.error(e);
    } 
    
     return map;
  }
}
