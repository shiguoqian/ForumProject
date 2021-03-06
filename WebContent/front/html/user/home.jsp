<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>用户主页</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="fly,layui,前端社区">
  <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
  <link rel="stylesheet" href="../../res/layui/css/layui.css">
  <link rel="stylesheet" href="../../res/css/global.css 	">
  <script src= "../../res/js/jquery-1.12.4.js"></script>
  <script>
      $(function () {
          friend();
      })
      function friend(){//判断好友列表中有没有该人
          var str = true;
          var friendId = $('#hidId').val();
          $.ajax({
              async:false,
              url:'/addfriendservlet',
              type:'post',
              data:{
                  friendId:friendId,
                  flag:"query"
              },
              success:function (data) {
                  console.log("data:"+data);
                  document.cookie = "canFriend="+data;
                  console.log("successful");
              },
              error:function (){
                  console.log("error");
              }
          });
          return str;
      }
      function addFriend(friendId){//添加好友
          $.ajax({
              url:'/addfriendservlet',
              type:'post',
              data:{
                  "friendId":friendId,
                  "flag":"add"
              },
              success:function (data) {
                  if ($.trim(data)=="true") {
                      console.log("添加成功");
                      location.reload("home.jsp");
                  }else{
                      console.log("添加失败");
                  }
              },
              error:function () {
                  console.log("失败");
              }
          })
      }
  </script>
</head>
<body style="margin-top: 65px;">

<div class="fly-header layui-bg-black">
  <div class="layui-container">
    <a class="fly-logo" href="../jie/shouye.jsp">
      <img src="../../res/images/logo.png" alt="layui">
    </a>
    <ul class="layui-nav fly-nav-user">
      <!-- 登入后的状态 -->
      <li class="layui-nav-item">
        <a class="fly-nav-avatar" href="javascript:;">
          <cite class="layui-hide-xs">${sessionScope.user.uName}</cite>
          <i class="iconfont icon-renzheng layui-hide-xs" title="认证信息：layui 作者"></i>
          <i class="layui-badge fly-badge-vip layui-hide-xs">操作</i>
          <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg">
        </a>
        <dl class="layui-nav-child">
          <dd><a href="../user/set.jsp"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
          <dd><a href="../user/message.html"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a></dd>
          <dd><a href="../user/home.html"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a></dd>
          <hr style="margin: 5px 0;">
          <dd><a href="logout.jsp" style="text-align: center;">退出</a></dd>
        </dl>
      </li>
    </ul>
  </div>
</div>

<div class="fly-home fly-panel" style="background-image: url();">
  <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
  <i class="iconfont icon-renzheng" title="Fly社区认证"></i>
  <h1>
  	 ${sessionScope.user.uName}
  	 <c:choose>
  	 	<c:when test="${sessionScope.user.uSex==0}">
  	 		<i class="iconfont icon-nan"></i>
  	 	</c:when>
  	 	 <c:when test="${sessionScope.user.uSex!=0}">
  	 		<i class="iconfont icon-nv"></i>
  	 	</c:when>
  	 </c:choose>
    
    <!-- <i class="iconfont icon-nv"></i>  -->
    <!--
    <span style="color:#c00;">（管理员）</span>
    <span style="color:#5FB878;">（社区之光）</span>
    <span>（该号已被封）</span>
    -->
  </h1>

  <p class="fly-home-info">
    <i class="iconfont icon-shijian"></i><span>${sessionScope.user.regTime}</span>
    <i class="iconfont icon-chengshi"></i><span>${sessionScope.user.uCity}</span>
  </p>

  <p class="fly-home-sign">${sessionScope.user.uSignName}</p>


  <div class="fly-sns" data-user="">
    <%--好友列表中没有这个人--%>
    <%--${sessionScope.user.uId}--%>
      <input type="hidden" id="hidId" value="2"/>
      <a href="javascript:addFriend(2)" class="layui-btn layui-btn-primary fly-imActive" data-type="addFriend">
        <c:if test="${cookie.canFriend.value=='true'}">关注</c:if>
        <c:if test="${sessionScope.user.uSex=='女'}">
          她
        </c:if>
        <c:if test="${sessionScope.user.uSex=='男'}">
          他
        </c:if>
        <c:if test="${cookie.canFriend.value=='false'}">已关注</c:if>
      </a>
    <a href="javascript:;" class="layui-btn layui-btn-normal fly-imActive" data-type="chat">发起会话</a>
  </div>

</div>

<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md6 fly-home-jie">
      <div class="fly-panel">
        <h3 class="fly-panel-title"> ${sessionScope.user.uName}最近的发帖</h3>
        <ul class="jie-row" id="myPost">
          <!-- <div class="fly-none" style="min-height: 50px; padding:30px 0; height:auto;"><i style="font-size:14px;">没有发表任何求解</i></div> -->
        </ul>
      </div>
    </div>
    
    <div class="layui-col-md6 fly-home-da">
      <div class="fly-panel">
        <h3 class="fly-panel-title"> ${sessionScope.user.uName}最近的评论</h3>
        <ul class="home-jieda">
          <li>
          <p>
          <span>1分钟前</span>
          在<a href="" target="_blank">tips能同时渲染多个吗?</a>中回答：
          </p>
          <div class="home-dacontent">
            尝试给layer.photos加上这个属性试试：
<pre>
full: true         
</pre>
            文档没有提及
          </div>
        </li>
        <li>
          <p>
          <span>5分钟前</span>
          在<a href="" target="_blank">在Fly社区用的是什么系统啊?</a>中回答：
          </p>
          <div class="home-dacontent">
            Fly社区采用的是NodeJS。分享出来的只是前端模版
          </div>
        </li>
        
          <!-- <div class="fly-none" style="min-height: 50px; padding:30px 0; height:auto;"><span>没有回答任何问题</span></div> -->
        </ul>
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
layui.cache.page = 'user';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '../../res/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "3.0.0"
  ,base: '../../res/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>

<script type="text/javascript">
function showMyPost() {
	$.ajax({
		url : "/ajaxservlet",
		method : "post",
		dataType : "json",
		
		data : {
			
		},
		success : function(result) {
			$(result).each(function(index, element) {
				var html="";
				var str='<li> <a href="" class="jie-title"> ${"${element.pTitle}"}</a> <i>${"${element.pTime}"}</i> </li>';
                html = html+str;
                $("#myPost").append(html);
			})
		}

	});
}
</script>
</body>
</html>