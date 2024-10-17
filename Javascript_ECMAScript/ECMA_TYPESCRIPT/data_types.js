var Demo = /** @class */ (function () {
    function Demo() {
    }
    Demo.prototype.getDataTypes = function () {
        var flag = true;
        var amount = 80000;
        var city = "Delhi";
        var pi = 3.141;
        var arr = [10, 20, 30, 40, 50];
        console.log("flag " + flag);
        console.log("amount " + amount);
        console.log("city " + city);
        console.log("pi " + pi);
        console.log(arr);
    };
    return Demo;
}());
var d = new Demo();
d.getDataTypes();
