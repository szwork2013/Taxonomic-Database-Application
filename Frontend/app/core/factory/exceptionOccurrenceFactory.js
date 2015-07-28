/**
 * Exception Occurrence Factory Model
 */
define(['app'], function (app) {

    'use strict';

    app.factory('ExceptionOccurrence', ['$http', '$rootScope', '$log', function ($http, $rootScope, $log) {

        /**
         * @constructor
         */
        function ExceptionOccurrence(userData) {
            if (userData) {
                this.setData(userData);
            }
        }

        /**
         *
         * @type {{setData: Function, load: Function, update: Function, getHost: Function}}
         */
        ExceptionOccurrence.prototype = {

            /**
             *
             * @param data
             */
            setData: function (data) {
                angular.extend(this, data);
            },

            list: function (page, size) {
                var self = this;
                $http.get( $rootScope.getHost() + "exception/search?page=" +  page + "&size=" +   size)
                    .success(function (data) {

                        self.setData( data );
                        $rootScope.$broadcast("ExceptionOccurrenceLoaded");
                    })
                    .error(function (message) {
                        $log.error(message);
                    });
            },

            search: function (filter, page, size) {
                var self = this;
                $http.get( $rootScope.getHost() + "exception/search/" + filter + "?page=" +  page + "&size=" +   size)
                    .success(function (data) {

                        self.setData( data );
                        $rootScope.$broadcast("ExceptionOccurrenceSearchLoaded");
                    })
                    .error(function (message) {
                        $log.error(message);
                    });
            }
        };

        return ExceptionOccurrence;

    }]);
});