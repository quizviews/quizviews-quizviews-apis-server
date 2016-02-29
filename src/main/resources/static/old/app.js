//  var myApp = angular.module('myApp', []);
//
// myApp.directive('fileModel', ['$parse', function ($parse) {
//     return {
//         restrict: 'A',
//         link: function(scope, element, attrs) {
//             var model = $parse(attrs.fileModel);
//             var modelSetter = model.assign;
//             
//             element.bind('change', function(){
//                 scope.$apply(function(){
//                     modelSetter(scope, element[0].files[0]);
//                 });
//             });
//         }
//     };
// }]);
//
// myApp.service('fileUpload', ['$http', function ($http) {
//     this.uploadFileToUrl = function(file, uploadUrl){
//         var fd = new FormData();
//         fd.append('file', file);
//         $http.post(uploadUrl, fd, {
//             transformRequest: angular.identity,
//             headers: {'Content-Type': undefined}
//         })
//         .success(function(){
//         })
//         .error(function(){
//         });
//     }
// }]);
//
// myApp.controller('myCtrl', ['$scope', 'fileUpload', function($scope, fileUpload){
//	 $scope.A="aaaa";
//     $scope.uploadFile = function(){
//    	 alert("uploadFile");
//         var file = $scope.myFile;
//         console.log('file is ' );
//         console.dir(file);
//         var uploadUrl = "/tests/upload";
//         fileUpload.uploadFileToUrl(file, uploadUrl);
//     };
//     
// }]);
// 

var app = angular.module('archive', []);

app.directive('fileModel', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function() {
				scope.$apply(function() {
					modelSetter(scope, element[0].files[0]);
				});
			});
		}
	};
} ]);

//app.service('ArchiveService', [ '$http', '$rootScope', function($http, $rootScope) {
//	this.search = function(name, date) {
//		$http.get("http://localhost:8080/archive/documents", {
//			params : {
//				person : name,
//				date : date
//			}
//		}).success(function(response) {
//			$rootScope.metadataList = response;
//		}).error(function() {
//		});
//	}
//}]);

app.service('fileUpload', ['$http', function($http) {
	this.uploadFileToUrl = function(uploadUrl, file, name, date) {
		var fd = new FormData();
		fd.append('file', file);
		fd.append('person', name);
		fd.append('date', date);
		$http.post(uploadUrl, fd, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}
		}).success(function() {
//			ArchiveService.search(null, null);
		}).error(function() {
		});
	}
} ]);

app.controller('UploadCtrl', [ '$scope', 'fileUpload',
		function($scope, fileUpload) {
			$scope.uploadFile = function() {
				var uploadUrl = "http://localhost:8080/api/tests/upload";
				var file = $scope.myFile;
				var name = $scope.name;
				var date = $scope.date;
				console.log('file is ' + JSON.stringify(file));
				fileUpload.uploadFileToUrl(uploadUrl, file, name, date);
			};
		} ]);

//app.controller('ArchiveCtrl', function($scope, $http) {
//	$scope.search = function(name, date) {
//		$http.get("http://localhost:8080/archive/documents", {
//			params : {
//				person : name,
//				date : date
//			}
//		}).success(function(response) {
//			$scope.metadataList = response;
//		});
//	};
//});

//app.run(function($rootScope, $http) {
//	$http.get("http://localhost:8080/archive/documents").success(
//			function(response) {
//				$rootScope.metadataList = response;
//			});
//});

//function sortByLabel(claims) {
//	claims.sort(function(a, b) {
//		var labelA = a.label.toLowerCase(), labelB = b.label.toLowerCase();
//		if (labelA < labelB) // sort string ascending
//			return -1;
//		if (labelA > labelB)
//			return 1;
//		return 0; // default return value (no sorting)
//	});
//}