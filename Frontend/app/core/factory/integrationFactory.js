/**
 * Integration Factory Model
 */
define(['app'], function (app) {

    'use strict';

    app.factory('Integration', ['$http', '$rootScope', '$log', function ($http, $rootScope, $log) {

        /**
         * @constructor
         */
        function Integration(userData) {
            if (userData) {
                this.setData(userData);
            }
        }

        /**
         *
         * @type {{setData: Function, load: Function, update: Function, getHost: Function}}
         */
        Integration.prototype = {

            /**
             *
             * @param data
             */
            setData: function (data) {
                angular.extend(this, data);
            },

            list: function () {
                var self = this;
                $http.get( $rootScope.getHost() + "integration/history")
                    .success(function (data) {
                        self.setData( data );
                        $rootScope.$broadcast("IntegrationHistoryLoaded");
                    })
                    .error(function (message) {
                        $log.error(message);
                    });
            },

            /**
             * Data integration process start action
             * @param name
             */
            start: function (name) {
                $http.get( $rootScope.getHost() + "integration/start/" + name)
                    .success(function (data) {
                        $log.log(data);
                        $rootScope.$broadcast("IntegrationStarted");
                    })
                    .error(function (message) {
                        $log.error(message);
                    });
            },

            /**
             * Data integration process stop action
             * @param name
             */
            stop: function (name) {
                $http.get( $rootScope.getHost() + "integration/stop/" + name)
                    .success(function (data) {
                        $log.log(data);
                        $rootScope.$broadcast("IntegrationStopped");
                    })
                    .error(function (message) {
                        $log.error(message);
                    });
            }
        };

        return Integration;

    }]);
});