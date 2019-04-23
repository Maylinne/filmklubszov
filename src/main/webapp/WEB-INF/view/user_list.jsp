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
	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<p class="text-muted lead">Felhasználók listája</p>
			</div>
			<div class="col-md-12 clearfix" id="users">
				<div class="box">

					<div class="table-responsive">
						<table class="table userTable">
							<thead>
								<tr>
									<th colspan="2">Felhasználónév</th>
									<th colspan="2">E-mail</th>
									<th>Szerepkör</th>
									<th>Státusz</th>
									<th style="width: 140px">
										<a href="#" class="btn btn-template-main" data-toggle="modal" data-target="#addUser_modal">
											<span class="addButtonText">Új felhasználó</span>
										</a>
									</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach var="userModel" items="${userModels}">
									<tr class="userRow" data-userId="${userModel.id}">
										<td colspan="2"><h5>
												<c:out value="${userModel.name}"></c:out>
											</h5>
										</td>
										<td colspan="2"><c:out value="${userModel.email}"></c:out></td>
										<td><c:out value="${userModel.role}"></c:out></td>
										<td><c:out value="${userModel.status}"></c:out></td>
										<td>
											<span class="listAction sendEmail"><i class="fa fa-envelope"></i></span>
											<span class="listAction deleteUser"><i class="fa fa-trash-o"></i></span>
											<span class="listAction editUser"><i class="fa fa-edit"></i></span>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- /.table-responsive -->

				</div>
				<!-- /.box -->

			</div>
			
		</div>
		
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

</t:master>