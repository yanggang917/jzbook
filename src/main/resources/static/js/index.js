$(function(){
    $.ajax({
        url : "/bills/selectList",
        async : false,
        type : "POST",
        contentType : 'application/json',
        dataType : 'json',
        success : function(data) {
            if (data.success == true){
                var arr = data.retData;
                var res = "";
                for (var i in arr){

                    res += "<div class=\"weui-cells__title\">"+i+"</div>";
                    var totalMoney = 0;//总额
                    for(var j=0; j<arr[i].length; j++){
                        res +="<div class=\"weui-cell\">\n" +
                            "            <div class=\"weui-cell__hd\"><img src=\"\"></div>\n" +
                            "            <div class=\"weui-cell__bd\">\n" +
                            "                <p>"+arr[i][j].dictName+"</p>\n" +
                            "            </div>\n" +
                            "            <div class=\"weui-cell__bd\">\n" +
                            "                <p>"+arr[i][j].money+"</p>\n" +
                            "            </div>\n" +
                            "            <div style='font-size: 0.2rem;' class=\"weui-cell__ft\">"+ getRemark(arr[i][j].remark) +"</div>\n" +
                            "        </div>";
                        totalMoney += arr[i][j].money;
                    }

                    res +="<div class=\"weui-cell\">\n" +
                        "            <div class=\"weui-cell__hd\">" +
                        // "               <img style='width: 1.5rem;' src=\"./images/icon/total_money.png\">" +
                        "               <img src=\"\">" +
                        "            </div>\n" +
                        "            <div class=\"weui-cell__bd\">\n" +
                        "                <p style='color: red'>合计</p>\n" +
                        "            </div>\n" +
                        "            <div class=\"weui-cell__bd\">\n" +
                        "                <p style='color: red'>"+totalMoney.toFixed(2)+"</p>\n" +
                        "            </div>\n" +
                        "            <div style='font-size: 0.2rem;' class=\"weui-cell__ft\">"+getRemark(null)+"</div>\n" +
                        "        </div>";

                }
                $(".weui-cells").html(res);
            }
        }
    });

});

function getcurrentDate() {
    var myDate = new Date;
    var year = myDate.getFullYear(); //获取当前年
    var mon = myDate.getMonth() + 1; //获取当前月
    var date = myDate.getDate(); //获取当前日
    // var h = myDate.getHours();//获取当前小时数(0-23)
    // var m = myDate.getMinutes();//获取当前分钟数(0-59)
    // var s = myDate.getSeconds();//获取当前秒
    var week = myDate.getDay();
    var weeks = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
    var dd = year + "年" + mon + "月" + date + "日" + weeks[week];
    return dd;
}

//备注保留n个字符
function getRemark(remark){
    var n = 8;

    if ("" == remark || null == remark){
        var temp = "";
        for (var i=0; i<n;i++){
            temp += "&emsp;";
        }
        return temp;
    }
    if (remark.length==n){
        return remark;
    }
    if (remark.length<n){
        var temp="";
        for (var i=0;i<n-remark.length;i++){
            temp += "&emsp;";
        }
        return remark+temp;
    }
    if (remark.length>n){
        return remark.substring(0, n-1)+"....";
    }
}
