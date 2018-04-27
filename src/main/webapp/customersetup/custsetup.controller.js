angular.module('CustSetup')
.controller('custSetupCtrl', function($scope,$rootScope,$http,$route,$location) {
	//alert("in customer setup controller");
	//$scope.dataLoading = true;
	$scope.error=false;
	
	$scope.createCustomer = function(){		
		//alert("in custSetup()");
		//alert("contacts: "+JSON.stringify($scope.customerDetails));
		$scope.submitInProcess = true;
		//$http.post("http://localhost:9000/cmsadministrator/custsetup/", $scope.customerDetails)
		$http.post("http://localhost:"+$rootScope.port+"/cmsadministrator/custsetup/", $scope.customerDetails)
			.then(function(response){
				$scope.submitInProcess = false;
				//alert("success"+response.status);
				$location.path('/home');							  	
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
