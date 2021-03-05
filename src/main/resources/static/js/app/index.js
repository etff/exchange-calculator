var main = {
    init : function() {
        var _this = this;

        $("#target").on("change", function() {
            _this.retrieve();
        });

        _this.load();
    },
    load : function() {
        var unit = "KRW";
        $.ajax({
            type: 'GET',
            url: '/currency',
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
            alert(JSON.stringify(error));
        });
    },
    retrieve: function() {
        var unit = $("#target").val();
        $.ajax({
            type: 'GET',
            url: '/currency',
            dataType: 'text',
            data: { target : unit},
            contentType:'application/json; charset=utf-8',
        }).done(function(data) {
            var result = JSON.parse(data);
            var amount = result.amount.replace(/['"]+/g, '');
            $("#rate").html(`환율 : ${amount} ${unit}/USD`);

        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();
