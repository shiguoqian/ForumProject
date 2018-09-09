$(function () {
    $('#hid').val(getUrlParam("hidVal"));//将传来的currentpage赋给隐藏域
    var flag = getUrlParam("flag");//获取标志
    if (flag == 1) {//
        getMsg();//是帖子的上下页
    } else if (flag == 2) {
        showCollect();//收藏贴的上下页
    } else {//第一次访问
        getMsg();
    }
    $('#sendPost').click(function () {
            getMsg();
        }
    );
    $('#collectPost').click(function () {
            showCollect();
        }
    );
})

/**
 *获取帖子数据
 */
function getMsg() {
    $('#Pagination').html("");
    $('#showPost').html("");
    $('#collectPost').removeClass('layui-this');
    $('#sendPost').addClass('layui-this');
    var hidVal = $('#hid').val();
    $.ajax({
        async: false,
        url: '/userpostsservlet',
        // 相对路径:front/res/js/userPosts.js
        type: 'POST',
        dataType: 'json',
        data: {
            currentPage: hidVal//传递当前页面
        },
        success: function (data) {//获取json数据postListStr
            var len = data.length;
            console.log(len);

            $.each(data, function (index, element) {//将json数据解析成对象数组
                // if (typeof(element)=="Page"){//如果是page类型
                if (index + 1 == len) {//最后一个存储的时page对象
                    console.log(element);
                    var html1 = "";
                    var currentPage = element.currentPage;
                    var pageCount = element.pageCount;
                    var totalCount = element.totalCount;
                    $('#posts').html('('+totalCount+')');
                    // html1 += "[" + currentPage + "/" + pageCount + "]"+"&nbsp;&nbsp;";
                    if (currentPage > 1) {
                        var subNum = parseInt(currentPage) - 1;//上一页
                        html1 += "<a class='layui-btn' href='javascript:void(0)' onclick='changeCurPage(" + 1 + "," + 1 + ")'>首</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class='layui-btn' href='javascript:void(0)' onclick='changeCurPage(" + subNum + "," + 1 + ")'><<</a>";
                    }
                    if (currentPage < pageCount) {
                        var addNum = parseInt(currentPage) + 1;//下一页
                        html1 += "<a class='layui-btn' href='javascript:void(0)' onclick='changeCurPage(" + addNum + "," + 1 + ")'>>></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class='layui-btn' href='javascript:void(0)' onclick='changeCurPage(" + pageCount + "," + 1 + ")'>末</a>";
                    }
                    $('#Pagination').html(html1);
                    return;
                }
                console.log(element);
                var html = "<li>";
                html += "<a class='jie-title' href='../jie/detail.html' target='_blank'>" + element.pTitle + "</a>";
                html += "<i>" + element.pTime + "</i>"
                if (element.pIsfine == 1) {
                    html += "<div class='mine-edit'>精</div>";
                }
                html += "<em><a class='mine-edit' href='javascript:void(0)' onclick='delPost(" + element.pId + "," + 0 + ")'>删除</a></em>";
                html += "</li>";
                $('#showPost').append(html);
                //     return;
                // }else{//如果是list类型

                // }
            });
        },
        error: function (jqXHR, textStatus, errorThrown) {
            /*弹出jqXHR对象的信息*/
            console.log("失败");
        }
    })
};

/**
 * 获取收藏数据
 * @param hidVal
 */
function showCollect() {
    $('#Pagination').html("");
    $('#showPost').html("");
    $('#sendPost').removeClass('layui-this');
    $('#collectPost').addClass('layui-this');
    var hidVal = $('#hid').val();
    $.ajax({
        url: "/collect",
        method: "post",
        dataType: "json",     //预期从服务器返回的数据是json类型
        data: {
            currentPage: hidVal//传递当前页面
        },
        success: function (data) {//获取json数据postListStr
            var len = data.length;
            console.log(len);

            $.each(data, function (index, element) {//将json数据解析成对象数组
                var currentPage = element.currentPage;
                var pageCount = element.pageCount;
                var totalCount = element.totalCount;
                $('#collectCount').html('(' + totalCount + ')');
                if (index + 1 == len) {//最后一个存储的时page对象
                    var html1 = "";
                    // html1 += "[" + currentPage + "/" + pageCount + "]"+"&nbsp;&nbsp;";
                    if (currentPage > 1) {
                        var subNum = parseInt(currentPage) - 1;//上一页
                        html1 += "<a class='layui-btn' href='javascript:void(0)' onclick='changeCurPage(" + 1 + "," + 2 + ")'>首</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class='layui-btn' href='javascript:void(0)' onclick='changeCurPage(" + subNum + "," + 2 + ")'><<</a>";
                    }
                    if (currentPage < pageCount) {
                        var addNum = parseInt(currentPage) + 1;//下一页
                        html1 += "<a class='layui-btn' href='javascript:void(0)' onclick='changeCurPage(" + addNum + "," + 2 + ")'>>></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class='layui-btn' href='javascript:void(0)' onclick='changeCurPage(" + pageCount + "," + 2 + ")'>末</a>";
                    }
                    $('#Pagination').html(html1);
                    return;
                }
                var html = "<li>";
                html += "<a class='jie-title' href='../jie/detail.html' target='_blank'>" + element.pTitle + "</a>";
                html += "<i>" + element.pTime + "</i>"
                if (element.pIsfine == 1) {
                    html += "<div class='mine-edit'>精</div>";
                }
                html += "<em><a class='mine-edit' href='javascript:void(0)' onclick='delPost(" + element.pId + "," + 2 + ")'>取消收藏</a></em>";
                html += "</li>";
                $('#showPost').append(html);
            })
        },
        error: function (jqXHR, textStatus, errorThrown) {
            /*弹出jqXHR对象的信息*/
            console.log("失败");
        }
    });
}

function changeCurPage(hidVal, flag) {
    window.location.href = "index.jsp?hidVal=" + hidVal + "&flag=" + flag;
}

function delPost(pId, flag) {
    $.ajax({
        async: false,
        url: '/delpostservlet',
        type: 'POST',
        data: {
            "pId": pId,
            "flag":flag
        },
        success: function (data) {
            if (data == "true") {
                console.log("删除成功");
                window.location.href = "index.jsp?flag=" + flag;
            } else {
                console.log("删除没有成功");
            }
        },
        error: function () {
            console.log("失败")
        }
    });
}

function getUrlParam(name) {//获取url中的参数
    //构造一个含有目标参数的正则表达式对象
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    //匹配目标参数
    var r = window.location.search.substr(1).match(reg);
    //返回参数值
    if (r != null) {
        return decodeURI(r[2]);
    }
    return null;
}