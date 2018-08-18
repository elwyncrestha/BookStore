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
					<h1 class="page-header">Edit Book</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Enter required informations</div>
						<!-- .panel-heading -->
						<div class="panel-body">
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne" aria-expanded="true" class="">First
												accordion: How to edit ? </a>
										</h4>
									</div>
									<div id="collapseOne" class="panel-collapse collapse in"
										aria-expanded="true" style="">
										<div class="panel-body">
											<h4>Load book details in third accordion using the form
												of second accordion.</h4>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseTwo" class="collapsed" aria-expanded="false">Second
												accordion: Load book details</a>
										</h4>
									</div>
									<div id="collapseTwo" class="panel-collapse collapse"
										aria-expanded="false">
										<div class="panel-body">
											<form role="form"
												action="${pageContext.request.contextPath}/backend/book/edit/all"
												method="post">
												<fieldset>
													<div class="form-group">
														<label>Book Id:</label> <input class="form-control"
															name="bookId" type="text" required>
													</div>
													<div class="form-group">
														<input type="submit" value="Search"
															class="btn btn-lg btn-success btn-block btn-outline">
													</div>
												</fieldset>
											</form>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseThree" class="collapsed"
												aria-expanded="false">Third accordion: Editable book
												details</a>
										</h4>
									</div>
									<div id="collapseThree" class="panel-collapse collapse"
										aria-expanded="false">
										<div class="panel-body">
											<form role="form"
												action="${pageContext.request.contextPath}/backend/book/edit"
												method="post" enctype="multipart/form-data">
												<fieldset>
													<div class="form-group">
														<label>Book ID:</label> <input type="text"
															class="form-control" value="${EditBookDetails.bookId}"
															name="bookId" readonly>
													</div>
													<div class="form-group">
														<img src="${cp}/images/${EditBookDetails.bookImageName}"
															alt="${EditBookDetails.bookImageName}"
															class="img-responsive" style="margin: 0 auto;">
													</div>
													<div class="form-group">
														<label>Book Name:</label> <input class="form-control"
															name="bookName" type="text"
															value="${EditBookDetails.bookName}" required>
													</div>
													<div class="form-group">
														<label>Book Price:</label> <input class="form-control"
															name="bookPrice" type="text"
															value="${EditBookDetails.bookPrice}" required>
														<p class="help-block">Note: No need to write currency
															symbol.</p>
													</div>
													<div class="form-group">
														<label>Book Author:</label> <input class="form-control"
															name="bookAuthor" type="text"
															value="${EditBookDetails.bookAuthor}" required>
													</div>
													<div class="form-group">
														<label>Book Publisher:</label> <input class="form-control"
															name="bookPublisher" type="text"
															value="${EditBookDetails.bookPublisher}" required>
													</div>
													<div class="form-group">
														<label>Book Publication Date:</label> <input
															class="form-control" name="bookPublishedDate"
															value="${EditBookDetails.bookPublishedDate}" type="date"
															required>
													</div>
													<div class="form-group">
														<label>Book Image:</label> <input class="form-control"
															name="bookImageURL" type="file">
													</div>
													<div class="form-group">
														<label>Add/remove book (Quantity):</label> <input
															class="form-control" name="bookQuantity" type="text"
															placeholder="100" required>
														<p class="help-block">Note: Add minus (-) sign for
															deducting book quantity.</p>
													</div>
													<div class="form-group">
														<input type="submit" value="UPDATE"
															class="btn btn-lg btn-success btn-block btn-outline">
													</div>
													<div class="form-group">
														<a
															href="" data-toggle="modal" data-target="#deleteModal"
															class="btn btn-lg btn-danger btn-block btn-outline">Delete</a>
													</div>
												</fieldset>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- .panel-body -->
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

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>

	<!-- Delete Modal -->
	<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title" id="exampleModalLabel">Are you sure ?</h3>
				</div>
				<div class="modal-body">...</div>
				<div class="modal-footer">
					<a href="${cp}/backend/book/delete?id=${EditBookDetails.bookId}" class="btn btn-primary">Delete</a>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>