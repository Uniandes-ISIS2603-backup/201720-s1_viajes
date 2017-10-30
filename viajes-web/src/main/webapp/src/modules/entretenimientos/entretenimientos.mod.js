(function (ng) {
var mod = ng.module("entretenimientosModule", []);
    mod.constant("entretenimientosContext", "api/entretenimientos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/entretenimientos/';
            $urlRouterProvider.otherwise("/entretenimientosList");

            $stateProvider.state('entretenimientosList', {
                url: '/entretenimientos',
                views: {
                    'mainView': {
                        controller: 'entretenimientosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'entretenimientos.list.html'
                    }
                }
            }).state('entretenimientoCreate', {
                url: '/entretenimientos/create',
                views: {
                    'mainView': {
                        controller: 'entretenimientosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'entretenimientos.create.html'
                    }
                }

            }).state('entretenimientoEdit', {
                url: '/entretenimientos/:entretenimientoId',
                param: {
                    entretenimientoId: null
                },
                views: {
                    'mainView': {
                        controller: 'entretenimientosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'entretenimientos.create.html'
                    }
                }
            });
        }]);

})(window.angular);