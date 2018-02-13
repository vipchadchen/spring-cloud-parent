var stzb = {
    init : function() {
        $("#wjupdate").unbind('click').bind('click', this.wjupdate);
        $("#first1,#first2,#first3,#first4,#first5,#first6").unbind('click').bind('click', this.firstcl);
        $(".detailclick").unbind('click').bind('click', this.detailclick);
        $(".detailcontrast").unbind('click').bind('click', this.detailcontrast);
        $("#btncont").unbind('click').bind('click', this.btncont);
        $(".contrastdel").unbind('click').bind('click', this.contrastdel);
        $(".clicksort").unbind('click').bind('click', this.clicksort);
    },
    wjupdate:function() {
        $.ajax({
            type : "post",
            url : PATH+"/stzb/update",
            data : "",
            success : function(data) {
                alert(data.message);
            },
            error : function(msg) {
                alert('连接服务器失败，请重试！');
            }
        });
    },
    firstcl:function() {
        var type = $(this).attr('data');
        window.location.href=PATH+"/stzb/first?type="+type;
    },
    detailclick:function() {
        var id = $(this).attr("data");
        window.location.href=PATH+"/stzb/hero/detail/"+id;
    },
    detailcontrast:function() {
        var id = $(this).attr("data");
        $.ajax({
            type : "post",
            url : PATH+"/stzb/hero/contrast/"+id,
            success : function(data) {
                alert(data.message);
            },
            error : function(msg) {
                alert('连接服务器失败，请重试！');
            }
        });
    },
    btncont:function() {
        window.location.href=PATH+"/stzb/hero/contrastlist";
    },
    contrastdel:function() {
        var id = $(this).attr("data");
        $.ajax({
            type : "post",
            url : PATH+"/stzb/hero/contrastdel/"+id,
            success : function(data) {
                alert(data.message);
                window.location.reload();
            },
            error : function(msg) {
                alert('连接服务器失败，请重试！');
            }
        });
    },
    clicksort:function() {
        var sort = $(this).attr("data");
        window.location.href=PATH+"/stzb/hero/list?sort="+sort;
    },

}

$(function() {
    stzb.init();
});