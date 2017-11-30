(function (ng) {
    var mod = ng.module("ubicacionModule", ['ui.router']);
    mod.constant("ubicacionContext", "api/ubicaciones");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/ubicacion/';
//            var basePathImagenes = 'src/modules/imagenes/';
            $urlRouterProvider.otherwise("/ubicacionList");

            $stateProvider.state('ubicacion', {
                url: '/ubicacion',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'ubicacion.html',
                        controller: 'ubicacionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('ubicacionList', {
                url: '',
                parent: 'ubicacion',
                views: {
                    'listView': {
                        templateUrl: basePath + 'ubicacion.list.html'
                    }
                }
            }).state('ubicacionDetail', {
                url: '/{ubicacionId:int}',
                parent: 'ubicacion',
                param: {
                    ubicacionId: null
                },
                views: {
//                    'listView': {
//                        templateUrl: basePathImagenes + 'imagenes.list.html',
//                        controller: 'blogCtrl',
//                        controllerAs: 'ctrl'
//                    },
                    'detailView': {
                        templateUrl: basePath + 'ubicacion.detail.html',
                        controller: 'ubicacionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('ubicacionDelete', {
                url: '/{ubicacionId:int}/delete',
                parent: 'ubicacion',
                param: {
                    ubicacionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/ubicacion.delete.html',
                        controller: 'ubicacionDeleteCtrl'
                    }
                }
            }).state('ubicacionCreate', {
                url: '',
                parent: 'ubicacion',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/ubicacion.new.html',
                        controller: 'ubicacionNewCtrl'
                    }
                }
            }).state('ubicacionUpdate', {
                url: '/{ubicacionId:int}/update',
                parent: 'ubicacion',
                param: {
                    ubicacionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/ubicacion.new.html',
                        controller: 'ubicacionUpdateCtrl'
                    }
                }
            });
        }]);
})(window.angular);