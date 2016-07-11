$('#myCarousel').carousel({
	//轮播频率
	interval: 3500
});

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
		var This=this,
			_data=This._data;
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8080/mblog/json/QueryArticlescrap_query",
			dataType: 'jsonp',
			jsonp: "callback",
			jsonpCallback: "query",
			data: {
				pageNum: pageNum,
				Num:Num,
			},
			success: function(data) {
				_data[pageNum] = data;
				if (data.success) {
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
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8080/mblog/json/QueryArticlescrap_getNum",
			dataType: 'jsonp',
			jsonp: "callback",
			success: function(data) {
				This.pageLength = data.length;
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