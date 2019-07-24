package com.openhouse.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.IllegalFormatException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.sendgrid.Mail;
import com.sendgrid.Email;
import com.sendgrid.Personalization;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.openhouse.beans.DateTO;
import com.openhouse.beans.PageSectionTO;
import com.openhouse.beans.SignupInformationTO;
import com.openhouse.beans.StaffMemberTO;
import com.openhouse.services.enums.PageSectionType;
import com.sendgrid.Content;

public final class ParameterService {
    private static final String CONTACT_DIRECTOR = "Contact Director";

    public Mail getContactMailFromRequest(String firstName, 
					  String lastName,
					  String email,
					  String phoneNumber,
					  String category,
					  String message) throws IllegalFormatException {
        final Mail mail = new Mail();
        
        final Personalization personalization = new Personalization();
        personalization.addTo(new Email(System.getenv("OPENHOUSE_EMAIL")));
        
        if(CONTACT_DIRECTOR.equals(category)) {
            personalization.addCc(new Email(System.getenv("DIRECTOR_EMAIL")));
        }

        final Content content = new Content();
        content.setType("text/html");

        final StringBuilder messageBody = new StringBuilder();
        messageBody.append(String.format("<h3>%s - %s %s</h3><h5>%s", 
                category, firstName, lastName, email));
       
        if(null != phoneNumber) {
            messageBody.append(String.format(" - %s", phoneNumber));
        }
        
        messageBody.append("</h5>");
        messageBody.append("<p>" + message + "</p>");

        content.setValue(messageBody.toString());
        mail.addContent(content);
        
        mail.addPersonalization(personalization);
        mail.setFrom(new Email(email));
        mail.setSubject(String.format("%s - %s %s",         
            category, firstName, lastName));     

        return mail;
    }
    
    public Mail getSignupMailFromRequest(final HttpServletRequest request) throws IllegalFormatException {
        final Mail mail = new Mail();
        
        final Personalization personalization = new Personalization();
        personalization.addTo(new Email(request.getParameter("email")));
        
        final Content content = new Content();
        content.setType("text/html");

        final StringBuilder messageBody = new StringBuilder();
        messageBody.append(String.format("<h3>Audition Confirmation - %s %s</h3>", 
                request.getParameter("first_name"), 
                request.getParameter("last_name")));
        
        messageBody.append(String.format("<p> Dear %s, <br><br> This email is to confirm "
        		+ "that you have scheduled an audition with the Open House Theatre Company on:"
        		+ "<br><br><strong>%s at %s</strong><br><br> We Look forward to seeing you then!<br><br>"
        		+ "<em>This email has been sent from a no-reply address, "
        		+ "if you respond it will not be seen.</p>",
        		request.getParameter("first_name"),
        		request.getParameter("dateText"),
        		request.getParameter("timeText")));

        content.setValue(messageBody.toString());
        mail.addContent(content);
        
        mail.addPersonalization(personalization);
        mail.setFrom(new Email("no-reply@openhousetheatre.com"));
        mail.setSubject(String.format("Audition Confirmation - %s %s",         
            request.getParameter("first_name"), 
            request.getParameter("last_name")));     

        return mail;
    }

    public StaffMemberTO getStaffMemberTOFromRequest(final HttpServletRequest request) {
    	final StaffMemberTO staffMember = new StaffMemberTO();
    
        if(StringUtils.isNotBlank(request.getParameter("firstName"))
            && StringUtils.isNotBlank(request.getParameter("lastName"))
            && StringUtils.isNotBlank(request.getParameter("title"))
            && StringUtils.isNotBlank(request.getParameter("bio"))) {
            
			staffMember.setFirstName(request.getParameter("firstName"));
			
            staffMember.setLastName(request.getParameter("lastName"));
            staffMember.setTitle(request.getParameter("title"));
            staffMember.setBio(request.getParameter("bio"));
        }

        return staffMember;
    }

    public String getStringFromRequest(HttpServletRequest request, String paramName) {
        if (StringUtils.isNotBlank(request.getParameter(paramName))) {
            return request.getParameter(paramName);
        }

        return "";
    }

    public File getImageFromRequest(HttpServletRequest request) throws IOException, ServletException {
        try {
            Part filePart = request.getPart("picture");
            InputStream fileContent = filePart.getInputStream();
            File image = new File(Paths.get(filePart.getSubmittedFileName()).getFileName().toString());
        
            try (OutputStream outputStream = new FileOutputStream(image)) {
                IOUtils.copy(fileContent, outputStream);
            }

            return image;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public Integer getIntFromRequest(HttpServletRequest request, String paramName) {
        try {
            return Integer.parseInt(request.getParameter(paramName));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Deprecated
	public PageSectionTO getPageSectionFromRequest(HttpServletRequest request) {
		final PageSectionTO aboutSection = new PageSectionTO();
		
		if (StringUtils.isNotBlank(request.getParameter("content"))
				&& StringUtils.isNotBlank(request.getParameter("sectionType"))) {
			aboutSection.setSectionContent(request.getParameter("content"));
			aboutSection.setSectionType(PageSectionType
					.getTypeFromKey(request.getParameter("sectionType")));
			aboutSection.setAdditionalProperties("");
		}

		
		return aboutSection;
	}
	
	public PageSectionTO getPageSectionFromRequest(String content, String sectionType) {
		final PageSectionTO aboutSection = new PageSectionTO();
		
		if (StringUtils.isNotBlank(content)
				&& StringUtils.isNotBlank(sectionType)) {
			aboutSection.setSectionContent(content);
			aboutSection.setSectionType(PageSectionType
					.getTypeFromKey(sectionType));
			aboutSection.setAdditionalProperties("");
		}

		
		return aboutSection;
	}
	
	public SignupInformationTO getSignupInformationFromRequest(HttpServletRequest request) {
		final SignupInformationTO signup = new SignupInformationTO();
		
		if(StringUtils.isNotBlank(request.getParameter("first_name"))
				&& StringUtils.isNotBlank(request.getParameter("last_name"))
				&& StringUtils.isNotBlank(request.getParameter("pronoun"))
				&& StringUtils.isNotBlank(request.getParameter("dateText"))
				&& StringUtils.isNotBlank(request.getParameter("timeText"))
				&& StringUtils.isNotBlank(request.getParameter("email"))
				&& StringUtils.isNotBlank(request.getParameter("phone_number"))) {
			signup.setFirstName(request.getParameter("first_name"));
			signup.setLastName(request.getParameter("last_name"));
			signup.setPronouns(request.getParameter("pronoun"));
			signup.setDate(request.getParameter("date") + ", " + request.getParameter("timeText"));
			signup.setEmail(request.getParameter("email"));
			signup.setPhoneNumber(request.getParameter("phone_number"));
		}
		
		return signup;
	}

	public DateTO getDateFromRequest(HttpServletRequest request) {
		final DateTO date = new DateTO();
		
		if (StringUtils.isNotBlank(request.getParameter("date"))
				&& StringUtils.isNotBlank(request.getParameter("time"))
		    		&& StringUtils.isNotBlank(request.getParameter("endTime"))
				&& StringUtils.isNotBlank(request.getParameter("location"))
				&& StringUtils.isNotBlank(request.getParameter("information"))) {
			date.setDate(request.getParameter("date"));
			date.setStartTime(request.getParameter("time"));
			date.setEndTime(request.getParameter("endTime"));
			date.setLocation(request.getParameter("location"));
			date.setInformation(request.getParameter("information"));
		}
		
		return date;
	}
}
