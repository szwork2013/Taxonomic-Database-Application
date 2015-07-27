define(['include'], function ( angularAMD ) {

	'use strict';

	var app = angular.module('TaxonomicDB', ['ui.router', 'ngResource','ngSanitize','toastr']);

	app.config(['$stateProvider','$provide', '$urlRouterProvider', function ($stateProvider, $provide, $urlRouterProvider) {

		$urlRouterProvider.otherwise('/login');

		$stateProvider

			.state('login', angularAMD.route(
				{
					url: '/login',
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
					controllerUrl: 'auth/controllers/authController'
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
					if ($window.sessionStorage.tokenSecret) {
						//config.headers['X-AUTH-TOKEN'] = $window.sessionStorage.tokenSecret;
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

	}]);

	app.CONST = {
		LOCALHOST:"http://localhost:8080/",
		SERVER:"http://ec2-54-94-252-185.sa-east-1.compute.amazonaws.com:8080/"
	};

	app.run(function( $rootScope ) {

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
	});

	return angularAMD.bootstrap(app);
});
