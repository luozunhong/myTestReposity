

function aaa(name){
    $('#empData').load(base+"/"+name);
}

function refresh(obj) {
    obj.src = "getVerifyCode?" + Math.random();
}

function mouseover(obj) {
    obj.style.cursor = "pointer";
}


/*商品分类*/
function typess(id){
    window.location=base+"/gem/detail/"+id;
}

//风格分类
function lifestyle(styles){
    window.location=base+"/gem/style/"+styles;
}


$(function () {


    $("#inf").click(function () {
        $.post(base+"/info",{
            uid:$("#user-uid").val(),
            uname: $("#user-name1").val(),
            phone: $("#user-phone").val(),
            time:$('#birthDate').val(),
            Gender:$("input[name='radio10']:checked").val(),
            email: $("#user-email").val()
        },function (data) {
            alert(data)
        });
    });
});

//购物车
function cart(pid) {
    $.ajax({
        type: "Post",
        url: base+"/carts",
        data:{pid:pid},
        success: function (data) {
            if(data==1){
                alert("添加购物车成功!");
            }else if(data==-1){
                var truthBeTold = window.confirm("您还未登录,是否登录!")
                if (truthBeTold) {
                    window.location=base+"/gem/login";
                }
            }else if(data==0){
                alert("增加成功!");
            }
        }
    });
}
//收藏
function save(pid) {
    $.ajax({
        type: "GET",
        url: base+"/wishs/"+pid,
        success: function (data) {
            if(data==1){
                alert("收藏成功!");
            }else if(data==0){
                alert("已收藏!");
            }else if(data==-1){
                var truthBeTold = window.confirm("您还未登录,是否登录!");
                if (truthBeTold) {
                    window.location=base+"/gem/login";
                }
            }
        }
    });
}


