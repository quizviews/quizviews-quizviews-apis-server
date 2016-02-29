/**
 * Created by houssem on 12/2/2015.
 */

angular.module("QuizViewApp")
    .factory("testsFactory", function($resource,$http,constants){
//         return $resource(constants.BASE_URL+"tests?size=500/:id" ,{id:'@id'},{"update":"put" });
//         return $resource(constants.BASE_URL+"tests/:id" ,{id:'@id'},{"update":"put"});
         return $resource(constants.BASE_URL+"tests/:idTest" ,{idTest:'@idTest'},
    		 {
             update: { method: 'PUT' }
    		 }
//         { 'update': { method: 'PUT' } }
//         ,
//    		 {
//              'delete': { method: 'DELETE'  }
//    		 }
        );
//        return {
//             listBooks: getAllBooks
//        };
        function getAllBooks(){
          return  $http.get(constants.BASE_URL+"tests");
         }
         	
         //can not send data to the controller
         //function getAllBooks(){
         //  $http.get("http://localhost:8080/tests")
         //    .then(function(response) {
         //        var tests=response.data;
         //        console.log(tests);
         //        return tests;
         //
         //    });
         //}


    });