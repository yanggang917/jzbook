$(function () {
    //初始化类别。。
    $.ajax({
        url : "/dict/selectList",
        async : false,
        type : "POST",
        contentType : 'application/json',
        dataType : 'json',
        success : function(data) {
            if (data.success == true){
                var arr = data.retData;
                var res = "<div class=\"weui-cells__title\">请选择类别</div>"
                for(var i=0; i<arr.length; i++){
                    res += "<label class=\"weui-cell weui-check__label\" for=\""+arr[i].id+"\">\n" +
                        "            <div class=\"weui-cell__bd\">\n" +
                        "                <p>"+arr[i].name+"</p>\n" +
                        "            </div>\n" +
                        "            <div class=\"weui-cell__ft\">\n" +
                        "                <input type=\"radio\" class=\"weui-check\" name=\"radio1\" value=\""+arr[i].id+"\" id=\""+arr[i].id+"\">\n" +
                        "                <span class=\"weui-icon-checked\"></span>\n" +
                        "            </div>\n" +
                        "        </label>";
                }
                $(".weui-cells_radio").html(res);
            }
        }
    });
});

function add() {
    var money = $("#money").val();
    var dictId = $('input:radio[name="radio1"]:checked').val();
    if ("" == money){
        $.toptip('请输入金额', 'error');
        return;
    }
    if (null == dictId){
        $.toptip('请选择类别', 'error');
        return;
    }

    var data =  {
        "money" : money,
        "remark" : $("#remark").val(),
        "dictId" : dictId
    };

    $.ajax({
        url : "/bills/save",
        async : false,
        type : "POST",
        contentType : 'application/json',
        dataType : 'json',
        data :JSON.stringify(data),
        success : function(data) {
            if (data.success == true){
                window.location.href = "index.html";
            }else{
                $.toptip('操作失败', 'error');
            }
        }
    });

}