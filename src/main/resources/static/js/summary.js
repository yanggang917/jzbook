
$(function(){
    $.ajax({
        url : "/bills/summary",
        async : false,
        type : "POST",
        contentType : 'application/json',
        dataType : 'json',
        success : function(data) {
            if (data.success == true) {
                initdate(data.retData.totalMoney, data.retData.list);
            }
        }
    });

});

function initdate(totalMoney, data){
    Highcharts.chart('container', {
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: '2019年11月一共支出'+totalMoney+'元'
        },
        // tooltip: {
        //     pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        // },
        // plotOptions: {
        //     pie: {
        //         allowPointSelect: true,
        //         cursor: 'pointer',
        //         dataLabels: {
        //             enabled: true,
        //             format: '<b>{point.name}</b>: {point.percentage:.1f} %',
        //             style: {
        //                 color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
        //             }
        //         }
        //     }
        // },
        credits: { enabled:false},
        exporting: { enabled:false },
        series: [{
            name: 'Brands',
            colorByPoint: true,
            data: data
            /*data: [{
                name: 'Chrome',
                y: 61.41,
                sliced: true,
                selected: true
            }, {
                name: 'Internet Explorer',
                y: 11.84
            }, {
                name: 'Firefox',
                y: 10.85
            }, {
                name: 'Edge',
                y: 4.67
            }, {
                name: 'Safari',
                y: 4.18
            }, {
                name: 'Sogou Explorer',
                y: 1.64
            }, {
                name: 'Opera',
                y: 1.6
            }, {
                name: 'QQ',
                y: 1.2
            }, {
                name: 'Other',
                y: 2.61
            }]*/
        }]
    });
}




