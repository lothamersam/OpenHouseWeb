package com.openhouse.rest.admin;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

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
	@Path("/change")
	public Response changeHomeSection(@FormParam("content") String content,
			@FormParam("sectionType") String sectionType) {

		int status = 500;
		final JSONObject responseBody = new JSONObject().put("success", false);

		PageSectionTO aboutSection = this.parameterService.getPageSectionFromRequest(content, sectionType);

		if (this.pageDao.editPageSection(aboutSection)) {
			status = 200;
			responseBody.put("success", true);
		} 

		return Response.status(status).entity(responseBody.toString()).build();
	}
}
