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
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<form role="form">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="E-mail" name="email"
										type="email" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name="password" type="password" value="">
								</div>
								<div class="checkbox">
									<label> <input name="remember" type="checkbox"
										value="Remember Me">Remember Me
									</label>
								</div>
								<div class="form-group">
                                    <input type="submit" class="btn btn-lg btn-success btn-block" value="Login">
                                </div>
                                <div class="form-group text-center">
                                    <a href="${pageContext.request.contextPath}/backend/account/register">Register an account <i class="fa fa-long-arrow-right"></i></a>
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