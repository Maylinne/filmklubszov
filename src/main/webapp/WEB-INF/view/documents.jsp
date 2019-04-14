<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<t:master>

		<div class="row">
			<div class="col-sm-3">
				<h5>Dokumentumok</h5>
				<ul>
					<jsp:include page="/WEB-INF/view/document_menu.jsp"></jsp:include>
				</ul>
			</div>
		</div>

</t:master>