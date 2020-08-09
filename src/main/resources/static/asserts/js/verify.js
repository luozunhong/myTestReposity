
/*    function $(elementId){
        return document.getElementById(elementId).value;
    }*/
function divId(elementId){
    return document.getElementById(elementId);
}

var boot1=false;
var boot2=false;
var boot3=false;
var boot4=false;
/*用户名验证*/
function checkUser(){
    var user=$("#uname-id").val();
    var userId=divId("user_prompt");
    userId.innerHTML="";
    var reg=/^[a-zA-Z][a-zA-Z0-9]{3,15}$/;
    if(reg.test(user)==false){
        userId.innerHTML="用户名不正确";
        return false;
    }
    boot1=true;
    return true;
}
/*密码验证*/
function checkPwd(){
    var pwd=$("#password-id").val();
    var pwdId=divId("pwd_prompt");
    pwdId.innerHTML="";
    var reg=/^[a-zA-Z0-9]{4,10}$/;
    if(reg.test(pwd)==false){
        pwdId.innerHTML="密码不能含有非法字符，长度在4-10之间";
        return false;
    }else {
        boot2=true;
        return true;
    }

}

function checkRepwd(){
    var repwd=$("#repwd").val();
    var pwd=$("#password-id").val();
    var repwdId=divId("repwd_prompt");
    repwdId.innerHTML="";
    if(pwd!=repwd){
        repwdId.innerHTML="两次输入的密码不一致";
        return false;
    }else {
        boot3=true;
        return true;
    }

}

/*    /!*验证邮箱*!/
    function checkEmail(){
        var email=$("email");
        var email_prompt=divId("email_prompt");
        email_prompt.innerHTML="";
        var reg=/^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
        if(reg.test(email)==false){
            email_prompt.innerHTML="Email格式不正确，例如web@sohu.com";
            return false;
        }
        return true;
    }*/
/*验证手机号码*/
function checkMobile(){
    var mobile=$("#phone-id").val();
    var mobileId=divId("mobile_prompt");
    var regMobile=/^1\d{10}$/;
    if(regMobile.test(mobile)==false){
        mobileId.innerHTML="手机号码不正确，请重新输入";
        return false;
    }else {
        $.post(base+"/gem/check", {phone: mobile}, function (data) {
            if (data == 1) {
                mobileId.innerHTML="该手机号已被注册";
                return false;
            }else {
                boot4=true;
                mobileId.innerHTML="";
                return true;
            }
        });
    }

}





$("#registerBtn").click(function () {
    if(boot1&&boot2&&boot3&&boot4){
        $.post(base+"/gem/log",{
            uname: $("#uname-id").val(),
            password: $("#password-id").val(),
            phone: $("#phone-id").val(),
            verify: $("#ver").val()
        },function (data) {
            if(data==1){
                alert("注册成功!")
                window.location = base + "/gem/login";
            }else if(data==0){
                var mobileId=divId("yzm");
                mobileId.innerHTML="验证码输入错误!";
            }
        });
    }else{
       
    }
});

$("#amend").click(function () {
    if(boot2&&boot3){
        $.post(base+"/amend",{
            password:$("#user-old-password").val(),
            newpwd: $("#password-id").val(),

        },function (data) {
            alert(data)
            $("#empData").load(base+"/safety")
        });
    }
});
function fasong() {
    $.post(base + "/verify",{
        phone: $("#phone-id").val()
    },function (data) {
        alert(data)
    });
}





