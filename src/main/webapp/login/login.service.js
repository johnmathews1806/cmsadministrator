//alert("authentication service started");
angular.module('Authentication')

.factory('AuthenticationService', ['$http','$rootScope','$cookieStore','$window',
	function($http,$rootScope,$cookieStore,$window) {
	return{

		SecureLogin : function(userid,password,callback){
			//alert("called secure Login service");		
			//alert(userid);
			//alert(password);
			var status={"valid":false,"message":""};					
			$http({
		        method: 'post',
		        url: 'login',
		        params: { 'username': userid, 'password': password },
		        headers: {  'Content-Type': 'application/x-www-form-urlencoded' },
		    })
			//When Response is OK
			.then(function (response) {    	
				//alert("authenticated"+response.data);	
				
				status.valid=true;				
				//alert(status.message);    	    	
				callback(status);
			}
			//When Response is NOT OK
			,function(response) {  
				//alert(response.data);
				if(response.data){
					status.message = response.data;
				}else{					
					status.message = "Host down or Network issue!";
				}
				//alert(status.message);        	
				callback(status);
			});    	

		},

		Login : function(userid,password,callback){
			//alert("called Login service");		
			//alert(userid);
			//alert(password);
			var status={"valid":false,"message":""};
			//var validUser = false;
			$http.get("http://localhost:9000/shoppingcart/secure/getUser/"+userid)
			//When Response is OK
			.then(function (response) {    	
				//alert("request: "+password);
				//alert("response: "+response.data.password);
				if(password==response.data.password && 
						angular.lowercase(userid)==angular.lowercase(response.data.loginId)){    					
					//validUser = true;
					status.valid=true;    										
				}    				

				if(!status.valid){
					status.message="Incorrect Credentials";
				}
				//alert(status.message);    	    	
				callback(status);
			}
			//When Response is NOT OK
			,function(response) {    		
				status.message = "Host down or Network issue!";    		
				//alert(status.message);        	
				callback(status);
			});    	

		}, 

		SetCredentials : function (userid,password) {
			var authdata = userid + ':' + password;
			//alert(authdata);
			$rootScope.globals = {
					currentUser: {
						userid: userid,
						authdata: authdata
					}
			};
			//alert('cookie is set');
			//alert($rootScope.globals.currentUser.userid);

			//$http.defaults.headers.common['Authorization'] = 'Basic ' + authdata; // jshint ignore:line
			//alert('setting '+$rootScope.globals.currentUser.userid);
			//$cookieStore.put('globals1', $rootScope.globals);  
			//$window.localStorage.setItem('globals1',JSON.stringify($rootScope.globals));
			$window.sessionStorage.setItem('globals1',JSON.stringify($rootScope.globals));
		}  ,

		ClearCredentials : function () {			
			$rootScope.globals = {};
			//$cookieStore.remove('globals');
			//$window.localStorage.removeItem('globals1');
			$window.sessionStorage.removeItem('globals1');
			//$http.defaults.headers.common.Authorization = 'Basic ';            
		}  	

	}
}]);

