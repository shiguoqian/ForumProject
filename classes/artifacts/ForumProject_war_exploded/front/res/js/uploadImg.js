layui.use('upload', function () {
    var $ = layui.jquery;
    var upload = layui.upload;

    var uploadInst = upload.render({
        elem: '#upload-img',
        url: '/img-upload-test',
        before: function (obj) {
            obj.preview(function (index, file, result) {
                ossUploadFile(file, uploadSuccCb);
            });

        },
        done: function (res) {
            // alert('上传成功');
        },
        error: function () {
            //alert('上传失败');
        }
    })
})