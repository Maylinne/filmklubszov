<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<t:master>
		<div class="container">
		<!-- == Add Location form == -->
			<div>
				<form:form modelAttribute="locationRequest" action="location" method="post">
					<div class="form-group">
						<p>
							<label for="input_city">City</label>
							<form:input path="city" id="input_city" placeholder="City" />
						</p>
						<p>
							<label for="input_author">Address</label>
							<form:input path="address" id="input_address"
								placeholder="Address" />
						</p>
						<p>
							<label for="input_description">Description</label>
							<form:textarea path="description" id="input_description"
								placeholder="Description" />
						</p>
					</div>
					<button type="submit" class="btn btn-primary">Save</button>
				</form:form>
			</div>
			<!-- == Add Location form END == -->

			<!-- == Location list == -->
			<div>

				<div class="card">
					<div class="card-header">Locations</div>
					<div class="card-body">
						<table>
							<thead>
								<tr>
									<th>City</th>
									<th>Address</th>
									<th>Description</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="location" items="${locations}">
									<tr>
										<td><c:out value="${location.city}"></c:out></td>
										<td><c:out value="${location.address}"></c:out></td>
										<td><c:out value="${location.description}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>
			<!-- == Location list END == -->

		</div>
</t:master>