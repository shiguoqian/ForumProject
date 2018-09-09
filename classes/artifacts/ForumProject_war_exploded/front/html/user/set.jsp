<%@page import="javafx.scene.control.Alert" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>帐号设置</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="fly,layui,前端社区">
    <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
    <link rel="stylesheet" href="../../res/layui/css/layui.css">
    <link rel="stylesheet" href="../../res/css/global.css">
    <script src="https://www.promisejs.org/polyfills/promise-6.1.0.js"></script>
    <script type="text/javascript" src="http://gosspublic.alicdn.com/aliyun-oss-sdk.min.js"></script>
    <script type="text/javascript" src="../../res/js/oss-upload.js"></script>

</head>
<body>
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
					<img src="${sessionScope.user.uImage}"/>
				
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="../user/set.jsp"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
                    <dd><a href="../user/home.jsp"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a>
                    </dd>
                    <hr style="margin: 5px 0;">
                    <dd><a href="" style="text-align: center;">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>

<div class="layui-container fly-marginTop fly-user-main">
    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
        <li class="layui-nav-item">
            <a href="home.jsp">
                <i class="layui-icon">&#xe609;</i>
                我的主页
            </a>
        </li>
        <li class="layui-nav-item">
            <a href="index.jsp">
                <i class="layui-icon">&#xe612;</i>
                用户中心
            </a>
        </li>
        <li class="layui-nav-item layui-this">
            <a href="set.jsp">
                <i class="layui-icon">&#xe620;</i>
                基本设置
            </a>
        </li>

    </ul>

    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>

    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>


    <div class="fly-panel fly-panel-user" pad20>
        <div class="layui-tab layui-tab-brief" lay-filter="user">
            <ul class="layui-tab-title" id="LAY_mine">
                <li class="layui-this" lay-id="info">我的资料</li>
                <li lay-id="avatar">头像</li>
                <li lay-id="pass">密码</li>

            </ul>
            <div class="layui-tab-content" style="padding: 20px 0;">
                <div class="layui-form layui-form-pane layui-tab-item layui-show">
                    <form method="post" action="../../../update">
                        <div class="layui-form-item">
                            <label for="L_email" class="layui-form-label">邮箱</label>
                            <div class="layui-input-inline">
                                <input type="text" id="L_email" name="email" value="${sessionScope.user.uEmail}"
                                <c:if test="${not empty sessionScope.user.uEmail}">
                                       placeholder="${sessionScope.user.uEmail}"
                                </c:if> required lay-verify="email" autocomplete="off" value="" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">如果您在邮箱已激活的情况下，变更了邮箱，需<a href="activate.html"
                                                                                               style="font-size: 12px; color: #4f99cf;">重新验证邮箱</a>。
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="L_username" class="layui-form-label">昵称</label>
                            <div class="layui-input-inline">
                                <input type="text" id="L_username" name="username"
                                       value="${sessionScope.user.uNickName}"
                                <c:if test="${not empty sessionScope.user.uNickName}">
                                       placeholder=" ${sessionScope.user.uNickName}"
                                </c:if> required lay-verify="required" autocomplete="off" value="" class="layui-input">
                            </div>
                            <div class="layui-inline">
                                <div class="layui-input-inline">
                                    <input type="radio" name="sex" value="0"
                                    <c:if test="${sessionScope.user.uSex=='0'}">
                                           checked
                                    </c:if>
                                           title="男">
                                    <input type="radio" name="sex" value="1"
                                    <c:if test="${sessionScope.user.uSex=='1'}">
                                           checked
                                    </c:if>
                                           title="女">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="L_city" class="layui-form-label">城市</label>
                            <div class="layui-input-inline">
                                <input type="text" id="L_city" name="city" value="${sessionScope.user.uCity}"
                                       autocomplete="off"
                                <c:if test="${not empty sessionScope.user.uCity}">
                                       placeholder="${sessionScope.user.uCity}"
                                </c:if> class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label for="L_sign" class="layui-form-label">签名</label>
                            <div class="layui-input-block">
                <textarea <c:if test="${not empty sessionScope.user.uSignName}">
                    placeholder="${sessionScope.user.uSignName}"
                </c:if> id="L_sign"
                        name="sign" autocomplete="off" class="layui-textarea"
                        style="height: 80px;">${sessionScope.user.uSignName}</textarea>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <button class="layui-btn" key="set-mine" lay-filter="*" lay-submit onclick="success1()">
                                确认修改
                            </button>
                        </div>
                    </form>
                </div>


                <%--<div class="layui-form layui-form-pane layui-tab-item">--%>
                <%--<div class="layui-form-item">--%>
                <%--<div class="avatar-add">--%>
                <%--<p>建议尺寸168*168，支持jpg、png、gif，最大不能超过50KB</p>--%>
                <%--<button type="button" class="layui-btn upload-img">--%>
                <%--<i class="layui-icon">&#xe67c;</i>上传头像--%>
                <%--</button>--%>
                <%--<img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg">--%>
                <%--<span class="loading"></span>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <div class="layui-form layui-form-pane layui-tab-item">
                    <div class="layui-form-item">
                        <div class="avatar-add">
                            <p>建议尺寸168*168，支持jpg、png、gif，最大不能超过50KB</p>
                            <button type="button" class="layui-btn" id="upload-img">
                                <i class="layui-icon">&#xe67c;</i>上传头像
                            </button>
                            <img id="img-show"/>
                            <span class="loading"></span>
                        </div>
                    </div>
                    <%--<div>--%>
                    <%--<form>--%>
                    <%--<div><input type="file" id="upload-img" value="选择图片"/></div>--%>
                    <%--</form>--%>
                    <%--<img src="" id="img-show2"/>--%>
                    <%--<div>--%>
                    <%--<button id="upload-btn" onClick="uploadFile(uploadCb)">上传</button>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                </div>

                <div class="layui-form layui-form-pane layui-tab-item">
                    <form action="../../../resetPassword" method="post">
                        <div class="layui-form-item">
                            <label for="L_nowpass" class="layui-form-label">当前密码</label>
                            <div class="layui-input-inline">
                                <input type="password" id="L_nowpass" name="nowpass" required lay-verify="required"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="L_pass" class="layui-form-label">新密码</label>
                            <div class="layui-input-inline">
                                <input type="password" id="L_pass" name="pass" required lay-verify="required"
                                       autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">6到16个字符</div>
                        </div>
                        <div class="layui-form-item">
                            <label for="L_repass" class="layui-form-label">确认密码</label>
                            <div class="layui-input-inline">
                                <input type="password" id="L_repass" name="repass" required lay-verify="required"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <button class="layui-btn" key="set-mine" lay-filter="*" lay-submit onclick="mcon()">确认修改
                            </button>
                        </div>
                    </form>
                </div>

                <div class="layui-form layui-form-pane layui-tab-item">
                    <ul class="app-bind">
                        <li class="fly-msg app-havebind">
                            <i class="iconfont icon-qq"></i>
                            <span>已成功绑定，您可以使用QQ帐号直接登录Fly社区，当然，您也可以</span>
                            <a href="javascript:;" class="acc-unbind" type="qq_id">解除绑定</a>

                            <!-- <a href="" onclick="layer.msg('正在绑定微博QQ', {icon:16, shade: 0.1, time:0})" class="acc-bind" type="qq_id">立即绑定</a>
                            <span>，即可使用QQ帐号登录Fly社区</span> -->
                        </li>
                        <li class="fly-msg">
                            <i class="iconfont icon-weibo"></i>
                            <!-- <span>已成功绑定，您可以使用微博直接登录Fly社区，当然，您也可以</span>
                            <a href="javascript:;" class="acc-unbind" type="weibo_id">解除绑定</a> -->

                            <a href="" class="acc-weibo" type="weibo_id"
                               onclick="layer.msg('正在绑定微博', {icon:16, shade: 0.1, time:0})">立即绑定</a>
                            <span>，即可使用微博帐号登录Fly社区</span>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>
<div class="fly-footer">
    <p><a href="http://fly.layui.com/" target="_blank">Fly社区</a> 2017 &copy; <a href="http://www.layui.com/"
                                                                                target="_blank">layui.com 出品</a></p>
    <p>
        <a href="http://fly.layui.com/jie/3147/" target="_blank">付费计划</a>
        <a href="http://www.layui.com/template/fly/" target="_blank">获取Fly社区模版</a>
        <a href="http://fly.layui.com/jie/2461/" target="_blank">微信公众号</a>
    </p>
</div>

<script src="../../res/layui/layui.js"></script>
<script>
    layui.config({
        version: "2.0.0"
        , base: '../../res/mods/'
    }).extend({
        fly: 'index'
    }).use('fly');
    layui.use('upload', function () {
        var $ = layui.jquery;
        var upload = layui.upload;
        var uploadSuccCb = function (imgUrl) {
            $.ajax({
                url: '/upload-image',
                method: 'post',
                data: {
                    imgUrl: imgUrl
                },
                async: false,
                success: function (result) {
                    document.getElementById('img-show').src = imgUrl;
                }
            })
        };
        var uploadInst = upload.render({
            elem: '#upload-img',
            url: '/upload-image', method: 'get',
            before: function (obj) {
                obj.preview(function (index, file, result) {
                    ossUploadFile(file, uploadSuccCb);
                });

            },
            done: function (res, index, upload) {
                alert('上传成功');
            },
            error: function (index, upload) {
                alert('上传失败');
            }
        })
    });

    function success1() {
        alert('您的信息已经更新成功！');
    }

    function mcon() {
        var boo = confirm('修改后，将需要用最新的密码登录了')
        //confirm 会返回你选择的选项,然后可以依据选择执行逻辑
        if (boo) {
            alert('修改成功');
        } else {

        }

    }


    function uploadCb(imgUrl) {
        //获取用户输入的验证码

        $.ajax({
            url: "/uploadimageservlet",
            method: "post",

            data: {
                imgUrl: imgUrl
            },
            success: function (result) {
                // document.getElementById('img-show').src = imgUrl;
                document.getElementById('img-show2').innerHTML = '<img src="' + imgUrl + '"/>';
                alert('upload successfully');
            }
        });
    }
</script>

</body>
</html>