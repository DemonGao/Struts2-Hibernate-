<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>DemonGao博客</title>
		<link href="<%=basePath %>myblog/static/bootstrap-3.3.5-dist/css/bootstrap.css" rel="stylesheet">
		<link rel="stylesheet" href="<%=basePath %>myblog/static/fonts/iconfont.css" />
		<!--基础Css-->
		<link rel="stylesheet" href="<%=basePath %>myblog/static/css/base.css" />
		<!--图标Css-->
		<link rel="stylesheet" href="<%=basePath %>myblog/static/fonts/iconfont.css" />
		<!--页面公共样式-->
		<link rel="stylesheet" href="<%=basePath %>myblog/static/css/userBlog-style.css" />
		<!--index的Css-->
		<link rel="stylesheet" href="<%=basePath %>myblog/static/css/userBlog.css" />
	</head>
	<body id="body">
		<!--浮出层-博主信息-->
		<div class="surface" id='surface'></div>
		<!--
        	作者：750229099@qq.com
        	时间：2016-05-20
        	描述：页头
        -->
		<header id="top">
			<div class="header-title">
				<h2>${session.user.userinfo.uiNickname}</h2>
				<input type="hidden" id="user_id" value=${session.user.user_id}>
				<span>ge ren bo ke</span>
			</div>
			<nav class="header-nav">
				<ul class="header-navbar">
					<li><a href="<%=basePath%>myblog/index.jsp"><i class="iconfont">&#xe600;</i><p>主页</p></a></li>
					<li><a href="<%=basePath%>myblog/page/reportArticles.jsp"><i class="iconfont">&#xe603;</i><p>发表日志</p></a></li>
					<li><a href="https://github.com/DemonGao"><i class="iconfont">&#xe601;</i><p>GitHub</p></a></li>
					<li><a href="#" id="clickbtn"><i class="iconfont">&#xe605;</i><p>关于我</p></a></li>
				</ul>
			</nav>
		</header>
		<!--
        	作者：750229099@qq.com
        	时间：2016-05-20
        	描述：页面主内容
        -->
		<div class="container">
			<!--View Image-->
			<div class="blogImage">
				<p>载着阳光</p>
				<p>一路前行</p>
			</div>
			<!--Content-->
			<div class="content">
				<h2>
					<p>时间<span>轴</span></p>
				</h2>
				<!--恻栏-->
				
				<div class="side-bar">
					<div id="weather">
						
					</div>
				</div>
				
				<!--内容栏-->
				<div class="content-bar" id="content-bar">
				<div class="reportsay">
						<form action="<%=basePath %>Articlescrap/Article_addArticlescrap" method="get" class="reportsay-form">
							
							<input type="hidden" name="userid" value="${session.user.user_id}">
							<input type="hidden" name="articlescrap.atype" value="0" />
							<textarea name="articlescrap.text" placeholder="说点儿什么吧"></textarea>
							<div class="reportsay-foot">
								<select name="articlescrap.type">
									<option value="个人日志">心情说说</option>
									<option value="签到说说">签到说说</option>
								</select>
								<button type="submit" class="btn reportsay-btn">发表</button>
							</div>
							
						</form>					
					</div>
					<div id="articles">
						
					</div>
					<div id="pagination">
						
					</div>
				</div>
			</div>
			
		</div>
		<!--
        	作者：750229099@qq.com
        	时间：2016-05-20
        	描述：页尾
        -->
		<footer>
			<div class="footer-title">
				<p>联系我</p>
			</div>
			<div class="footer-word">
				<p>TEL:${session.user.userinfo.uiTel}</p>
				<p>邮箱:${session.user.userinfo.uiEmail}</p>
			</div>
			<div class="footer-end">
				<p>
					<span>@demonGao</span>
					<span>
						<a href="#top">Back to top</a>
					</span>
				</p>
			</div>
		</footer>
		<!--我的Js库-->
		<script type="text/javascript" src="<%=basePath %>myblog/static/js/myJS.js" ></script>
		<!--jquery-->
		<script type="text/javascript" src="<%=basePath %>myblog/static/bootstrap-3.3.5-dist/js/jquery.min.js"></script>
		<script src="<%=basePath %>myblog/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
		<!--浮出层-博主信息js-->
		<script type="text/javascript" src="<%=basePath %>myblog/static/js/surface.js" ></script>
		<!--模板-->
		<script type="text/javascript" src="<%=basePath %>myblog/static/js/ViewCommand-user.js" ></script>
		<!--model js-->
		<script type="text/javascript" src="<%=basePath %>myblog/static/js/userBlog-model.js" ></script>
		
		<script>
		/***
		 * 博主信息浮出层
		 * 
		 */
		var base = {
				width: '320px', //浮出层层宽度
				//	min_width:'400px',
				height: '100%', //浮出层高度
				min_height: '300px',
				left: '-320px',
				top: '50px',
				head_height: '260px',
				head_title_content: '<a style="background-image: url(/mblog/upload/userInfo/${session.user.userinfo.userImg})" href="#"><span>关于${session.user.userinfo.uiNickname}</span></a>', //浮出层的页头内容
				head_content: '<div class="surface-content-say">' +
					'<h1>执子之手，与子偕老</h1>' +
					'<p>于千万人之中，我遇见了我所遇见的人....</p>' +
					'</div>' +
					'<div class="surface-content-info">' +
					'<p><i class="iconfont">&#xe608;</i>网名: ${session.user.userinfo.uiNickname}</p>' +
					'<p><i class="iconfont">&#xe60a;</i>籍贯: ${session.user.userinfo.uiBrithplace}</p>' +
					'<p><i class="iconfont">&#xe606;</i>电话: ${session.user.userinfo.uiTel}</p>' +
					'<p><i class="iconfont">&#xe607;</i>邮箱: ${session.user.userinfo.uiEmail}</p>' +
					'</div>' +
					'<div class="surface-content-shareBox">' +
					'<a href="#" title="分享到QQ空间"></a>' +
					'</div>',
				foot_content: '<p>这是浮出层的页脚</p>',
				showElementL: 'clickbtn', //浮出层显示按钮
				closebtn: false, //关闭按钮是否存在
				foot: false, //页脚是否存在
				ismove: false, //是否可移动
				isresize: false, //是否可以改变大小
			};
			var surfaced = Surfaced('surface', base);
			surfaced.init();
		</script>
	</body>
</html>

