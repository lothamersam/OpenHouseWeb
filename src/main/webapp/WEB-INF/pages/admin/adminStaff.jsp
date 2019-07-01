<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="tags" %>

<html>
<tags:meta title="Edit Staff" />

<body>
    <tags:adminHeader />

    <div class="fixed-action-btn">
        <a class="btn-floating btn-large red modal-trigger tooltipped" href="#newMemberModal"
            data-position="left" data-delay="50" data-tooltip="Add a staff member">                      
            <i class="large material-icons">mode_edit</i>
        </a>
    </div>
    <div class="row top-row container">
        <c:forEach items="${staffMembers}" var="member" varStatus="status">
            <c:if test="${status.index != 0 && status.index % 3 == 0}">
                </div>
                <div class="row container top-row">
            </c:if>
            <div class="col s12 m12 l4">
                <div class="card">
                    <div class="card-image">
                        <img src="${member.imagePath}" class="circle responsive-img">
                        <a class="btn-floating halfway-fab waves-effect waves-light red modal-trigger tooltipped"
                            id="deleteStaff" data-position="bottom" data-delay="50" data-tooltip="Delete this staff member"
                            href="#${member.firstName}"><i class="material-icons">delete</i></a>
                    </div>
                    <div class="card-content">
                        <span class="card-title"><strong>${member.firstName} ${member.lastName}</strong></span>
                        <span class="card-title flow-text" style="font-size:100%;">${member.title}</span>
                    </div>
                    <div class="card-action">
                        <a class="modal-trigger" href="#${member.firstName}">Edit ${member.firstName}'s info</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <c:forEach items="${staffMembers}" var="member">
        <div id="${member.firstName}" class="modal modal-fixed-footer">
            <div class="modal-content">
                <div class="row">
                    <div class="col s12 m4 l4">
                        <img src="${member.imagePath}" class="circle responsive-img">
                        <br><br>
                        <span class="flow-text"><strong>${member.firstName} ${member.lastName}</strong></span>
                        <br>
                        <span>${member.title}</span>
                    </div>
                    <div class="col s12 m8 l8">
                        <p>${member.bio}</p>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat ">Apply Edits</a>
            </div>
        </div>
    </c:forEach>

    <div id="newMemberModal" class="modal modal-fixed-footer">
        <form action="#">
            <div class="modal-content">
                <div class="row">
                    <div class="file-field input-field">
                        <div class="btn">
                            <span>Profile Picture</span>
                            <input type="file">
                        </div>
                        <div class="file-path-wrapper">
                            <input class="file-path validate" type="text">
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat ">Add member</a>
            </div>
        </form>
    </div>

    <tags:footer />

    <script src="/static/js/standardPage.js"></script>
</body>

</html>