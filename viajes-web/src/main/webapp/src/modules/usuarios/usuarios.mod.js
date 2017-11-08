(function (ng) {
var mod = ng.module("usuariosModule", []);
    mod.constant("usuariosContext", "api/usuarios");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/usuarios/';

            $stateProvider.state('usuariosList', {
                url: '/usuarios',
                views: {
                    'mainView': {
                        controller: 'usuariosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'usuarios.list.html'
                    }
                }
            }).state('usuariosCreate', {
                url: '/usuarios/create',
                views: {
                    'mainView': {
                        controller: 'usuariosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'usuarios.create.html'
                    }
                }

            }).state('usuariosEdit', {
                url: '/usuarios/:usuariosId',
                param: {
                    usuariosId: null
                },
                views: {
                    'mainView': {
                        controller: 'usuariosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'usuarios.create.html'
                    }
                }
                 }).state('usuarioDetail', {
                url: '/{usuariosId:int}/detail',
                param: {
                    usuariosId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'usuario.detail.html',
                        controller: 'usuariosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);

})(window.angular);