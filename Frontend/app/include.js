define(
    [
        'angularAMD','angular','underscore',
        'angular-ui-router','angular-toastr',
        'angular-resource','angular-sanitize',
        'angular-toastr-tpl', 'highcharts-ng',
        'core/directives/core.include.template.directive',
        'core/directives/core.jquery.tab.directive',
        'core/directives/core.image.popup.directive',
        'core/filters/core.pagination.filter'
    ],
    function (angularAMD) {
        'use strict';

        return angularAMD;
    }
);
