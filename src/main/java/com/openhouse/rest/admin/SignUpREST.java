package com.openhouse.rest.admin;

import com.openhouse.daos.AuditionDao;
import com.openhouse.factory.DaoFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@Path("/admin/signup")
public class SignUpREST {
    private final AuditionDao auditionDao = DaoFactory.getAuditionDao();

    @GET
    @Path("/delete/{id}/{referrer}")
    public Response deleteSignUp(
            @Context UriInfo uriInfo,
            @PathParam("id") int id,
            @PathParam("referrer") String referrer) {
        this.auditionDao.deleteAuditionSignup(id);

        return javax.ws.rs.core.Response.seeOther(uriInfo.getBaseUriBuilder().path("../admin/" + referrer).build()).build();
    }
}
