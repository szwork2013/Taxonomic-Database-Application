/**
 * Directive to show the username info box
 * @author josecarlos.it@gmail.com
 */
define(['angularAMD', 'popover'], function (angularAMD) {

    'use strict';

    angularAMD.directive('usernameBox', function ($timeout, $compile, $rootScope, $state, $http) {

        return {
            restrict: 'A',
            transclude: true,
            templateUrl: 'app/auth/views/username.box.tpl.html',
            scope:{
                placement: '=',
                logged: '=',
                name: '='
            },
            controller: function( $scope){
                this.logged = false;

                $scope.logoutFunc = function(){
                    $rootScope.logout();
                    $scope.closePopover();
                };

                $scope.closePopover = function(){
                    $('.fa-caret-down').webuiPopover('hide');
                }
            },
            link: function (scope, element, attrs) {

                var box = $('#box_template').html();

                scope.$watch(attrs.logged, function(newValue, oldValue) {
                    if(newValue != oldValue){

                            $('.fa-caret-down').webuiPopover(
                                {
                                    content: $compile(box)(scope),
                                    placement:scope.placement,
                                    html: true
                                }
                            );
                    }

                });
            }
        };
    });
});