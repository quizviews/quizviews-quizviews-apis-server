/**
 * Created by houssem on 12/2/2015.
 */
var app = angular.module("QuizViewApp",
		[ 'ngResource', 'ngRoute', 'ngMessages' ]);
app.run(function($rootScope) {
	$rootScope.messageTest = "it just works !";
});
app.config(function($routeProvider, $locationProvider) {
	$routeProvider.when("/tests/", {
		controller : "listTestsController",
		templateUrl : "QuizViewApp/app/views/ListTests.html"
	}).when("/tests/new", {
		controller : "newTestController",
		templateUrl : "QuizViewApp/app/views/NewTest.html"
	}).when("/tests/:idTest", {
		controller : "SingleTestController",
		templateUrl : "QuizViewApp/app/views/SingleTest.html"
	});
//	.otherwise({
//		redirectTo : "/"
//	});

	// added by me
	// .otherwise('/');
	// $locationProvider.html5Mode(true).hashPrefix('!');
	$locationProvider.html5Mode(true);

});
