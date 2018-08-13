<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="pageHeader.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="fa fa-book"></i> Book Store - Register an account
						</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="" method="post">
							<fieldset>
								<div class="row">
									<div class="form-group col-lg-6">
										<label>First name:</label> <input class="form-control"
											placeholder="Jack" name="firstName" type="text" autofocus
											required>
									</div>
									<div class="form-group col-lg-6">
										<label>Last name:</label> <input class="form-control"
											placeholder="Edward" name="lastName" type="text" required>
									</div>
								</div>
								<div class="form-group">
									<label>Address:</label> <input class="form-control"
										placeholder="Tahachal-13, Kathmandu, Nepal" name="address"
										type="text" required>
								</div>
								<div class="form-group">
									<label>Date of birth:</label> <input class="form-control"
										name="dob" type="date" required>
								</div>
								<div class="form-group">
									<label>Phone number:</label> <input class="form-control"
										placeholder="+977 986-0687788" name="phoneNumber" type="text"
										required>
								</div>
								<div class="form-group">
									<label>Gender:</label> <label class="radio-inline"> <input
										type="radio" name="gender" value="M" checked="">Male
									</label> <label class="radio-inline"> <input type="radio"
										name="gender" value="F">Female
									</label> <label class="radio-inline"> <input type="radio"
										name="gender" value="O">Others
									</label>
								</div>
								<div class="form-group">
									<label>Enter email:</label> <input class="form-control"
										placeholder="jackedward@gmail.com" name="email" type="email"
										required>
									<p class="help-block">Your email address will be used as
										username for login.</p>
								</div>
								<div class="form-group">
									<label>Enter password:</label> <input class="form-control"
										placeholder="********" name="password" type="password"
										minlength="8" required>
								</div>
								<div class="form-group">
									<input type="submit" value="Register"
										class="btn btn-lg btn-success btn-block btn-outline">
								</div>
								<div class="form-group text-center">
									<a href="${pageContext.request.contextPath}/backend/account/login">Login instead <i class="fa fa-long-arrow-left"></i></a>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="pageFooter.jsp"></jsp:include>
</body>
</html>