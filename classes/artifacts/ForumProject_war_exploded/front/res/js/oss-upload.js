function ossGenImgName(oldName) {
    // 生成一个随机的文件名，避免重复 : 当前时间 + 随机整数
    var suffixName = '.' + oldName.split('.').pop(); // 得到后缀名
    function rnd(start, end){
        // 指定范围的随机整数
        return Math.floor(Math.random() * (end - start) + start)
    }
    return (new Date().getTime()).toString() + rnd(1000, 10000).toString() + suffixName
}
function ossUploadFile(file, callback) {
    var client = new OSS.Wrapper({
        region: 'oss-cn-beijing',
        accessKeyId: 'LTAIZjBDeNNShsSK',
        accessKeySecret: 'Ea4DN1jZvlmHgidVkPPOvuKZJP981v',
        bucket: 'sgq'
    }); // 这种使用方法非常不安全 直接将重要信息放在浏览器
    console.log('打印file');
    console.log(file);
    var newFileName = ossGenImgName(file.name);    // 使用新的文件名
    console.log(file.name + ' => ' + newFileName);
    console.log(client);
    client.multipartUpload(newFileName, file)
        .then(function (res) {
            console.log(res.res);
            var oldUrl = res.res.requestUrls[0];
            var newUrl = oldUrl.split('?')[0];
            console.log(newUrl);    // 上传后的文件的url
            callback(newUrl);
        })
        .catch(function () {
            alert('上传失败');
        })
}