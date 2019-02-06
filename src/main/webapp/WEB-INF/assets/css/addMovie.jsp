<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<link href="<c:url value="assets/css/style.default.css" />" rel="stylesheet"
	id="theme-stylesheet">

<!-- Custom stylesheet - for your changes -->
<link href="<c:url value="assets/css/custom.css" />" rel="stylesheet">

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
<link href="css/forViktor.css" rel="stylesheet">
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
							<div class="social">
								<a href="#" class="external facebook" data-animate-hover="pulse"><i
									class="fa fa-facebook"></i></a> <a href="#" class="external gplus"
									data-animate-hover="pulse"><i class="fa fa-meetup"></i></a>
								<!--a href="#" class="external twitter" data-animate-hover="pulse"><i class="fa fa-twitter"></i></a-->
								<a href="#" class="email" data-animate-hover="pulse"><i
									class="fa fa-envelope"></i></a>
							</div>

							<div class="login">
								<a href="#" data-toggle="modal" data-target="#login-modal"><i
									class="fa fa-sign-in"></i> <span
									class="hidden-xs text-uppercase">tagoknak</span></a>
								<!--<a href="#" data-toggle="modal" data-target="#login-modal"><i class="fa fa-sign-in"></i> <span class="hidden-xs text-uppercase">partnereknek</span></a>-->
								<a href="form.html"><i class="fa fa-sign-in"></i> <span
									class="hidden-xs text-uppercase">partnereknek</span></a>
								<!--a href="customer-register.html"><i class="fa fa-sign-in"></i> <span class="hidden-xs text-uppercase">partnereknek</span></a-->
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

							<a class="navbar-brand home" href="index.html">
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
									class="dropdown-toggle" data-toggle="dropdown">Filmklubok<b
										class="caret"></b></a>
									<ul class="dropdown-menu">
										<li>
											<div class="yamm-content">
												<div class="row"></div>
											</div>
										</li>
									</ul></li>
								<li class="dropdown use-yamm yamm-fw"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown">A Mozgalom <b
										class="caret"></b></a>
									<ul class="dropdown-menu">
										<li>
											<div class="yamm-content">
												<div class="row"></div>
											</div>
										</li>
									</ul></li>
								<!-- ========== FULL WIDTH MEGAMENU ================== -->
								<li class="dropdown use-yamm yamm-fw"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown"
									data-hover="dropdown" data-delay="200">A Szövetség <b
										class="caret"></b></a>
									<ul class="dropdown-menu">
										<li>
											<div class="yamm-content">
												<div class="row"></div>
											</div> <!-- /.yamm-content -->
										</li>
									</ul></li>
								<!-- ========== FULL WIDTH MEGAMENU END ================== -->

								<li class="dropdown"><a href="javascript: void(0)"
									class="dropdown-toggle" data-toggle="dropdown">Csatlakozz!</a>

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
						<h4 class="modal-title" id="Login">Customer login</h4>
					</div>
					<div class="modal-body">
						<form action="customer-orders.html" method="post">
							<div class="form-group">
								<input type="text" class="form-control" id="email_modal"
									placeholder="email">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="password_modal"
									placeholder="password">
							</div>

							<p class="text-center">
								<button class="btn btn-template-main">
									<i class="fa fa-sign-in"></i> Log in
								</button>
							</p>

						</form>
						
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
			<div class="container">
				<!--<div class="col-md-12">

            <div class="item">
                    <div class="row">
                        <div class="col-sm-5 right">
                            <ul class="list-style-none">


                            </ul>
                        </div>
                        <div class="col-sm-7">
                            <img class="img-responsive" src="img/MMA.png" alt="">
                        </div>
                    </div>
             </div>


        </div>-->
				<div class="row">

					<div class="col-md-offset-1 col-md-6 clearfix" id="checkout">

						<div class="box">
							<div class="myForm">

								<ul class="nav nav-pills nav-justified">
									<li id="movieButton" data-formId="movie"
										class="active formNavButton"><a href="#"><i
											class="fa fa-film"></i><br>Film</a></li>
									<li id="venuesButton" data-formid="venues"
										class="formNavButton"><a href="#"><i
											class="fa fa-map-marker"></i><br>Helyszín</a></li>
									<li class="disabled"></li>
									<li class="disabled"></li>
								</ul>

								<div id="movieForm" style="display: none"
									class="content formElement ft_formelement">
									<div class="row">
										<div class="col-sm-12">
											<div class="form-group">
												<label for="title">Film címe</label> <input type="text"
													class="form-control" name="title" id="title">
											</div>
										</div>
									</div>
									<!-- /.row -->

									<!-- /.row -->

									<div class="row">
										<div class="col-sm-6 col-md-6">
											<div class="form-group">
												<label for="author">Rendező</label> <input type="text"
													class="form-control" name="author" id="author">
											</div>
										</div>

										<div class="col-sm-6 col-md-3">
											<div class="form-group">
												<label for="year">Év</label> <input type="number"
													class="form-control" name="year" id="year">
											</div>
										</div>

										<div class="col-sm-6 col-md-3">
											<div class="form-group">
												<label for="length">Hossz</label> <input type="number"
													class="form-control" name="length" id="length">
											</div>
										</div>



									</div>

									<div class="row">
										<div class="col-sm-12">
											<div class="form-group">
												<label for="imdb_url">IMDB Url</label> <input type="text"
													class="form-control" name="imdb_url" id="imdb_url">
											</div>
										</div>
									</div>

									<!-- /.row -->
								</div>

								<div id="venuesForm" style="display: none"
									class="content formElement ft_formelement">
									<div class="venuesHead">
										<div class=" row">
											<div class="col-sm-12">
												<div class="form-group">
													<label for="name">Név</label> <input type="text"
														name="name" class="form-control" id="name">
												</div>
											</div>
										</div>
										<!-- /.row -->

										<div class="row">
											<div class="col-sm-3">
												<div class="form-group">
													<label for="zip">Irányítószám</label> <input type="number"
														name="ZIPCode" class="form-control" id="zip">
												</div>
											</div>

											<div class="col-sm-4">
												<div class="form-group">
													<label for="city">Város</label> <input type="text"
														name="city" class="form-control" id="city">
												</div>
											</div>

											<div class="col-sm-5">
												<div class="form-group">
													<label for="address">Cím</label> <input type="text"
														name="address" class="form-control" id="adress">
												</div>
											</div>
										</div>
										<!-- /.row -->
									</div>
									<table class="myTable spotTable">

									</table>

									<div class="row">
										<div class="pull-left col-md-6">
											<button type="button" class="btn btn-template-main myButton">Terem
												hozzáadása</button>
										</div>
										<!--<div class="col-md-12">
                                            <table id="spotTable" class="spotTable">
                                                <thead>
                                                    <tr>
                                                        <th style="width:90%">Terem adatok</th>
                                                        <th style="width:10%">#</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                </tbody>
                                            </table>
                                        </div>-->
									</div>
									<!-- /.row -->
								</div>

								<div class="box-footer">
									<!--<div class="pull-left">
                                        <a href="shop-basket.html" class="btn btn-default"><i class="fa fa-chevron-left"></i>Back to basket</a>
                                    </div>-->
									<div class="pull-right">
										<button type="button" class="btn btn-template-main saveJson">
											Adatok mentése<i class="fa fa-chevron-right"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
						<!-- /.box -->


					</div>
					<!-- /.col-md-9 -->

					<div class="col-md-4">

						<div class="box" id="order-summary">
							<div class="box-header">
								<h3>Partner Adatok</h3>
							</div>
							<p class="text-muted">Mentés után a következő formátum kerül
								az adatbázisba:</p>

							<div id="forTheJson">
								<p></p>

							</div>

						</div>

					</div>
					<!-- /.col-md-3 -->

				</div>
				<!-- /.row -->

			</div>
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
	<script src="<c:url value="assets/js/jquery.cookie.js" />" ></script>
	<script src="<c:url value="assets/js/waypoints.min.js" />"></script>
	<script src="<c:url value="assets/js/jquery.counterup.min.js" />"></script>
	<script src="<c:url value="assets/js/jquery.parallax-1.1.3.js" />"></script>
	<script src="<c:url value="assets/js/front.js" />"></script>



	<!-- owl carousel -->
	<script src="js/owl.carousel.min.js"></script>



</body>

</html>