layui.use(['form', 'layer', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;
    // var countNum = 0;

    //用户列表
    var tableIns = table.render({
        elem: '#userList',
        url: '/usersservlet',
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limits: [10, 15, 20, 25],
        limit: 20,
        id: "userListTable",
        cols: [[
            {type: "checkbox", fixed: "left", width: 50},
            {field: 'uId', title: 'Id', width: 50},
            {field: 'uName', title: '用户名'},
            {field: 'uNickName', title: '昵称'},
            {field: 'uPass', title: '密码', width: 60},
            {field: 'uSex', title: '性别', width: 60},
            {field: 'regTime', title: '注册时间'},
            {field: 'loginTime', title: '最近登录'},
            {
                field: 'uEmail', title: '邮箱', minWidth: 170, align: 'center', templet: function (d) {
                    return '<a class="layui-blue" href="mailto:' + d.uEmail + '">' + d.uEmail + '</a>';
                }
            },
            {field: 'uPhone', title: '电话'},
            {field: 'uCity', title: '所在城市'},
            {field: 'uPost', title: '发帖量'},
            {field: 'uCollect', title: '收藏贴量'},
            {field: 'uAtte', title: '关注数'},
            {field: 'uFans', title: '粉丝数'},
            {field: 'uRank', title: '等级'},
            {title: '操作', minWidth: 50, templet: '#userListBar', fixed: "right", align: "center"}
        ]],
        // done:function (res) {
        //     countNum = res.count;
        // }
    });

    // //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    // $(".search_btn").on("click",function(){
    //     if($(".searchVal").val() != ''){
    //         table.reload("newsListTable",{
    //             page: {
    //                 curr: 1 //重新从第 1 页开始
    //             },
    //             where: {
    //                 key: $(".searchVal").val()  //搜索的关键字
    //             }
    //         })
    //     }else{
    //         layer.msg("请输入搜索的内容");
    //     }
    // });

    // //添加用户
    // function addUser(edit){
    //     var index = layui.layer.open({
    //         title : "添加用户",
    //         type : 2,
    //         content : "userAdd.html",
    //         success : function(layero, index){
    //             var body = layui.layer.getChildFrame('body', index);
    //             if(edit){
    //                 body.find(".userName").val(edit.userName);  //登录名
    //                 body.find(".userEmail").val(edit.userEmail);  //邮箱
    //                 body.find(".userSex input[value="+edit.userSex+"]").prop("checked","checked");  //性别
    //                 body.find(".userGrade").val(edit.userGrade);  //会员等级
    //                 body.find(".userStatus").val(edit.userStatus);    //用户状态
    //                 body.find(".userDesc").text(edit.userDesc);    //用户简介
    //                 form.render();
    //             }
    //             setTimeout(function(){
    //                 layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
    //                     tips: 3
    //                 });
    //             },500)
    //         }
    //     })
    //     layui.layer.full(index);
    //     window.sessionStorage.setItem("index",index);
    //     //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
    //     $(window).on("resize",function(){
    //         layui.layer.full(window.sessionStorage.getItem("index"));
    //     })
    // }
    // $(".addNews_btn").click(function(){
    //     addUser();
    // })

    //批量删除
    $(".delAll_btn").click(function () {
        var checkStatus = table.checkStatus('userListTable');
        var data = checkStatus.data;
        var uId = new Array();
        if (data.length > 0) {
            for (var i in data) {
                uId.push(data[i].uId);
            }
            console.log(uId);
            layer.confirm('确定删除选中的用户？', {icon: 3, title: '提示信息'}, function (index) {
                $.ajax({
                    url: '/deluserservlet',
                    type: 'POST',
                    traditional: true,//可以传送数组
                    data: {
                        "uId": uId,
                        "flag": 1
                    },
                    success: function (data) {
                        if (data == "true") {
                            // count = (countNum-uId.length);
                            console.log("删除成功");
                        } else {
                            console.log("删除没有成功");
                        }
                        layer.close(index);
                        tableIns.reload();
                    },
                    error: function () {
                        console.log("失败")
                    }
                });
            });
        } else {
            layer.msg("请选择需要删除的文章");
        }
    })
    //列表操作
    table.on('tool(userList)', function (obj) {
        var layEvent = obj.event;
        var data = obj.data;//当前行数据
        var uId = data.uId;

        // if(layEvent === 'edit'){ //编辑
        //     addUser(data);
        // }else if(layEvent === 'usable'){ //启用禁用
        //     var _this = $(this),
        //         usableText = "是否确定禁用此用户？",
        //         btnText = "已禁用";
        //     if(_this.text()=="已禁用"){
        //         usableText = "是否确定启用此用户？",
        //         btnText = "已启用";
        //     }
        //     layer.confirm(usableText,{
        //         icon: 3,
        //         title:'系统提示',
        //         cancel : function(index){
        //             layer.close(index);
        //         }
        //     },function(index){
        //         _this.text(btnText);
        //         layer.close(index);
        //     },function(index){
        //         layer.close(index);
        //     });
        // }else
        if (layEvent === 'del') { //删除
            layer.confirm('确定删除此用户？', {icon: 3, title: '提示信息'}, function (index) {
                $.ajax({
                    url: '/deluserservlet',
                    type: 'POST',
                    data: {
                        "uId": uId,
                        "flag": 0
                    },
                    success: function (data) {
                        if (data == "true") {
                            console.log("删除成功");
                        } else {
                            console.log("删除没有成功");
                        }
                        layer.close(index);
                        tableIns.reload();
                    },
                    error: function () {
                        console.log("失败")
                    }
                });
            });
        }
    });
})
