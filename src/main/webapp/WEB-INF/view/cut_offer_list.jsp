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
	                <h1>Rendelhető kópiák</h1>
	            </div>
	        </div>
	    </div>
    </div>
        
        
    <!-- CUT OFFER LIST -->
	<div class="container table-container offerTable">
			<div class="row outer-header-row">
			<div class="col-md-offset-1 col-md-2">Partner</div>
			<div class="col-md-4">Kópia</div>
			<div class="col-md-1">Beküldve</div>
			<div class="col-md-1">Leírás</div>
			<div class="button-div col-md-2">
			<security:authorize access="hasRole('ROLE_ADMIN,ROLE_VENDOR')">
				<a href="#" class="btn btn-template-main list-header-btn" data-toggle="modal" data-target="#addCutOffer_modal">
					<span class="addButtonText">Új ajánlat</span>
				</a>
			</security:authorize>
			</div>
		</div>
		
		<c:if test="${not isMine}">
			<c:forEach var="cutOfferModel" items="${cutOfferModels.offers}" varStatus="allLoopStatus">
				<div class="row outer-table-row ${allLoopStatus.index % 2 == 0 ? 'even' : ''}">
					<div class="col-md-offset-1 col-md-2"><c:out value="${cutOfferModel.partner.name} "></c:out></div>
					<div class="col-md-4 offer-cut-title">
						<span><c:out value="${cutOfferModel.cut.filmMetaTitle} (${cutOfferModel.cut.title})"></c:out></span>
						<span class="x-small"><c:out value="${cutOfferModel.cut.filmMetaHungarianTitle} (${cutOfferModel.cut.hungarianTitle})"></c:out></span>
					</div>
					<div class="col-md-1 lm-date"><c:out value="${cutOfferModel.lastModifiedTime}"></c:out></div>
					<div class="col-md-2 description"><c:out value="${cutOfferModel.description} "></c:out></div>
					<div class="col-md-1">
						<security:authorize access="hasRole('ROLE_ADMIN')">
							<span class="listAction deleteOffer" data-offerId="${cutOfferModel.id}"><i class="fa fa-trash-o"></i></span>
						</security:authorize>
					</div>
				</div>
			</c:forEach>
		</c:if>
					
		<c:if test="${isMine}">
			<c:forEach var="cutOfferModel" items="${myCutOfferModels.offers}" varStatus="mineLoopStatus">
				<div class="row outer-table-row ${mineLoopStatus.index % 2 == 0 ? 'even' : ''}">
					<div class="col-md-offset-1 col-md-2"><c:out value="${cutOfferModel.partner.name} "></c:out></div>
					<div class="col-md-4 offer-cut-title">
						<span><c:out value="${cutOfferModel.cut.filmMetaTitle} (${cutOfferModel.cut.title})"></c:out></span>
						<span class="x-small"><c:out value="${cutOfferModel.cut.filmMetaHungarianTitle} (${cutOfferModel.cut.hungarianTitle})"></c:out></span>
					</div>
					<div class="col-md-1 lm-date"><c:out value="${cutOfferModel.lastModifiedTime}"></c:out></div>
					<div class="col-md-2 description" title="${cutOfferModel.description}"><c:out value="${cutOfferModel.description} "></c:out></div>
					<div class="col-md-1">
						<span class="listAction deleteOffer" data-offerId="${cutOfferModel.id}"><i class="fa fa-trash-o"></i></span>
					</div>
				</div>
			</c:forEach>
		</c:if>				
	</div>
	<!-- CUT OFFER LIST END -->

	<%-- CUT MODAL --%>
	<div class="modal fade" id="addCutOffer_modal" tabindex="-1"
		role="dialog" aria-labelledby="AddCutOffer" aria-hidden="true">
		<div class="modal-dialog modal-sm">

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="AddCutOffer">Kópia ajánlat hozzáadása/szerkesztése</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="cutOfferRequest"
						action="offers/offerPost" method="post">
						
						<form:input path="id" id="Id" type="number" style="display:none" />
						<div class="form-group">
							<form:select class="form-control" path="partnerId">
								<form:options items="${cutOfferModel.availableUsers}" />
							</form:select>
						</div>
						<div class="form-group">
							<form:select class="form-control" path="cutId">
								<form:options items="${cutOfferModel.availableCuts}" />
							</form:select>
						</div>
						<div class="form-group">
							<form:input path="description" type="text" class="form-control" id="Description" placeholder="Leirás"/>
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
	<%-- CUT MODAL END --%>
	

</t:master>