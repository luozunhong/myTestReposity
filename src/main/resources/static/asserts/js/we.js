$(function () {
    //页面加载完毕后,创建富文本编辑器
    var E = window.wangEditor;
    var editor = new E('#editor');
    // 上传图片到服务器
    editor.customConfig.uploadImgServer = base + '/uploadImage';
    // 隐藏“网络图片”tab
    editor.customConfig.showLinkImg = false;
    // 将图片大小限制为 3M
    editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
    // 限制一次最多上传 5 张图片
    editor.customConfig.uploadImgMaxLength = 5;
    // 自定义上传图片时的fileName
    editor.customConfig.uploadFileName = 'file';
    // 默认200ms自动同步富文本编辑器中内容到隐藏域中
    editor.customConfig.onchange = function (html) {
        // html 即变化之后的内容
        $("#comment").val(html);
    };
    editor.create();
});


