(function (ng) {
var mod = ng.module("tarjetasModule", []);
    mod.constant("tarjetasContext", "api/tarjetas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider) {
            var basePath = 'src/modules/tarjetas/';

            $stateProvider.state('tarjetasList', {
                url: '/tarjetas',
                views: {
                    'mainView': {
                        controller: 'tarjetasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'tarjetas.list.html'
                    }
                }
            }).state('tarjetasCreate', {
                url: '/tarjetas/create',
                views: {
                    'mainView': {
                        controller: 'tarjetasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'tarjetas.create.html'
                    }
                }

            }).state('tarjetasEdit', {
                url: '/tarjetas/:tarjetasId',
                param: {
                    tarjetasId: null
                },
                views: {
                    'mainView': {
                        controller: 'tarjetasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'tarjetas.create.html'
                    }
                }
                 }).state('tarjetaDetail', {
                        url: '/{tarjetasId:int}/detail',
                      //  parent:'tarjetas',
                        param: {
                            tarjetasId: null
                        },
                        views: {
                            'mainView': {
                                templateUrl: basePath + 'tarjeta.detail.html',
                                controller: 'tarjetasCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
            });
        }]);

})(window.angular);