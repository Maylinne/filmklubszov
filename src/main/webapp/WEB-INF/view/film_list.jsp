<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
                     <h1>Vetíthető filmek</h1>
                 </div>
                 
             </div>
         </div>
     </div>
     <!-- GRAY HEADER END -->
     
     <!-- MODALS -->
	<div class="container">
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
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
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
							<div class="form-group flex-group">
								<form:input path="length" type="number" class="form-control" id="Length" placeholder="Hossz" />
							</div>
							<div class="form-group flex-group">
								<form:input path="year" type="number" class="form-control" id="Year" placeholder="Gyártási év" />
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
	
	<!-- FILM LIST -->
	<div class="container table-container movieTable">
		<div class="row outer-header-row">
			<div class="col-md-offset-1 col-md-6">Címek</div>
			<div class="col-md-2">Rendező</div>
			<div class="button-div col-md-2">
				<a href="#" class="btn btn-template-main list-header-btn" data-toggle="modal" data-target="#addFilm_modal">
					<span class="addButtonText">Új cím</span>
				</a>
			</div>
		</div>
		<c:forEach var="filmMetaModel" items="${filmMetaModels}" varStatus="loopStatus">
			<div class="row outer-table-row ${loopStatus.index % 2 == 0 ? 'even' : ''}">
				<div class="col-md-offset-1 col-md-1">(${fn:length(filmMetaModel.cuts)}) <span class="expandButton" data-filmMetaId="${filmMetaModel.id}"> <i class="fa fa-angle-down fa-2x middle"> </i></span></div>
				<div class="col-md-5"><c:out value="${filmMetaModel.title} (${filmMetaModel.hungarianTitle})"></c:out></div>
				<div class="col-md-3"><c:out value="${filmMetaModel.director}"></c:out></div>
				<div class="col-md-1">
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<span class="listAction deleteFilm" data-filmMetaId="${filmMetaModel.id}"><i class="fa fa-trash-o"></i></span> 
						<span class="listAction editFilm" data-filmMetaId="${filmMetaModel.id}"><i class="fa fa-edit"></i></span>
					</security:authorize>
				</div>
			</div>
			<div class="inner-rows">
				<div class="row inner-header-row" data-filmMetaId="${filmMetaModel.id}">
					<div class="col-md-offset-2 col-md-3">Kópiák</div>
					<div class="col-md-1">Év</div>
					<div class="col-md-1">Hossz</div>
					<div class="button-div col-md-4">
						<a href="#" class="btn btn-template-main list-header-btn addCut" data-filmMetaId="${filmMetaModel.id}" data-toggle="modal" data-target="#addCut_modal">
							<span class="addButtonText">Új kópia</span>
						</a>
					</div>
				</div>
				<c:forEach var="cutModel" items="${filmMetaModel.cuts}" varStatus="cutLoopStatus">
					<div class="row inner-table-row ${cutLoopStatus.index % 2 == 0 ? 'even' : ''}">
						<div class="col-md-offset-2 col-md-3 cut-title">
							<span><c:out value="${cutModel.title}"></c:out></span>
							<c:if test="${not empty cutModel.hungarianTitle}">
								<span class="x-small"><c:out value="${cutModel.hungarianTitle}"></c:out></span>
							</c:if>
						</div>
						<div class="col-md-1"><c:out value="${cutModel.year}"></c:out></div>
						<div class="col-md-4"><c:out value="${cutModel.length}"></c:out></div>
						<div class="col-md-1">
							<security:authorize access="hasRole('ROLE_ADMIN')">
								<span class="listAction deleteCut" data-cutId="${cutModel.cutId}" data-filmMetaId="${filmMetaModel.id}"><i class="fa fa-trash-o"></i></span> 
								<span class="listAction editCut" data-cutId="${cutModel.cutId}" data-filmMetaId="${filmMetaModel.id}"><i class="fa fa-edit"></i></span>
							</security:authorize>
						</div>
					</div>		
				</c:forEach>
			</div>
		</c:forEach>				
	</div>
	<!-- FILM LIST END -->



</t:master>