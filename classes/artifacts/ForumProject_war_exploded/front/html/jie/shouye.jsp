<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>天方夜谈</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="fly,layui,前端社区">
  <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
  <link rel="stylesheet" href="/ForumProject/front//res/layui/css/layui.css">
  <link rel="stylesheet" href="/ForumProject/front//res/css/global.css">
</head>
<body>

<div class="fly-header layui-bg-black">
  <div class="layui-container">
    <a class="fly-logo" href="/">
      <img src="/ForumProject/front/res/images/logo.png" alt="layui">
    </a>

    
    <ul class="layui-nav fly-nav-user">
      
     
      <!-- 这里href要调到个人主页 -->
      <li class="layui-nav-item">
        <a href="/ForumProject/front/html/user/home.jsp">${sessionScope.user.uName}</a>
      </li>
  
      <li class="layui-nav-item layui-hide-xs">
        <a href="/app/qq/" onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})" title="QQ登入" class="iconfont icon-qq"></a>
      </li>
      <li class="layui-nav-item layui-hide-xs">
        <a href="/app/weibo/" onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})" title="微博登入" class="iconfont icon-weibo"></a>
      </li>
    </ul>
  </div>
</div>

<div class="fly-panel fly-column">
  <div class="layui-container">
    <ul class="layui-clear">
      <li class="layui-hide-xs layui-this"><a href="shouye.jsp">首页</a></li> 
      <li><a href="/ForumProject/front/html/jie/index.jsp">提问</a></li> 
      <li><a href="/ForumProject/front/html/jie/index.jsp">分享<span class="layui-badge-dot"></span></a></li> 
      <li><a href="/ForumProject/front/html/jie/index.jsp">讨论</a></li> 
      <li><a href="/ForumProject/front/html/jie/index.jsp">建议</a></li> 
      <li><a href="/ForumProject/front/html/jie/index.jsp">动态</a></li> 
      <li><a href="">系统公告</a></li> 
      <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><span class="fly-mid"></span></li> 
      
      <!-- 用户登入后显示 -->
      <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><a href="/ForumProject/front/html/user/index.jsp">我发表的贴</a></li> 
      <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><a href="/ForumProject/front/html/user/index.jsp#collection">我收藏的贴</a></li> 
    </ul> 
    
    <div class="fly-column-right layui-hide-xs"> 
      <span class="fly-search"><i class="layui-icon"></i></span> 
      <a href="/ForumProject/front/html/jie/add.jsp" class="layui-btn">发表新帖</a> 
    </div> 
    <div class="layui-hide-sm layui-show-xs-block" style="margin-top: -10px; padding-bottom: 10px; text-align: center;"> 
      <a href="/ForumProject/front/html/jie/add.jsp" class="layui-btn">发表新帖</a> 
    </div> 
  </div>
</div>

<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md8">
      <div class="fly-panel">
        <div class="fly-panel-title fly-filter">
          <a>置顶</a>
          <a href="#signin" class="layui-hide-sm layui-show-xs-block fly-right" id="LAY_goSignin" style="color: #FF5722;">去签到</a>
        </div>
        <ul class="fly-list" id="top">
         
        </ul>
      </div>

      <div class="fly-panel" style="margin-bottom: 0;">
        
        <div class="fly-panel-title fly-filter">
          <a href="#" class="layui-this">综合</a>
          <span class="fly-mid"></span>
          <a href="#">未结</a>
          <span class="fly-mid"></span>
          <a href="#">已结</a>
          <span class="fly-mid"></span>
          <a href="#">精华</a>
          <span class="fly-filter-right layui-hide-xs">
            <a href="#" class="layui-this">按最新</a>
            <span class="fly-mid"></span>
            <a href="#">按热议</a>
          </span>
        </div>

        <ul class="fly-list" id="allPost">
        <!-- sss写的所有帖子展示页 -->          
 
        </ul>
        <div style="text-align: center">
          <div class="laypage-main">
            <a href="jie/index.html" class="laypage-next">更多求解</a>
          </div>
        </div>

      </div>
    </div>
    <div class="layui-col-md4">

      <div class="fly-panel">
        <h3 class="fly-panel-title">温馨通道</h3>
        <ul class="fly-panel-main fly-list-static">
          <li>
            <a href="http://fly.layui.com/jie/4281/" target="_blank">layui 的 GitHub 及 Gitee (码云) 仓库，欢迎Star</a>
          </li>
          <li>
            <a href="http://fly.layui.com/jie/5366/" target="_blank">
              layui 常见问题的处理和实用干货集锦
            </a>
          </li>
          <li>
            <a href="http://fly.layui.com/jie/4281/" target="_blank">layui 的 GitHub 及 Gitee (码云) 仓库，欢迎Star</a>
          </li>
          <li>
            <a href="http://fly.layui.com/jie/5366/" target="_blank">
              layui 常见问题的处理和实用干货集锦
            </a>
          </li>
          <li>
            <a href="http://fly.layui.com/jie/4281/" target="_blank">layui 的 GitHub 及 Gitee (码云) 仓库，欢迎Star</a>
          </li>
        </ul>
      </div>


      <div class="fly-panel fly-signin">
        <div class="fly-panel-title">
          签到
          <i class="fly-mid"></i> 
          <a href="javascript:;" class="fly-link" id="LAY_signinHelp">说明</a>
          <i class="fly-mid"></i> 
          <a href="javascript:;" class="fly-link" id="LAY_signinTop">活跃榜<span class="layui-badge-dot"></span></a>
          <span class="fly-signin-days">已连续签到<cite id="day"></cite>天</span>
        </div>
        <div class="fly-panel-main fly-signin-main">
          <button class="layui-btn layui-btn-danger" id="LAY_signin"onclick="sign()">今日签到</button>
          <span>可获得<cite>5</cite>飞吻</span>
          
          <!-- 已签到状态 -->
          <!--
          <button class="layui-btn layui-btn-disabled">今日已签到</button>
          <span>获得了<cite>20</cite>飞吻</span>
          -->
        </div>
      </div>

      <div class="fly-panel fly-rank fly-rank-reply" id="LAY_replyRank">
        <h3 class="fly-panel-title">回贴周榜</h3>
        <dl>
          <!--<i class="layui-icon fly-loading">&#xe63d;</i>-->
          <dd>
            <a href="user/home.html">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
            </a>
          </dd>
          <dd>
            <a href="user/home.html">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
            </a>
          </dd>
          <dd>
            <a href="user/home.html">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
            </a>
          </dd>
          <dd>
            <a href="user/home.html">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
            </a>
          </dd>
          <dd>
            <a href="user/home.html">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
            </a>
          </dd>
          <dd>
            <a href="user/home.html">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
            </a>
          </dd>
          <dd>
            <a href="user/home.html">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
            </a>
          </dd>
          <dd>
            <a href="user/home.html">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
            </a>
          </dd>
          <dd>
            <a href="user/home.html">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
            </a>
          </dd>
          <dd>
            <a href="user/home.html">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
            </a>
          </dd>
          <dd>
            <a href="user/home.html">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
            </a>
          </dd>
          <dd>
            <a href="user/home.html">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
            </a>
          </dd>
        </dl>
      </div>

      <dl class="fly-panel fly-list-one">
        <dt class="fly-panel-title">本周热议</dt>
        <dd>
          <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
          <span><i class="iconfont icon-pinglun1"></i> 16</span>
        </dd>
        <dd>
          <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
          <span><i class="iconfont icon-pinglun1"></i> 16</span>
        </dd>
        <dd>
          <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
          <span><i class="iconfont icon-pinglun1"></i> 16</span>
        </dd>
        <dd>
          <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
          <span><i class="iconfont icon-pinglun1"></i> 16</span>
        </dd>
        <dd>
          <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
          <span><i class="iconfont icon-pinglun1"></i> 16</span>
        </dd>
        <dd>
          <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
          <span><i class="iconfont icon-pinglun1"></i> 16</span>
        </dd>
        <dd>
          <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
          <span><i class="iconfont icon-pinglun1"></i> 16</span>
        </dd>
        <dd>
          <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
          <span><i class="iconfont icon-pinglun1"></i> 16</span>
        </dd>
        <dd>
          <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
          <span><i class="iconfont icon-pinglun1"></i> 16</span>
        </dd>
        <dd>
          <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
          <span><i class="iconfont icon-pinglun1"></i> 16</span>
        </dd>

        <!-- 无数据时 -->
        <!--
        <div class="fly-none">没有相关数据</div>
        -->
      </dl>

      <div class="fly-panel">
        <div class="fly-panel-title">
          这里可作为广告区域
        </div>
        <div class="fly-panel-main">
          <a href="http://layim.layui.com/?from=fly" target="_blank" class="fly-zanzhu" time-limit="2017.09.25-2099.01.01" style="background-color: #5FB878;">LayIM 3.0 - layui 旗舰之作</a>
        </div>
      </div>
      
      <div class="fly-panel fly-link">
        <h3 class="fly-panel-title">友情链接</h3>
        <dl class="fly-panel-main">
          <dd><a href="http://www.layui.com/" target="_blank">layui</a><dd>
          <dd><a href="http://layim.layui.com/" target="_blank">WebIM</a><dd>
          <dd><a href="http://layer.layui.com/" target="_blank">layer</a><dd>
          <dd><a href="http://www.layui.com/laydate/" target="_blank">layDate</a><dd>
          <dd><a href="mailto:xianxin@layui-inc.com?subject=%E7%94%B3%E8%AF%B7Fly%E7%A4%BE%E5%8C%BA%E5%8F%8B%E9%93%BE" class="fly-link">申请友链</a><dd>
        </dl>
      </div>

    </div>
  </div>
</div>

<div class="fly-footer">
  <p><a href="http://fly.layui.com/" target="_blank">Fly社区</a> 2017 &copy; <a href="http://www.layui.com/" target="_blank">layui.com 出品</a></p>
  <p>
    <a href="http://fly.layui.com/jie/3147/" target="_blank">付费计划</a>
    <a href="http://www.layui.com/template/fly/" target="_blank">获取Fly社区模版</a>
    <a href="http://fly.layui.com/jie/2461/" target="_blank">微信公众号</a>
  </p>
</div>
 
<script src="../../res/layui/layui.js"></script>
<script>
layui.cache.page = '';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '../res/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "3.0.0"
  ,base: '../res/mods/' //这里实际使用时，建议改成绝对路径
}).extend({
  fly: 'index'
}).use('fly');
</script>

<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_30088308'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "w.cnzz.com/c.php%3Fid%3D30088308' type='text/javascript'%3E%3C/script%3E"));</script>
<script type="text/javascript" src="/ForumProject/front/res/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(function () {
	showAll();
})
function showAll(){
	$.ajax({
		url:"showAll",
		method:"post",
		dataType:"json",     //预期从服务器返回的数据是json类型
		data:{
			
		},
		success:function(result){
			//result：从服务器端返回的数据
			//$(result) :把返回的数据，变成jquery对象，以便使用jquery的each遍历方法
			//index :遍历的索引
			//element:每次遍历的对象的引用
			//index 和element 都是形参 可以换名字
			var html="";
			$("#allPost").empty();
			$(result).each(function(index,element){
				liStr=`<li><a href="/ForumProject/front/html/user/home.html" class="fly-avatar">
		              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
		            </a>
		            <h2>
		              <a class="layui-badge">${"${element.type}"}</a>
		              <a href="jie/detail.html">${"${element.pTitle}"}</a>
		            </h2>
		            <div class="fly-list-info">
		              <a href="user/home.html" link>
		                <cite>${"${element.uName}"}</cite>
		                <!--
		                <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
		                <i class="layui-badge fly-badge-vip">VIP3</i>
		                -->
		              </a>
		              <span>${"${element.pTime}"}</span>
		              
		              <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>
		              <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
		              <span class="fly-list-nums"> 
		                <i class="iconfont icon-pinglun1" title="回答"></i> 66
		              </span>
		            </div>
		            <div class="fly-list-badge">
		              <!--<span class="layui-badge layui-bg-red">精帖</span>-->
		            </div></li>`

				html=html+liStr;
			});
			var ulStr=html
			
			//把拼接后的代码，追加到div
			$("#allPost").append(ulStr);
		}
	})
}
function sign(){
	$.ajax({
			url : "front/html/sign?flag=qiandao",
			method : "post",
			data : {},
			async:false,
			success : function(result) {
				if (result == "100") {
					var days =parseInt($("#day").text());
					$("#day").html(days+1);
					$("#LAY_signin").toggleClass("layui-btn-disabled");
				} else {
					$("#LAY_signin").toggleClass("layui-btn-disabled");
				}
			}
		})
		
	}

 $(function(){
	$.ajax({
		url : "front/html/sign?flag=tianshu",
		method : "post",
		dateType:"json",
		data : {},
		success:function(result){
			$("#day").html(result);
		}
	});
		
})
</script>
</body>
<script>
$(function(){
	topMessage();
	showAll()
})

function showAll(){
	$.ajax({
		url:"/ForumProject/showAll",
		method:"post",
		dataType:"json",     //预期从服务器返回的数据是json类型
		data:{
			
		},
		success:function(result){
			//result：从服务器端返回的数据
			//$(result) :把返回的数据，变成jquery对象，以便使用jquery的each遍历方法
			//index :遍历的索引
			//element:每次遍历的对象的引用
			//index 和element 都是形参 可以换名字
			var html="";
			$("#allPost").empty();
			$(result).each(function(index,element){
				liStr=`<li><a href="user/home.html" class="fly-avatar">
		              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
		            </a>
		            <h2>
		              <a class="layui-badge">${"${element.type}"}</a>
		              <a href="/ForumProject/front/html/jie/detail.html?pID=${"${element.pId}"}">${"${element.pTitle}"}</a>
		            </h2>
		            <div class="fly-list-info">
		              <a href="user/home.html" link>
		                <cite>${"${element.uName}"}</cite>
		                <!--
		                <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
		                <i class="layui-badge fly-badge-vip">VIP3</i>
		                -->
		              </a>
		              <span>${"${element.pTime}"}</span>
		              
		              <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>
		              <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
		              <span class="fly-list-nums"> 
		                <i class="iconfont icon-pinglun1" title="回答"></i> 66
		              </span>
		            </div>
		            <div class="fly-list-badge">
		              <!--<span class="layui-badge layui-bg-red">精帖</span>-->
		            </div></li>`

				html=html+liStr;
			});
			var ulStr=html
			
			//把拼接后的代码，追加到div
			$("#allPost").append(ulStr);
		}
	})
}
function topMessage() {
	$.ajax({
		url : "/ForumProject/post",
		method : "post",
		dataType : "json",
		
		data : {
			flag:"shouyeTop"
		},
		success : function(result) {
			$(result).each(function(index, element) {
				var html="";
				
				var str = `<li>
		            <a href="user/home.html" class="fly-avatar">
		              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
		            </a>
		            <h2>
		              <a class="layui-badge">${"${element.type}"}</a>
		              <a href="/ForumProject/front/html/jie/detail.html?pID=${"${element.pId}"}">${"${element.pTitle}"}</a>
		            </h2>
		            <div class="fly-list-info">
		              <a href="user/home.html" link>
		                <cite>${"${element.uName}"}</cite>
		                <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
		                <i class="layui-badge fly-badge-vip">VIP3</i>
		              </a>
		              <span>${"${element.pTime}"}</span>
		              
		              <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>
		              <span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>
		              <span class="fly-list-nums"> 
		                <i class="iconfont icon-pinglun1" title="回答"></i> 66
		              </span>
		            </div>
		            <div class="fly-list-badge">
		              <!--
		              <span class="layui-badge layui-bg-black">置顶</span>
		              <span class="layui-badge layui-bg-red">精帖</span>
		              -->
		            </div>
		          </li>`;
		          html = html+str;
				$("#top").append(html);
			})
			
		}

	});
}
</script>

</html>