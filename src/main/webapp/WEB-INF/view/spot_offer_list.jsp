<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<t:master>
		<div id="heading-breadcrumbs" class="custom-heading">
            <div class="container">
                <div class="row">
                    <div class="col-md-7">
                        <h1>Bérelhető termek</h1>
                    </div>
                    
                </div>
            </div>
        </div>
	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<p class="text-muted lead">Ajánlatok listája</p>
			</div>
			<div class="col-md-12 clearfix" id="users">
				<div class="box">

					<div id="spotOfferForm" class="content formElement active">
						<div class="table-responsive">
							<table class="table offerTable">
								<thead>
									<tr>
										<th colspan="2">Partner</th>
										<th colspan="2">Helyszín</th>
										<th>Leírás</th>
										<th style="width: 140px">
										<security:authorize access="hasAnyRole('ROLE_ADMIN,ROLE_VENDOR')">
											<a href="#" class="btn btn-template-main" data-toggle="modal" data-target="#addSpotOffer_modal">
												<span class="addButtonText">Új ajánlat</span>
											</a>
										</security:authorize>
										</th>
									</tr>
								</thead>

								<tbody>
									<c:if test="${not isMine}">
										<c:forEach var="spotOfferModel" items="${spotOfferModels}">
											<tr data-offerId="${spotOfferModel.id}">
												<td colspan="2"><h5>
														<c:out value="${spotOfferModel.partner.name}"></c:out>
													</h5></td>
												<td colspan="2"><c:out value="${spotOfferModel.spot.locationName} (${spotOfferModel.spot.name})"></c:out></td>
												<td><c:out value="${spotOfferModel.description}"></c:out></td>
												<security:authorize access="hasRole('ROLE_ADMIN')">
													<td><span class="listAction deleteOffer"><i class="fa fa-trash-o"></i></span></td>
												</security:authorize>
											</tr>
										</c:forEach>
									</c:if>
									
									<c:if test="${isMine}">
										<c:forEach var="spotOfferModel" items="${mySpotOfferModels}">
											<tr data-offerId="${spotOfferModel.id}">
												<td colspan="2"><h5>
														<c:out value="${spotOfferModel.partner.name}"></c:out>
													</h5></td>
												<td colspan="2"><c:out value="${spotOfferModel.spot.locationName} (${spotOfferModel.spot.name})"></c:out></td>
												<td><c:out value="${spotOfferModel.description}"></c:out></td>
												<td><span class="listAction deleteOffer"><i
														class="fa fa-trash-o"></i></span></td>
											</tr>
										</c:forEach>
									</c:if>
								</tbody>
							</table>
						</div>
						<!-- /.table-responsive -->
					</div>

				</div>
				<!-- /.box -->

			</div>

		</div>

		<%-- SPOT MODAL --%>
			<div class="modal fade" id="addSpotOffer_modal" tabindex="-1"
			role="dialog" aria-labelledby="AddSpotOffer" aria-hidden="true">
			<div class="modal-dialog modal-sm">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="AddSpotOffer">Helyszin ajánlat hozzáadása/szerkesztése</h4>
					</div>
					<div class="modal-body">
						<form:form modelAttribute="spotOfferRequest" action="offers/offerPost" method="post">
							<form:input path="id" id="Id" type="number" style="display:none" />
							<div class="form-group">
							<form:select class="form-control" path="partnerId">
								<form:options items="${spotOfferModel.availableUsers}" />
							</form:select>
							</div>
							<div class="form-group">
							<form:select class="form-control" path="spotId">
								<form:options items="${spotOfferModel.availableSpots}" />
							</form:select>
							</div>
							<form:input path="description" type="text" class="form-control" id="Description" placeholder="Leirás"/>
							
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
		<%-- SPOT MODAL END --%>


	</div>

</t:master>