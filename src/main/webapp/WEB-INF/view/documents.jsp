<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<t:master>

		<div class="container">

			<h1>Welcome</h1>
			
			<button action="documents" method="post">Create Drive</button>
			
<div>
			<div class="card">
				<div class="card-header">Documents</div>
				<div class="card-body">
					<table>
						<thead>
							<tr>
								<th>Document name</th>
								<th>Document id</th>
								<th>Document MIME type</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="driveFile" items="${driveFiles}">
								<tr>
									<td><a href="/fksz/documents/download?fileId=${driveFile.id}"><c:out value="${driveFile.name}" /></a></td>
									<td><c:out value="${driveFile.id}"></c:out></td>
									<td><c:out value="${driveFile.mimeType}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</div>

		</div>
	
</t:master>