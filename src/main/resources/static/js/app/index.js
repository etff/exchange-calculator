var main = {
    init : function() {
        var _this = this;

        $("#target").on("change", function() {
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
            dataType: 'text',
            data: { target : unit},
            contentType:'application/json; charset=utf-8',
        }).done(function(data) {
            if (data) {
                var result = JSON.parse(data);
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
        var unit = $("#target").val();
        $.ajax({
            type: 'GET',
            url: '/api/currency',
            dataType: 'text',
            data: { target : unit},
            contentType:'application/json; charset=utf-8',
        }).done(function(data) {
            var result = JSON.parse(data);
            var amount = result.amount.replace(/['"]+/g, '');
            $("#rate").html(`환율 : ${amount} ${unit}/USD`);

        }).fail(function (error) {
            alert(error.responseJSON.message);
        });
    },
    send : function() {
        var data = {
            target: $('#target').val(),
            amount: $('#amount').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/currency/calculate',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(result) {
            console.log(result);
        }).fail(function (error) {
            alert(error.responseJSON.message);
        });
    }
};

main.init();
