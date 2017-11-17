(function (ng) {
    var mod = ng.module("entretenimientosModule", ['ui.router']);
    mod.constant("entretenimientosContext", "api/entretenimientos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/entretenimientos/';
            var basePathImagenes = 'src/modules/imagenes/';
            $urlRouterProvider.otherwise("/entretenimientosList");

            $stateProvider.state('entretenimientos', {
                url: '/entretenimientos',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'entretenimientos.html',
                        controller: 'entretenimientoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('entretenimientosList', {
                url: '/list',
                parent: 'entretenimientos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'entretenimientos.list.html'
                    }
                }
            }).state('entretenimientosDetail', {
                url: '/{entretenimientoId:int}',
                parent: 'entretenimientos',
                param: {
                    entretenimientoId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePathImagenes + 'imagenes.list.html',
                        controller: 'entretenimientoCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'entretenimientos.detail.html',
                        controller: 'entretenimientoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('entretenimientoDelete', {
                url: '/delete/{entretenimientoId:int}',
                parent: 'entretenimientos',
                param: {
                    entretenimientoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/entretenimientos.delete.html',
                        controller: 'entretenimientoDeleteCtrl'
                    }
                }
            }).state('entretenimientosCreate', {
                url: '/create',
                parent: 'entretenimientos',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/entretenimientos.new.html',
                        controller: 'entretenimientoNewCtrl'
                    }
                }
            }).state('entretenimientoUpdate', {
                url: '/update/{entretenimientoId:int}',
                parent: 'entretenimientos',
                param: {
                    entretenimientoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/entretenimientos.new.html',
                        controller: 'entretenimientoUpdateCtrl'
                    }
                }
            });
        }]);
})(window.angular);