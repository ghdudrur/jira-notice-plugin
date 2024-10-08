package dev.jira.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.atlassian.plugin.spring.scanner.annotation.imports.JiraImport;

import com.atlassian.jira.bc.issue.IssueService;
import com.atlassian.jira.bc.issue.search.SearchService;
import com.atlassian.jira.bc.project.ProjectService;
import com.atlassian.jira.config.ConstantsManager;
import com.atlassian.templaterenderer.TemplateRenderer;
import com.atlassian.jira.security.JiraAuthenticationContext;



public class AdminConfigServlet extends HttpServlet{
    private static final Logger log = LoggerFactory.getLogger(AdminConfigServlet.class);

    @JiraImport
    private IssueService issueService;
    @JiraImport
    private ProjectService projectService;
    @JiraImport
    private SearchService searchService;
    @JiraImport
    private TemplateRenderer templateRenderer;
    @JiraImport
    private JiraAuthenticationContext authenticationContext;
    @JiraImport
    private ConstantsManager constantsManager;

    AdminConfigServlet(
        IssueService issueService, ProjectService projectService,
        SearchService searchService,
        TemplateRenderer templateRenderer,
        JiraAuthenticationContext authenticationContext,
        ConstantsManager constantsManager) 
    {
        this.issueService = issueService;
        this.projectService = projectService;
        this.searchService = searchService;
        this.templateRenderer = templateRenderer;
        this.authenticationContext = authenticationContext;
        this.constantsManager = constantsManager;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Map<String, Object> context = new HashMap<>();

        resp.setContentType("text/html");
        templateRenderer.render("/templates/adminConfig/edit.vm", context, resp.getWriter());
        // resp.getWriter().write("<html><body>Hello World</body></html>");
    }

}