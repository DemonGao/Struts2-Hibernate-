/***
 * 博主信息浮出层
 * 
 */
//var base = {
//	width: '320px', //浮出层层宽度
//	//	min_width:'400px',
//	height: '100%', //浮出层高度
//	min_height: '300px',
//	left: '-320px',
//	top: '50px',
//	head_height: '260px',
//	head_title_content: '<a href="#"><span>关于高世超</span></a>', //浮出层的页头内容
//	head_content: '<div class="surface-content-say">' +
//		'<h1>执子之手，与子偕老</h1>' +
//		'<p>于千万人之中，我遇见了我所遇见的人....</p>' +
//		'</div>' +
//		'<div class="surface-content-info">' +
//		'<p><i class="iconfont">&#xe608;</i>网名: demonGao | 若水犹离</p>' +
//		'<p><i class="iconfont">&#xe60a;</i>籍贯: 山东省-济南</p>' +
//		'<p><i class="iconfont">&#xe606;</i>电话: 17853593651</p>' +
//		'<p><i class="iconfont">&#xe607;</i>邮箱: 750229099@qq.com</p>' +
//		'</div>' +
//		'<div class="surface-content-shareBox">' +
//		'<a href="#" title="分享到QQ空间"></a>' +
//		'</div>',
//	foot_content: '<p>这是浮出层的页脚</p>',
//	showElementL: 'clickbtn', //浮出层显示按钮
//	closebtn: false, //关闭按钮是否存在
//	foot: false, //页脚是否存在
//	ismove: false, //是否可移动
//	isresize: false, //是否可以改变大小
//};
//var surfaced = Surfaced('surface', base);
//surfaced.init();
/***
 * 模板
 * 
 */
//获取天气数据 并绘制
ViewCommand({
	command: 'getWeatherData',
	param: ['烟台']
});

//天气切换
var SelectCity = {
	tpl: {
		selectcn: [
			'<div class="selectcity">',
			'<input id="Icityname" type="text" placeholder="请输入城市"/>',
			'<button id="weathersearch">查询</button>',
			'</div>',
		].join(''),
	},
	Action: {
		create: function(container) {
			container.innerHTML += SelectCity.tpl.selectcn;
			var weathersearch = document.getElementById("weathersearch");
			addEvent(weathersearch, "click", function() {
				var cityname = document.getElementById("Icityname").value.toString();
				ViewCommand({
					command: 'getWeatherData',
					param: [cityname]
				});
			})
		},
	}
};
//天气切换事件绑定 By委托模式
var _cityname = false;
addEvent(document.getElementById("weather"), 'click', function(event) {
	var event = getEvent(event);
	var target = getTarget(event);
	if (target.id === "cityname") {
		if (_cityname == false) {
			SelectCity.Action["create"](target.parentNode.parentNode);
			_cityname = true;
		}
	}
});

function Articles() {
	if (!this instanceof Articles) {
		return new Articles();
	}
	this.pageNum = 0;//页码
	this._data = {};//保存文章数据
	this.Num=3;//一页的文章数
	this.pageSize=0;//文章总数
}
Articles.prototype = {
	init: function() {
		this.addEventClick();
		this.getArticles(this.pageNum);
		this.getNum();
	},
	addEventClick: function() {
		var This = this;
		var pagination = document.getElementById("pagination");
		addEvent(pagination, "click", function(e) {
			var event = getEvent(e);
			var target = getTarget(event);
			if (target.id === "nextpage") {
				if (++This.pageNum > This.pageSize-1) {
					alert("已经是最后一页了!");
					This.pageNum = This.pageSize-1;
				}
				This.getArticles(This.pageNum);
			}
			if (target.id === "prepage") {
				console.log("前"+This.pageNum);
				This.pageNum--;
				if (This.pageNum < 0) {
					console.log("后"+This.pageNum);
					This.pageNum = 0;
					alert("已经是第一页了!");
				}
				This.getArticles(This.pageNum);
			}
		});
	},
	//Ajax获取文章
	Ajax_Articles: function(pageNum,Num) {
		var user_id=document.getElementById("user_id").value;//获取用户id
		var This=this,
			_data=This._data;
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8080/mblog/json/QueryArticlescrap_queryById",
			dataType: 'jsonp',
			jsonp: "callback",
			jsonpCallback: "query",
			data: {
				pageNum: pageNum,
				Num:Num,
				userid:user_id,
			},
			success: function(data) {
				_data[pageNum] = data;
				if (data.success) {
					console.log(data.articlescraps.length);
//					console.log(data.articlescraps.size);
//					if(data.articlescraps.length==0){
//						return;
//					}
					ViewCommand({
						//参数说明 方法display
						command: 'display',
						//参数说明  parma1 : 元素容器,parma2 : 标题数据,parma3 : 元素模版
						param: ['articles', data.articlescraps, 'articlescrap']
					});
				}
				
			}
		});
	},
	//获取文章方法,并展示
	getArticles: function(pageNum) {
		this.pageNum=pageNum;
		var This=this;
		var _data = This._data;
		if (_data[pageNum]) {
			console.log("存在");
			ViewCommand({
				//参数说明 方法display
				command: 'display',
				//参数说明  parma1 : 元素容器,parma2 : 标题数据,parma3 : 元素模版
				param: ['articles', _data[pageNum].articlescraps, 'articlescrap']
			});
		} else {
			This.Ajax_Articles(pageNum,This.Num);
		}
	},
	getNum: function() {
		var html = '',
			tpl = {
				paginationTop: [
					'<nav>',
					'<ul class="pagination">',
					'<li>',
					'<a id="prepage" href="javascript:;" aria-label="Previous">',
					'<span id="prepage" aria-hidden="true">&laquo;</span>',
					'</a>',
					'</li>',
				].join(''),
				paginationEnd: [
					'<li>',
					'<a id="nextpage" href="javascript:;" aria-label="Next">',
					'<span id="nextpage" aria-hidden="true">&raquo;</span>',
					'</a>',
					'</li>',
				].join(''),
			};
		var This = this;
		var user_id=document.getElementById("user_id").value;//获取用户id
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8080/mblog/json/QueryArticlescrap_getNum",
			dataType: 'jsonp',
			jsonp: "callback",
			data: {
				arg1: "user_id",
				arg2:user_id,
			},
			success: function(data) {
				This.pageLength = data.length;
//				if(data.length==0){
//					return;
//				}
				This.pageSize=Math.ceil(This.pageLength / This.Num);
				html += tpl["paginationTop"];
				for (var i = 1; i <= This.pageSize; i++) {
					html += '<li><a href="javascript:a.getArticles('+(i-1)+');">' + i + '</a></li>';
				}
				html += tpl["paginationEnd"];
				document.getElementById("pagination").innerHTML = html;
			}
		})
	}
}
var a = new Articles();
a.init();