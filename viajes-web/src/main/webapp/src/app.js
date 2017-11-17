(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        'ui.bootstrap',
        
        // Internal modules dependencies       
        'transportesModule',
        'hospedajesModule',
        'itinerariosModule',
        'transportesModule',
        'entretenimientosModule',
        'blogModule',
        'imagenModule',
        'usuariosModule',
        'logModule',
        'companiaModule',
        'guiasModule',
        'tarjetasModule'
    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);