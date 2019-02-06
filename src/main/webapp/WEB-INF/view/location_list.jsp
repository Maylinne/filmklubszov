<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<t:master>

	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<p class="text-muted lead">Helyek listája</p>
			</div>
			<div class="col-md-12 clearfix" id="films">
				<div class="box">

					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th colspan="2">Név</th>
									<th>Város</th>
									<th colspan="2">Cim</th>
									<th style="width: 120px"><a href="#" data-toggle="modal" data-target="#addLocation_modal"><i class="fa fa-plus-square fa-2x"></i><span class="addButtonText">Helyszin</span></a></th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="locationModel" items="${locationModels}">
									<tr>
										<td><span class="expandButton"> <i class="fa fa-angle-down fa-2x"> </i></span></td>
										<td><h5>
												<c:out value="${locationModel.name}"></c:out>
											</h5></td>
										<td><c:out value="${locationModel.city}"></c:out></td>
										<td colspan="2"><c:out value="${locationModel.address}"></c:out></td>
										<td>
											<span class="listAction deleteLocation"><i class="fa fa-trash-o"></i></span>
											<span class="listAction editLocation"><i class="fa fa-edit"></i></span>
										</td>
									</tr>


									<tr class="subTableRow" data-locationId="${locationModel.id}">
									<td></td>
										<td colspan="5">
												<table class="table">
													<thead>
														<tr>
															<th colspan="2">Név</th>
															<th>Férőhelyek</th>
															<th class="spotModal" style="width: 110px"><a href="#" data-toggle="modal" data-target="#addSpot_modal"><i class="fa fa-plus-square fa-2x"></i><span class="addButtonText">Terem</span></a></th>
														</tr>
													</thead>
													<tbody>
														<c:if test="${not empty locationModel.spots}">
														<c:forEach var="spotModel" items="${locationModel.spots}">
														<tr>
															
															<td colspan="2"><c:out value="${spotModel.name}"></c:out></td>
															<td><c:out value="${spotModel.places}"></c:out></td>
															
														
															
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
		
		<div class="modal fade" id="addLocation_modal" tabindex="-1" role="dialog" aria-labelledby="AddLocation" aria-hidden="true">
            <div class="modal-dialog modal-sm">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="AddLocation">Helyszin hozzáadása/szerkesztése</h4>
                    </div>
                    <div class="modal-body">
                        <form:form modelAttribute="locationRequest" action="location/addlocation" method="post">
                            <div class="form-group">
                                <form:input path="name" type="text" class="form-control" id="Name" placeholder="Helyszin neve" />
                            </div>
							<div class="form-group">
                                <form:input path="city" type="text" class="form-control" id="City" placeholder="Város" />
                            </div>
                            <div class="form-group">
                                <form:input path="address" type="text" class="form-control" id="Address" placeholder="Cim" />
                            </div>

                            <p class="text-center">
                                <button type="submit" class="btn btn-template-main"><i class="fa fa-sign-in"></i> Mentés</button>
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
                        <form:form modelAttribute="spotRequest" action="location/addspot" method="post">
                        	<form:input path="locationId" id="LocationId" type="number" style="display:none"/>
                            <div class="form-group">
                                <form:input path="name" type="text" class="form-control" id="Name" placeholder="Terem neve" />
                            </div>
							<div class="form-group">
                                <form:input path="places" type="number" class="form-control" id="Places" placeholder="Helyek" />
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