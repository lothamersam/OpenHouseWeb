package com.openhouse.rest.admin;

import java.net.URI;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.openhouse.beans.PageSectionTO;
import com.openhouse.daos.BasicPageDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.factory.ServiceFactory;
import com.openhouse.services.ParameterService;

@Path("/admin/page")
public class PageSectionChangeREST {
	private final ParameterService parameterService = ServiceFactory.getParameterService();
	private final BasicPageDao pageDao = DaoFactory.getPageDao();

	@POST
	@Path("/change/{referrer}")
	public Response changeHomeSection(@PathParam("referrer") String referrer,
			@FormParam("content") String content,
			@FormParam("sectionType") String sectionType) {
		PageSectionTO aboutSection = this.parameterService.getPageSectionFromRequest(content, sectionType);

		this.pageDao.editPageSection(aboutSection);

		return Response.seeOther(URI.create("/admin/" + referrer)).build();
	}
}
