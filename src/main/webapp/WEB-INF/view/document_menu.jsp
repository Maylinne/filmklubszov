<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:forEach var="driveFile" items="${driveFiles}">
	<li>
		<a href="/documents/download?fileId=${driveFile.id}">
			<i class="fa fa-icon fa-file-text"></i>
			<c:out value="${driveFile.name}" />
		</a>
	</li>
</c:forEach>