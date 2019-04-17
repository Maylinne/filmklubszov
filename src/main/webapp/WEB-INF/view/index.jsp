<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<t:master>
	<!-- To check the role. Dev purposes -->
	<security:authorize access="hasRole('ROLE_VENDOR')">
		This text is only visible to a vendor <br/>
	</security:authorize>
	<security:authorize access="hasRole('ROLE_ADMIN')">
		This text is only visible to an admin <br/>
	</security:authorize>

        <section class="bar background-pentagon">
                <div class="container">
                
                    <div class="row showcase">
                        <div class="col-md-3 col-sm-6">
                            <div class="item">
                                <div class="icon"><i class="fa fa-align-justify"></i>
                                </div>
                                <h4><span class="counter">70</span><br>klub</h4>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="item">
                                <div class="icon"><i class="fa fa-align-justify"></i>
                                </div>
                                <h4><span class="counter">100</span><br>sorozat</h4>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="item">
                                <div class="icon"><i class="fa fa-copy"></i>
                                </div>
                                <h4><span class="counter">950</span><br>alkalom</h4>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="item">
                                <div class="icon"><i class="fa fa-users"></i>
                                </div>
                                <h4><span class="counter">118000</span><br>érdeklődő</h4>
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container -->
            </section>
        
        

        <section class="bar background-gray no-mb">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="heading text-center">
                        
                        </div>

                        
                        <!-- /.owl-carousel -->
                    </div>

                </div>
            </div>
        </section>


        <!-- /#content -->
</t:master>