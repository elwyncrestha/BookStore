<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>

<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	<div class="navbar-header">
	    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	    </button>
	    <a class="navbar-brand" href="${cp}/backend/admin/homepage"><i class="fa fa-book"></i> Book Store</a>
	</div>
	<!-- /.navbar-header -->
	
	<ul class="nav navbar-top-links navbar-right">
	    <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="">
	            <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
	        </a>
	        <ul class="dropdown-menu dropdown-user">
	            <li><a href="${cp}/backend/account/display/info"><i class="fa fa-user fa-fw"></i> User Profile</a>
	            </li>
	            <li><a href="${cp}/backend/account/edit"><i class="fa fa-gear fa-fw"></i> Settings</a>
	            </li>
	            <li class="divider"></li>
	            <li><a href="" data-toggle="modal" data-target="#logoutModal"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
	            </li>
	        </ul>
	        <!-- /.dropdown-user -->
	    </li>
	    <!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->
	
	<div class="navbar-default sidebar" role="navigation">
	    <div class="sidebar-nav navbar-collapse">
	        <ul class="nav" id="side-menu">
	            <li class="sidebar-search">
	                <div class="input-group custom-search-form">
	                    <input type="text" class="form-control" placeholder="Search...">
	                    <span class="input-group-btn">
	                        <button class="btn btn-default" type="button">
	                            <i class="fa fa-search"></i>
	                        </button>
	                    </span>
	                </div>
	                <!-- /input-group -->
	            </li>
	            <li>
	                <a href="${cp}/backend/admin/homepage"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
	            </li>
	            <li>
	                <a href="${cp}/backend/book/add"><i class="fa fa-save fa-fw"></i> Book Registration</a>
	            </li>
	            <li>
	                <a href="${cp}/backend/book/display/all"><i class="fa fa-book fa-fw"></i> Display Book List</a>
	            </li>
	            <li>
	                <a href="${cp}/backend/book/edit/all"><i class="fa fa-edit fa-fw"></i> Edit Book Information</a>
	            </li>
	            <li>
	            	<a><i class="fa fa-tag fa-fw"></i> Book Genre<span class="fa arrow"></span></a>
	            	<ul class="nav nav-second-level">
	            		<li>
	            			<a href="${cp}/backend/bbc/assign">Assign book genre</a>
	            		</li>
	            		<li>
	            			<a href="${cp}/backend/bbc/display">Display book genre</a>
	            		</li>
	            	</ul>
	            </li>
	            <li>
	                <a><i class="fa fa-tags fa-fw"></i> Book Category<span class="fa arrow"></span></a>
	                <ul class="nav nav-second-level">
	                    <li>
	                        <a href="${cp}/backend/book/category/add">Add category</a>
	                    </li>
	                    <li>
	                        <a href="${cp}/backend/book/category/display/all">Display categories</a>
	                    </li>
	                </ul>
	                <!-- /.nav-second-level -->
	            </li>
	            <li>
	                <a><i class="fa fa-user fa-fw"></i> User management<span class="fa arrow"></span></a>
	                <ul class="nav nav-second-level">
	                    <li>
	                        <a href="${cp}/backend/account/display/all">Display Users</a>
	                    </li>
	                    <li>
	                        <a href="${cp}/backend/account/edit">Edit user details</a>
	                    </li>
	                </ul>
	                <!-- /.nav-second-level -->
	            </li>
	        </ul>
	    </div>
	    <!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>

<!-- Logout Modal -->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h3 class="modal-title" id="exampleModalLabel">Are you sure ?</h3>
        <!-- <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button> -->
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <a href="${cp}/frontend/homepage" class="btn btn-primary">Logout</a>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>