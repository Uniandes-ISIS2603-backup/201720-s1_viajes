
(function (ng) {
    // Definición del módulo
    var mod = ng.module("itinerariosModule", ['ui.router']);
    mod.constant("itinerariosContext", "api/itinerarios");
    // Configuración de los estados del módulo
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            // En basePath se encuentran los templates y controladores de módulo
            var basePath = 'src/modules/itinerarios/';
            // Mostrar la lista de autores será el estado por defecto del módulo
          
            // Definición del estado 'authorsList' donde se listan los autores
            $stateProvider.state('itinerariosList', {
                // Url que aparecerá en el browser
                url: '/itinerarios/list',
                views: {
                    'mainView': {                      
                        controller: 'itinerariosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'itinerarios.list.html'
                    }
                }
            });
        }]);
})(window.angular);

