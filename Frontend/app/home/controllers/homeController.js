define(['app', 'bootstrap', 'highcharts-ng',
    'core/factory/userFactory',
    'core/factory/integrationFactory',
    'core/factory/faunaFactory',
    'core/factory/exceptionOccurrenceFactory'], function () {

    'use strict';

    return ['$scope','User', 'Integration','Fauna', 'ExceptionOccurrence', '$stateParams', '$rootScope','$timeout', '$state', '$http','toastr',

        function ($scope, User, Integration, Fauna, ExceptionOccurrence, $stateParams, $rootScope, $timeout, $state, $http, toastr) {


            $scope.page = {totalElements : 0, number: 0, size: 20, totalPages: 0};
            $scope.pageUser = {totalElements : 0, number: 0, size: 20, totalPages: 0};
            $scope.queryException = $stateParams.queryException || "";
            $scope.queryUser = $stateParams.queryUser || "";

            $scope.user = undefined;
            $scope.integration = undefined;
            $scope.exceptionOccurrence = undefined;
            $scope.faunaSumamry = undefined;

            /**
             * Listener when the view
             */
            $scope.$on('$viewContentLoaded', function() {
                console.log('view Content Loaded...');

                $scope.faunaSumamry = new Fauna();
                $scope.integration = new Integration();

                $scope.integration.list();
            });

            /**
            * Defines the Species Plus chart data
            */
            $scope.$on('IntegrationHistoryLoaded', function() {
                console.log('IntegrationHistoryLoaded');

                $scope.faunaSumamry.list();
            });

            /**
             * Defines the Fauna chat data
             */
            $scope.$on('FaunaSummaryLoaded', function() {
                console.log('FaunaSummaryLoaded');

                $timeout(function() {
                    $('#loading').fadeToggle('400');
                }, 2000);

                plotSpeciesPlus();
                plotFaunaChart();
            });

            $scope.startIntegration = function(name){
                $scope.integration.start(name);
            };

            $scope.stopIntegration = function(name){
                $scope.integration.stop(name);
            };

            $scope.$on('UserDeleted', function() {
                $scope.user.list($scope.pageUser.number, $scope.pageUser.size);
            });

            $scope.$on('IntegrationStarted', function() {
                console.log('IntegrationStarted');

                $scope.integration.list();
            });

            $scope.$on('IntegrationStopped', function() {
                console.log('IntegrationStopped');

                $scope.integration.list();
            });

            $scope.$on('UsersListed', function(){
                console.log('UsersListed');

                $('#loading').fadeToggle('400');
                setUserPage();
            });

            $scope.$on('ExceptionOccurrenceLoaded', function(  ){
                console.log('ExceptionOccurrenceLoaded');

                $('#loading').fadeToggle('400');
                setExceptionOccurrencePage();
            });

            $scope.$on('ExceptionOccurrenceSearchLoaded', function(){
                console.log('ExceptionOccurrenceSearchLoaded');

                $('#loading').fadeToggle('400');
                setExceptionOccurrencePage();
            });

            /**
             * Search Method for Exceptions Occurrence
             *
             */
            $scope.searchException = function(  ){
                $('#loading').fadeToggle('400');

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
                    $scope.user.list($scope.pageUser.number, $scope.pageUser.size);
                } else {
                    $scope.user.search($scope.queryUser, $scope.pageUser.number, $scope.pageUser.size);
                }
            };

            $scope.exceptionOccurrencePage = function(page, size){

                $('#loading').fadeToggle('400');
                $scope.exceptionOccurrence.list(page, size);
            };

            $scope.userLoadPage = function(page, size){

                $('#loading').fadeToggle('400');
                $scope.user.list(page, size);
            };

            /**
             * Register Form method submission
             */
            $scope.registerFormSubmit = function () {

                $scope.user.insert( $scope.user , function(response, status) {

                    console.log($scope.user);

                    if(status == 200) {

                        $('#myModal').modal('hide');

                        toastr.success('User Created successfully', 'Success!');

                        $('#loading').fadeToggle('400');

                        $scope.user.list($scope.pageUser.number, $scope.pageUser.size);

                        clearModel();
                    }
                    else {
                        toastr.error(response.message, 'Error!');
                    }
                });
            };

            function plotSpeciesPlus(){

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
            }

            function plotFaunaChart(){

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
            }

            function setExceptionOccurrencePage(  ){

                $scope.page.number = $scope.exceptionOccurrence.number;
                $scope.page.size = $scope.exceptionOccurrence.size;
                $scope.page.totalPages = $scope.exceptionOccurrence.totalPages;
                $scope.page.totalElements = $scope.exceptionOccurrence.totalElements;
            }

            function setUserPage(  ){

                $scope.pageUser.number = $scope.user.number;
                $scope.pageUser.size = $scope.user.size;
                $scope.pageUser.totalPages = $scope.user.totalPages;
                $scope.pageUser.totalElements = $scope.user.totalElements;
            }

            /**
             * Reset User Model
             */
            function clearModel(){

                $scope.user.username = null;
                $scope.user.password = null;
                $scope.user.firstName = null;
                $scope.user.address = null;
                $scope.user.phoneNumber = null;
                $scope.user.role = null;
                $scope.user.enabled = null;
                $scope.user.email = null;
            }

            $('#tabs').click('tabsselect', function (event, ui) {

                var selectedTab = $("#tabs").tabs('option','active');

                switch (selectedTab){
                    case 1 :{
                        if($scope.exceptionOccurrence == undefined){

                            $('#loading').fadeToggle('400');
                            $scope.exceptionOccurrence = new ExceptionOccurrence();
                            $scope.exceptionOccurrence.list($scope.page.number, $scope.page.size);
                        }
                        break;
                    }
                    case 2 :{
                        if($scope.user == undefined){

                            $('#loading').fadeToggle('400');
                            $scope.user = new User();
                            $scope.user.list($scope.pageUser.number, $scope.pageUser.size);
                        }
                        break;
                    }
                }
            });

        }];
});
