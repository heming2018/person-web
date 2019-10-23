function addTab(title, url) {
    var element = layui.element;
    element.tabDelete('homeTab', title);

    var content = '<iframe id="content" name="content" class="layui-show" src="' + url + '" style="width: 100%; height:100%"></iframe>';
    element.tabAdd('homeTab', {
        title: title,
        content: content,
        id: title
    });
    element.tabChange('homeTab', title);
}