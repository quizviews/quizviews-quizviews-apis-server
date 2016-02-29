///**
//  */
//
//angular.module("QuizViewApp").service('fileUpload', [ '$http', function($http) {
//	// this.uploadFileToUrl = function(uploadUrl, file, name, date) {
//	this.uploadFileToUrl = function(uploadUrl, file) {
//		var fd = new FormData();
//		fd.append('file', file);
//		// fd.append('person', name);
//		// fd.append('date', date);
//		$http.post(uploadUrl, fd, {
//			transformRequest : angular.identity,
//			headers : {
//				'Content-Type' : undefined
//			}
//		
//		}).success(function(data, status, headers, config) {
//			 var location = headers('Location');
//			// alert($scope.nameTest);
//			// alert(headers('Location'));
//			//
//			// //alert(status);
//			// //alert(headers);
////			 alert(headers.location);
//			 console.log("---> " +location);
//			 return function(){
//				 
//			 }
// 		}).error(function() {
//			console.log("error!");
//		});
//	}
//} ]);


/**
  */

angular.module("QuizViewApp").service('fileUpload', [ '$http', function($http) {
	// this.uploadFileToUrl = function(uploadUrl, file, name, date) {
	this.uploadFileToUrl = function(uploadUrl, file) {
		var fd = new FormData();
		fd.append('file', file);
		// fd.append('person', name);
		// fd.append('date', date);
		return $http.post(uploadUrl, fd, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}
		
		});
	}
} ]);
