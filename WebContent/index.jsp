<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="A web based book store developed using Java Server Pages and Servlet">
<meta name="author" content="Elvin Shrestha">

<title>Book Store</title>

<!-- Bootstrap core CSS -->
<link href="${cp}/frontendFiles/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link
	href="${cp}/frontendFiles/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="${cp}/frontendFiles/css/agency.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">Book
				Store</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fa fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#services">Services</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#portfolio">Books</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#about">About</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#team">Team</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#contact">Contact</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="" data-toggle="modal" data-target="#logoutModal"><i
							class="fa fa-sign-out fa-fw"></i> Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Header -->
	<header class="masthead">
		<div class="container">
			<div class="intro-text">
				<div class="intro-lead-in">Welcome To Our Bookstore!</div>
				<div class="intro-heading">It's Nice To Meet You</div>
				<a class="btn btn-xl js-scroll-trigger" href="#services">Tell Me
					More</a>
			</div>
		</div>
	</header>

	<!-- Services -->
	<section id="services">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">Services</h2>
					<h3 class="section-subheading text-muted">A short introduction
						on our services</h3>
				</div>
			</div>
			<div class="row text-center">
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fa fa-circle fa-stack-2x text-primary"></i> <i
						class="fa fa-book fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="service-heading">Books of your Interest</h4>
					<p class="text-muted">On the basis of your interest, we will
						present you with the available list of books. You can choose
						different book categories as per your interest.</p>
				</div>
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fa fa-circle fa-stack-2x text-primary"></i> <i
						class="fa fa-laptop fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="service-heading">Online Transactions</h4>
					<p class="text-muted">Being a web based bookstore, every
						transactional activities will be carried out through the Internet.</p>
				</div>
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fa fa-circle fa-stack-2x text-primary"></i> <i
						class="fa fa-lock fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="service-heading">Web Security</h4>
					<p class="text-muted">This site is secure. Transactions are
						processed without any breach. Also, user's data privacy is taken
						proper consideration and is well maintained.</p>
				</div>
			</div>
		</div>
	</section>

	<!-- Books Grid -->
	<section class="bg-light" id="portfolio">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">Books</h2>
					<h3 class="section-subheading text-muted">Lists of available
						books and its description.</h3>
				</div>
			</div>
			<div class="row">
				<div class="text-center">
					<form action="${cp}/backend/uci/update" method="post" novalidate>
						<div class="form-group">
							<h5>Your genre interest:</h5>
							<br>
							<c:forEach items="${CategoryDetails}" var="cd">
								<span> <label> <input type="checkbox"
										name="categoryId" value="${cd.categoryId}"
										<c:if test="${VerifyCategory.contains(cd.categoryName)}">checked</c:if>>
										${cd.categoryName}
								</label>
								</span>
							</c:forEach>
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-xl js-scroll-trigger"
								value="Update">
						</div>
					</form>
				</div>
			</div>
			<hr />
			<div class="row">
				<c:if test="${not empty BookDetails}">
					<c:forEach items="${BookDetails}" var="bd">
						<div class="col-md-4 col-sm-6 portfolio-item">
							<a class="portfolio-link" data-toggle="modal"
								href="#portfolioModal${bd.bookId}">
								<div class="portfolio-hover">
									<div class="portfolio-hover-content">
										<i class="fa fa-plus fa-3x"></i>
									</div>
								</div> <img class="img-fluid" src="${cp}/images/${bd.bookImageName}"
								alt="${bd.bookImageName}" style="width: 400px; height: 300px;">
							</a>
							<div class="portfolio-caption">
								<h4>${bd.bookName}</h4>
								<p class="text-muted">By: ${bd.bookAuthor}</p>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty BookDetails}">
					<div class="text-center">
						<h1>No books available as per your genre interest.</h1>
					</div>
				</c:if>
			</div>
		</div>
	</section>

	<!-- About -->
	<section id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">About</h2>
					<h3 class="section-subheading text-muted">About our bookstore.</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<ul class="timeline">
						<li>
							<div class="timeline-image">
								<img class="rounded-circle img-fluid"
									src="${cp}/frontendFiles/img/about/1.jpg" alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>June 2018</h4>
									<h4 class="subheading">Our Humble Beginnings</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">The idea of this bookstore was
										collectively initiated by Elvin Shrestha and Mohammad Sheikh
										Hussain. The basic idea was to develop a web application that
										will work as normal bookstore.</p>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-image">
								<img class="rounded-circle img-fluid"
									src="${cp}/frontendFiles/img/about/2.jpg" alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>July 2018</h4>
									<h4 class="subheading">Interface Design</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">As per proposed idea of the project,
										initial designs were made using a wireframe. Actual interface
										is powered by Bootstrap framework and Javascript.</p>
								</div>
							</div>
						</li>
						<li>
							<div class="timeline-image">
								<img class="rounded-circle img-fluid"
									src="${cp}/frontendFiles/img/about/3.jpg" alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>August 2018</h4>
									<h4 class="subheading">Site Development</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">A static site was brought to live
										using Java Server Pages and Servlets. The core of this site is
										powered by Java programming language.</p>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-image">
								<img class="rounded-circle img-fluid"
									src="${cp}/frontendFiles/img/about/4.jpg" alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>August 2018</h4>
									<h4 class="subheading">Ready to Go!</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">As per plan, site got fully
										functionable by the end of August. This bookstore is very
										simple application that allows a user to search through
										various categories of books as per his/her interest.</p>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-image">
								<h4>
									Be Part <br>Of Our <br>Story!
								</h4>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</section>

	<!-- Team -->
	<section class="bg-light" id="team">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">Our Small Amazing Team</h2>
					<h3 class="section-subheading text-muted">A group of two
						peoples.</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="team-member">
						<img class="mx-auto rounded-circle"
							src="${cp}/frontendFiles/img/team/1.jpg" alt="">
						<h4>Mohammad Sheikh Hussain</h4>
						<p class="text-muted">Suggestor, Ideator</p>
						<ul class="list-inline social-buttons">
							<li class="list-inline-item"><a href="#"> <i
									class="fa fa-twitter"></i>
							</a></li>
							<li class="list-inline-item"><a
								href="https://github.com/Mohammadhussain257"> <i
									class="fa fa-github"></i>
							</a></li>
							<li class="list-inline-item"><a href="#"> <i
									class="fa fa-linkedin"></i>
							</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="team-member">
						<img class="mx-auto rounded-circle"
							src="${cp}/frontendFiles/img/team/2.jpg" alt="">
						<h4>Elvin Shrestha</h4>
						<p class="text-muted">Ideator, Lead Designer and Developer</p>
						<ul class="list-inline social-buttons">
							<li class="list-inline-item"><a
								href="https://twitter.com/elwyncrestha"> <i
									class="fa fa-twitter"></i>
							</a></li>
							<li class="list-inline-item"><a
								href="https://github.com/elwyncrestha"> <i
									class="fa fa-github"></i>
							</a></li>
							<li class="list-inline-item"><a
								href="https://www.linkedin.com/in/elvin-shrestha-a559a6156/">
									<i class="fa fa-linkedin"></i>
							</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8 mx-auto text-center">
					<p class="large text-muted">First I (Elvin Shrestha) initiated
						this idea to design and develop a web based application. My friend
						(Mohammad) provided me some ideas. We developed two distinct
						bookstore on our own. This one is mine. You can check out his work
						in his Github repository.</p>
				</div>
			</div>
		</div>
	</section>

	<!-- Contact -->
	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">Contact Us</h2>
					<h3 class="section-subheading text-muted">Provide us your
						authentic information to contact us.</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<form id="contactForm" name="sentMessage" novalidate>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<input class="form-control" id="name" type="text"
										placeholder="Your Name *" required
										data-validation-required-message="Please enter your name.">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									<input class="form-control" id="email" type="email"
										placeholder="Your Email *" required
										data-validation-required-message="Please enter your email address.">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									<input class="form-control" id="phone" type="tel"
										placeholder="Your Phone *" required
										data-validation-required-message="Please enter your phone number.">
									<p class="help-block text-danger"></p>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<textarea class="form-control" id="message"
										placeholder="Your Message *" required
										data-validation-required-message="Please enter a message."></textarea>
									<p class="help-block text-danger"></p>
								</div>
							</div>
							<div class="clearfix"></div>
							<div class="col-lg-12 text-center">
								<div id="success"></div>
								<button id="sendMessageButton" class="btn btn-xl" type="submit">Send
									Message</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<span class="copyright">Copyright &copy; Book Store 2018</span>
				</div>
				<div class="col-md-4">
					<ul class="list-inline social-buttons">
						<li class="list-inline-item"><a
							href="https://twitter.com/elwyncrestha"> <i
								class="fa fa-twitter"></i>
						</a></li>
						<li class="list-inline-item"><a
							href="https://github.com/elwyncrestha"> <i
								class="fa fa-github"></i>
						</a></li>
						<li class="list-inline-item"><a
							href="https://www.linkedin.com/in/elvin-shrestha-a559a6156/">
								<i class="fa fa-linkedin"></i>
						</a></li>
					</ul>
				</div>
				<div class="col-md-4">
					<ul class="list-inline quicklinks">
						<li class="list-inline-item"><a href="#">Privacy Policy</a></li>
						<li class="list-inline-item"><a href="#">Terms of Use</a></li>
						<c:if test="${not empty AdminStatus}">
							<li class="list-inline-item"><a
								href="${cp}/backend/admin/homepage">Login</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</footer>

	<!-- Portfolio Modals -->
	<c:forEach items="${BookDetails}" var="bd">
		<!-- Modal 1 -->
		<div class="portfolio-modal modal fade"
			id="portfolioModal${bd.bookId}" tabindex="-1" role="dialog"
			aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="close-modal" data-dismiss="modal">
						<div class="lr">
							<div class="rl"></div>
						</div>
					</div>
					<div class="container">
						<div class="row">
							<div class="col-lg-8 mx-auto">
								<div class="modal-body">
									<!-- Project Details Go Here -->
									<h2>${bd.bookName}</h2>
									<p class="item-intro text-muted">Genres: ${bd.bookGenre}</p>
									<img class="img-fluid d-block mx-auto"
										src="${cp}/images/${bd.bookImageName}"
										alt="${bd.bookImageName}">
									<ul class="list-inline">
										<li>Book Price: $ ${bd.bookPrice}</li>
										<li>Book Author: ${bd.bookAuthor}</li>
										<li>Book Publisher: ${bd.bookPublisher}</li>
										<li>Book Publication Date: ${bd.bookPublishedDate}</li>
										<li>Book Available Quantity: ${bd.bookQuantity}</li>
									</ul>
									<button class="btn btn-primary" data-dismiss="modal"
										type="button">
										<i class="fa fa-times"></i> Close Book
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<!-- Logout Modal -->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title" id="exampleModalLabel">Are you sure ?</h3>
					<!-- <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button> -->
				</div>
				<div class="modal-body">...</div>
				<div class="modal-footer">
					<a href="${cp}/account/logout" class="btn btn-primary">Logout</a>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript -->
	<script src="${cp}/frontendFiles/vendor/jquery/jquery.min.js"></script>
	<script src="${cp}/frontendFiles/vendor/popper/popper.min.js"></script>
	<script src="${cp}/frontendFiles/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="${cp}/frontendFiles/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="${cp}/frontendFiles/js/agency.min.js"></script>

</body>

</html>
