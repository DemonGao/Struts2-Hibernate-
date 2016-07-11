<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />  
<title></title>  
<script type="text/javascript">       
function countDown(secs,surl){           
 var jumpTo = document.getElementById('jumpTo');  
 jumpTo.innerHTML=secs;    
 if(--secs>0){       
     setTimeout("countDown("+secs+",'"+surl+"')",1000);       
     }       
 else{         
     location.href=surl;       
     }       
 }       
</script>   
</head>  
  
<body>  
<h1>操作失敗</h1>  
<%
	String url=basePath+session.getAttribute("url").toString();
%>  
<a href="<%=url  %>"><span id="jumpTo">3</span>秒后系统会自动跳转，也可点击本处直接跳</a>   
<script type="text/javascript">  
    countDown(3,'<%=url %>');  
</script>    
</body>  
</html>  