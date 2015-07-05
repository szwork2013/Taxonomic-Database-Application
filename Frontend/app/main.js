require.config({
    baseUrl: '/app',

    // alias libraries paths.  Must set 'angular'
    paths: {
        'jquery' : '../resources/vendor/jquery/dist/jquery.min',
        'jquery-ui': '../resources/vendor/jquery-ui/jquery-ui.min',
        'jquery-validation': '../resources/vendor/jquery-validation/dist/additional-methods.min',
        'jquery-magnific-popup':'../resources/vendor/magnific-popup/dist/jquery.magnific-popup.min',
        'angular': '../resources/vendor/angular/angular',
        'angular-route': '../resources/vendor/angular-route/angular-route',
        'angular-ui-router': '../resources/vendor/angular-ui-router/release/angular-ui-router',
        'angular-translate': '../resources/vendor/angular-translate/angular-translate',
        'angularAMD': '../resources/vendor/angularAMD/angularAMD.min',
        'ngload': '../resources/vendor/ng-load/ng-load',
        'angular-resource': '../resources/vendor/angular-resource/angular-resource',
        'bootstrap' : '../resources/vendor/bootstrap/dist/js/bootstrap',
        'underscore': '../resources/vendor/underscore/underscore'
    },

    // Add angular modules that does not support AMD out of the box, put it in a shim
    shim: {
        'jquery': { exports: '$'},
        'jquery-ui': { deps: ['jquery']},
        'jquery-validation': { deps: ['jquery']},
        'jquery-magnific-popup': { deps: ['jquery']},
        'angular-route': [ 'angular' ],
        'angularAMD': [ 'angular' ],
        'ngload': [ 'angularAMD' ],
        'angular-resource': [ 'angular' ],
        'angular-translate': [ 'angular' ],
        'angular-ui-router': [ 'angular' ],
        'bootstrap': { exports: 'bootstrap', deps: ['jquery'] }

    },

    // kick start application
    deps: ['app']
});