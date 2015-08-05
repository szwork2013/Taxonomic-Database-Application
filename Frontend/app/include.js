define(
    [
        'angularAMD','angular','underscore',
        'angular-ui-router','angular-toastr',
        'angular-resource','angular-sanitize',
        'angular-toastr-tpl', 'highcharts-ng',
        'core/directives/core.include.template.directive',
        'core/directives/core.load.screen.directive',
        'core/directives/core.jquery.tab.directive',
        'core/directives/core.image.popup.directive',
        'core/directives/core.select.wrap.directive',
        'core/directives/core.dialog.confirm.directive',
        'core/filters/core.pagination.filter',
        'auth/directives/auth.username.directive'
    ],
    function (angularAMD) {
        'use strict';

        return angularAMD;
    }
);
