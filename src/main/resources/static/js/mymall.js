// 绑定按钮与页面的方法
function bindPage(btn, url, name){
    // 判断按钮点击事件
    $("#" + btn).click(function(){
        // 加载内容
        $("#mainContentId").load(url);
        // 替换页面标题
        $("#name-title").text(name)
    });
}

// 判断登录态
function loadLoginState(){
    if($.cookie("id") != undefined){
        $("#nav-avatar-login").load("/page/navLogin");
    }else{
        $("#nav-avatar-login").load("/page/navLogout");
    }
}