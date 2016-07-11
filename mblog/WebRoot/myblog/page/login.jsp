<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title><%=basePath %>博客-登录</title>

		<!-- Bootstrap -->
		<link href="<%=basePath %>myblog/static/bootstrap-3.3.5-dist/css/bootstrap.css" rel="stylesheet">
		
		<link rel="stylesheet" href="<%=basePath %>myblog/static/css/login.css" />
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	</head>

	<body>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				    </button>
					<a class="navbar-brand" href="#">Blog</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="#">登录 <span class="sr-only">(current)</span></a></li>
						<li><a href="<%=basePath %>myblog/page/register.jsp">注册</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="jumbotron" id="content">
			<div class="container">
				<div class="form-login">
					<form action="<%=path%>/user/User_login" method="post">
						<h2 class="form-login-heading">Sign in</h2>
						<div class="form-group">
							<label for="inputUsername" class="sr-only">用户名</label>
							<input type="text" name="user.username" id="inputUsername" class="form-control" placeholder="用户名" required="" autofocus="">
							
							<s:if test="#session.login_msg!=null&&#session.login_msg=='用户名不存在!'">
								<span style="color:#fff">${login_msg}</span>
							</s:if>
							
						</div>
						<div class="form-group">
							<label for="inputPassword" class="sr-only">密码</label>
							<input type="password" name="user.password" id="inputPassword" class="form-control" placeholder="密码" required="">
							<s:if test="#session.login_msg!=null&&#session.login_msg=='密码错误!'">
								<span style="color:#fff">${login_msg}</span>
							</s:if>
						</div>
						<div class="form-login-group form-group">
							<div class="col-xs-3">
								<a href="#">忘记密码</a>
							</div>
							<div class="col-xs-3 col-xs-offset-6">
								<a href="<%=basePath %>myblog/page/register.jsp">免费注册</a>
							</div>
							<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<script src="<%=basePath %>myblog/static/bootstrap-3.3.5-dist/js/jquery.min.js"></script>
		<script src="<%=basePath %>myblog/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	</body>

</html>