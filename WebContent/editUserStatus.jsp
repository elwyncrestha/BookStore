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
					<h1 class="page-header">Edit User Status</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Edit Admin Status</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<form role="form"
								action="${pageContext.request.contextPath}/backend/account/edit/data"
								method="post">
								<fieldset>
									<div class="row">
										<div class="form-group col-lg-4">
											<label>User Id:</label> <input class="form-control" name="id"
												type="text" value="${UserDetails.get(0).userId}" readonly>
										</div>
										<div class="form-group col-lg-4">
											<label>First name:</label> <input class="form-control"
												placeholder="Jack" name="firstName" type="text"
												value="${UserDetails.get(0).firstName}" readonly>
										</div>
										<div class="form-group col-lg-4">
											<label>Last name:</label> <input class="form-control"
												placeholder="Edward" name="lastName" type="text"
												value="${UserDetails.get(0).lastName}" readonly>
										</div>
									</div>
									<!-- /.row -->
									<div class="row">
										<div class="form-group col-lg-4">
											<label>Address:</label> <input class="form-control"
												placeholder="Tahachal-13, Kathmandu, Nepal" name="address"
												type="text" value="${UserDetails.get(0).address}" readonly>
										</div>

										<div class="form-group col-lg-4">
											<label>Date of birth:</label> <input class="form-control"
												name="dob" type="date" value="${UserDetails.get(0).dob}"
												readonly>
										</div>
										<div class="form-group col-lg-4">
											<label>Phone number:</label> <input class="form-control"
												placeholder="+977 986-0687788" name="phoneNumber"
												type="text" value="${UserDetails.get(0).phone}" readonly>
										</div>
									</div>
									<!-- /.row -->
									<div class="row">
										<div class="form-group col-lg-12">
											<label>Gender:</label> <label class="radio-inline"> <input
												type="radio" name="gender" value="M"
												<c:if test="${UserDetails.get(0).gender.equals('M')}">checked="checked"</c:if>>Male
											</label> <label class="radio-inline"> <input type="radio"
												name="gender" value="F" readonly
												<c:if test="${UserDetails.get(0).gender.equals('F')}">checked="checked"</c:if>>Female
											</label> <label class="radio-inline"> <input type="radio"
												name="gender" value="O" readonly
												<c:if test="${UserDetails.get(0).gender.equals('O')}">checked</c:if>>Others
											</label>
										</div>
									</div>
									<!-- /.row -->
									<div class="row">
										<div class="form-group col-lg-6">
											<label>Enter email:</label> <input class="form-control"
												placeholder="jackedward@gmail.com" name="email" type="email"
												value="${UserDetails.get(0).username}" readonly>
											<p class="help-block">Your email address will be used as
												username for login.</p>
										</div>
										<div class="form-group col-lg-6">
											<label>Enter password:</label> <input class="form-control"
												placeholder="********" name="password" type="password"
												minlength="8" value="${UserDetails.get(0).password}"
												readonly>
										</div>
									</div>
									<!-- /.row -->
									<div class="form-group">
										<label>Is Admin:</label> <label class="radio-inline">
											<input type="radio" name="adminStatus" value="true"
											<c:if test="${UserDetails.get(0).isAdmin.equals(true)}">checked</c:if>>True
										</label><label class="radio-inline"> <input type="radio"
											name="adminStatus" value="false"
											<c:if test="${UserDetails.get(0).isAdmin.equals(false)}">checked</c:if>>False
										</label>
									</div>
									<div class="form-group">
										<input type="submit" value="Update"
											class="btn btn-lg btn-success btn-block btn-outline">
									</div>
								</fieldset>
							</form>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
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

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>

</body>
</html>