/**
 * User Factory Model
 */
define(['app'], function (app) {

    'use strict';

    app.factory('User', ['$http', '$rootScope', '$log', function ($http, $rootScope, $log) {

        /**
         * @constructor
         */
        function User(userData) {

            if (userData) {
                this.setData(userData);
            }
        }

        /**
         *
         * @type {{setData: Function, load: Function, update: Function, getHost: Function}}
         */
        User.prototype = {

            /**
             *
             * @param data
             */
            setData: function (data) {
                angular.extend(this, data);
            },
            list: function () {

                var self = this;

                $http.get( $rootScope.getHost() + "users")
                    .success(function (data) {

                        self.setData( data );
                        $rootScope.$broadcast("UsersListed");
                    })
                    .error(function (message) {
                        $log.error(message);
                    });
            },
            load: function (id) {

                var self = this;

                $http.get( $rootScope.getHost() + "users/" + id)
                    .success(function (data) {

                        self.setData(data);
                        $rootScope.$broadcast("UserLoaded");
                    })
                    .error(function (message) {
                        $log.error(message);
                    });
            },
            update: function (id) {
                var self = this;

                $http.put( $rootScope.getHost() + "users/" + id, this)
                    .success(function (data) {

                        $log.info('user put completed: ');
                        $rootScope.$broadcast("UserUpdated");
                    })
                    .error(function (message) {
                        $log.error(message);
                    });
            }
        };

        return User;

    }]);
});