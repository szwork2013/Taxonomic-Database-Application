define(['app', 'bootstrap',
    'core/factory/userFactory',
    'core/factory/integrationFactory',
    'core/factory/exceptionOccurrenceFactory'], function () {

    'use strict';

    return ['$scope','User', 'Integration', 'ExceptionOccurrence', '$stateParams', '$rootScope','$timeout', '$state',

        function ($scope, User, Integration, ExceptionOccurrence, $stateParams, $rootScope, $timeout, $state) {

            var page  = {totalElements : 0, number: 0, size: 100, totalPages: 0};

            $scope.page = page;
            $scope.queryException = $stateParams.queryException || "";
            $scope.queryUser = $stateParams.queryUser || "";

            $scope.user = undefined;
            $scope.integration = undefined;
            $scope.exceptionOccurrence = undefined;

            /**
             * Listener when the view
             */
            $scope.$on('$viewContentLoaded', function() {
                console.log('view Content Loaded...');

                $scope.user = new User();
                $scope.user.list($scope.page.number, $scope.page.size);

                $scope.integration = new Integration();
                $scope.integration.list();

                $scope.exceptionOccurrence = new ExceptionOccurrence();
                $scope.exceptionOccurrence.list($scope.page.number, $scope.page.size);

            });

            /**
             * Search Method for Exceptions Occurrence
             *
             */
            $scope.searchException = function(  ){
                if ($scope.queryException == "") {
                    $scope.exceptionOccurrence.list($scope.page.number, $scope.page.size);
                } else {
                    $scope.exceptionOccurrence.search($scope.queryException, $scope.page.number, $scope.page.size);
                }
            };

            /**
             * Search Method for Exceptions Occurrence
             *
             */
            $scope.searchUser = function(  ){
                if ($scope.queryUser == "") {
                    $scope.user.list($scope.page.number, $scope.page.size);
                } else {
                    $scope.user.search($scope.queryUser, $scope.page.number, $scope.page.size);
                }
            };

            /**
             *  Edit User action
             */
            $scope.editUser = function(id) {
                $state.go('user', { id : id });
            };

        }];
});
