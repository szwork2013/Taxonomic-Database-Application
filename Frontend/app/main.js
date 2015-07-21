require.config({
    baseUrl: '/app',

    // alias libraries paths.  Must set 'angular'
    paths: {
        'jquery' : '../resources/vendor/jquery/dist/jquery.min',
        'jquery-ui': '../resources/vendor/jquery-ui/jquery-ui.min',
        'jquery-validation': '../resources/vendor/jquery-validation/dist/additional-methods.min',
        'jquery-magnific-popup':'../resources/vendor/magnific-popup/dist/jquery.magnific-popup.min',
        'angular': '../resources/vendor/angular/angular.min',
        'angular-route': '../resources/vendor/angular-route/angular-route.min',
        'angular-ui-router': '../resources/vendor/angular-ui-router/release/angular-ui-router.min',
        'angular-translate': '../resources/vendor/angular-translate/angular-translate.min',
        'angular-sanitize': '../resources/vendor/angular-sanitize/angular-sanitize.min',
        'angular-toastr': '../resources/vendor/angular-toastr/dist/angular-toastr.min',
        'angular-toastr-tpl': '../resources/vendor/angular-toastr/dist/angular-toastr.tpls.min',
        'angularAMD': '../resources/vendor/angularAMD/angularAMD.min',
        'ngload': '../resources/vendor/ng-load/ng-load',
        'angular-resource': '../resources/vendor/angular-resource/angular-resource.min',
        'bootstrap' : '../resources/vendor/bootstrap/dist/js/bootstrap.min',
        'underscore': '../resources/vendor/underscore/underscore'
    },

    // Add angular modules that does not support AMD out of the box, put it in a shim
    shim: {
        'jquery': { exports: '$'},
        'jquery-ui': { deps: ['jquery']},
        'jquery-validation': { deps: ['jquery']},
        'jquery-magnific-popup': { deps: ['jquery']},
        'angular':{ exports: 'angular'},
        'angular-route': { exports: 'angular-route', deps: ['angular']},
        'angularAMD': { exports: 'angularAMD', deps: ['angular']},
        'ngload':{ exports: 'ngload', deps: ['angularAMD']},
        'angular-resource': { exports: 'angular-resource', deps: ['angular']},
        'angular-translate': { exports: 'angular-translate', deps: ['angular']},
        'angular-ui-router':{ exports: 'angular-ui-router', deps: ['angular']},
        'angular-sanitize':{ exports: 'angular-sanitize', deps: ['angular']},
        'angular-toastr':{ exports: 'angular-toastr', deps: ['angular']},
        'angular-toastr-tpl':{ exports: 'angular-toastr-tpl', deps: ['angular-toastr']},
        'bootstrap': { exports: 'bootstrap', deps: ['jquery'] }
    },

    // kick start application
    deps: ['app']
});