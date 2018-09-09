//史国茜

layui.use(['form', 'layer', 'laydate', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //新闻列表
    var tableIns = table.render({
        elem: '#newsList',
        url: '/ForumProject/newservlet',
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limit: 20,
        limits: [10, 15, 20, 25],
        id: "newsListTable",
        cols: [[
            {type: "checkbox", fixed: "left", width: 50},
            {field: 'pId', title: '主题帖ID', align: "center"},
            {field: 'pTitle', title: '文章标题'},
            {field: 'uId', title: '用户ID', align: "center"},
            {field: 'pCheck', title: '发布状态', align: 'center', templet: "#newsStatus"},
            {field: 'experience', title: '悬赏状态', align: 'center', templet: "#expStatus"},
            {field: 'likeNum', title: '点赞数量', width: 60, align: 'center'},
            {
                field: 'pIsfine', title: '是否精贴', align: 'center', templet: function (d) {
                    return '<input type="checkbox" name="newsTop" lay-filter="pIsfine" lay-skin="switch" lay-text="是|否" value="'+d.pId+','+d.pIsfine+'"'+(d.pIsfine==1?'checked':'')+'>';
                }
            },
            {
                field: 'pIstop', title: '是否置顶', align: 'center', templet: function (d) {
                    return '<input type="checkbox" name="newsTop" lay-filter="pIstop" lay-skin="switch" lay-text="是|否" value="'+d.pId+','+d.pIstop+'"'+(d.pIstop==1?'checked':'')+'>';
                }
            },
            {
                field: 'pTime', title: '发布时间', align: 'center', minWidth: 110, templet: function (d) {
                    return d.pTime;
                }
            },
            {field: 'type', title: '类型', align: 'center'},
            {field: 'project', title: '所属产品', align: 'center'},
            {field: 'browser', title: '浏览器', align: 'center'},
            {field: 'version', title: '版本号', align: 'center'},
            {title: '操作', width: 170, templet: '#newsListBar', fixed: "right", align: "center"}
        ]],
        done: function (res, curr, count) {
            console.log(res);
            console.log(curr);
            console.log(count);
        }
    });

    //是否置顶
    form.on('switch(pIstop)', function (data) {
        var dataStrArr = data.value.split(",");//string数组
        var dataIntArr = new Array();
        for (var i=0;i<dataStrArr.length;i++){
            dataIntArr[i] = parseInt(dataStrArr[i]);
        }
        var topFlag = (dataIntArr[1]==0?1:0);//是否置顶
        $.ajax({
            url:'/ForumProject/toppostservlet',
            type:'POST',
            data:{
                "pId":dataIntArr[0],
                "topFlag":topFlag
            },
            success:function (data) {
                if (data=="true") {
                    console.log("改变置顶状态成功");
                }else{
                    console.log("改变置顶状态失败");
                }
            },
            error:function () {
                console.log("失败")
            }
        });
    })
    //是否精贴
    form.on('switch(pIsfine)', function (data) {
        var dataStrArr = data.value.split(",");//string数组
        var dataIntArr = new Array();
        for (var i=0;i<dataStrArr.length;i++){
            dataIntArr[i] = parseInt(dataStrArr[i]);
        }
        var fineFlag = (dataIntArr[1]==0?1:0);//是否精贴
        $.ajax({
            url:'/ForumProject/finepostservlet',
            type:'POST',
            data:{
                "pId":dataIntArr[0],
                "fineFlag":fineFlag
            },
            success:function (data) {
                if (data=="true") {
                    console.log("改变精贴状态成功");
                }else{
                    console.log("改变精贴状态失败");
                }
            },
            error:function () {
                console.log("失败")
            }
        });
    })
    //列表操作
    table.on('tool(newsList)', function (obj) {
        var layEvent = obj.event;
        var data = obj.data;//当前行数据
        var pId = data.pId;

        if (layEvent === 'postPass') { //审核通过
                $.ajax({
                    url:'/ForumProject/passpostservlet',
                    type:'POST',
                    data:{
                        "pId":pId
                    },
                    success:function (data) {
                        if (data=="true") {
                            console.log("审核通过");
                        }else{
                            console.log("审核没有通过");
                        }
                        tableIns.reload();
                    },
                    error:function () {
                        console.log("失败")
                    }
                });
        } else if (layEvent === 'del') { //删除
            layer.confirm('确定删除此帖子？', {icon: 3, title: '提示信息'}, function (index) {
                $.ajax({
                    url:'/ForumProject/delpostservlet',
                    type:'POST',
                    data:{
                        "pId":pId,
                        "flag":0
                    },
                    success:function (data) {
                        if (data=="true") {
                            console.log("删除成功");
                        }else{
                            console.log("删除没有成功");
                        }
                        layer.close(index);
                        tableIns.reload();
                    },
                    error:function () {
                        console.log("失败")
                    }
                });
            });
        }
    });


    // //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    // $(".search_btn").on("click", function () {
    //     if ($(".searchVal").val() != '') {
    //         table.reload("newsListTable", {
    //             page: {
    //                 curr: 1 //重新从第 1 页开始
    //             },
    //             where: {
    //                 key: $(".searchVal").val()  //搜索的关键字
    //             }
    //         })
    //     } else {
    //         layer.msg("请输入搜索的内容");
    //     }
    // });

    //添加帖子--需要newsAdd.html的配合
    function addNews(edit) {
        var index = layui.layer.open({
            title: "添加帖子",
            type: 2,
            content: "newsAdd.html",
            success: function (layero, index) {
                var body = layui.layer.getChildFrame('body', index);
                if (edit) {
                    body.find(".newsName").val(edit.newsName);
                    body.find(".abstract").val(edit.abstract);
                    body.find(".thumbImg").attr("src", edit.newsImg);
                    body.find("#news_content").val(edit.content);
                    body.find(".newsStatus select").val(edit.newsStatus);
                    body.find(".openness input[name='openness'][title='" + edit.newsLook + "']").prop("checked", "checked");
                    body.find(".newsTop input[name='newsTop']").prop("checked", edit.newsTop);
                    form.render();
                }
                setTimeout(function () {
                    layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                }, 500)
            }
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize", function () {
            layui.layer.full(index);
        })
    }

    $(".addNews_btn").click(function () {
        addNews();
    })

    //批量删除
    $(".delAll_btn").click(function () {
        var checkStatus = table.checkStatus('newsListTable');
        var data = checkStatus.data;
        var pId = new Array();
        if (data.length > 0) {
            for (var i in data) {
                pId.push(data[i].pId);
            }
            console.log(pId);
            layer.confirm('确定删除选中的文章？', {icon: 3, title: '提示信息'}, function (index) {
                $.ajax({
                    url:'/ForumProject/delpostservlet',
                    type:'POST',
                    traditional:true,//可以传送数组
                    data:{
                        "pId":pId,
                        "flag":1
                    },
                    success:function (data) {
                        if (data=="true") {
                            console.log("删除成功");
                        }else{
                            console.log("删除没有成功");
                        }
                        layer.close(index);
                        tableIns.reload();
                    },
                    error:function () {
                        console.log("失败")
                    }
                });
            });
        } else {
            layer.msg("请选择需要删除的文章");
        }
    })


})