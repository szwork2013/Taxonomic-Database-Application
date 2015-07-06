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
			.state('about', angularAMD.route(
				{
					url: '/about',
					templateUrl: 'app/home/views/about.html',
					controllerUrl: 'home/controllers/homeController'
				}));

	}]);

	return angularAMD.bootstrap(app);
});
