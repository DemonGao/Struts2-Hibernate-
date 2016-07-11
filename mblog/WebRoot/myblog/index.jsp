<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
		<title>Bootstrap 101 Template</title>

		<!-- Bootstrap -->
		<link href="<%=basePath %>myblog/static/bootstrap-3.3.5-dist/css/bootstrap.css" rel="stylesheet">
		<link rel="stylesheet" href="<%=basePath %>myblog/static/fonts/iconfont.css" />
		<link rel="stylesheet" href="<%=basePath %>myblog/static/css/index.css" />
	</head>

	<body>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				    </button>
					<a class="navbar-brand" href="#">Blog</a>
				</div>

				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<s:if test="#session.user!=null">
							<li class="active"><a href="#"> ${session.user.userinfo.uiNickname}</a></li>
							<!-- ${session.user.user_id} -->
						<li data-toggle="modal" data-target="#loginout"><a href="#"> 注销 <span class="sr-only">(current)</span></a></li>
						</s:if>
						<s:else>
							<li class="active"><a href="#"> 亲,请登录</a></li>
							<li data-toggle="modal"><a href="<%=basePath %>/myblog/page/login.jsp"> 登陆 <span class="sr-only">(current)</span></a></li>
						</s:else>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人博客 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="<%=basePath%>myblog/page/userBlog.jsp">发表说说</a></li>
								<li><a href="<%=basePath%>myblog/page/reportArticles.jsp">发表日志</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="<%=basePath%>myblog/page/userBlog.jsp">我的博客</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Message <span class="badge">27</span><span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">回复消息<span class="badge float-right">3</span></a></li>
								<li><a href="#">提问消息<span class="badge float-right">23</span></a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">博客留言<span class="badge float-right">1</span></a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<div id="loginout" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="loginout">
			<div class="modal-dialog modal-sm">
				<form action="<%=basePath %>user/User_logoutUser" method="get">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<h4 class="modal-title">提示信息</h4>
						</div>
						<div class="modal-body">
							<p>亲,你真的要退出么?</p>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">Yes</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="content">
			<div id="myCarousel" class="carousel slide">
				<!-- 轮播（Carousel）指标 -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
				<!-- 轮播（Carousel）项目 -->
				<div class="carousel-inner">
					<div class="item active">
						<img src="../myblog/static/img/slider1.jpg" alt="First slide">
					</div>
					<div class="item">
						<img src="../myblog/static/img/slider1.jpg" alt="Second slide">
					</div>
					<div class="item">
						<img src="../myblog/static/img/slider1.jpg" alt="Third slide">
					</div>
				</div>
				<!-- 轮播（Carousel）导航 -->
				<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
				<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>
			<div class="container">
				<!--恻栏-->
				<div class="side-bar">
					<div id="weather">
						
					</div>
				</div>
				
				<!--内容栏-->
				<div class="content-bar" id="content-bar">
					
					<div id="articles">
						
					</div>
					<div id="pagination">
						
					</div>
				</div>
				
			</div>
		</div>
		<footer>
			<p>制作人:高世超  20132214106 软件二班</p>
			<p>制作人:高世超  20132214106 软件二班</p>
		</footer>
		<script src="<%=basePath %>myblog/static/bootstrap-3.3.5-dist/js/jquery.min.js"></script>
		<script src="<%=basePath %>myblog/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=basePath %>myblog/static/js/ViewCommand.js" ></script>
		<script type="text/javascript" src="<%=basePath %>myblog/static/js/myJS.js" ></script>
		<script type="text/javascript" src="<%=basePath %>myblog/static/js/index.js" ></script>
		<script>
			
		</script>
	</body>

</html>