define(['angularAMD'], function (angularAMD) {

    'use strict';

    angularAMD.directive('username', function ( ) {

        return {
            restrict: 'A',
            template:'<span>{{username}}</span>',
            scope:{
                username:'='
            },
            controller: function($scope, $window){
                    $scope.username = $window.sessionStorage.user;
            }
        };
    });
});