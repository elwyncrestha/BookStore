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
					<h1 class="page-header">Dashboard</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-book fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${CountDetails.bookCount}</div>
									<div>Total Books</div>
								</div>
							</div>
						</div>
						<a href="${cp}/backend/book/display/all">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="panel panel-green">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-tasks fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${CountDetails.bookCategoryCount}</div>
									<div>Total Book Categories</div>
								</div>
							</div>
						</div>
						<a href="${cp}/backend/book/category/display/all">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="panel panel-yellow">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-users fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${CountDetails.userCount}</div>
									<div>Total Users</div>
								</div>
							</div>
						</div>
						<a href="${cp}/backend/account/display/all">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
			</div>
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<b>Welcome to Book Store Dashboard</b>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<!-- Nav tabs -->
							<ul class="nav nav-tabs">
								<li class="active"><a href="#intro" data-toggle="tab"
									aria-expanded="true">Intro</a></li>
								<li class=""><a href="#book" data-toggle="tab"
									aria-expanded="false">Book</a></li>
								<li class=""><a href="#bookgenre" data-toggle="tab"
									aria-expanded="false">Book Genre</a></li>
								<li class=""><a href="#bookCategory" data-toggle="tab"
									aria-expanded="false">Book Category</a></li>
								<li class=""><a href="#userManagement" data-toggle="tab"
									aria-expanded="false">User management</a></li>
							</ul>

							<!-- Tab panes -->
							<div class="tab-content">
								<div class="tab-pane fade active in" id="intro">
									<h4>Introduction Tab</h4>
									<p class="text-justify">Dashboard is only designed for the
										back end users who control the book store. This web interface
										is featured with multiple navigations: Dashboard, Book
										Registration, Display Book List, Edit Book Information, Book
										Category (sub-lists: Add category, Display categories), User
										management (sub-lists: Display Users, Edit user details).
										These tabs will provide short description of each navigations.</p>
								</div>
								<div class="tab-pane fade" id="book">
									<h4>Book Tab</h4>
									<p class="text-justify">
										Book is sub divided into three different lists. <br> A
										list named <b>Book Registration</b> is used for adding or
										registering new books. Similarly, <b>Display Book List</b> is
										used for displaying available books in the store. And <b>Edit
											Book Information</b> is used for editing the book details. Also,
										it is used for changing the quantity of available books.
									</p>
								</div>
								<div class="tab-pane fade" id="bookgenre">
									<h4>Book Genre Tab</h4>
									<p class="text-justify">
										In order to assign specific genre of the book, the navigation
										named Book Genre can be used.<br> Sub categories are: <b>Assign
											book genre</b> and <b>Display book genre</b>. Assign book genre
										can be used to assign and edit (re-assign) the book category
										or genre. Whereas, Display book genre can be used to view the list of categorized books.
									</p>
								</div>
								<div class="tab-pane fade" id="bookCategory">
									<h4>Book Category Tab</h4>
									<p class="text-justify">
										Books are categorized into different category according to its
										genre. To add or display book category, this navigation can be
										used. Moreover, in order to edit or delete the category, <b>Display
											categories</b> navigation can be used.
									</p>
								</div>
								<div class="tab-pane fade" id="userManagement">
									<h4>User management Tab</h4>
									<p class="text-justify">
										To view or edit the user details, <b>User management</b> can
										be used. It is sub categorized into two different lists: <b>Display
											Users</b> and <b>Edit user details</b>.
									</p>
								</div>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-6 -->
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