<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="uri" value="${req.requestURI}" />
<c:set var="url">${req.requestURL}</c:set>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="robots" content="all,follow">
<meta name="googlebot" content="index,follow,snippet,archive">
<meta name="viewport" content="width=device-width, initial-scale=1">
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />

<title>A Magyar Filmklubszövetség hivatalos oldala</title>

<meta name="keywords" content="">

<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800'
	rel='stylesheet' type='text/css'>
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Pacifico"
	rel="stylesheet">

<!-- Bootstrap and Font Awesome css -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Css animations  -->
<link href="<c:url value="assets/css/animate.css" />" rel="stylesheet">

<!-- Theme stylesheet, if possible do not edit this stylesheet -->
<link href="<c:url value="assets/css/style.default.css" />" rel="stylesheet" id="theme-stylesheet">

<!-- Custom stylesheet - for your changes -->
<link href="<c:url value="assets/css/custom.css" />" rel="stylesheet">
<link href="<c:url value="assets/css/forViktor.css" />" rel="stylesheet">

<!-- Responsivity for older IE -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- Favicon and apple touch icons-->
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<link rel="apple-touch-icon" href="img/apple-touch-icon.png" />
<link rel="apple-touch-icon" sizes="57x57"
	href="img/apple-touch-icon-57x57.png" />
<link rel="apple-touch-icon" sizes="72x72"
	href="img/apple-touch-icon-72x72.png" />
<link rel="apple-touch-icon" sizes="76x76"
	href="img/apple-touch-icon-76x76.png" />
<link rel="apple-touch-icon" sizes="114x114"
	href="img/apple-touch-icon-114x114.png" />
<link rel="apple-touch-icon" sizes="120x120"
	href="img/apple-touch-icon-120x120.png" />
<link rel="apple-touch-icon" sizes="144x144"
	href="img/apple-touch-icon-144x144.png" />
<link rel="apple-touch-icon" sizes="152x152"
	href="img/apple-touch-icon-152x152.png" />
<!-- owl carousel css -->

<link href="<c:url value="assets/css/owl.carousel.css" />" rel="stylesheet">
<link href="<c:url value="assets/css/owl.theme.css" />" rel="stylesheet">
<link <c:url value="assets/css/forViktor.css" /> rel="stylesheet">
</head>

<body class="boxed">

	<div id="all">

		<header>

			<!-- *** TOP ***
_________________________________________________________ -->
			<div id="top">
				<div class="container">
					<div class="row">
						<div class="col-xs-5 contact">
							<p class="hidden-sm hidden-xs">A Magyar Filmklub Mozgalom független civil háttérszervezete.</p>
							<p class="hidden-md hidden-lg">
								<a href="#" data-animate-hover="pulse"><i
									class="fa fa-phone"></i></a> <a href="#" data-animate-hover="pulse"><i
									class="fa fa-envelope"></i></a>
							</p>
						</div>
						<div class="col-xs-7">
						
							<div class="social">
                                <a href="https://www.facebook.com/filmklubszovetseg/" class="facebook external" data-animate-hover="pulse"><i class="fa fa-facebook"></i></a>
                                <a href="#" class="gplus" data-animate-hover="pulse"><i class="fa fa-meetup"></i></a>
                                <a href="#" class="email" data-animate-hover="pulse"><i class="fa fa-envelope"></i></a>
                            </div>
							<div class="authentication login">
								<c:if test="${not empty homepageModel.loginUrl}">
									<a href="#" data-toggle="modal" data-target="#login-modal" />
										<i class="fa fa-sign-in"></i>
										<span class="hidden-xs text-uppercase">tagoknak</span>
									</a>
								</c:if>
								<c:if test="${not empty homepageModel.logoutUrl}">
									<a href="<c:url value="/profile"/>">
										<i class="fa fa-lock"></i> <span class="hidden-xs text-uppercase">Jelszóváltoztatás</span>
									</a>
									<a href="<c:url value='${homepageModel.logoutUrl}' />"> <i
										class="fa fa-sign-in"></i> <span
										class="hidden-xs text-uppercase">Kijelentkezés</span>
									</a>
								</c:if>
							</div>

						</div>

					</div>
				</div>
			</div>

			<!-- *** TOP END *** -->

			<!-- *** NAVBAR ***
    _________________________________________________________ -->

			<div class="navbar-affixed-top" data-spy="affix"
				data-offset-top="200">

				<div class="navbar navbar-default yamm" role="navigation"
					id="navbar">

					<div class="container">
						<div class="navbar-header">

							<a class="navbar-brand home" href="">
								<div
									style="font-family: 'Pacifico', serif; font-size: 39px; margin-top: 10px">filmklubszov.hu</div>
							</a>
							<div class="navbar-buttons">
								<button type="button" class="navbar-toggle btn-template-main"
									data-toggle="collapse" data-target="#navigation">
									<span class="sr-only">Toggle navigation</span> <i
										class="fa fa-align-justify"></i>
								</button>
							</div>
						</div>
						<!--/.navbar-header -->

						<div class="navbar-collapse collapse" id="navigation">
                            <ul class="nav navbar-nav navbar-right">
								<li class="nav-extra-container">
								<div class="dropdown">
									<security:authorize access="hasAnyRole('ROLE_ADMIN,ROLE_VENDOR')">
									<button class="btn btn-secondary dropdown-toggle extra-button" type="button" id="filmExtraDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										<i class="fa fa-film fa-2x"></i></br>Kópiák
									</button>
									</security:authorize>
									<div class="dropdown-menu dropdown-extra" aria-labelledby="filmExtraDropdown">
										<a class="btn btn-secondary dropdown-toggle extra-button" href="<c:url value="/movies" />">
											<i class="fa fa-pie-chart fa-2x"></i></br>Összes
										</a>
										<hr class="extra-hr">
										<a class="btn btn-secondary dropdown-toggle extra-button" href="<c:url value="/offers/mycutoffers" />">
											<i class="fa fa-copyright fa-2x"></i></br>Saját
										</a>
									</div>
								</div>
								<div class="dropdown">
									<security:authorize access="hasAnyRole('ROLE_ADMIN,ROLE_VENDOR')">
									<button class="btn btn-secondary dropdown-toggle extra-button" type="button" id="locationExtraDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										<i class="fa fa-map-marker fa-2x"></i></br>Termek
									</button>
									</security:authorize>
									<div class="dropdown-menu dropdown-extra" aria-labelledby="filmExtraDropdown">
										<a class="btn btn-secondary dropdown-toggle extra-button" href="<c:url value="/locations" />">
											<i class="fa fa-pie-chart fa-2x"></i></br>Összes
										</a>
										<hr class="extra-hr">
										<a class="btn btn-secondary dropdown-toggle extra-button" href="<c:url value="/offers/myspotoffers" />">
											<i class="fa fa-copyright fa-2x"></i></br>Saját
										</a>
									</div>
								</div>
									<security:authorize access="hasAnyRole('ROLE_ADMIN')">
									<button id="userList" class="btn btn-secondary dropdown-toggle extra-button" >
										<i class="fa fa-group fa-2x"></i></br>Tagok
									</button>
									</security:authorize>
								</li>
								<li class="dropdown active"><a href="javascript: void(0)"
									class="dropdown-toggle" data-toggle="dropdown">Hírek</a>

								</li>
								<li class="dropdown use-yamm yamm-fw"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown">Filmet<b
										class="caret"></b></a>
									<ul class="dropdown-menu">
										<li>
											<div class="yamm-content">
												<div class="row">

													<div class="col-sm-3">
														<img src="assets/img/filmlogo.png" class="img-responsive hidden-xs" alt="">
													</div>

													<div class="col-sm-3">
														<h5>
															alkotások <i class="fa fa-external-link"></i>
														</h5>
														<ul>
															<li><a href="<c:url value="/offers/allcutoffers" />">kopiák / csomagok</a></li>
															<li><a href="#">jogok</a></li>
															<li><a href="#">jogtulajdonosok</a></li>
														</ul>
														<h5>
															vetítések <i class="fa fa-external-link"></i>
														</h5>
														<ul>
															<li><a href="#">sorozatok</a></li>
															<li><a href="#">kurátorok</a></li>
															<li><a href="#">technikusok</a></li>
															<li><a href="#">gyik</a></li>
														</ul>
													</div>

												</div>
											</div>
										</li>
									</ul></li>
								<li class="dropdown use-yamm yamm-fw"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown">Klubot<b
										class="caret"></b></a>
									<ul class="dropdown-menu">
										<li>
											<div class="yamm-content">
												<div class="row">

													<div class="col-sm-3">
														<img src="assets/img/filmlogo.png" class="img-responsive hidden-xs" alt="">
													</div>

													<div class="col-sm-3">
														<h5>
															klubélet <i class="fa fa-external-link"></i>
														</h5>
														<ul>
															<li><a href="<c:url value="/offers/allspotoffers" />">termek / helyszínek </a></li>
															<li><a href="#">technika</a></li>
															<li><a href="#">üzemeltetők</a></li>
														</ul>
														<h5>
															beszélgetések <i class="fa fa-external-link"></i>
														</h5>
														<ul>
															<li><a href="#">közösségek</a></li>
															<li><a href="#">moderátorok</a></li>
															<li><a href="#">vendégelőadók</a></li>
															<li><a href="#">gyik</a></li>
														</ul>
													</div>

												</div>
											</div>
										</li>
									</ul></li>
								<!-- ========== FULL WIDTH MEGAMENU ================== -->
								<li class="dropdown use-yamm yamm-fw"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown"
									data-hover="dropdown" data-delay="200"> Szövetséget<b
										class="caret"></b>
								</a>
									<ul class="dropdown-menu">
										<li>
											<div class="yamm-content">
												<div class="row">

													<div class="col-sm-3">
														<img src="assets/img/filmlogo.png" class="img-responsive hidden-xs" alt="">
													</div>

													<div class="col-sm-3">
														<h5>klubszakma <i class="fa fa-external-link"></i></h5>
														<ul>
                                                            <li><a href="#">filmterjesztés</a></li>
                                                            <li><a href="#">szervezőcsapatok / hálozatok</a></li>
                                                            <li><a href="#">kulturális pályázatok</a></li>
                                                        </ul>
														<h5>mozgalom <i class="fa fa-external-link"></i></h5>
                                                        <ul>
                                                            <li><a href="#">történet (1923-1986)</a></li>
                                                            <li><a href="#">szereplők / partnerek</a></li>
                                                            <li><a href="#">civil pályázatok</a></li>
                                                        </ul>
													</div>
													
													<div class="col-sm-3">
														<h5>egyesület <i class="fa fa-external-link"></i></h5>
                                                        <ul>
                                                            <li><a href="#">történet (1986-2014)</a></li>
                                                            <li><a href="#">tagok / tisztségviselők</a></li>
                                                            <li><a href="#">elérhetőségek</a></li>
                                                            <li><a href="#">projektek</a></li>
                                                            <li><a href="#">programok</a></li>
                                                            <li><a href="#">ösztöndíjak</a></li>
                                                            <li><a href="#">minősitések</a></li>
                                                            <li><a href="#">gyik</a></li>
                                                        </ul>
													</div>
													
													<div class="col-sm-3">
														<h5>Dokumentumok <i class="fa fa-external-link"></i></h5>
								                        <ul>
									                        <li><a href="<c:url value="/documents" />">beszámolók</a></li>
                                                            <li><a href="<c:url value="/documents" />">szabályzatok</a></li>
                                                            <li><a href="<c:url value="/documents" />">jegyzőkönyvek</a></li>
                                                            <li><a href="<c:url value="/documents" />">tervezetek</a></li>
								                        </ul>
													</div>
												</div>
											</div>
										</li>
									</ul></li>


								<!-- ========== FULL WIDTH MEGAMENU END ================== -->
									<li class="dropdown"><a href="javascript: void(0)"
										class="dropdown-toggle joinButton" data-toggle="dropdown">Jelentkezés</a>

									</li>


							</ul>

						</div>
						<!--/.nav-collapse -->



						<div class="collapse clearfix" id="search">

							<form class="navbar-form" role="search">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="Search">
									<span class="input-group-btn">

										<button type="submit" class="btn btn-template-main">
											<i class="fa fa-search"></i>
										</button>

									</span>
								</div>
							</form>

						</div>
						<!--/.nav-collapse -->

					</div>


				</div>
				<!-- /#navbar -->

			</div>

			<!-- *** NAVBAR END *** -->

		</header>

		<!-- *** LOGIN MODAL ***
_________________________________________________________ -->

		<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
			aria-labelledby="Login" aria-hidden="true">
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
									<form:input path="email" class="form-control"
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

		<!-- *** LOGIN MODAL END *** -->

		<section class="bar background-white custom-background">

			<jsp:doBody />

		</section>

		<div class="modal fade" id="confirmation_modal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 id="confirm-title"></h4>
					</div>
					<div class="modal-body">
						<p id="confirm-info"></p>
						<div class="confirm-modal-buttons">
							<button type="button" id="confirm-yes" data-dismiss="modal" class="btn btn-template-main">Igen</button>
							<button type="button" id="confirm-no" data-dismiss="modal" class="btn btn-template-main">Nem</button>
						</div>
					</div>
				</div>
			</div>
		</div>





		<!-- *** GET IT ***
_________________________________________________________ -->

		<div id="get-it">
			<div class="container">
				<div class="col-md-8 col-sm-12">
					<h3></h3>
				</div>
				<div class="col-md-4 col-sm-12"></div>
			</div>
		</div>


		<!-- *** GET IT END *** -->




		<!-- *** COPYRIGHT ***
_________________________________________________________ -->

		<div id="copyright">
            <div class="container">
                <div class="col-md-12">
                    <p class="pull-right">&copy; ArtCredo & ProRec Media.</p><span class="clearfix"></span>
                    <p class="pull-right footer-lh-5">Tárhelyünket a <a href="http://mafihe.hu/">Magyar Fizikushallgatók Egyesülete</a> biztosítja.</p><span class="clearfix"></span>
                </div>
                <div class="col-md-12 footer-mma">
                    <img class="pull-right" alt="Oldalunk megújulása a Magyar Művészeti Akadémia támogatásából valósult meg 2016. és 2019. között." height="60" src="http://www.mma.hu/mma-theme/images/logo/hu_HU.png" width="55">
                    <p class="pull-right footer-mma-desc">
                        Oldalunk megújulása a</br>
                        <a href="http://mma.hu/">Magyar Művészeti Akadémia</a></br>
                        támogatásából valósult meg</br>
                        2016. és 2019. között</p>
                </div>
            </div>
        </div>
		<!-- /#copyright -->

		<!-- *** COPYRIGHT END *** -->



	</div>
	<!-- /#all -->

	<!-- #### JAVASCRIPT FILES ### -->

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/jquery-1.11.0.min.js"><\/script>')
	</script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


	<script src="<c:url value="assets/js/formForViktor.js" />"></script>
	<script src="<c:url value="assets/js/jquery.cookie.js" />"></script>
	<script src="<c:url value="assets/js/waypoints.min.js" />"></script>
	<script src="<c:url value="assets/js/jquery.counterup.min.js" />"></script>
	<script src="<c:url value="assets/js/jquery.parallax-1.1.3.js" />"></script>
	<script src="<c:url value="assets/js/front.js" />"></script>

	<!-- owl carousel -->
	<script src="<c:url value='assets/js/owl.carousel.min.js' />"></script>

</body>
</html>
