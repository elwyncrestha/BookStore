<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="pageHeader.jsp"></jsp:include>
</head>
<body>
	<div id="wrapper">

		<!-- Navigation -->
		<jsp:include page="nav.jsp"></jsp:include>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">User Profile</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-info">
						<div class="panel-heading">${UserProfile.get(0).firstName}
							${UserProfile.get(0).lastName}</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-2">
									<label>First Name: </label>
								</div>
								<div class="col-lg-10">
									<p>${UserProfile.get(0).firstName}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-2">
									<label>Last Name: </label>
								</div>
								<div class="col-lg-10">
									<p>${UserProfile.get(0).lastName}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-2">
									<label>Address: </label>
								</div>
								<div class="col-lg-10">
									<p>${UserProfile.get(0).address}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-2">
									<label>Date of Birth: </label>
								</div>
								<div class="col-lg-10">
									<p>${UserProfile.get(0).dob}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-2">
									<label>Phone number: </label>
								</div>
								<div class="col-lg-10">
									<p>${UserProfile.get(0).phone}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-2">
									<label>Gender: </label>
								</div>
								<div class="col-lg-10">
									<p>${UserProfile.get(0).gender}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-2">
									<label>Username: </label>
								</div>
								<div class="col-lg-10">
									<p>${UserProfile.get(0).username}</p>
								</div>
							</div>
						</div>
						<div class="panel-footer">Is Admin:
							${UserProfile.get(0).isAdmin}</div>
					</div>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-12">
					<p class="text-center">&copy; 2018 Elvin Shrestha. All Right
						Reserved.</p>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<jsp:include page="pageFooter.jsp"></jsp:include>
</body>
</html>