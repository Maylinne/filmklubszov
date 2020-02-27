<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<t:master>

		<div class="container">

			<h3>Configurations</h3>
			<form:form class="col-md-4" modelAttribute="configModel" action="config/saveurl" method="post">
			
			<form:input path="id" id="Id" type="number" style="display:none" value="${configModel.id}"/>
			<form:input path="key" id="Key" type="teyt" style="display:none" value="${configModel.key}"/>
			
				<div class="form-group">
					<form:input path="value" type="text" class="form-control" id="ReportUrl" placeholder="Report url" />
				</div>
	
				<p class="text-center">
					<button type="submit" class="btn btn-template-main">
						<i class="fa fa-sign-in"></i> Mentés
					</button>
				</p>
	
			</form:form>

		</div>
	
</t:master>