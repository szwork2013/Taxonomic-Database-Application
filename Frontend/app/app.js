define(['include'], function ( angularAMD ) {

	'use strict';

	var app = angular.module('TaxonomicDB', ['ui.router', 'ngResource','ngSanitize', 'toastr', 'highcharts-ng']);

	app.config(['$stateProvider','$provide', '$urlRouterProvider','$httpProvider',

		function ($stateProvider, $provide, $urlRouterProvider, $httpProvider, toastr) {

		$urlRouterProvider.otherwise('/login');

		$stateProvider

			.state('login', angularAMD.route(
				{
					url: '/login',
					templateUrl: 'app/auth/views/login.html',
					controllerUrl: 'auth/controllers/authController'
				}))
			.state('logout', angularAMD.route(
				{
					url: '/logout',
					templateUrl: 'app/auth/views/login.html',
					controllerUrl: 'auth/controllers/authController'
				}))
			.state('home', angularAMD.route(
				{
					url: '/home',
					templateUrl: 'app/home/views/default.html',
					controllerUrl: 'home/controllers/homeController'

				}))
			.state('user', angularAMD.route(
				{
					url: '/user/:id',
					templateUrl: 'app/home/views/user.form.html',
					controllerUrl: 'home/controllers/userController'
				}))
			.state('newuser', angularAMD.route(
				{
					url: '/user',
					templateUrl: 'app/home/views/user.form.html',
					controllerUrl: 'home/controllers/userController'
				}))
			.state('signup', angularAMD.route(
				{
					url: '/signup',
					templateUrl: 'app/auth/views/signup.html',
					controllerUrl: 'home/controllers/homeController'
				}))
			.state('reset', angularAMD.route(
				{
					url: '/reset',
					templateUrl: 'app/auth/views/reset.password.html',
					controllerUrl: 'auth/controllers/authController'
				}))
			.state('about', angularAMD.route(
				{
					url: '/about',
					templateUrl: 'app/home/views/about.html',
					controllerUrl: 'home/controllers/homeController'
				}));

			$provide.factory('authInterceptor', function ($rootScope, $q, $window) {

				return {
					request: function (config) {
						config.headers = config.headers || {};
						if ($window.sessionStorage.tokenSecret != null && $window.sessionStorage.tokenSecret != "null") {
							config.headers['X-AUTH-TOKEN'] = $window.sessionStorage.tokenSecret;
							$rootScope.username = $window.sessionStorage.user;
							$rootScope.userId = $window.sessionStorage.userId;
							$rootScope.userRole = $window.sessionStorage.userRole;
							$rootScope.logged = true;
						} else {
							$rootScope.username = null;
							$rootScope.userId = null;
							$rootScope.userRole = null;
							$rootScope.logged = false;
						}
						return config;
					},
					response: function (response) {
						if (response.status === 401) {
							// handle the case where the user is not authenticated
						}
						return response || $q.when(response);
					}
				};
			});

			$provide.factory('errorHandlerInterceptor', function ($rootScope, $q, $window, $location, toastr) {

				return {
					request: function(config) {
						return config;
					},
					requestError : function(rejection) {
						return rejection;
					},
					responseError : function(rejection) {
						if( rejection.status === 401 ) {
							$location.path('login');
							toastr.error(rejection.data, 'Error!');
							return $q.reject(rejection);
						}
						if( rejection.status === 400 ) {
							$location.path('login');
							toastr.error(rejection.data, 'Error!');
							return $q.reject(rejection);
						}
						if( rejection.status === 404 ) {
							toastr.error(rejection.data, 'Error!');
							return $q.reject(rejection);
						}

						if( rejection.status >= 500) {
							toastr.error(rejection.data, 'Error!');
							return $q.reject(rejection);
						}

						return $q.reject(rejection);

					}
				};
			});

			$httpProvider.interceptors.push('authInterceptor');
			$httpProvider.interceptors.push('errorHandlerInterceptor');

	}]);

	app.CONST = {
		//LOCALHOST:"http://localhost:8080/", //LOCAL
		LOCALHOST:"http://ec2-54-207-59-211.sa-east-1.compute.amazonaws.com:8080/", // QA
		SERVER:"http://ec2-54-207-59-211.sa-east-1.compute.amazonaws.com:8080/" // QA
		//SERVER:"http://ec2-54-232-250-216.sa-east-1.compute.amazonaws.com:8080/" // DEV
	};

	app.run(function( $rootScope, $timeout, $http, $window, $state, $location ) {

		/**
		 * Return the current host
		 *
		 * @returns {*}
		 */
		$rootScope.getHost = function() {

			if (document.location.hostname == 'localhost') {

				return app.CONST.LOCALHOST;
			}
			else {
				return app.CONST.SERVER;
			}
		};

		$rootScope.$on( "$stateChangeStart", function(event, toState, toParams, fromState, fromParams) {

			/*var path = $location.path();

			console.log(path);

			if (path === '/login' || path === '/logout') {
				return;
			}

			event.preventDefault();

			if (path === '/logout') {
				$state.go('login');
			}
			if($window.sessionStorage.user  == 'null'){

				console.log('go');
				$state.go('login');
			}*/
		});

	});

	return angularAMD.bootstrap(app);
});
