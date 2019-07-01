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
                <!-- </div>
                <div class="row"> -->
            </c:if>
            <div class="col s12 m12 l4">
                <div class="card">
                    <div class="card-image">
                        <img src="${member.imagePath}" class="circle responsive-img">
                        <a class="btn-floating halfway-fab waves-effect waves-light red modal-trigger tooltipped"
                            id="deleteStaff" data-position="bottom" data-delay="50" data-tooltip="Delete this staff member"
                            href="/action/staffChange?action=edit&id=${member.id}"><i class="material-icons">delete</i></a>
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
            <form action="/action/staffChange" method="POST" enctype="multipart/form-data">
                <div class="modal-content">
                    <div class="row">
                        <div class="file-field input-field">
                            <div class="btn">
                                <span>Profile Picture</span>
                                <input type="file" name="picture">
                            </div>
                            <div class="file-path-wrapper">
                                <input class="file-path validate" type="text">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <input value="${member.firstName}" name="firstName" id="first_name" type="text" class="validate" required>
                            <label for="first_name">First Name</label>
                        </div>
                        <div class="input-field col s6">
                            <input value="${member.lastName}" name="lastName" id="last_name" type="text" class="validate" required>
                            <label for="last_name">Last Name</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input value="${member.title}" name="title" id="title" type="text" class="validate" required>
                            <label for="title">Job Title</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <textarea name="bio" id="bioTextArea" class="materialize-textarea"
                                required>${member.bio}</textarea>
                            <label for="bioTextArea">Staff Member Bio</label>
                        </div>
                    </div>
                </div>
                <input type="hidden" name="id" value="${member.id}" />
                <input type="hidden" name="action" value="edit" />
                <div class="modal-footer">
                    <button class="btn waves-effect waves-light" type="submit" name="action">Apply Edits
                        <i class="material-icons right">add_box</i>
                    </button>
                </div>
            </form>
        </div>
    </c:forEach>

    <div id="newMemberModal" class="modal modal-fixed-footer">
        <form action="/action/staffChange" method="POST" enctype="multipart/form-data">
            <div class="modal-content">
                <div class="row">
                    <div class="file-field input-field">
                        <div class="btn">
                            <span>Profile Picture</span>
                            <input type="file" name="picture">
                        </div>
                        <div class="file-path-wrapper">
                            <input class="file-path validate" type="text">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input name="firstName" id="first_name" type="text" class="validate" required>
                        <label for="first_name">First Name</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="lastName" id="last_name" type="text" class="validate" required>
                        <label for="last_name">Last Name</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input name="title" id="title" type="text" class="validate" required>
                        <label for="title">Job Title</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <textarea name="bio" id="bioTextArea" class="materialize-textarea"
                            required></textarea>
                        <label for="bioTextArea">Staff Member Bio</label>
                    </div>
                </div>
            </div>
            <input type="hidden" name="action" value="add" />
            <div class="modal-footer">
                <button class="btn waves-effect waves-light" type="submit" name="action">Add Staff Member
                    <i class="material-icons right">add_box</i>
                </button>
            </div>
        </form>
    </div>

    <tags:footer />

    <script src="/static/js/standardPage.js"></script>
</body>

</html>