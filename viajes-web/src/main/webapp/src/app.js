/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        'usuariosModule',
        'logModule',
        'companiasModule',
        'guiasModule'


    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);

