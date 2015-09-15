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
                    $window.sessionStorage.user = data.user.username;
                    $window.sessionStorage.userId = data.user.id;
                    $window.sessionStorage.userRole = data.user.userRole.role;
                    $window.sessionStorage.tokenSecret = data.token;
                    $http.defaults.headers.common['X-AUTH-TOKEN'] = data.token;

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

        service.logout = function( callback ){

            $window.sessionStorage.user = null;
            $window.sessionStorage.userId = null;
            $window.sessionStorage.userRole = null;
            $window.sessionStorage.tokenSecret = null;
            $http.defaults.headers.common['X-AUTH-TOKEN'] = null;

            $rootScope.username = null;
            $rootScope.logged = false;

            callback({}, 200);

            //$http.get( $rootScope.getHost() + "logout" )
            //    .success(function (data, status, headers, config) {
            //        console.log(data);
            //        $window.sessionStorage.user = null;
            //        $window.sessionStorage.userId = null;
            //        $window.sessionStorage.tokenSecret = null;
            //
            //        $rootScope.username = null;
            //        $rootScope.logged = false;
            //
            //        callback(data, status, headers, config);
            //    })
            //    .error(function(data, status, headers, config){
            //        callback(data, status, headers, config);
            //    }
            // );
        };

        service.isAuthenticated = function(){
            $http.get( $rootScope.getHost() + "users/isauthenticated" )
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