(function (ng) {
var mod = ng.module("hospedajesModule", []);
    mod.constant("hospedajesContext", "api/hospedajes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/hospedajes/';
            var basePathImagenes = 'src/modules/imagenes/';
            $urlRouterProvider.otherwise("/hospedajesList");
            
            $stateProvider.state('hospedajes', {
                url: '/hospedajes',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'hospedajes.html',
                        controller: 'hospedajesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('hospedajesList', {
                url: '',
                parent: 'hospedajes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'hospedajes.list.html'
                    }
                }
            }).state('hospedajeDetail', {
                url: '/{hospedajesId:int}',
                parent: 'hospedajes',
                param: {
                    hospedajeId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePathImagenes + 'imagenes.list.html',
                        controller: 'hospedajesCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'hospedaje.detail.html',
                        controller: 'hospedajesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('hospedajesCreate', {
                url: '',
                parent: 'hospedajes',
                views: {
                    'detailView': {
                        controller: 'hospedajesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'hospedajes.create.html'
                    }
                }

            }).state('hospedajesEdit', {
                url: '/{hospedajesId:int}',
                parent: 'hospedajes',
                param: {
                    hospedajesId: null
                },
                views: {
                    'detailView': {
                        controller: 'hospedajesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'hospedajes.create.html'
                    }
                }
            });
        }]);

})(window.angular);