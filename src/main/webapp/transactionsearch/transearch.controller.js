angular.module('TranSearch')
.controller('tranSearchCtrl', function($scope,$rootScope,$http,$route,$location) {
	//alert("in customer setup controller");
	//$scope.dataLoading = true;
	$scope.error=false;
	
	$scope.searchTransaction = function(){		
		//alert("in searchTransaction()");
		
		$scope.submitInProcess = true;
		//$http.get("http://localhost:9000/cmsadministrator/secure/getTransactions/"+($scope.firstName||"")+","+($scope.middleName||"")+","+($scope.lastName||"")+",x")
		$http.get("http://localhost:"+$rootScope.port+"/cmsadministrator/secure/getTransactions/"+($scope.firstName||"")+","+($scope.middleName||"")+","+($scope.lastName||"")+",x")
			.then(function(response){
				$scope.submitInProcess = false;
				$scope.transactions=response.data;
				//alert(response.data);
				//alert("success"+response.status);
				//$route.reload();					  	
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
