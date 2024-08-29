package dev.jira.rest;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.plugin.spring.scanner.annotation.imports.JiraImport;
import com.atlassian.plugins.rest.common.security.AnonymousAllowed;
import com.atlassian.sal.api.transaction.TransactionCallback;
import com.microsoft.graph.models.Todo;

import dev.jira.ao.Notice;


import java.util.Date;
import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;

/**
 * A resource of message.
 */
@Path("/")
public class NoticeRestModule {
      @JiraImport
      private final ActiveObjects ao;

      @JiraImport
      private final JiraAuthenticationContext jiraAuthenticationContext;

      public NoticeRestModule (ActiveObjects ao, JiraAuthenticationContext jiraAuthenticationContext) {
         this.ao = ao;
         this.jiraAuthenticationContext = jiraAuthenticationContext;
      }

    @Path("/getlist")
    @GET
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getNoticeList()
    {
      NoticeListModel noticeListModel = new NoticeListModel();
      ao.executeInTransaction( new TransactionCallback<Void>() // (1)
       {
           @Override
           public Void doInTransaction()
           {
               for (Notice notice : ao.find(Notice.class)) // (2)
               {
                  noticeListModel.list.add(new NoticeDetailModel(notice));
               }
               return null;
           }
       });
         return Response.ok(noticeListModel.list).build();
    }
    
    @Path("/create")
    @POST
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(@RequestBody Map<String, String> data)
    {
      if(jiraAuthenticationContext.getLoggedInUser() == null ){
         return Response.status(Status.UNAUTHORIZED).build();
      }
      String subject = data.get("subject");
      String context = data.get("context");
      ao.executeInTransaction(new TransactionCallback<Notice>() // (1)
    {
        @Override
        public Notice doInTransaction()
        {
            final Notice notice = ao.create(Notice.class); // (2)
            notice.setSubject(subject); // (3)
            notice.setContext(context);
            notice.setCreator(jiraAuthenticationContext.getLoggedInUser().getUsername());
            notice.setCreateDate(new Date());
            notice.save(); // (4)
            return notice;
        }
    });
       return Response.ok(new NoticeRestModuleModel("Hello World")).build();
    }
    
    @Path("/update")
    @POST
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response update(@RequestBody Map<String, String> data, @QueryParam("id") int id)
    {
      
      int noticeId = id;

      if(jiraAuthenticationContext.getLoggedInUser() == null ){
         return Response.status(Status.UNAUTHORIZED).build();
      }
      String subject = data.get("subject");
      String context = data.get("context");
      Notice notice = ao.executeInTransaction(new TransactionCallback<Notice>() // (1)
    {
        @Override
        public Notice doInTransaction()
        {
            final Notice[] notice = ao.find(Notice.class, "ID = ?",noticeId);
            if (notice.length != 1){return null;} // (2)
            notice[0].setSubject(subject); // (3)
            notice[0].setContext(context);
            notice[0].setCreator(jiraAuthenticationContext.getLoggedInUser().getUsername());
            notice[0].setUpdateDate(new Date());
            notice[0].save(); // (4)
            return notice[0];
        }
    });
      NoticeDetailModel noticeDetailModel = new NoticeDetailModel(notice);
      
      return Response.ok(noticeDetailModel).build();
    }

    @Path("/getdetail")
    @GET
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getDetail(@QueryParam("id") int id)
    {
      int noticeId = id;
      
      Notice notice = ao.executeInTransaction( new TransactionCallback<Notice>() // (1)
    {
        @Override
        public Notice doInTransaction()
        {   
         Notice[] notices = ao.find(Notice.class, "ID = ?",noticeId);
            if (notices.length != 1){
               return null;
            }
         
            return notices[0];
        }
    });
    NoticeDetailModel noticeDetailModel = new NoticeDetailModel(notice);
    
       return Response.ok(noticeDetailModel).build();
    }

    @Path("/delete")
    @DELETE
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response delete(@QueryParam("id") int id)
    {
      
      int noticeId = id;

      if(jiraAuthenticationContext.getLoggedInUser() == null ){
         return Response.status(Status.UNAUTHORIZED).build();
      }
      
      int deleteCount = ao.deleteWithSQL(Notice.class, "ID = ?",noticeId);
    
      
      return Response.ok(new NoticeRestDeleteModel("Delete", noticeId)).build();
    }
}