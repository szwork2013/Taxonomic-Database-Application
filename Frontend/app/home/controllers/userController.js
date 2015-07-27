define(['app', 'bootstrap', 'core/factory/userFactory'], function () {

    'use strict';

    return ['$scope','User', '$stateParams', '$rootScope','$timeout', '$state',

        function ($scope, User, $stateParams, $rootScope, $timeout, $state) {

            $scope.user = undefined;

            /**
             * Listener when the view
             */
            $scope.$on('$viewContentLoaded', function() {
                console.log('view Content Loaded...');

                $scope.user = new User();
                if ($stateParams.id != null) {
                    $scope.title = 'Edit User';
                    $scope.user.load($stateParams.id);
                } else {
                    $scope.title = 'Add User';
                }
            });

            /**
             *  Save User form action
             */
            $scope.save = function() {
                if ($stateParams.id != null) {
                    $scope.user.update($stateParams.id);
                } else {
                    $scope.user.enabled = true;
                    $scope.user.insert();
                }
            };

        }];
});
