var stzb = {
    init : function() {
        $("#wjupdate").unbind('click').bind('click', this.wjupdate);
        $("#first1,#first2,#first3,#first4,#first5,#first6").unbind('click').bind('click', this.firstcl);
    },
    wjupdate:function() {
        $.ajax({
            type : "post",
            url : PATH+"/stzb/update",
            data : "",
            success : function(data) {
                console.log(1);
                console.log(data);
                alert(data.message);
            },
            error : function(msg) {
                console.log(2);
                console.log(msg);
                alert('连接服务器失败，请重试！');
            }
        });
    },
    firstcl:function() {
        var type = $(this).attr('data');
        window.location.href=PATH+"/stzb/first?type="+type;
    },

}

$(function() {
    stzb.init();
});