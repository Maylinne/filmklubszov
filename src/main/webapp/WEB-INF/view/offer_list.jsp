<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<t:master>

	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<p class="text-muted lead">Ajánlatok listája</p>
			</div>
			<div class="col-md-12 clearfix" id="users">
				<div class="box">

					<ul class="nav nav-pills nav-justified">

						<li id="cutOfferButton" data-formid="cutOffer"
							class="active formNavButton"><a href="#"><i
								class="fa fa-film"></i><br>Kópiák</a></li>

						<li id="spotOfferButton" data-formid="spotOffer"
							class="formNavButton"><a href="#"><i
								class="fa fa-map-marker"></i><br>Helyszínek</a></li>

					</ul>

					<div id="cutOfferForm" class="content formElement active">
						<div class="table-responsive">
							<table class="table offerTable">
								<thead>
									<tr>
										<th colspan="2">Partner</th>
										<th colspan="2">Kópia</th>
										<th>Leírás</th>
										<th style="width: 140px"><a href="#" data-toggle="modal"
											data-target="#addCutOffer_modal"><i
												class="fa fa-plus-square fa-2x"></i><span
												class="addButtonText">Ajánlat</span></a></th>
									</tr>
								</thead>

								<tbody>

									<c:forEach var="cutOfferModel" items="${cutOfferModels}">
										<tr data-offerId="${cutOfferModel.id}">
											<td colspan="2"><h5>
													<c:out value="${cutOfferModel.partner.name}"></c:out>
												</h5></td>
											<td colspan="2"><c:out
													value="${cutOfferModel.cut.filmHungarianTitle} (${cutOfferModel.cut.hungarianTitle})"></c:out></td>
											<td><c:out value="${cutOfferModel.description}"></c:out></td>
											<td><span class="listAction deleteOffer"><i class="fa fa-trash-o"></i></span></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- /.table-responsive -->
					</div>

					<div id="spotOfferForm" class="content formElement">
						<div class="table-responsive">
							<table class="table offerTable">
								<thead>
									<tr>
										<th colspan="2">Partner</th>
										<th colspan="2">Helyszín</th>
										<th>Leírás</th>
										<th style="width: 140px"><a href="#" data-toggle="modal"
											data-target="#addSpotOffer_modal"><i
												class="fa fa-plus-square fa-2x"></i><span
												class="addButtonText">Ajánlat</span></a></th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="spotOfferModel" items="${spotOfferModels}">
										<tr data-offerId="${spotOfferModel.id}">
											<td colspan="2"><h5>
													<c:out value="${spotOfferModel.partner.name}"></c:out>
												</h5></td>
											<td colspan="2"><c:out
													value="${spotOfferModel.spot.locationName} (${spotOfferModel.spot.name})"></c:out></td>
											<td><c:out value="${spotOfferModel.description}"></c:out></td>
											<td><span class="listAction deleteOffer"><i
													class="fa fa-trash-o"></i></span></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- /.table-responsive -->
					</div>

				</div>
				<!-- /.box -->

			</div>

		</div>

		<%-- CUT MODAL --%>
		<div class="modal fade" id="addCutOffer_modal" tabindex="-1"
			role="dialog" aria-labelledby="AddCutOffer" aria-hidden="true">
			<div class="modal-dialog modal-sm">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="AddCutOffer">Kópia ajánlat
							hozzáadása/szerkesztése</h4>
					</div>
					<div class="modal-body">
						<form:form modelAttribute="cutOfferRequest"
							action="offers/offerPost" method="post">
							<form:input path="id" id="Id" type="number" style="display:none" />
							
							<form:select path="partnerId">
								<form:options items="${offerModel.availableUsers}" />
							</form:select>
							
							<form:select path="cutId">
								<form:options items="${offerModel.availableCuts}" />
							</form:select>
							
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
		<%-- CUT MODAL END --%>
		
		
		<%-- SPOT MODAL --%>
			<div class="modal fade" id="addSpotOffer_modal" tabindex="-1"
			role="dialog" aria-labelledby="AddSpotOffer" aria-hidden="true">
			<div class="modal-dialog modal-sm">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="AddSpotOffer">Helyszin ajánlat
							hozzáadása/szerkesztése</h4>
					</div>
					<div class="modal-body">
						<form:form modelAttribute="spotOfferRequest"
							action="offers/offerPost" method="post">
							<form:input path="id" id="Id" type="number" style="display:none" />
							
							<form:select path="partnerId">
								<form:options items="${spotOfferModel.availableUsers}" />
							</form:select>
							
							<form:select path="spotId">
								<form:options items="${spotOfferModel.availableSpots}" />
							</form:select>
							
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