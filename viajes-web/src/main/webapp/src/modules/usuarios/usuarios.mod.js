(function (ng){
    var mod = ng.module("usuarioModule", ['ui.router']);
    mod.constant("usuariosContext", "api/usuarios");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/usuarios/';
            var basePathItinerarios = 'src/modules/itinerarios/';
            var basePathTarjetas = 'src/modules/tarjetas/';
            $urlRouterProvider.otherwise("/usuariosList");

            $stateProvider.state('usuarios', {
                url: '/usuarios',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'usuarios.html',
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('usuariosList', {
                url: '',
                parent: 'usuarios',
                views: {
                    'listView': {
                        templateUrl: basePath + 'usuarios.list.html'
                    }
                }
            }).state('usuarioDetail', {
                url: '/{usuarioId:int}',
                parent: 'usuarios',
                param: {
                    usuarioId: null
                },
                views: {
                    'listViewI': {
                        templateUrl: basePathItinerarios + 'itinerarios.list.html',
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl'
                    },
                    'listViewT': {
                        templateUrl: basePathTarjetas + 'tarjetas.list.html',
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'usuarios.detail.html',
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('usuarioDelete', {
                url: '/{usuarioId:int}',
                parent: 'usuarios',
                param: {
                    usuarioId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/usuario.delete.html',
                        controller: 'usuarioDeleteCtrl'
                    }
                }
            }).state('usuariosCreate', {
                url: '',
                parent: 'usuarios',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/usuarios.new.html',
                        controller: 'usuarioNewCtrl'
                    }
                }
            }).state('usuarioUpdate', {
                url: '/{usuarioId:int}',
                parent: 'usuarios',
                param: {
                    usuarioId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/usuarios.new.html',
                        controller: 'usuarioUpdateCtrl'
                    }
                }
            });
        }]);
})(window.angular);


