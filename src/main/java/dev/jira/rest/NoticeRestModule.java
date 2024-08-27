package dev.jira.rest;

import com.atlassian.plugins.rest.common.security.AnonymousAllowed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * A resource of message.
 */
@Path("/")
public class NoticeRestModule {
    @Path("/getlist")
    @GET
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getNoticeList()
    {
       return Response.ok(new NoticeListModel()).build();
    }
    @Path("/create")
    @GET
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create()
    {
       return Response.ok(new NoticeRestModuleModel("Hello World")).build();
    }
    @Path("/update")
    @GET
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response update()
    {
       return Response.ok(new NoticeRestModuleModel("Hello World")).build();
    }
    @Path("/getdetail")
    @GET
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getDetail(@QueryParam("id") int id)
    {
        NoticeDetailModel noticeDetailModel = new NoticeDetailModel(id);
       return Response.ok(noticeDetailModel).build();
    }
}