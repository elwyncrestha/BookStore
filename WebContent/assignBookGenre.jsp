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
					<h1 class="page-header">Assign Book Categories</h1>
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
												accordion: How to assign ? </a>
										</h4>
									</div>
									<div id="collapseOne" class="panel-collapse collapse in"
										aria-expanded="true" style="">
										<div class="panel-body">
											<h4>Load book in third accordion using the button of
												second accordion, and assign the categories.</h4>
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
											<table width="100%"
												class="table table-striped table-bordered table-hover"
												id="dataTables-example">
												<thead>
													<tr>
														<th>Book Image</th>
														<th>Book Name</th>
														<th>Load</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${BookDetails}" var="bd">
														<tr>
															<td><img src="${cp}/images/${bd.bookImageName}"
																alt="${bd.bookImageName}"
																style="width: 100px; height: 100px;"></td>
															<td>${bd.bookName}</td>
															<td><a
																href="${cp}/backend/bbc/load/one?id=${bd.bookId}"
																class="btn btn-success btn-block">Load</a></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
											<!-- /.table-responsive -->
										</div>
									</div>
								</div>
								<c:if test="${not empty BBCDetails}">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapseThree" class="collapsed"
													aria-expanded="false">Third accordion: Assign book
													genre</a>
											</h4>
										</div>
										<div id="collapseThree" class="panel-collapse collapse"
											aria-expanded="false">
											<div class="panel-body">
												<form role="form"
													action="${pageContext.request.contextPath}/backend/bbc/assign"
													method="post">
													<fieldset>
														<div class="form-group">
															<label>Book ID:</label> <input type="text"
																class="form-control" value="${BBCDetails.bookId}"
																name="bookId" readonly required>
														</div>
														<div class="form-group">
															<label>Book Name:</label> <input class="form-control"
																name="bookName" type="text"
																value="${BBCDetails.bookName}" required readonly>
														</div>
														<div class="form-group">
															<c:forEach items="${CategoryDetails}" var="cd">
																<label class="checkbox-inline"> <input
																	type="checkbox" name="categoryId"
																	value="${cd.categoryId}"> ${cd.categoryName}
																</label>
															</c:forEach>
														</div>
														<div class="form-group">
															<input type="submit" value="Assign"
																class="btn btn-lg btn-success btn-block btn-outline">
														</div>
													</fieldset>
												</form>
											</div>
										</div>
									</div>
								</c:if>
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

</body>
</html>