angular.module('Logout')
.controller('logoutCtrl', function($scope,$location,$http,AuthenticationService) {
	
	
		//alert('calling logout...');
		
		//$http({
	      //  method: 'get',
	      //  url: 'logout'	        
	    //})
	    //$http.post('logout', {})
	    $http.get('logout')
		//When Response is OK
		.then(function () {    	
			//alert("logout success");			
		}
		//When Response is NOT OK
		,function() {			    		
			//alert("logout failure");			
		});
		AuthenticationService.ClearCredentials();
		//$location.path('/login');
		window.location = 'index.html';
	
});
