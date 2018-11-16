var url_ori = window.location.href
var url_process_1 = url_ori.replace("platform", "loantotal");
var url_process_2 = url_ori.replace("platform", "loanavg");
var url_process_3 = url_ori.replace("platform", "loanmonth");

var data_list = [],
    grade_list = [],
    time_list = [],
    new_time_list1;

var data_total_1;
var data_loan_total;
var data_funded_total;
var data_funded_inv;

var data_load_2 = [];

var data_month_3 = [];

var data_month = [],
    data_count = [];

var list_a = [],
    list_b = [],
    list_c = [],
    list_d = [],
    list_e = [],
    list_f = [],
    list_g = [];


$(function () {
    $.ajax({
        url: url_process_1,
        complete: function (json1) {
            data_total_1 = JSON.parse(json1.responseText)[0];
            data_loan_total = Math.round(data_total_1["loan_total"]).format();
            data_funded_total = Math.round(data_total_1["funded_total"]).format();
            data_funded_inv = Math.round(data_total_1["funded_inv"]).format();

            document.getElementById("peep1").innerHTML = "$" + data_loan_total;
            document.getElementById("peep2").innerHTML = "$" + data_funded_total;
            document.getElementById("peep3").innerHTML = "$" + data_funded_inv;

        }

    });

    $.ajax({
        url: url_process_2,
        type: 'GET',
        dataType: 'json',
        complete: function (json2) {
            data_load_2 = JSON.parse(json2.responseText);


            for (var i = 0; i < data_load_2.length; i++) {

                if (data_load_2[i]['level'] == "A_Grade") {
                    list_a.push(Math.round(data_load_2[i]['loadAvg']));
                }
                if (data_load_2[i]['level'] == "B_Grade") {
                    list_b.push(Math.round(data_load_2[i]['loadAvg']));
                }
                if (data_load_2[i]['level'] == "C_Grade") {
                    list_c.push(Math.round(data_load_2[i]['loadAvg']));
                }
                if (data_load_2[i]['level'] == "D_Grade") {
                    list_d.push(Math.round(data_load_2[i]['loadAvg']));
                }
                if (data_load_2[i]['level'] == "E_Grade") {
                    list_e.push(Math.round(data_load_2[i]['loadAvg']));
                }
                if (data_load_2[i]['level'] == "F_Grade") {
                    list_f.push(Math.round(data_load_2[i]['loadAvg']));
                }
                if (data_load_2[i]['level'] == "G_Grade") {
                    list_g.push(Math.round(data_load_2[i]['loadAvg']));
                }
                data_list.push(data_load_2[i]['loadAvg']);
                grade_list.push(data_load_2[i]['grade']);
                time_list.push(data_load_2[i]['month']);

            }

            new_time_list1 = Array.from(new Set(time_list));

            var chart1 = new Highcharts.chart('container_chart1', {
                title: {
                    text: 'Loans by Credit Grade'
                },

                subtitle: {
                    text: 'Loans Issued by Credit Score (Grade)'
                },
                xAxis: {
                    categories: new_time_list1,
                    tickInterval: 1,
                    labels: {
                        enabled: true
                    }

                },

                yAxis: {
                    title: {
                        text: 'Average Loan Amount'
                    }
                },
                legend: {
                    title: {
                        text: 'Grade<br/><span style="font-size: 9px; color: #666; font-weight: normal">(Click to hide)</span>',
                        style: {
                            fontStyle: 'italic'
                        }
                    },
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle'
                },

                plotOptions: {
                    series: {
                        label: {
                            connectorAllowed: false
                        }
                    }
                },

                series: [{
                    name: 'A',
                    data: list_a
                }, {
                    name: 'B',
                    data: list_b
                }, {
                    name: 'C',
                    data: list_c
                }, {
                    name: 'D',
                    data: list_d
                }, {
                    name: 'E',
                    data: list_e
                }, {
                    name: 'F',
                    data: list_f
                }, {
                    name: 'G',
                    data: list_g
                }],

                responsive: {
                    rules: [{
                        condition: {
                            maxWidth: 500
                        },
                        chartOptions: {
                            legend: {
                                layout: 'horizontal',
                                align: 'center',
                                verticalAlign: 'bottom'
                            }
                        }
                    }]
                }

            });

        }

    });

    $.ajax({
        url: url_process_3,
        complete: function (json3) {
            data_month_3 = JSON.parse(json3.responseText);

            for (var k = 0; k < data_month_3.length; k++) {
                data_count.push(data_month_3[k]['count']);
                data_month.push(data_month_3[k]['month']);
            }

            var chart2 = new Highcharts.chart('container_chart2', {
                chart: {
                    type: 'column'
                },
                title: {
                    text: '<b>Monthly Loan Volume</b>'
                },
                subtitle: {
                    text: 'Lending Club - Monthly Loan Volume for Year'
                },
                xAxis: {
                    categories: data_month,
                    tickInterval: 1,
                    labels: {
                        enabled: true
                    }
                },
                yAxis: {
                    title: {
                        text: 'Loan Volume'
                    }

                },
                legend: {
                    enabled: false
                },
                plotOptions: {
                    series: {
                        borderWidth: 0,
                        dataLabels: {
                            enabled: true
                        }
                    }
                },

                tooltip: {
                    headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                    pointFormat: '<b>{point.y}</b>'
                },

                series: [
                    {
                        name: "Monthly Loan",
                        colorByPoint: true,
                        data: data_count
                    }
                ]
            });

        }

    });
});

Number.prototype.format = function (n, x) {
    var re = '\\d(?=(\\d{' + (x || 3) + '})+' + (n > 0 ? '\\.' : '$') + ')';
    return this.toFixed(Math.max(0, ~~n)).replace(new RegExp(re, 'g'), '$&,');
};


function run() {
    window.location.href = window.location.href.replace(url_ori.substring(51, 55), document.getElementById("Ultra").value);
   //window.location.href = window.location.href.replace(url_ori.substring(22, 26), document.getElementById("Ultra").value);
}