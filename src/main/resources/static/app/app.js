/**
 * Created by houssem on 11/30/2015.
 */
(function () {
    var app = angular.module('app', []);

    app.config(function ($provide) {
        $provide.provider('books', function () {
            this.$get = function () {
                var appName = "Book Logger";
                var appDesc = "Book descreption";
                return {
                    appName: appName,
                    appDesc: appDesc
                };
            };
        });
    });


    // 2ed provider
    app.provider('livres', function () {
        this.$get = function () {
            var appName = "livre Logger";
            var appDesc = "livre descreption";
            if (priceLivre = true) {
                appDesc = "livre trop cher"
            }
            return {
                appName: appName,
                appDesc: appDesc
            };
            var priceLivre = false;
            this.isHighPriceLivre = function (value) {
                priceLivre = value;
            };
        };
    });

    app.config(function (livresProvider) {
        livresProvider.isHighPriceLivre = true;
    });

//3ime service facroty
    app.factory("dataService", dataService);
    function dataService(constantService) {
        console.log("BASE_URL " + constantService.BASE_URL);
        return {
            url: constantService.BASE_URL,
            listBooks: getAllBooks,
            listReaders: getAllReaders
        };
        function getAllBooks() {
            return [
                {
                    book_id: 1,
                    title: "A",
                    author: "Mr A",
                    year_published: 1658
                }, {
                    book_id: 3,
                    title: "C",
                    author: "Mr C",
                    year_published: 1958
                }, {
                    book_id: 2,
                    title: "B",
                    author: "Mr B",
                    year_published: 1858
                }
            ]
        }

        function getAllReaders() {
            return [
                {
                    book_id: 1,
                    title: "A",
                    author: "Mr A",
                    year_published: 1658
                }, {
                    book_id: 3,
                    title: "C",
                    author: "Mr C",
                    year_published: 1958
                }, {
                    book_id: 2,
                    title: "B",
                    author: "Mr B",
                    year_published: 1858
                }
            ]
        }

    };

    //constant service
    app.constant("constantService", {
        BASE_URL: "http://localhost:8080/"
        , "port": "80"
    });




}());