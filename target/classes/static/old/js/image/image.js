function Image($scope, $http) {
	  
 
 $http.get('http://localhost:8080/images').
 success(function(data) {
 $scope.images = data;
 	     
 });



}