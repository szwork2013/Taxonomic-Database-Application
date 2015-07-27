define(['app', 'bootstrap', 'highcharts-ng',
    'core/factory/userFactory',
    'core/factory/integrationFactory',
    'core/factory/exceptionOccurrenceFactory'], function () {

    'use strict';

    return ['$scope','User', 'Integration', 'ExceptionOccurrence', '$stateParams', '$rootScope','$timeout', '$state', '$http',

        function ($scope, User, Integration, ExceptionOccurrence, $stateParams, $rootScope, $timeout, $state, $http) {

            /**
             * Defines the Fauna chat data
             */
            $scope.$on('FaunaSummaryLoaded', function() {
                var unresolved = 0,
                    delegated = 0,
                    resolved = 0,
                    rejected = 0;

                _.each($scope.faunaSumamry, function(obj){
                    switch (obj[1]) {
                        case "UNRESOLVED":
                            unresolved = obj[0];
                            break;
                        case "DELEGATED":
                            delegated = obj[0];
                            break;
                        case "RESOLVED":
                            resolved = obj[0];
                            break;
                        case "REJECTED":
                            rejected = obj[0];
                            break;
                    }
                });
                $scope.faunaChart = {
                    options: {chart: {type: 'bar'}},
                    title: {text: ''},
                    credits: {enabled: false},
                    xAxis: {categories: ['Unresolved', 'Delegated', 'Resolved', 'Rejected']},
                    yAxis: {allowDecimals: false},
                    legend: {enabled: false},
                    series: [{showInLegend: false, data: [unresolved, delegated, rejected, rejected]}],
                    loading: false
                };
            });

            /**
             * Defines the Species Plus chart data
             */
            $scope.$on('IntegrationHistoryLoaded', function() {

                var speciesPlus = null;
                _.each($scope.integration, function(obj){
                    if (obj.integrationSource.source == "SPECIES_PLUS") {
                        speciesPlus = obj;
                    }
                });

                if (speciesPlus != null) {
                    $scope.speciesPlusChart = {
                        options: {chart: {type: 'pie'}},
                        title: {text: ''},
                        credits: {enabled: false},
                        legend: {enabled: true},
                        series: [{
                            showInLegend: true, dataLabels: {enabled: false}, data: [
                                ['Unmatched', (speciesPlus.recordsProcessed - speciesPlus.recordsUpdated)],
                                ['Matched', speciesPlus.recordsUpdated]]
                        }],
                        loading: false
                    };
                }
            });

            var page  = {totalElements : 0, number: 0, size: 100, totalPages: 0};

            $scope.page = page;
            $scope.queryException = $stateParams.queryException || "";
            $scope.queryUser = $stateParams.queryUser || "";

            $scope.user = undefined;
            $scope.integration = undefined;
            $scope.exceptionOccurrence = undefined;

            /**
             * Get the User factory controller
             * @returns {undefined|*}
             */
            $scope.getUserFactory = function() {
                return $scope.user;
            };

            /**
             * Get the Integration factory controller
             * @returns {undefined|*}
             */
            $scope.getIntegrationFactory = function() {
                return $scope.integration;
            };

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

                $http.get( $rootScope.getHost() + "exception/summary/FAUNA")
                    .success(function (data) {
                        $scope.faunaSumamry = data;
                        $rootScope.$broadcast("FaunaSummaryLoaded");
                    })
                    .error(function (message) {
                        $log.error(message);
                });
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

            $scope.$on('UserDeleted', function() {
                $scope.user.list();
            });

            $scope.$on('IntegrationStarted', function() {
                console.log('IntegrationStarted');
                $scope.integration.list();
            });

            $scope.$on('IntegrationStopped', function() {
                console.log('IntegrationStopped');
                $scope.integration.list();
            });
        }];
});
