(function (ng) {
    // Definición del módulo
    var mod = ng.module("itinerariosModule", ['ui.router']);
    mod.constant("pagoContext", "api/pagos");
    mod.constant("itinerariosContext", "api/itinerarios");
    // Configuración de los estados del módulo
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider) {
            // En basePath se encuentran los templates y controladores de módulo
            var basePath = 'src/modules/itinerarios/';
            // Mostrar la lista de autores será el estado por defecto del módulo
          
            // Definición del estado 'authorsList' donde se listan los autores
            $stateProvider.state('itinerariosList', {
                // Url que aparecerá en el browser
                url: '/itinerarios',
                views: {
                    'mainView': {                      
                        controller: 'itinerariosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'itinerarios.list.html'
                    }
                }
            }).state('itinerariosCreate', {
                url: '/itinerarios/create',
                views: {
                    'mainView': {
                        controller: 'itinerariosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'itinerarios.create.html'
                    }
                }

            }).state('itinerariosEdit', {
                url: '/itinerarios/:itinerarioId',
                param: {
                    itinerarioId: null
                },
                views: {
                    'mainView': {
                        controller: 'itinerariosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'itinerarios.create.html'
                    }
                }
            }).state('itinerariosDetail', {
                url: '/itinerarios/detail/:itinerarioId',
                param: {
                    itinerarioId: null
                },
                views: {
                    'mainView': {
                        controller: 'itinerariosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'itinerarios.detail.html'
                    }
                }
            }).state('itinerariosPago', {
                url: '/itinerarios/Pago/:itinerarioPago',
                param: {
                    itinerarioPago: null
                },
                views: {
                    'mainView': {
                        controller: 'itinerariosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'itinerarios.pago.html'
                    }
                }
            });
        }]);
})(window.angular);

