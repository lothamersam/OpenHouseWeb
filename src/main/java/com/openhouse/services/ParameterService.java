package com.openhouse.services;

import com.openhouse.beans.DateTO;
import com.openhouse.beans.PageSectionTO;
import com.openhouse.beans.SignupInformationTO;
import com.openhouse.beans.StaffMemberTO;
import com.openhouse.beans.UserTO;
import com.openhouse.services.enums.PageSectionType;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Personalization;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

public final class ParameterService {
    private static final String CONTACT_DIRECTOR = "Contact Director";

    public Mail getContactMailFromRequest(String firstName, String lastName, String email, String phoneNumber,
                                          String category, String message) {
        final Mail mail = new Mail();

        final Personalization personalization = new Personalization();
        personalization.addTo(new Email(System.getenv("OPENHOUSE_EMAIL")));

        if (CONTACT_DIRECTOR.equals(category)) {
            personalization.addCc(new Email(System.getenv("DIRECTOR_EMAIL")));
        }

        final Content content = new Content();
        content.setType("text/html");

        final StringBuilder messageBody = new StringBuilder();
        messageBody.append(String.format("<h3>%s - %s %s</h3><h5>%s", category, firstName, lastName, email));

        if (null != phoneNumber) {
            messageBody.append(String.format(" - %s", phoneNumber));
        }

        messageBody.append("</h5>");
        messageBody.append("<p>" + message + "</p>");

        content.setValue(messageBody.toString());
        mail.addContent(content);

        mail.addPersonalization(personalization);
        mail.setFrom(new Email(email));
        mail.setSubject(String.format("%s - %s %s", category, firstName, lastName));

        return mail;
    }

    public Mail getSignupMailFromRequest(String firstName, String lastName, String email, String dateText,
                                         String timeText) {
        final Mail mail = new Mail();

        final Personalization personalization = new Personalization();
        personalization.addTo(new Email(email));

        final Content content = new Content();
        content.setType("text/html");

        final StringBuilder messageBody = new StringBuilder();
        messageBody.append(String.format("<h3>Audition Confirmation - %s %s</h3>", firstName, lastName));

        messageBody.append(String.format("<p> Dear %s, <br><br> This email is to confirm "
                        + "that you have scheduled an audition with the Open House Theatre Company on:"
                        + "<br><br><strong>%s at %s</strong><br><br> We Look forward to seeing you then!<br><br>"
                        + "<em>This email has been sent from a no-reply address, " + "if you respond it will not be seen.</p>",
                firstName, dateText, timeText));

        content.setValue(messageBody.toString());
        mail.addContent(content);

        mail.addPersonalization(personalization);
        mail.setFrom(new Email("no-reply@openhousetheatre.com"));
        mail.setSubject(String.format("Audition Confirmation - %s %s", firstName, lastName));

        return mail;
    }

    public StaffMemberTO getStaffMemberTOFromRequest(final HttpServletRequest request) {
        final StaffMemberTO staffMember = new StaffMemberTO();

        if (StringUtils.isNotBlank(request.getParameter("firstName"))
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

    public PageSectionTO getPageSectionFromRequest(String content, String sectionType) {
        final PageSectionTO aboutSection = new PageSectionTO();

        if (StringUtils.isNotBlank(content) && StringUtils.isNotBlank(sectionType)) {
            aboutSection.setSectionContent(content);
            aboutSection.setSectionType(PageSectionType.getTypeFromKey(sectionType));
            aboutSection.setAdditionalProperties("");
        }

        return aboutSection;
    }

    public SignupInformationTO getSignupInformationFromRequest(String firstName,
                                                               String lastName,
                                                               String pronoun,
                                                               String dateText,
                                                               String timeText,
                                                               String email,
                                                               String phoneNumber) {
        final SignupInformationTO signup = new SignupInformationTO();

        if (StringUtils.isNotBlank(firstName) && StringUtils.isNotBlank(lastName) && StringUtils.isNotBlank(pronoun)
                && StringUtils.isNotBlank(dateText) && StringUtils.isNotBlank(timeText) && StringUtils.isNotBlank(email)
                && StringUtils.isNotBlank(phoneNumber)) {
            signup.setFirstName(firstName);
            signup.setLastName(lastName);
            signup.setPronouns(pronoun);
            signup.setDate(dateText + ", " + timeText);
            signup.setEmail(email);
            signup.setPhoneNumber(phoneNumber);
        }

        return signup;
    }

    public DateTO getDateFromRequest(String date,
                                     String location,
                                     String startTime,
                                     String endTime,
                                     String information) {
        final DateTO dateTo = new DateTO();

        if (StringUtils.isNotBlank(date)
                && StringUtils.isNotBlank(startTime)
                && StringUtils.isNotBlank(endTime)
                && StringUtils.isNotBlank(location)
                && StringUtils.isNotBlank(information)) {
            dateTo.setDate(date);
            dateTo.setStartTime(startTime);
            dateTo.setEndTime(endTime);
            dateTo.setLocation(location);
            dateTo.setInformation(information);
        }

        return dateTo;
    }

    public UserTO getUserFromRequest(String firstName, String lastName, String username, String hashedPassword) {
        final UserTO user = new UserTO();

        if (StringUtils.isNotBlank(firstName) && StringUtils.isNotBlank(lastName) && StringUtils.isNotBlank(username)
                && StringUtils.isNotBlank(hashedPassword)) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUsername(username);
            user.setPassword(hashedPassword);
        }

        return user;
    }

    public UserTO getUserFromRequest(int id, String hashedPassword) {
        final UserTO user = new UserTO();

        if (StringUtils.isNotBlank(hashedPassword)) {
            user.setId(id);
            user.setPassword(hashedPassword);
        }

        return user;
    }
}
