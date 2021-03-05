var main = {
    init : function() {
        var _this = this;

        $("#unit").on("change", function() {
            _this.retrieve();
        });

        $("#send").on("click", function() {
            _this.send();
        });

        _this.load();
    },
    load : function() {
        var unit = "KRW";
        $.ajax({
            type: 'GET',
            url: '/api/currency',
            dataType: 'json',
            data: { unit : unit},
            contentType:'application/json; charset=utf-8',
        }).done(function(data) {
            if (data) {
                var result = data;
                var apiSuccess = result.success;
                if (apiSuccess) {
                    var amount = result.amount.replace(/['"]+/g, '');
                    $("#rate").html(`환율 : ${amount} ${unit}/USD`);
                }
            }

        }).fail(function (error) {
            alert(error.responseJSON.message);
        });
    },
    retrieve: function() {
        var unit = $("#unit").val();
        $.ajax({
            type: 'GET',
            url: '/api/currency',
            dataType: 'json',
            data: { unit : unit},
            contentType:'application/json; charset=utf-8',
        }).done(function(data) {
            var amount = data.amount.replace(/['"]+/g, '');
            $("#rate").html(`환율 : ${amount} ${unit}/USD`);

        }).fail(function (error) {
            alert(error.responseJSON.message);
        });
    },
    send : function() {
        var unit = $("#unit").val();

        var param = {
            unit: $('#unit').val(),
            amount: $('#amount').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/currency/calculate',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(param)
        }).done(function(data) {
            var amount = data.amount.replace(/['"]+/g, '');

            $("#result").html(`수취금액은 ${amount} ${unit} 입니다.`);

        }).fail(function (error) {
            alert(error.responseJSON.message);
        });
    }
};

main.init();
