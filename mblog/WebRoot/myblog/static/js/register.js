//表单验证的安全类
function CheckFrom(){
	if(!this instanceof CheckFrom)
	{
		return new CheckFrom();
	}
}
CheckFrom.prototype={
	checkNum:function(inputNode,prompt,title){
		var value=inputNode.value,
			msg='error',
			len=0,
			istrue=0;	
		for(var i=0;i<value.length;i++)
		{
			//获取每个字符的 Unicode 编码
			charCode = value.charCodeAt(i);
			charCode >= 0 && charCode <= 128?len += 1:len += 2;   
		}
		if(len==0){
			msg='empty';
		}else if(len>=4&&len<=16)
		{
			msg='success';

		}else{
			msg='error';
		}
		istrue=this.promptStyle(msg,title,prompt,inputNode);
		return istrue;
	},
	//验证籍贯
	checkJiguan:function(inputNode,prompt,title){
		var value=inputNode.value,
			msg='',
			istrue=0,
			filter  = /[\u4e00-\u9fa5]/g;
		filter.test(value)?msg='success1':msg='error1';
		if(value.length==0)
			msg='empty';
		istrue=this.promptStyle(msg,title,prompt,inputNode);
		return istrue;
	},
	//验证确认密码
	checkPwd:function(psd,repsd,title,prompt){
		var msg,
			psdValue=psd.value,
			repsdValue=repsd.value,
			istrue=0;
		psdValue==repsdValue?msg='repwd_success':msg='repwd_error';
		if(repsdValue.length==0)
			msg='empty';
		istrue=this.promptStyle(msg,title,prompt,repsd);
		return istrue;
	},
	//验证邮箱
	checkEmail:function(inputNode,prompt,title){
		var value=inputNode.value,
			msg='',
			istrue=0,
			filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		filter.test(value)?msg='success1':msg='error1';
		if(value.length==0)
			msg='empty';
		istrue=this.promptStyle(msg,title,prompt,inputNode);
		return istrue;
	},
	checkPhone:function(inputNode,prompt,title){
		var value=inputNode.value,
			msg='',
			istrue=0,
			filter  = /^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$/i;
		filter.test(value)?msg='success1':msg='error1';
		if(value.length==0)
			msg='empty';
		istrue=this.promptStyle(msg,title,prompt,inputNode);
		return istrue;
	},
	//提示栏样式
	promptStyle:function(msg,title,prompt,inputNode){
		var istrue=0;
		switch(msg){
			case 'empty':
				prompt.innerHTML=title+"不能为空";
				prompt.style.color='red';
				inputNode.style.borderColor='red';
				prompt.style.display="";
				break;
			case 'repwd_rule':
				prompt.innerHTML="再次输入相同密码";
				prompt.style.color='#aaa';
				inputNode.style.borderColor='';
				prompt.style.display="";
				break;
			case 'success': 
				prompt.innerHTML=title+"可用";
				prompt.style.color='green';
				inputNode.style.borderColor='green';
				prompt.style.display="none";
				istrue=1;
				break;
			case 'success1': 
				prompt.innerHTML=title+"格式正确";
				prompt.style.color='green';
				inputNode.style.borderColor='green';
				prompt.style.display="none";
				istrue=1;
				break;				
			case 'repwd_success': 
				prompt.innerHTML="密码输入一致";
				prompt.style.color='green';
				inputNode.style.borderColor='green';
				prompt.style.display="none";
				istrue=1;
				break;
			case 'rule':
				prompt.innerHTML=title+"必填，长度为4~16个字符";
				prompt.style.color='#aaa';
				inputNode.style.borderColor='';
				prompt.style.display="";
				break;
			case 'rule1':
				prompt.innerHTML="请输入"+title+"格式";
				prompt.style.color='#aaa';
				inputNode.style.borderColor='';
				break;			
			case 'repwd_error':
				prompt.innerHTML=title+"与密码不一致";
				prompt.style.color='red';
				inputNode.style.borderColor='red';
				prompt.style.display="";
				break;
			case 'error1':
				prompt.innerHTML=title+"格式错误";
				prompt.style.color='red';
				inputNode.style.borderColor='red';
				prompt.style.display="";
				break;
		}
		return istrue;
	},
	//事件绑定
	bindEvent:function(dom,type,fn){
		addEvent(dom,type,fn);
	},
};
var checkFrom=new CheckFrom();
var section=document.getElementsByTagName("section")[0];
var name_istrue=0,
	pwd_istrue=0,
	repwd_istrue=0,
	emain_istrue=0,
	phone_istrue=0,
	jiguan_istrue=0,
	nicheng_istrue=0;
//名称
var nameinput=document.getElementById("nameinput");
checkFrom.bindEvent(nameinput,'focus',function(){
	var nameresult=document.getElementById("nameresult");
	checkFrom.promptStyle('rule','名称',nameresult,nameinput);
});
checkFrom.bindEvent(nameinput,'blur',function(){
	var nameresult=document.getElementById("nameresult");
	name_istrue=checkFrom.checkNum(nameinput,nameresult,'名称');
});

//密码
var password=document.getElementById("password");
checkFrom.bindEvent(password,'focus',function(){
	var pwdresult=document.getElementById("pwdresult");
	checkFrom.promptStyle('rule','密码',pwdresult,password);
});
checkFrom.bindEvent(password,'blur',function(){
	var pwdresult=document.getElementById("pwdresult");
	pwd_istrue=checkFrom.checkNum(password,pwdresult,'密码');
	console.log(pwd_istrue);
});

//确认密码
var repassword=document.getElementById("repassword");
checkFrom.bindEvent(repassword,'focus',function(){
	var repwdresult=document.getElementById("repwdresult");
	checkFrom.promptStyle('repwd_rule','确认密码',repwdresult,repassword);
});
checkFrom.bindEvent(repassword,'blur',function(){
	var repwdresult=document.getElementById("repwdresult");
	repwd_istrue=checkFrom.checkPwd(password,repassword,'确认密码',repwdresult);
});

//邮箱
var email=document.getElementById("email");
checkFrom.bindEvent(email,'focus',function(){
	var emailresult=document.getElementById("emailresult");
	checkFrom.promptStyle('rule1','邮箱',emailresult,email);
});
checkFrom.bindEvent(email,'blur',function(){
	var emailresult=document.getElementById("emailresult");
	emain_istrue=checkFrom.checkEmail(email,emailresult,'邮箱');
});
//手机
var phonenum=document.getElementById("phonenum");
checkFrom.bindEvent(phonenum,'focus',function(){
	var phonenumresult=document.getElementById("phonenumresult");
	checkFrom.promptStyle('rule1','手机',phonenumresult,phonenum);
});
checkFrom.bindEvent(phonenum,'blur',function(){
	var phonenumresult=document.getElementById("phonenumresult");
	phone_istrue=checkFrom.checkPhone(phonenum,phonenumresult,'手机');
});

//籍贯
var jiguan=document.getElementById("jiguan");
checkFrom.bindEvent(jiguan,'focus',function(){
	var jiguanresult=document.getElementById("jiguanresult");
	checkFrom.promptStyle('rule1','籍贯',jiguanresult,jiguan);
});
checkFrom.bindEvent(jiguan,'blur',function(){
	var jiguanresult=document.getElementById("jiguanresult");
	jiguan_istrue=checkFrom.checkJiguan(jiguan,jiguanresult,'籍贯');
});

//籍贯
var nicheng=document.getElementById("nicheng");
checkFrom.bindEvent(nicheng,'focus',function(){
	var nichengresult=document.getElementById("nichengresult");
	checkFrom.promptStyle('rule','昵称',nichengresult,nicheng);
});
checkFrom.bindEvent(nicheng,'blur',function(){
	var nichengresult=document.getElementById("nichengresult");
	nicheng_istrue=checkFrom.checkNum(nicheng,nichengresult,'昵称');
});
function checkResult(){
	var result=false;
	var date_istrue=document.getElementById("calendarText").value?1:0;
	name_istrue&&pwd_istrue&&repwd_istrue&&emain_istrue&&phone_istrue&&jiguan_istrue&&date_istrue&&nicheng_istrue?result=true:alert('信息填写不正确,无法提交!');
	return result;
}
