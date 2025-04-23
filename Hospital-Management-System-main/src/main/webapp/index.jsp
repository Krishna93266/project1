<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>
	
	<% Connection conn=DBConnect.getConn(); %>

	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/hos.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/hos2.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/hos3.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<div class="container p-3">
		<p class="text-center fs-2">Key Features of our Hospital</p>
		<div class="row">
			<!-- Key Features Section -->
			<div class="col-md-8 p-5">
				<div class="row">
					<!-- Comprehensive Patient Care -->
					<div class="col-md-6 mb-4">
						<div class="card paint-card h-100">
							<div class="card-body">
								<p class="fs-5">Comprehensive Patient Care</p>
								<p>Efficient patient registration, appointment scheduling,
									and medical history management</p>
							</div>
						</div>
					</div>
					<!-- Expert Medical Staff -->
					<div class="col-md-6 mb-4">
						<div class="card paint-card h-100">
							<div class="card-body">
								<p class="fs-5">Expert Medical Staff</p>
								<p>Access detailed profiles of qualified doctors and
									specialists available for consultations</p>
							</div>
						</div>
					</div>
					<!-- Advanced Diagnostic Services -->
					<div class="col-md-6 mb-4">
						<div class="card paint-card h-100">
							<div class="card-body">
								<p class="fs-5">Advanced Diagnostic Services</p>
								<p>State-of-the-art diagnostic tools and services to ensure
									accurate and timely diagnosis</p>
							</div>
						</div>
					</div>
					<!-- Seamless Billing & Payments -->
					<div class="col-md-6 mb-4">
						<div class="card paint-card h-100">
							<div class="card-body">
								<p class="fs-5">Seamless Billing & Payments</p>
								<p>Easy and transparent billing system with multiple payment
									options and insurance integration</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Image Section -->
			<div class="col-md-4">
				<img alt="Doctor" src="img/doct.jpg" class="img-fluid">
			</div>
		</div>
	</div>

	<hr>
	<div class="container p-2">
		<p class="text-center fs-2 ">Our Team</p>
		<div class="row">
			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="img/doc1.jpeg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr. Ananya Sharma</p>
						<p class="fs-7">(CEO & chairman)</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="img/doc2.jpeg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr. Aarav Mehta</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="img/doc3.jpeg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr. Kabir Singh</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="img/doc4.jpeg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr. Rohan Malhotra</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>
		</div>
	</div>

<%@include file="component/footer.jsp" %>

</body>
</html>