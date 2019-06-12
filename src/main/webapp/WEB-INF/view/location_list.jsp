<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:master>
	<!-- GRAY HEADER -->
	<div id="heading-breadcrumbs" class="custom-heading">
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <h1>Vetítőhelyek</h1>
                </div>
            </div>
        </div>
    </div>
    <!-- GRAY HEADER -->
        
    <!-- LOCATION LIST -->
	<div class="container table-container locationTable">
			<div class="row outer-header-row">
			<div class="col-md-offset-1 col-md-4">Név</div>
			<div class="col-md-4">(Város) Cím</div>
			<div class="button-div col-md-2">
				<a href="#" class="btn btn-template-main list-header-btn" data-toggle="modal" data-target="#addLocation_modal">
					<span class="addButtonText">Új helyszín</span>
				</a>
			</div>
		</div>
		
		<c:forEach var="locationModel" items="${locationModels}" varStatus="loopStatus">
			<div class="row outer-table-row ${loopStatus.index % 2 == 0 ? 'even' : ''}">
				<div class="col-md-offset-1 col-md-1">(${fn:length(locationModel.spots)}) <span class="expandButton"> <i class="fa fa-angle-down fa-2x middle"> </i></span></div>
				<div class="col-md-3"><c:out value="${locationModel.name} "></c:out></div>
				<div class="col-md-5"><c:out value="(${locationModel.city}) ${locationModel.address}"></c:out></div>
				<div class="col-md-1">
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<span class="listAction deleteLocation" data-locationId="${locationModel.id}"><i class="fa fa-trash-o"></i></span> 
						<span class="listAction editLocation" data-locationId="${locationModel.id}"><i class="fa fa-edit"></i></span>
					</security:authorize>
				</div>
			</div>
			<div class="inner-rows">
				<div class="row inner-header-row" data-locationId="${locationModel.id}">
					<div class="col-md-offset-2 col-md-3">Termek</div>
					<div class="col-md-2">Férőhelyek</div>
					<div class="button-div col-md-4">
						<a href="#" class="btn btn-template-main list-header-btn addSpot" data-locationId="${locationModel.id}" data-toggle="modal" data-target="#addSpot_modal">
							<span class="addButtonText">Új terem</span>
						</a>
					</div>
				</div>
				<c:forEach var="spotModel" items="${locationModel.spots}" varStatus="spotLoopStatus">
					<div class="row inner-table-row ${spotLoopStatus.index % 2 == 0 ? 'even' : ''}">
						<div class="col-md-offset-2 col-md-3"><c:out value="${spotModel.name}"></c:out></div>
						<div class="col-md-5"><c:out value="${spotModel.places}"></c:out></div>
						<div class="col-md-1">
							<security:authorize access="hasRole('ROLE_ADMIN')">
								<span class="listAction deleteSpot" data-spotId="${spotModel.id}"><i class="fa fa-trash-o"></i></span> 
								<span class="listAction editSpot" data-spotId="${spotModel.id}"><i class="fa fa-edit"></i></span>
							</security:authorize>
						</div>
					</div>		
				</c:forEach>
			</div>
		</c:forEach>				
	</div>
	<!-- LOCATION LIST END -->
    
    <!-- MODALS -->
	<div class="container">

		<div class="modal fade" id="addLocation_modal" tabindex="-1" role="dialog" aria-labelledby="AddLocation" aria-hidden="true">
			<div class="modal-dialog modal-sm">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="AddLocation">Helyszin hozzáadása/szerkesztése</h4>
					</div>
					<div class="modal-body">
						<form:form modelAttribute="locationRequest" action="locations/addlocation" method="post">
							<form:input path="id" id="Id" type="number" style="display:none"/>
							<div class="form-group">
								<form:input path="name" type="text" class="form-control"
									id="Name" placeholder="Helyszin neve" />
							</div>
							<div class="form-group">
								<form:input path="city" type="text" class="form-control"
									id="City" placeholder="Város" />
							</div>
							<div class="form-group">
								<form:input path="address" type="text" class="form-control"
									id="Address" placeholder="Cim" />
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

		<div class="modal fade" id="addSpot_modal" tabindex="-1" role="dialog" aria-labelledby="AddSpot" aria-hidden="true">
			<div class="modal-dialog modal-sm">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="AddSpot">Terem hozzáadása/szerkesztése</h4>
					</div>
					<div class="modal-body">
						<form:form modelAttribute="spotRequest" action="locations/addspot"
							method="post">
							<form:input path="id" id="SpotId" type="number" style="display:none" />
							<form:input path="locationId" id="LocationId" type="number" style="display:none" />
							<div class="form-group">
								<form:input path="name" type="text" class="form-control" id="Name" placeholder="Terem neve" />
							</div>
							<div class="form-group flex-group">
								<span class="flex-label form-control no-border">Férőhelyek:</span>
								<form:input path="places" type="number" class="form-control flex-input" id="Places" placeholder="Helyek" />
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
	<!-- MODALS END -->

</t:master>