<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<t:master>

	<!-- GRAY HEADER -->
	<div id="heading-breadcrumbs" class="custom-heading">
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <h1>Dokumentumok</h1>
                </div>
            </div>
        </div>
    </div>
    <!-- GRAY HEADER -->

	<div class="navbar">
	<div class="container yamm-content ">
		<div class="row">
			<div class="col-md-offset-1 col-sm-3">
				<h5>2018. dokumentumok</h5>
				<ul>
					<jsp:include page="/WEB-INF/view/document_menu.jsp"></jsp:include>
				</ul>
			</div>
		</div>
	</div>
	</div>

</t:master>