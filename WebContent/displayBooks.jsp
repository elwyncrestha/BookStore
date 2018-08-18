<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<h1 class="page-header">List of Books</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Books Table</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Book Id</th>
										<th>Book Name</th>
										<th>Book Price</th>
										<th>Book Author</th>
										<th>Book Publisher</th>
										<th>Book Publication Date</th>
										<th>Book Quantities</th>
										<th>Book Image</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${BookDetails}" var="bd">
									<tr>
										<td>${bd.bookId}</td>
										<td>${bd.bookName}</td>
										<td>$ ${bd.bookPrice}</td>
										<td>${bd.bookAuthor}</td>
										<td>${bd.bookPublisher}</td>
										<td>${bd.bookPublishedDate}</td>
										<td>${bd.bookQuantity}</td>
										<td><img src="${cp}/images/${bd.bookImageName}" alt="${bd.bookImageName}" style="width: 100px; height: 100px;"></td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							<!-- /.table-responsive -->
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