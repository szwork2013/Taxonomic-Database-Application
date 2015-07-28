/**
 * AuthenticationService Factory Model
 * @author Jose Carlos
 * @email jozecarlos.it@gmail.com
 *
 */
define(['app'], function (app) {

    'use strict';

    app.factory('AuthenticationService', ['$http','$window', '$rootScope', '$log', function ($http, $window, $rootScope, $log) {

        var service = {};

        service.authentication = function ( model, callback) {

            $http.post( $rootScope.getHost() + "login", model )
                .success(function (data, status, headers, config) {

                    //$http.defaults.headers.common['X-AUTH-TOKEN'] = data.token;
                    $window.sessionStorage.tokenSecret = data.token;

                    callback(data, status, headers, config);
                })
                .error(function(data, status, headers, config){
                    callback(data, status, headers, config);
                }
            );
        };

        service.registration = function ( model, callback ){

            $http.post( $rootScope.getHost() + "users/signup", model )
                .success(function (data, status, headers, config) {
                    callback(data, status, headers, config);
                })
                .error(function(data, status, headers, config){
                    callback(data, status, headers, config);
                }
            );
        };

        service.resetPassword = function ( model, callback ){

            $http.post( $rootScope.getHost() + "users/resetpassword", model )
                .success(function (data, status, headers, config) {
                    callback(data, status, headers, config);
                })
                .error(function(data, status, headers, config){
                    callback(data, status, headers, config);
                }
            );
        };

        return service;

    }]);
});