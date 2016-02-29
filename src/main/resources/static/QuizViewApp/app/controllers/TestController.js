/**
 * All controller for the test component CRUD: Create Read List update delete
 */

angular.module("QuizViewApp")

.controller(
		"newTestController",
		function($rootScope,$scope, testsFactory, fileUpload, $location,constants) {
			$rootScope.PAGE="new"	;
			// $scope.test=new Test ({
			$scope.test = new testsFactory({
				// titleTest : ['aaa','text'],
				// imageCoverTest:'',
				email : '',
				website : '',
				titleTest : ''
			// titleTest:['x','Text' ],
			// firstName : [ '', 'text' ],
			// lastName : [ '', 'text' ],
			// email : [ '', 'email' ],
			// homePhone : [ '', 'tel' ],
			// cellPhone : [ '', 'tel' ],
			// birthday : [ '', 'date' ],
			// website : [ '', 'url' ],
			// address : [ '', 'text' ]

			});

			$scope.saveTest = function() {
				var isImageCoverInputExist = false;

				// the name of the form in the view is newTestForm
				if ($scope.newTestForm.$invalid) {
					console.log("invalid testForm");
					$scope.$broadcast('record:invalid');
					// $broadcast messages based interComponent communication
					// $scope.$on('record:invalid', function() {
					// $scope[$scope.field].$setDirty();
					// });

				} else {
//					var uploadUrl = "http://localhost:8080/api/tests/upload";
					var uploadUrl =constants.BASE_URL +"/tests/upload";
					var file = $scope.myFile;
					if (file === undefined) {
						// alert("file is null: "+file);
					} else {
						// alert("file is not null ! "+file.name);
						isImageCoverInputExist = true;
						fileUpload.uploadFileToUrl(uploadUrl, file).success(
								function(data, status, headers, config) {
									var location = headers('Location');
									console.log("---> " + location);
									// console.log("$scope.test: "+$scope.test);
									// $scope.test.images={"url_image":"123.png"};
									$scope.test.image = {
										"urlImage" : location
									};
									// console.log("$scope.test: "+$scope.test);
									console.log("stringify: "
											+ JSON.stringify($scope.test));

									$scope.test.$save().then(function(res) {
										$location.url("/tests");
									});
								});
					}

					// console.log("$scope.test: " + $scope.test);
					// console.log("$scope.test.titleTest[0]: "
					// + $scope.test.titleTest[0]);
					// console.log("$scope.test.titleTest[1]: "
					// + $scope.test.titleTest[1]);
					// console.log("$scope.test.titleTest: "
					// + $scope.test.titleTest);
					// $scope.test.$save();
					if (isImageCoverInputExist === false) {
						$scope.test.$save().then(function(res) {
							$location.url("/tests");
						});
					}
				}
			};

		}).controller("listTestsController",
		function($rootScope, $scope, testsFactory, tableFieldsValues, $location) {
			// $scope.contacts=[];
			$rootScope.PAGE="all"	;

			$scope.tests = testsFactory.query();
			// contactFactory.listBooks().then(function(response) {
			// var tests=response.data;
			// console.log(tests);
			// });
			// $scope.contacts =tests;
			// $scope.fields=["firstName","lastName"];
			$scope.fields = tableFieldsValues.listTableFields("tests");
			$scope.sort = function(field) {
				$scope.sort.field = field;
				$scope.sort.order = !$scope.sort.order;
			}

			$scope.sort.field = 'idTest';
			$scope.sort.order = false;
			$scope.read = function(idTest) {
				$location.url("/tests/" + idTest);
			};

		}).controller("SingleTestController",
		function($rootScope,$scope, $location, testsFactory, $routeParams,$http) {
			$rootScope.PAGE="single";
			$scope.test = testsFactory.get({
				idTest : parseInt($routeParams.idTest,10)
			});
// var testString=JSON.stringify($scope.test );
			$scope.delete=function(){
					$scope.test.$delete({idTest:  parseInt($routeParams.idTest,10)}, 
						    function(successResult) {
							 $location.url('/tests');
						        // do something on success
						    }, function(errorResult) {
						        // do something on error
						        if(errorResult.status === 404) {            
						        }}); 
// $http.delete('http://localhost:8080/api/tests/'+
// parseInt($routeParams.id,10))
// .success(function(data, status, headers, config) {
// console.log("OK");
// $location.url('/tests');
// })
// .error(function(data, status, headers, config) {
// console.log('Error deleting Todo');
// $location.url('/');
// });
			};
		});