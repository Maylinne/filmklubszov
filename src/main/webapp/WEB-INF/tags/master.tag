<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="robots" content="all,follow">
<meta name="googlebot" content="index,follow,snippet,archive">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>A Filmklub Szövetség hivatalos oldala</title>

<meta name="keywords" content="">

<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800'
	rel='stylesheet' type='text/css'>
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Pacifico"
	rel="stylesheet">

<!-- Bootstrap and Font Awesome css -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Css animations  -->
<link href="<c:url value="assets/css/animate.css" />" rel="stylesheet">

<!-- Theme stylesheet, if possible do not edit this stylesheet -->
<link href="<c:url value="assets/css/style.default.css" />"
	rel="stylesheet" id="theme-stylesheet">

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

<link href="css/owl.carousel.css" rel="stylesheet">
<link href="css/owl.theme.css" rel="stylesheet">
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
							<p class="hidden-sm hidden-xs">A Filmklub Mozgalom független
								civil háttérszervezete 1986 óta.</p>
							<p class="hidden-md hidden-lg">
								<a href="#" data-animate-hover="pulse"><i
									class="fa fa-phone"></i></a> <a href="#" data-animate-hover="pulse"><i
									class="fa fa-envelope"></i></a>
							</p>
						</div>
						<div class="col-xs-7">
							<div class="authentication login">
								<c:if test="${not empty homepageModel.loginUrl}">
									<a href="#" data-toggle="modal" data-target="#login-modal" />
									<i class="fa fa-sign-in"></i>
									<span class="hidden-xs text-uppercase">Bejelentkezés</span>
									</a>
								</c:if>
								<c:if test="${not empty homepageModel.logoutUrl}">
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
									style="font-family: 'Pacifico', serif; font-size: 39px; margin-top: 10px">filmklubszovetseg.hu</div>
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
								<li class="dropdown active"><a href="javascript: void(0)"
									class="dropdown-toggle" data-toggle="dropdown">Aktualitások</a>

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
															<a href="http://movies.filmklubszov.hu">muvek <i
																class="fa fa-external-link"></i></a>
														</h5>
														<ul>
															<li><a href="#">kopiak / csomagok</a></li>
															<li><a href="#">jogok</a></li>
															<li><a href="#">jogtulajdonosok</a></li>
														</ul>
														<h5>
															vetitesek <i class="fa fa-external-link"></i>
														</h5>
														<ul>
															<li><a href="#">sorozatok</a></li>
															<li><a href="#">kuratorok</a></li>
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
															klubelet <i class="fa fa-external-link"></i>
														</h5>
														<ul>
															<li><a href="#">termek / helyszinek </a></li>
															<li><a href="#">technika</a></li>
															<li><a href="#">uzemeltetok</a></li>
														</ul>
														<h5>
															beszelgetesek <i class="fa fa-external-link"></i>
														</h5>
														<ul>
															<li><a href="#">kozossegek</a></li>
															<li><a href="#">moderatorok</a></li>
															<li><a href="#">vendegeloadok</a></li>
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
														<h5>Dokumentumok</h5>
														<ul>
															<jsp:include page="/WEB-INF/view/document_menu.jsp"></jsp:include>
														</ul>
													</div>
												</div>
											</div>
										</li>
									</ul></li>


								<!-- ========== FULL WIDTH MEGAMENU END ================== -->
								<c:if test="${empty homepageModel.adminUrl}">
									<li class="dropdown"><a href="javascript: void(0)"
										class="dropdown-toggle" data-toggle="dropdown">Csatlakozz!</a>

									</li>
								</c:if>

								<c:if test="${not empty homepageModel.adminUrl}">
									<li class="dropdown use-yamm yamm-fw"><a href="#"
										class="dropdown-toggle" data-toggle="dropdown"
										data-hover="dropdown" data-delay="200"> Admind <b
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
														<ul>

															<li><a href="<c:url value="/movies" />">Filmek</a></li>
															<li><a href="<c:url value="/locations" />">Helyszinek</a></li>
															<li><a href="<c:url value="/users" />">Felhasználók</a></li>
															<li><a href="<c:url value="/offers" />">Ajánlatok</a></li>

														</ul>
													</div>
													</div>
												</div>
											</li>
										</ul></li>
								</c:if>

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

		<section>
			<!-- *** HOMEPAGE CAROUSEL ***
 _________________________________________________________ -->

			<div class="home-carousel">

				<div class="dark-mask"></div>

				<div class="container">
					<div class="homepage owl-carousel">
						<div class="item">
							<div class="row">
								<div class="col-sm-5 right">
									<ul class="list-style-none">
										<li>Szakmai projektjeink megvalósításában támogatónk a
											Magyar Művészeti Akadémia</li>

									</ul>
								</div>
							</div>
						</div>
					</div>
					<!-- /.project owl-slider -->
				</div>
			</div>

			<!-- *** HOMEPAGE CAROUSEL END *** -->
		</section>
		<section class="bar background-white">

			<jsp:doBody />

		</section>




		<section class="bar background-gray no-mb">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="heading text-center">
							<h2>Partnereink</h2>
						</div>


						<!-- /.owl-carousel -->
					</div>

				</div>
			</div>
		</section>


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
					<p class="pull-left">&copy; 2017. ArtCredo</p>
					<p class="pull-right">
						Oldalunk megújulása az <a href="http://mma.hu">MMA</a>
						támogatásából valósult meg 2016-ban.

					</p>

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