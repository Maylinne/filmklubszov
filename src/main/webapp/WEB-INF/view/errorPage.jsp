<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>


<t:master>

		<div class="container">

			<h1>Ajjaj, valami hiba történt!</h1>
			<h5>${errorMsg}</h5>

		</div>
	
</t:master>