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
        'usuarioModule',
        'logModule',
        'companiaModule',
        'guiasModule',
        'tarjetasModule',
        'oficinasModule',
        'ubicacionModule'
    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);