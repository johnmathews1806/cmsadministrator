//Module declaration
angular.module('Authentication', []);
angular.module('Home', []);
angular.module('CustSetup', ['ngRoute']);
angular.module('CustSearch', ['ngRoute']);
angular.module('ProdSearch', ['ngRoute']);
angular.module('TranSearch', ['ngRoute']);
angular.module('Logout', []);
var app = angular.module('cms',[
										'ngRoute',
										'ngCookies',
										'Authentication',		
										'Home',				
										'CustSetup',
										'CustSearch',
										'ProdSearch',
										'TranSearch',
										'Logout'
										]);

app.config(function($routeProvider) {	
    $routeProvider    
    .when("/home", {
        templateUrl : 'home/home.html',
        controller : "homeCtrl"
    })
    .when("/prodsearch", {
        templateUrl : 'productsearch/prodsearch.html',
        controller : "prodSearchCtrl"
    })
    .when("/orders", {
        templateUrl : 'orders/orders.html',
        controller : "ordersCtrl"
    })
    .when("/custsetup", {
        templateUrl : 'customersetup/custsetup.html',
        controller : "custSetupCtrl"
    })
    .when("/custsearch", {
        templateUrl : 'customersearch/custsearch.html',
        controller : "custSearchCtrl"
    })
    .when("/transearch", {
        templateUrl : 'transactionsearch/transearch.html',
        controller : "tranSearchCtrl"
    })
    .when("/menu5", {
        templateUrl : 'menu5/menu5.html'
    })    
    .when("/logout", {
        //templateUrl : 'logout/logout.html', //This blocks logout when server is down
    	template : '<html>Logging out...</html>',
        controller : "logoutCtrl"  
    })    
    .otherwise({
        redirectTo: '/home'
    });
    
})
.run(['$rootScope', '$location', '$cookieStore', '$http','$window',
    function ($rootScope, $location, $cookieStore, $http, $window) {
		$rootScope.port=7001; //application port setting
        // keep user logged in after page refresh		
        //$rootScope.globals = $cookieStore.get('globals1') || {}; //COOKIE
        //$rootScope.globals = angular.fromJson($window.localStorage.getItem('globals1')) || {}; //LOCALSTORAGE
        $rootScope.globals = angular.fromJson($window.sessionStorage.getItem('globals1')) || {}; //SESSIONSTORAGE        
        
        //alert('called on refresh '+$rootScope.globals.currentUser.userid);
        if ($rootScope.globals.currentUser) {
        	//alert('Has valid user in cookie');
            //$http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }
  
        $rootScope.$on('$locationChangeStart', function (event, next, current) {        	
        	//if(!$rootScope.globals)
        		//$rootScope.globals= $cookies.get('globals') || {};
        	//alert('path change...1');        	
        	//alert(!$rootScope.globals.currentUser?'No Cookie':'Cookie exists');
            // redirect to login page if not logged in
            if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
            	//alert('in check');
                //$location.path('/login');
                window.location = 'index.html';
            }
        });
    }]);
