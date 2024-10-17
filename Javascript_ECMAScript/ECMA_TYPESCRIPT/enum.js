function f1() {
    var Month;
    (function (Month) {
        Month[Month["JAN"] = 1] = "JAN";
        Month[Month["FEB"] = 2] = "FEB";
        Month[Month["MAR"] = 3] = "MAR";
        Month[Month["APR"] = 4] = "APR";
        Month[Month["NOV"] = 11] = "NOV";
        Month[Month["DEC"] = 12] = "DEC";
    })(Month || (Month = {}));
    var m = Month.DEC;
    console.log("month is : " + m);
}
f1();
