var stzb = {
    init : function() {
        $("#wjupdate").unbind('click').bind('click', this.wjupdate);
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

}

$(function() {
    stzb.init();
});