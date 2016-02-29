/**
 * this directive has 2 directives 
 * one for the field-input and the other for the file-model "uploading file into a form" 
 * */

var app = angular.module("QuizViewApp");

app.directive("formField", function($timeout, FieldTypes, TypeMessages) {
	return {
		restrict : 'EA',
		templateUrl : 'QuizViewApp/app/views/templates/form-field.html',
		replace : true,
		scope : {
			record : "=",
			field : "@",
			live : "@",
			required : "@"
		},

		link : function($scope, element, attr) {
			// recordtypes I have used it for testing
			$scope.recordtypes = {
				'titleTest' : 'text',
				'email' : 'email'
			};
			$scope.debug = false;

			$scope.field_message_list = FieldTypes;
			$scope.type_message_list = TypeMessages;

			$scope.$on('record:invalid', function() {
				$scope[$scope.field].$setDirty();
			});

			$scope.remove = function(field) {
				delete $scope.record[field];
				$scope.blurUpdate();
			};
			$scope.blurUpdate = function() {
				if ($scope.live !== 'false') {
					$scope.record.$update( function(updatedRecord) {
						$scope.record = updatedRecord;
					});
				}
			};

			var saveTimeout;

			$scope.update = function() {
				$timeout.cancel(saveTimeout);
				saveTimeout = $timeout($scope.blurUpdate, 1000);
			};

		}
	};
});

app.directive('fileModel', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function() {
				scope.$apply(function() {
					modelSetter(scope, element[0].files[0]);
					var binaryData = [];
					binaryData.push(element[0].files[0]);
					var tmppath = window.URL.createObjectURL(new Blob(binaryData, {type: element[0].files[0].type}))

//					$("#file-name-id").append(element[0].files[0].name);
//					$("#file-name-id").append(tmppath);
//					$("#file-name-id").append("<img class='img-rounded' style='width:50%;' src='"+tmppath+"'/>");
					$("#file-name-id").fadeIn("fast").attr('src',tmppath);
//					http://jsfiddle.net/dwebexperts/4FGg8/1/
				});
			});
		}
	};
} ]);
