/**
 * Created by houssem on 12/1/2015.
 */
( function () {

var app=angular.module("app");
    app.service("loggerService", BookLoggerService);

    function LoggerServiceBase() {

    }

    LoggerServiceBase.prototype.output = function (message) {
        console.log('LoggerServiceBase ' + message);
    };

    function BookLoggerService() {
        LoggerServiceBase.call(this);
        this.logBook= function (book) {
        console.log("book: "+book.title);

        }
    }

    BookLoggerService.prototype = Object.create(LoggerServiceBase.prototype);

}());