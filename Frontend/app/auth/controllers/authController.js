define(['app'], function () {

    'use strict';

    return ['$scope','$http','$rootScope', '$stateParams', function ($scope, $http, $rootScope, $stateParams ) {

        $scope.message = 'Login page';
    }];
});