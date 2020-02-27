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
                    <h1>Report</h1>
                </div>
            </div>
        </div>
    </div>
    <!-- GRAY HEADER -->

	<div class="navbar">
	<div class="container yamm-content ">
		<div class="row">
			<iframe width="100%" height="700" src=${configModel.value} frameborder="0" allowFullScreen="true"></iframe>
		</div>
	</div>
	</div>

</t:master>