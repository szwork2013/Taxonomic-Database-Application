define(['angularAMD', 'jquery-magnific-popup'], function (angularAMD) {

    'use strict';

    angularAMD.directive('imagePopup', function ( ) {

        return {
            restrict: 'A',
            link: function (scope, element, attrs) {
                $(element).magnificPopup({
                    type: 'image'
                });
            }
        };
    });
});