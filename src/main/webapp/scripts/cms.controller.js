angular.module('shoppingcartX')
.controller('logoutCtrlX', function($scope,$location,$http,AuthenticationService) {


	//alert('calling logout...');

	$scope.logout = function() {

		$http.post('logout', {})
		//When Response is OK
		.success(function() {
			AuthenticationService.ClearCredentials();
		})
		//When Response is NOT OK
		.error(function(data) {
			AuthenticationService.ClearCredentials();
		});
		window.location = 'index.html';

	}	
	/*
		$http({
	        method: 'post',
	        url: 'logout'	        
	    })
		//When Response is OK
		.then(function (response) {    	
			alert("logout success");			
		}
		//When Response is NOT OK
		,function(response) {			    		
			alert("logout failure");			
		});
		AuthenticationService.ClearCredentials();
		//$location.path('/login');

		window.location = 'index.html';
	 */

});
