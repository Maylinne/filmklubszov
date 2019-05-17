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
                    <h1>Üdvözlünk, ${user.name}!</h1>
                </div>
            </div>
        </div>
    </div>
    <!-- GRAY HEADER -->
	<div class="container">


		<div class="col-md-12">
			<p class="text-muted">Az új jelszónak legalább 8 karakter hosszúnak kell lennie.</p>
			<c:if test="${empty successMsg and empty errorMsg}">
				<p><br></p>
			</c:if>
			<c:if test="${not empty errorMsg}">
				<p class="text-muted" style="color:red"><i class="fa fa-exclamation-triangle"></i> ${errorMsg}</p>
			</c:if>
			<c:if test="${not empty successMsg}">
				<p class="text-muted" style="color:#38A7BB"><i class="fa fa-check"></i> ${successMsg}</p>
			</c:if>
		</div>


		<form:form class="col-md-4" modelAttribute="changePswRequest" action="profile/changepsw" method="post">
			<form:input path="userId" id="Id" type="number" style="display:none" value="${user.id}"/>
			<div class="form-group">
				<form:input path="oldPsw" type="password" class="form-control" id="OldPsw" placeholder="Régi jelszó" />
			</div>
			<div class="form-group">
				<form:input path="newPsw" type="password" class="form-control" id="NewPsw" placeholder="Új jelszó" />
			</div>
			<div class="form-group">
				<form:input path="newPswAgain" type="password" class="form-control" id="NewPswAgain" placeholder="Új jelszó újra" />
			</div>

			<p class="text-center">
				<button type="submit" class="btn btn-template-main">
					<i class="fa fa-sign-in"></i> Mentés
				</button>
			</p>

		</form:form>



	</div>

</t:master>