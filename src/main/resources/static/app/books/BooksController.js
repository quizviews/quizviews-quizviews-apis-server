/**
 * Created by houssem on 11/30/2015.
 */
( function () {
    angular.module('app')
        //BooksController contains the provider and factory services
        .controller('BooksController', BooksController)
        //LivresController contains the provider and factory services
        .controller('LivresController', LivresController);
    function BooksController(books,dataService, loggerService) {
        loggerService.output('BooksController is created !');
        var vm = this;
        vm.appName = books.appName;
        vm.listBooks=dataService.listBooks();
        vm.url=dataService.url;
    }

    function LivresController(livres) {
        var vm = this;
        vm.appName = livres.appName;
        vm.appDesception = livres.appDesc;
    }
}());