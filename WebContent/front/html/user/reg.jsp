<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>注册</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="keywords" content="fly,layui,前端社区">
<meta name="description"
	content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
<link rel="stylesheet" href="../../res/layui/css/layui.css">
<link rel="stylesheet" href="../../res/css/global.css">
</head>
<body>
	<div class="fly-header layui-bg-black">
		<div class="layui-container">
			<a class="fly-logo" href="/"> <img
				src="../../res/images/logo.png" alt="layui">
			</a>

			<ul class="layui-nav fly-nav-user">
				<!-- 未登入的状态 -->
				<li class="layui-nav-item"><a
					class="iconfont icon-touxiang layui-hide-xs" href="login.html"></a>
				</li>
				<li class="layui-nav-item"><a href="login.jsp">登入</a></li>
				<li class="layui-nav-item"><a href="reg.jsp">注册</a></li>
				<li class="layui-nav-item layui-hide-xs"><a href="/app/qq/"
					onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})"
					title="QQ登入" class="iconfont icon-qq"></a></li>
				<li class="layui-nav-item layui-hide-xs"><a href="/app/weibo/"
					onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})"
					title="微博登入" class="iconfont icon-weibo"></a></li>
			</ul>
		</div>
	</div>

	<div class="layui-container fly-marginTop" style="height:600px">
		<div class="fly-panel fly-panel-user" pad20>
			<div class="layui-tab layui-tab-brief" lay-filter="user">
				<ul class="layui-tab-title">
					<li><a href="login.jsp">登入</a></li>
					<li class="layui-this">注册</li>
				</ul>
				<div class="layui-form layui-tab-content" id="LAY_ucm"
					style="padding: 20px 0;">
					<div class="layui-tab-item layui-show">
						<div class="layui-form layui-form-pane">
							<form method="post" action="../../../reg">
								<div class="layui-form-item">
									<label class="layui-form-label">用户名</label>
									<div class="layui-input-inline">
										<input type="text" id="name" name="uName" autocomplete="off"
											class="layui-input" onblur="isRegister()">
									</div>
									<div class="layui-form-mid layui-word-aux">将会成为您唯一的登入名</div>
									
								</div>
								<div class="layui-form-item">
									<label for="L_pass" class="layui-form-label">密码</label>
									<div class="layui-input-inline">
										<input type="password" id="L_pass" name="pass" required
											lay-verify="required" autocomplete="off" class="layui-input"
											onblur="checkPass()"> <span id="checkPass"></span>
									</div>
									<div class="layui-form-mid layui-word-aux">6到16个字符</div>
								</div>
								<div class="layui-form-item">
									<label for="L_repass" class="layui-form-label">确认密码</label>
									<div class="layui-input-inline">
										<input type="password" id="L_repass" name="repass" required
											lay-verify="required" autocomplete="off" class="layui-input"
											onblur="isCorrect()"> <span id="check"></span>
									</div>
								</div>
								<div class="layui-form-item">
									<label for="L_vercode" class="layui-form-label">人类验证</label>
									<div class="layui-input-inline">
										<input type="text" name="code" placeholder="请输入验证码"
											onblur="checkCode()" style="width: 82px; height: 35px;"
											id="code" />
										<!-- 图片验证码 -->
									<img src="createCode" id="codeImg" alt="" width="100"
											class="passcode" style="height: 40px; cursor: pointer;"
											onclick="changeCode()">
										<div id="info"></div>
									</div>
								</div>
								</div>
								<div class="layui-form-item">
									<button class="layui-btn" lay-submit>立即注册</button>
								</div>
								<div class="layui-form-item fly-form-app">
									<span>或者直接使用社交账号快捷注册</span> <a href=""
										onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})"
										class="iconfont icon-qq" title="QQ登入"></a> <a href=""
										onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})"
										class="iconfont icon-weibo" title="微博登入"></a>
								</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
	<div class="fly-footer">
		<p>
			<a href="http://fly.layui.com/" target="_blank">Fly社区</a> 2017 &copy;
			<a href="http://www.layui.com/" target="_blank">layui.com 出品</a>
		</p>
		<p>
			<a href="http://fly.layui.com/jie/3147/" target="_blank">付费计划</a> <a
				href="http://www.layui.com/template/fly/" target="_blank">获取Fly社区模版</a>
			<a href="http://fly.layui.com/jie/2461/" target="_blank">微信公众号</a>
		</p>
	</div>
	<script src="../../res/js/jquery-1.12.4.js"></script>
	<script src="../../res/layui/layui.js"></script>
	<script>
		layui.cache.page = 'user';
		layui.cache.user = {
			username : '游客',
			uid : -1,
			avatar : '../../res/images/avatar/00.jpg',
			experience : 83,
			sex : '男'
		};
		layui.config({
			version : "3.0.0",
			base : '../../res/mods/'
		}).extend({
			fly : 'index'
		}).use('fly');
	</script>
	<script type="text/javascript" src="../../res/js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		function isCorrect() {
			if ($("#L_pass").val() == $("#L_repass").val()) {
				$("#check").html("两次密码一致");
			} else {
				$("#check").html("两次密码输入不一致");
			}
		}
		function checkPass() {
			var inputPass = $("#L_pass").val();
			var passReg = /^[a-zA-Z0-9_-]{6,16}$/;
			if (!passReg.test(inputPass)) {
				$("#checkPass").html("请输入6-16位密码");
			} else {
				$("#checkPass").html("");
			}
		}
		function checkCode() {
			//获取用户输入的验证码
			var code = $("#code").val();
			$.ajax({
				url : "checkCode",
				method : "get",
				data : {
					checkCode : code
				},
				success : function(result) {
					if (result == "100") {
						$("#info").html("验证码正确");
					} else {
						$("#info").html("验证码不正确，请重新输入!");
					}
				}
			});
		}
		function changeCode() {
			$("#codeImg").attr("src", "createCode?time=" + new Date());
		}
	</script>
</body>
</html>