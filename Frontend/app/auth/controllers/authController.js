define(['app','auth/factory/authenticationFactory'], function () {

    'use strict';

    return ['$scope','AuthenticationService','$http','$rootScope', '$stateParams','$timeout','toastr','$state','$window',

        function ($scope, AuthenticationService, $http, $rootScope, $stateParams, $timeout, toastr , $state, $window) {

            $scope.user = {};

            /**
             * Listener when the state is changed
             */
            $scope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
                console.log('state Change Success');
            });
            
            /**
             * Listener when the view
             */
            $scope.$on('$viewContentLoaded', function() {
                console.log('auth view Content Loaded...');

                $('#loading').fadeToggle('400');
            });

            /**
             * Method for user authenticate
             */
            $scope.loginFormSubmit = function(){

                loadingScreen();

                AuthenticationService.authentication( $scope.user , function(response, status) {

                    loadingScreen();

                    if(status == 200) {
                        clearModel();

                        $rootScope.username = $window.sessionStorage.user;
                        $rootScope.logged = true;

                        $state.go('home');
                        toastr.success('Login successfully', 'Success!');
                    }
                    else {
                        toastr.error(response.message, 'Error!');
                    }
                });
            };

            /**
             * Reset Password form
             */
            $scope.resetPasswordFormSubmit = function(){
                loadingScreen();
                AuthenticationService.resetPassword( $scope.user , function(response, status) {

                    $('#loading').fadeToggle('400');

                    if(status == 200) {
                        clearModel();
                        toastr.success('Password changed', 'Success!');
                    }
                    else {
                        toastr.error('', 'Error!');
                    }
                });
            };

            /**
             * Reset Password form
             */
            $rootScope.logout = function(){

                loadingScreen();
                AuthenticationService.logout( function(response, status) {

                    $('#loading').fadeToggle('400');

                    if(status == 200) {
                        $state.go('login');
                    }
                    else {
                        toastr.error('', 'Error!');
                    }
                });
            };


            /**
             * Show Loading screen
             */
            function loadingScreen(){

                $timeout(function(){
                    $('#loading').fadeToggle('400');
                }, 2000);
            }
            /**
             * Reset User Model
             */
            function clearModel(){
                $scope.user = {};
            }

        }];
});