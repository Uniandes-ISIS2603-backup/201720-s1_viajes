
(function (ng) {
    // Definición del módulo
    var mod = ng.module("itinerariosModule", ['ui.router']);

    // Configuración de los estados del módulo
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            // En basePath se encuentran los templates y controladores de módulo
            var basePath = 'src/modules/itinerarios/';
            // Mostrar la lista de autores será el estado por defecto del módulo
            $urlRouterProvider.otherwise("/itinerariosList");
            // Definición del estado 'authorsList' donde se listan los autores
            $stateProvider.state('itinerarios', {
                // Url que aparecerá en el browser
                url: '/itinerarios',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'itinerarios.html',
                        controller: 'itinerariosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);

