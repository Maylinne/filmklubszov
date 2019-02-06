<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<t:master>

		<div class="container">

			<div class="modal-dialog modal-sm">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="Login">Bejelentkezés</h4>
					</div>

					<div class="modal-body">

						<form:form modelAttribute="loginRequest"
							action="j_spring_security_check">
							<form:errors element="div" cssClass="validation-error" />
							<div class="form-group">
								<p>
									<form:input path="username" class="form-control"
										id="input_email" placeholder="E-mail" />
								</p>
								<p>
									<form:password path="password" class="form-control"
										id="input_password" placeholder="Jelszó" />
								</p>
							</div>
							<p class="text-center">
								<button type="submit" class="btn btn-template-main">
									<i class="fa fa-sign-in"></i> Bejelentkezés
								</button>
							</p>
						</form:form>

					</div>

				</div>
			</div>
		</div>

</t:master>