angular.module('Home')
.controller('homeCtrl', function($scope,$rootScope) {	
	//alert('in home controller'); 
    
	$scope.creds = $rootScope.globals.currentUser.userid;
	$scope.message = 'Text put here';



});

