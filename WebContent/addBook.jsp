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
					<h1 class="page-header">Book</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Add Book</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<form role="form"
								action="${pageContext.request.contextPath}/backend/book/add"
								method="post" enctype="multipart/form-data">
								<fieldset>
									<div class="form-group">
										<label>Book Name:</label> <input class="form-control"
											name="bookName" type="text"
											placeholder="In Search of Lost Time: Swann's Way, Vol. 1"
											required>
									</div>
									<div class="form-group">
										<label>Book Price:</label> <input class="form-control"
											name="bookPrice" type="text" placeholder="$14.40" required>
											<p class="help-block">Note: No need to write currency symbol.</p>
									</div>
									<div class="form-group">
										<label>Book Author:</label> <input class="form-control"
											name="bookAuthor" type="text" placeholder="Marcel Proust" required>
									</div>
									<div class="form-group">
										<label>Book Publisher:</label> <input class="form-control"
											name="bookPublisher" type="text" placeholder="Hardcover" required>
									</div>
									<div class="form-group">
										<label>Book Publication Date:</label> <input
											class="form-control" name="bookPublishedDate" type="date"
											required>
									</div>
									<div class="form-group">
										<label>Book Image:</label> <input class="form-control"
											name="bookImageURL" type="file" required>
									</div>
									<div class="form-group">
										<label>Book Quantity:</label> <input class="form-control"
											name="bookQuantity" type="text" placeholder="100" required>
									</div>
									<div class="form-group">
										<input type="submit" value="ADD"
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

</body>
</html>