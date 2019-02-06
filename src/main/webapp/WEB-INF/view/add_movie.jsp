<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<t:master>
	<div class="container">

		<!-- == Add FilmMeta form == -->
		<div>
			<form:form modelAttribute="filmMetaRequest" action="addmovie" method="post">
				<div class="formGroup">
					<p>
						<label for="input_title">Title</label>
						<form:input path="title" id="input_title" placeholder="Title" />
					</p>
					<p>
						<label for="input_hunTitle">Hungarian title</label>
						<form:input path="hungarianTitle" id="input_hunTitle" placeholder="Hungarian title" />
					</p>
					<p>
						<label for="input_director">Director</label>
						<form:input path="director" id="input_director" placeholder="Director" />
					</p>
				</div>
				<button type="submit" class="btn btn-primary">Save</button>
			</form:form>
		</div>
		<!-- == Add FilmMeta form END == -->


		<!-- == FilmMeta list == -->
		<div>
			<div class="card">
				<div class="card-header">Locations</div>
				<div class="card-body">
					<table>
						<thead>
							<tr>
								<th>Title</th>
								<th>Hungarian title</th>
								<th>Director</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="filmMetaModel" items="${filmMetaModels}">
								<tr>
									<td><c:out value="${filmMetaModel.title}"></c:out></td>
									<td><c:out value="${filmMetaModel.hungarianTitle}"></c:out></td>
									<td><c:out value="${filmMetaModel.director}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</div>
		<!-- == FilmMeta list END== -->
		


	</div>
</t:master>