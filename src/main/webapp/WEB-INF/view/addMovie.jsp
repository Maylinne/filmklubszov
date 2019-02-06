<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:master>

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


							<form:form modelAttribute="filmMetaRequest" action="addmovie" method="post">
								<div id="movieForm" style="display: none" class="content formElement ft_formelement">
									<div class="row">
										<div class="col-sm-12">
											<div class="form-group">
												<label for="title">Film címe</label> 
												<form:input type="text" path="title" class="form-control" name="title" id="title" />
											</div>
											
											<div class="form-group">
												<label for="hungarianTitle">Magyar cím</label> 
												<form:input type="text" path="hungarianTitle" class="form-control" name="hungarianTitle" id="hungarianTitle" />
											</div>
											
											<div class="form-group">
												<label for="title">Rendező</label> 
												<form:input type="text" path="director" class="form-control" name="director" id="director" />
											</div>
											
										
										</div>
									</div>
									<!-- /.row -->

									<!-- /.row -->


								</div>
								<button type="submit" class="btn btn-primary">Save</button>
							</form:form>

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



</t:master>