angular.module('Authentication')
.controller('loginCtrl', function($scope,$http,$location,AuthenticationService) {	

	$scope.login = function() {
		//alert("in login");
		$scope.error = false;
		$scope.dataLoading = true;
		AuthenticationService.SecureLogin($scope.userid, $scope.password,function(status){
			//alert("in callback2");
			//alert(status.valid);
			//alert(status.message);
			if(status.valid){
				//alert('calling SetCredentials...');
				AuthenticationService.SetCredentials($scope.userid, $scope.password);
				window.location = 'app.html'; // when loading a separate page altogether for the app
				//$location.path('/home'); // when using index.html and replacing partials for the app
				//$location.url('app.html');
			}else{
				$scope.error = status.message;
				$scope.dataLoading = false;
			}

		});		
	};

});
/*
.service('AuthenticationService', function($http) {
    this.myFunc = function (x) {
        return x.toString(16);
    }
    
    this.VerifyCall = function(){
    	return 'Log in called';
    }
    
    this.Login = function(userid,password,callback){
    	alert("called show1");		
    	alert(userid);
    	alert(password);
    	var status={"valid":"false","message":""};
    	var validUser = false;
    	$http.get("scripts/users.js")
    	//When Response is OK
    		.then(function (response) {
    			alert("in http");
    			//alert(response.data.users);    			
    			for(var count = 0; count < response.data.users.length; count++){    	    		
    	    		//alert("loop: "+count);
    				if(password==response.data.users[count].password && 
    						angular.lowercase(userid)==angular.lowercase(response.data.users[count].name)){
    					alert("validated");
    					validUser = true;
    					break;					
    				}    				
    			}    			
    			
    			if(validUser){
    				alert("valid");
    	    		status.valid=true;
    	    	}else{
    	    		alert("not valid");
    	    		status.valid=false;
    	    		status.message="Incorrect Credentials";
    	    	}	    	    	
    	    	alert(status.message);    	    	
    	    	callback(status);
    	}
        	//When Response is NOT OK
    		,function(response) {    		
    		status.valid=false;
    		status.message = "Something went wrong";       	
        	alert(status.message);        	
        	callback(status);
		});    	

    }
});
*/