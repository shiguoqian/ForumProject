<%@page import="java.util.*"%>
<%@page import="bean.Comment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="fly,layui,前端社区">
  <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
  <link rel="stylesheet" href="../../res/layui/css/layui.css">
  <link rel="stylesheet" href="../../res/css/global.css">
</head>
<body onload="getPostBrowserNum();showMessage();CommentMessage()">

<div class="fly-header layui-bg-black">
  <div class="layui-container">
    <a class="fly-logo" href="shouye.jsp">
      <img src="../../res/images/logo.png" alt="layui">
    </a>
    
    
    <ul class="layui-nav fly-nav-user">
      
   
      
      <!-- 登入后的状态 -->
      <li class="layui-nav-item">
        <a class="fly-nav-avatar" href="javascript:;">
          <cite class="layui-hide-xs">${sessionScope.user.uName}</cite>
          <i class="iconfont icon-renzheng layui-hide-xs" title="认证信息：layui 作者"></i>
        </a>
        <dl class="layui-nav-child">
          <dd><a href="../user/set.jsp"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
          <dd><a href="../user/message.html"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a></dd>
          <dd><a href="../user/home.jsp"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a></dd>
          <hr style="margin: 5px 0;">
          <dd><a href="" style="text-align: center;">退出</a></dd>
        </dl>
      </li>
    </ul>
  </div>
</div>

<div class="layui-hide-xs">
  <div class="fly-panel fly-column">

  </div>
</div>

<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md8 content detail">
      <div class="fly-panel detail-box">
        <h1 id="pTitle"></h1>
        <div class="fly-detail-info">
          
          <span class="layui-badge layui-bg-green fly-detail-column" id="type">默认</span>
          
          
          
          <div class="fly-admin-box" data-id="123">
            
          </div>
          <span class="fly-list-nums"> 
            <a href="#comment"><i class="iconfont" title="回答">&#xe60c;</i> 66</a>
            <i class="iconfont" title="人气">&#xe60b;</i> <span id="browserNum"></span>
          </span>
        </div>
        <div class="detail-about">
          <a class="fly-avatar" href="../user/home.html">
            <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="网速">
          </a>
          <div class="fly-detail-user">
            <a href="../user/home.html" class="fly-link">
              <cite id="uName"></cite>
              <i class="iconfont icon-renzheng" title="认证信息：{{ rows.user.approve }}"></i>
              
            </a>
            <span id="pTime"></span>
          </div>
          <div class="detail-hits" id="LAY_jieAdmin" data-id="123">
            <span style="padding-right: 10px; color: #FF7200">悬赏：60飞吻</span>
             <a href=""><button class="layui-btn layui-btn-xs jie-admin" onclick="doCollect()" >点击收藏</button></a> 
          </div>
        </div>
        <div class="detail-body photos">
          
          <h1>帖子内容：</h1>
          
<pre >
	<h2 id="pContent"></h2>
</pre>

          <hr>
        </div>
      </div>

      <div class="fly-panel detail-box" id="flyReply">
        <fieldset class="layui-elem-field layui-field-title" style="text-align: center;">
          <legend>回帖</legend>
        </fieldset>

        <ul class="jieda" id="jieda">
        <!-- 用于显示评论列表 -->       
          <!-- 无数据时 -->
          <!-- <li class="fly-none">消灭零回复</li> -->
        </ul>
<!-- 可替换内容至此 -->  
        <div class="layui-form layui-form-pane">
          <form action="" method="post">
            <div class="layui-form-item layui-form-text">
              <a name="comment"></a>
              <div class="layui-input-block">
                <textarea id="L_content" name="content" required lay-verify="required" placeholder="请输入内容"  class="layui-textarea fly-editor" style="height: 150px;"></textarea>
              </div>
            </div>
            <div class="layui-form-item">
              <input type="hidden" name="jid" value="123">
              <button class="layui-btn" lay-filter="*" lay-submit onclick="sendComment()">提交回复</button>
            </div>
          </form>
          <!-- form表单提交处 -->
        </div>
      </div>
    </div>
    <div class="layui-col-md4">
      <dl class="fly-panel fly-list-one">
        <dt class="fly-panel-title">本周热议</dt>
        <dd>
          <a href="">基于 layui 的极简社区页面模版</a>
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

      <div class="fly-panel" style="padding: 20px 0; text-align: center;">
        <img src="../../res/images/weixin.jpg" style="max-width: 100%;" alt="layui">
        <p style="position: relative; color: #666;">微信扫码关注 layui 公众号</p>
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

<%
    String pId1 = request.getParameter("pID"); 
    int pId = -1;
    if(pId1!=null&&!"".equals(pId1)){
    pId = Integer.parseInt(pId1);
    }
%>
<script src="../../res/layui/layui.js"></script>
<script>
layui.config({
  version: "3.0.0"
  ,base: '../../res/mods/'
}).extend({
  fly: 'index'
}).use(['fly', 'face'], function(){
  var $ = layui.$
  ,fly = layui.fly;
  //如果你是采用模版自带的编辑器，你需要开启以下语句来解析。
  /*
  $('.detail-body').each(function(){
    var othis = $(this), html = othis.html();
    othis.html(fly.content(html));
  });
  */
});
</script>
</body>
<script src="../../res/js/jquery-1.12.4.js"></script>
<script>
function showMessage(){
	var str="getPostById";
	$.ajax({
		url:"/ForumProject/post",
		method:"post",
		dataType:"json",     //预期从服务器返回的数据是json类型
		data:{
			flag:str,PID:<%=pId%>,
		},
		success:function(result){
			
			//设置 值插入标签中
			$("#pContent").html(result.pContent);
			$("#pTitle").html(result.pTitle);
			$("#pTime").html(result.pTime);
			$("#uName").html(result.uName);
			$("#type").html(result.type);
			
		
			
		}
	})
}
function CommentMessage() {	
	var pId = "";
	$.ajax({
		url : "/ForumProject/comment",
		method : "post",
		dataType : "json",
		data : {
			pId:<%=pId%>,
			content:null,
		},
		success : function(result) {
				var html="";
					$(result).each(function(index,element){
						liStr= "<li data-id='111' class='jieda-daan'>"
			            +"<a name='item-1111111111'></a>"
			            +"<div class='detail-about detail-about-reply'>"
			            +" <a class='fly-avatar' href=''>"
			            +" <img src='https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg' alt=' '>"
			            +" </a>"
			            +" <div class='fly-detail-user'>"
			            +"  <a href='' class='fly-link'>"
			            +"    <cite>"+element.uNickName+"</cite>"
			            +"     <i class='iconfont icon-renzheng' title='认证信息：XXX'></i>"
			            +"     <i class='layui-badge fly-badge-vip'>VIP3</i>  "            
			            +"   </a>			     "           	              
			            +" </div>"
			            +"  <div class='detail-hits'>"
			            +"   <span>"+element.comTime+"</span>"
			            +"  </div>"
			           
			            +"</div>"
			            +" <div class='detail-body jieda-body photos'>"
			            +"  <p>"+element.comContent+"</p>"
			            +"</div>"
			            +"<div class='jieda-reply'>"
			            +" <span class='jieda-zan zanok' type='zan'>"
			            +"  </div>"
			            +"</div>"
			            +"</li>";				
						html=html+liStr;
					});
					var ulStr="<ul>"+html+"</ul>";
					//把拼接后的代码，追加到div
					$("#jieda").append(ulStr);
			}		
		});
	}
function sendComment(){
	$("#jieda").html=null;
	$.ajax({
		url : "/ForumProject/comment",
		method : "post",
		dataType : "json",
		data : {
			pId:<%=pId%>,
			content:$("#L_content").val(),//获取表单里的评论内容
		},
		success : function(result) {
			var html="";
			$(result)(function(index,element){
				liStr= "<li data-id='111' class='jieda-daan'>"
	            +"<a name='item-1111111111'></a>"
	            +"<div class='detail-about detail-about-reply'>"
	            +" <a class='fly-avatar' href=''>"
	            +" <img src='https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg' alt=' '>"
	            +" </a>"
	            +" <div class='fly-detail-user'>"
	            +"  <a href='' class='fly-link'>"
	            +"    <cite>"+element.uNickName+"</cite>"
	            +"     <i class='iconfont icon-renzheng' title='认证信息：XXX'></i>"
	            +"     <i class='layui-badge fly-badge-vip'>VIP3</i>  "            
	            +"   </a>			     "           	           	              
	            +" </div>"
	            +"  <div class='detail-hits'>"
	            +"   <span>"+element.comTime+"</span>"
	            +"  </div>"
	            +"</div>"
	            +" <div class='detail-body jieda-body photos'>"
	            +"  <p>"+element.comContent+"</p>"
	            +"</div>"
	            +"<div class='jieda-reply'>"
	            +" <span class='jieda-zan zanok' type='zan'>"
	        
	            +"    <em>66</em>"
	            +" </span>"
	            +" <span type='reply'>"
	            +"    <i class='iconfont icon-svgmoban53'></i>	回复"
	            +" </span>"
	            +" <div class='jieda-admin'>"
	            +"  <span type='edit'>编辑</span>"
	            +"  <span type='del'>删除</span>	"		              
	            +"  </div>"
	            +"</div>"
	            +"</li>";				
				html=html+liStr;
			});
			var ulStr="<ul>"+html+"</ul>";
			//把拼接后的代码，追加到div
			$("#jieda").append(ulStr);

		}		
	});
}
function doCollect() {
	alert("收藏成功");
	$.ajax({
		url : "../../../doCollect",
		method : "post",
		dataType : "json",
		data : {
			collectPostId:<%=pId%>,
		},
		success : function(result) {
				
			}
		})
}
function getPostBrowserNum(){
	$.ajax({
		url:"/ForumProject/post",
		method:"post",
		dataType:"json",
		data:{
			flag:"browserNum",
			pId:<%=pId%>,
		},
		success:function(result){
			$("#browserNum").html(result);
		}
	})
}
</script>
</html>