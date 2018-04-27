angular.module('Register')
.controller('registerCtrl', function($scope,$rootScope,$http,$route,$location) {	
	
	//$scope.dataLoading = true;
	$scope.error=false;
	$scope.register = function(){				
		alert("contacts: "+JSON.stringify($scope.registerDetails));
		$scope.submitInProcess = true;
		$http.post("http://localhost:9000/cmsadministrator/register/", $scope.registerDetails)
			.then(function(response){
				$scope.submitInProcess = false;
				alert("success"+response.status);
				$location.path('/login');							  	
			}, 
			function(response){
				$scope.submitInProcess = false;
				if(response.status=403){
					//$scope.error = "You do not have rights to perform this action !";
				   alert("You do not have rights to perform this action !");
				}else{
					$scope.error = "Host down or Network issue!";
				}				
				//alert("failure"+response.statusText);
			}
		);		


	}
	
});
