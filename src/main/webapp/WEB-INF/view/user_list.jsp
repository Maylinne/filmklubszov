<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<t:master>
		
	<div id="heading-breadcrumbs" class="custom-heading">
	    <div class="container">
		    <div class="row">
			    <div class="col-md-7">
			        <h1>Felhasználók</h1>
			    </div>
		    </div>
	    </div>
    </div>
    
    
     <!-- USER LIST -->
	<div class="container table-container userTable">
			<div class="row outer-header-row">
			<div class="col-md-offset-1 col-md-2">Felhasználónév</div>
			<div class="col-md-3">E-mail</div>
			<div class="col-md-2">Szerepkör</div>
			<div class="col-md-1">Státusz</div>
			<div class="button-div col-md-2">
				<a href="#" class="btn btn-template-main list-header-btn" data-toggle="modal" data-target="#addUser_modal">
					<span class="addButtonText">Új felhasználó</span>
				</a>
			</div>
		</div>
		
		<c:forEach var="userModel" items="${userModels}" varStatus="loopStatus">
			<div class="row outer-table-row ${loopStatus.index % 2 == 0 ? 'even' : ''}">
				<div class="col-md-offset-1 col-md-2"><c:out value="${userModel.name} "></c:out></div>
				<div class="col-md-3"><c:out value="${userModel.email} "></c:out></div>
				<div class="col-md-2"><c:out value="${userModel.role} "></c:out></div>
				<div class="col-md-1"><c:out value="${userModel.status}"></c:out></div>
				<div class="col-md-2 text-center">
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<span class="listAction sendEmail" data-userId="${userModel.id}"><i class="fa fa-envelope"></i></span>
						<span class="listAction deleteUser" data-userId="${userModel.id}"><i class="fa fa-trash-o"></i></span> 
						<span class="listAction editUser" data-userId="${userModel.id}"><i class="fa fa-edit"></i></span>
					</security:authorize>
				</div>
			</div>
		</c:forEach>				
	</div>
	<!-- USER LIST END -->
    
    <!-- USER MODAL -->
	<div class="container">
		
		<div class="modal fade" id="addUser_modal" tabindex="-1" role="dialog" aria-labelledby="AddUser" aria-hidden="true">
            <div class="modal-dialog modal-sm">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="AddUser">Felhasználó hozzáadása/szerkesztése</h4>
                    </div>
                    <div class="modal-body">
                         <form:form modelAttribute="userRequest" action="users/adduserpost" method="post">
                        	<form:input path="id" id="Id" type="number" style="display:none"/>
                            <div class="form-group">
                                <form:input path="name" type="text" class="form-control" id="Name" placeholder="Felhasználónév" />
                            </div>
							<div class="form-group">
                                <form:input path="email" type="text" class="form-control" id="Email" placeholder="Email címe" />
                            </div>
                            <div  class="form-group">
                            	<form:select id="roleSelect"  class="form-control" path="role" items="${userModel.availableRoles}"></form:select>
                            </div>
                            
                            <p class="text-center">
                                <button type="submit" class="btn btn-template-main"><i class="fa fa-sign-in"></i> Mentés</button>
                            </p>

                        </form:form>
                    </div>
                </div>
            </div>
        </div>

	</div>
	<!-- USER MODAL END -->

</t:master>