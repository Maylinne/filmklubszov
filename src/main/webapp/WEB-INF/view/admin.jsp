<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<t:master>

		<div class="container">

			<a href="<c:url value="/addmovie" />">Add movie</a>
			<br/>
			<a href="<c:url value="/location" />">Add location</a>

		</div>

</t:master>