<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<t:master>

	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<p class="text-muted lead">Filmek listája</p>
			</div>
			<div class="col-md-12 clearfix" id="films">
				<div class="box">

					<div class="table-responsive">
						<table class="table movieTable">
							<thead>
								<tr>
									<th colspan="2">Film</th>
									<th colspan="2">Rendező</th>
									<th style="width: 100px"><a href="#" data-toggle="modal"
										data-target="#addFilm_modal"><i
											class="fa fa-plus-square fa-2x"></i><span
											class="addButtonText">Film</span></a></th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="filmMetaModel" items="${filmMetaModels}">
									<tr data-filmMetaId="${filmMetaModel.id}">
										<td><span class="expandButton"> <i
												class="fa fa-angle-down fa-2x"> </i></span></td>
										<td><h5>
												<c:out
													value="${filmMetaModel.title} (${filmMetaModel.hungarianTitle})"></c:out>
											</h5></td>
										<td colspan="2"><c:out value="${filmMetaModel.director}"></c:out></td>
										<td>
										<security:authorize access="hasRole('ROLE_ADMIN')">
											<span class="listAction deleteFilm"><i class="fa fa-trash-o"></i></span> 
											<span class="listAction editFilm"><i class="fa fa-edit"></i></span>
										</security:authorize>
										</td>
									</tr>


									<tr class="subTableRow" data-filmMetaId="${filmMetaModel.id}">
										<td></td>
										<td colspan="4" style="padding-right: 0px">
											<table class="table">
												<thead>
													<tr>
														<th>Kópia</th>
														<th>Év</th>
														<th>Hossz</th>
														<th class="cutModal" style="width: 100px"><a href="#"
															data-toggle="modal" data-target="#addCut_modal"><i
																class="fa fa-plus-square fa-2x"></i><span
																class="addButtonText">Kópia</span></a></th>
													</tr>
												</thead>
												
												<tbody>
													<c:if test="${not empty filmMetaModel.cuts}">
														<c:forEach var="cutModel" items="${filmMetaModel.cuts}">
															<tr data-cutId="${cutModel.cutId}">
																<td><c:out value="${cutModel.title}"></c:out></td>
																<td><c:out value="${cutModel.year}"></c:out></td>
																<td><c:out value="${cutModel.length}"></c:out></td>
																<td>
																	<security:authorize access="hasRole('ROLE_ADMIN')">
																		<span class="listAction deleteCut"><i class="fa fa-trash-o"></i></span> 
																		<span class="listAction editCut"><i class="fa fa-edit"></i></span>
																	</security:authorize>
																</td>
															</tr>
														</c:forEach>
													</c:if>
												</tbody>
											</table>
											
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

		<div class="modal fade" id="addFilm_modal" tabindex="-1" role="dialog"
			aria-labelledby="AddFilm" aria-hidden="true">
			<div class="modal-dialog modal-sm">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="AddFilm">Film hozzáadása/szerkesztése</h4>
					</div>
					<div class="modal-body">
						<form:form modelAttribute="filmMetaRequest" action="movies/addfilmmeta" method="post">
							<form:input path="id" id="Id" type="number" style="display:none" />
							<div class="form-group">
								<form:input path="title" type="text" class="form-control" id="Title" placeholder="Film eredeti címe" />
							</div>
							<div class="form-group">
								<form:input path="hungarianTitle" type="text" class="form-control" id="HungarianTitle"
									placeholder="Film magyar címe" />
							</div>
							<div class="form-group">
								<form:input path="director" type="text" class="form-control" id="Director" placeholder="Rendező" />
							</div>

							<p class="text-center">
								<button type="submit" class="btn btn-template-main">
									<i class="fa fa-sign-in"></i> Mentés
								</button>
							</p>

						</form:form>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="addCut_modal" tabindex="-1" role="dialog"
			aria-labelledby="AddCut" aria-hidden="true">
			<div class="modal-dialog modal-sm">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="AddFilm">Kópia hozzáadása</h4>
					</div>
					<div class="modal-body">
						<form:form modelAttribute="cutRequest" action="movies/addcut" method="post">
							<form:input path="cutId" id="Id" type="number" style="display:none" />
							<form:input path="filmMetaId" id="FilmMetaId" type="number" style="display:none" />
							<div class="form-group">
								<form:input path="title" type="text" class="form-control" id="Title" placeholder="Kópia eredeti címe" />
							</div>
							<div class="form-group">
								<form:input path="hungarianTitle" type="text" class="form-control" id="HungarianTitle"
									placeholder="Kópia magyar címe" />
							</div>
							<div class="form-group">
								<form:input path="length" type="number" class="form-control" id="Length" placeholder="Hossz" />
							</div>
							<div class="form-group">
								<form:input path="year" type="number" class="form-control" id="Year" placeholder="Kiadás éve" />
							</div>
							<p class="text-center">
								<button type="submit" class="btn btn-template-main">
									<i class="fa fa-sign-in"></i> Mentés
								</button>
							</p>


						</form:form>
					</div>
				</div>
			</div>
		</div>



	</div>

</t:master>