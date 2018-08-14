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
				<div class="panel panel-warning login-panel">
					<div class="panel-heading">ERROR</div>
					<div class="panel-body">
						<p>${ErrorMessage}</p>
					</div>
					<div class="panel-footer"><a href="${pageContext.request.contextPath}/frontend/homepage"><i class="fa fa-long-arrow-left"></i>Back to Home page</a></div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="pageFooter.jsp"></jsp:include>
</body>
</html>