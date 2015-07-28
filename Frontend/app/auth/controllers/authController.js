define(['app','auth/factory/authenticationFactory'], function () {

    'use strict';

    return ['$scope','AuthenticationService','$http','$rootScope', '$stateParams','$timeout','toastr','$state',

        function ($scope, AuthenticationService, $http, $rootScope, $stateParams, $timeout, toastr , $state) {

            $scope.user = {};

            /**
             * Listener when the view
             */
            $scope.$on('$viewContentLoaded', function() {
                console.log('auth view Content Loaded...');

                $('#loading').fadeToggle('400');
            });

            /**
             * Register Form method submission
             */
            $scope.registerFormSubmit = function () {

                loadingScreen();

                AuthenticationService.registration( $scope.user , function(response, status) {

                    $('#loading').fadeToggle('400');

                    if(status == 200) {
                        clearModel();
                        toastr.success('User created successfully', 'Success!');
                    }
                    else {
                        toastr.error(response.message, 'Error!');
                    }
                });
            };

            /**
             * Method for user authenticate
             */
            $scope.loginFormSubmit = function(){

                loadingScreen();

                AuthenticationService.authentication( $scope.user , function(response, status) {

                    loadingScreen();

                    if(status == 200) {
                        clearModel();
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