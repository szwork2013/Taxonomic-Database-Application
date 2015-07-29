/**
 * Integration Factory Model
 */
define(['app'], function (app) {

    'use strict';

    app.factory('Fauna', ['$http', '$rootScope', '$log', function ($http, $rootScope, $log) {

        /**
         * @constructor
         */
        function Fauna(faunaData) {
            if (faunaData) {
                this.setData(faunaData);
            }
        }

        /**
         *
         * @type {{setData: Function, load: Function, update: Function, getHost: Function}}
         */
        Fauna.prototype = {

            /**
             *
             * @param data
             */
            setData: function (data) {
                angular.extend(this, data);
            },

            list: function () {
                var self = this;
                $http.get( $rootScope.getHost() + "exception/summary/FAUNA")
                    .success(function (data) {
                        self.setData( data );
                        $rootScope.$broadcast("FaunaSummaryLoaded");
                    })
                    .error(function (message) {
                        $log.error(message);
                    });
            }

        };

        return Fauna;

    }]);
});