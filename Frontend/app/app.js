define(['include'], function ( angularAMD ) {

	'use strict';

	var app = angular.module('TaxonomicDB', ['ui.router', 'ngResource']);

	app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

		$urlRouterProvider.otherwise('/home');

		$stateProvider

			.state('home', angularAMD.route(
				{
					url: '/home',
					templateUrl: 'app/home/views/default.html',
					controllerUrl: 'home/controllers/homeController'
				}))
			.state('login', angularAMD.route(
				{
					url: '/login',
					templateUrl: 'app/auth/views/login.html',
					controllerUrl: 'auth/controllers/authController'
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

	}]);

	return angularAMD.bootstrap(app);
});
