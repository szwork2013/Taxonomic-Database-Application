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
            list: function (page, size) {
                var self = this;
                $http.get( $rootScope.getHost() + "users/search" + "?page=" +  page + "&size=" +   size)
                    .success(function (data) {
                        self.setData( data );
                        $rootScope.$broadcast("UsersListed");
                    })
                    .error(function (message) {
                        $log.error(message);
                    });
            },
            search: function (filter, page, size) {
                var self = this;
                $http.get( $rootScope.getHost() + "users/search/" + filter + "?page=" +  page + "&size=" +   size)
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
                $http.put( $rootScope.getHost() + "users/" + id, this)
                    .success(function (data) {
                        $log.info('user put completed: ');
                        $rootScope.$broadcast("UserUpdated");
                    })
                    .error(function (message) {
                        $log.error(message);
                    });
            },
            insert: function ( model, callback ) {

                $http.post( $rootScope.getHost() + "users/signup", model )
                    .success(function (data, status, headers, config) {
                        callback(data, status, headers, config);
                    })
                    .error(function(data, status, headers, config){
                        callback(data, status, headers, config);
                    }
                );
            },
            delete: function (id) {
                $http.delete( $rootScope.getHost() + "users/" + id, this)
                    .success(function (data) {
                        $log.info('user deleted completed: ');
                        $rootScope.$broadcast("UserDeleted");
                    })
                    .error(function (message) {
                        $log.error(message);
                    });
            }

        };

        return User;

    }]);
});