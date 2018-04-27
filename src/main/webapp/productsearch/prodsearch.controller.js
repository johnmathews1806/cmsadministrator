angular.module('ProdSearch')
.controller('prodSearchCtrl', function($scope,$rootScope,$http,$route,$location) {
	//alert("in customer setup controller");
	//$scope.dataLoading = true;
	$scope.error=false;
	
	$scope.searchProduct = function(){		
		//alert("in prodSearch()");
		
		$scope.submitInProcess = true;
		//$http.get("http://localhost:9000/cmsadministrator/secure/getProducts/"+($scope.firstName||"")+","+($scope.middleName||"")+","+($scope.lastName||"")+",x")
		$http.get("http://localhost:"+$rootScope.port+"/cmsadministrator/secure/getProducts/"+($scope.firstName||"")+","+($scope.middleName||"")+","+($scope.lastName||"")+",x")
			.then(function(response){
				$scope.submitInProcess = false;
				$scope.products=response.data;
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
