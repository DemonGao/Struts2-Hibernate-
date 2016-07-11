<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>发表文章</title>
		<link rel="stylesheet" href="<%=basePath %>myblog/static/css/base.css" />
		<link href="<%=basePath %>myblog/static/bootstrap-3.3.5-dist/css/bootstrap.css" rel="stylesheet">
		<link rel="stylesheet" href="<%=basePath %>myblog/static/css/iconfont.css" />
		<link rel="stylesheet" href="<%=basePath %>myblog/static/zyUpload/control/css/zyUpload.css" type="text/css">
		<link rel="stylesheet" href="<%=basePath %>myblog/static/css/reportArticles.css" />
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
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title">提示信息</h4>
					</div>
					<div class="modal-body">
						<p>亲,你真的要退出么?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
						<button type="button" class="btn btn-primary">Yes</button>
					</div>
				</div>
			</div>
		</div>
		<div class="content">
			<div class="model_as">
				<div class="model_as-title">
					<h4>写日志</h4>
				</div>
				<div class="model_as-content">
					<form action="<%=basePath %>Articlescrap/Articlescrap_addArticlescrap" class="model_as-cont-form" id="model_as_form" enctype="multipart/form-data" method="post">
						<input name="articlescrap.title" class="title" type="text" placeholder="请在这输入日志标题" maxlength="30" required="required">
						<hr />
						<!--<input type="hidden" name="userid" value="1"> -->
						<input type="hidden" name="userid" value="${session.user.user_id}">
						<input type="hidden" name="articlescrap.atype" value="1">
						<div class="contentBox">
							<textarea class="cont" name="articlescrap.text"></textarea>
						</div>
						<div class="type">
							<span>分类:</span>
							<select class="form-control as-type" name="articlescrap.type">
								<option value="个人日志">个人日志</option>
								<option value="私密日志">私密日志</option>
							</select>
							<input type="file" name="upload">
						</div>
					</form>
				</div>
				<div class="model_as-footer">
					<div class="model_as-footer-publish">
						<p>
							<button class="btn btn-info" type="submit" form="model_as_form">发<span class="spacing1"></span>表</button>
							<button class="btn btn-default" type="button">取<span class="spacing1"></span>消</button>
						</p>
					</div>
				</div>
			</div>
			<br/>
		</div>
		<script src="<%=basePath %>myblog/static/bootstrap-3.3.5-dist/js/jquery.min.js"></script>
		<script src="<%=basePath %>myblog/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	</body>

</html>
