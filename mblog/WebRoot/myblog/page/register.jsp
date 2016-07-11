<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>用户注册</title>

		<!-- Bootstrap -->
		<link href="<%=basePath %>myblog/static/bootstrap-3.3.5-dist/css/bootstrap.css" rel="stylesheet">
		<link rel="stylesheet" href="<%=basePath %>myblog/static/css/Calendar.css" />
		<link rel="stylesheet" href="<%=basePath %>myblog/static/css/register.css" />
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
						<li><a href="<%=basePath %>myblog/page/login.jsp">登录 <span class="sr-only">(current)</span></a></li>
						<li class="active"><a href="#">注册</a></li>
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
				<div class="form-register">
					<form id="registerForm" action="<%=path%>/user/User_register" onsubmit="return checkResult();" enctype="multipart/form-data" method="post">
						<!--<h2 class="form-register-heading">Register</h2>-->
						<section>
							<p class='pinput'>名称:
								<input name="user.username" id='nameinput' type="text" placeholder="请输入名称...">
								<p class="checkresult" id="nameresult"></p>
							</p>
							<p class='pinput'>密码:
								<input name="user.password" id='password' type="password" placeholder="请输入密码...">
								<p class="checkresult" id="pwdresult"></p>
							</p>
							<p class='pinput'>确认密码:
								<input id='repassword' type="password" placeholder="请再次输入密码...">
								<p class="checkresult" id="repwdresult"></p>
							</p>
							<p class='pinput'>昵称:
								<input name="userinfo.uiNickname" id='nicheng' type="text" placeholder="请输入昵称...">
								<p class="checkresult" id="nichengresult"></p>
							</p>
							<p class="pinput">出生日期:
								<input name="userinfo.uiBrithdate" type="text" class='calendarText' id="calendarText" placeholder="请选择出生日期..." readonly="readonly">
							</p>
							<p class='pinput'>籍贯:
								<input name="userinfo.uiBrithplace" id='jiguan' type="text" placeholder="请输入籍贯...">
								<p class="checkresult" id="jiguanresult"></p>
							</p>
							<p class='pinput'>邮箱:
								<input name="userinfo.uiEmail" id='email' type="text" placeholder="请输入邮箱...">
								<p class="checkresult" id="emailresult"></p>
							</p>
							<p class='pinput'>手机:
								<input name="userinfo.uiTel" id='phonenum' type="text" placeholder="请输入手机号...">
								<p class="checkresult" id="phonenumresult"></p>
							</p>
							<a class="file">上传头像
								<input type="file" name="upload">
								<span class="showFileName"></span>
							</a>
							<p class="fileerrorTip"></p>
							<button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>

						</section>

					</form>
				</div>
			</div>
		</div>
		<script src="<%=basePath %>myblog/static/bootstrap-3.3.5-dist/js/jquery.min.js"></script>
		<script src="<%=basePath %>myblog/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=basePath %>myblog/static/js/util.js"></script>
		<script type="text/javascript" src="<%=basePath %>myblog/static/js/Calendar.js" ></script>
		<script type="text/javascript" src="<%=basePath %>myblog/static/js/register.js"></script>
		
		<script>
		$(".file").on("change","input[type='file']",function(){
		    var filePath=$(this).val();
		    if(filePath.indexOf("jpg")!=-1 || filePath.indexOf("png")!=-1){
		        $(".fileerrorTip").html("").hide();
		        var arr=filePath.split('\\');
		        var fileName=arr[arr.length-1];
		        $(".showFileName").html(fileName);
		    }else{
		        $(".showFileName").html("");
		        $(".fileerrorTip").html("您未上传文件，或者您上传文件类型有误！").show();
		        return false 
		    }
		})
		</script>
	</body>

</html>
