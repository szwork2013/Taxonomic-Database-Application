define(['app', 'bootstrap',
    'core/factory/userFactory',
    'core/factory/integrationFactory',
    'core/factory/exceptionOccurrenceFactory'], function () {

    'use strict';

    return ['$scope','User', 'Integration', 'ExceptionOccurrence', '$stateParams', '$rootScope','$timeout',

        function ($scope, User, Integration, ExceptionOccurrence, $stateParams, $rootScope, $timeout) {

            var page  = {totalElements : 0, number: 0, size: 100, totalPages: 0};

            $scope.page = page;
            $scope.query = $stateParams.query || "";

            $scope.user = undefined;
            $scope.integration = undefined;
            $scope.exceptionOccurrence = undefined;

            /**
             * Listener when the view
             */
            $scope.$on('$viewContentLoaded', function() {
                console.log('view Content Loaded...');

                $scope.user = new User();
                $scope.user.list();

                $scope.integration = new Integration();
                $scope.integration.list();

                $scope.exceptionOccurrence = new ExceptionOccurrence();
                $scope.exceptionOccurrence.list($scope.page.number, $scope.page.size);

            });

            /**
             * Search Method
             *
             */
            $scope.search = function(  ){
                if ($scope.query == "") {
                    $scope.exceptionOccurrence.list($scope.page.number, $scope.page.size);
                } else {
                    $scope.exceptionOccurrence.search($scope.query, $scope.page.number, $scope.page.size);
                }
            };


        }];
});
