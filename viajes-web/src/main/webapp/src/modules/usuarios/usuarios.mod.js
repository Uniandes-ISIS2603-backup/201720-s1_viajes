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
            }).state('usuarioCreate', {
                url: '/usuarios/create',
                views: {
                    'mainView': {
                        controller: 'usuariosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'usuarios.create.html'
                    }
                }

            }).state('usuarioEdit', {
                url: '/usuarios/:usuarioId',
                param: {
                    usuarioId: null
                },
                views: {
                    'mainView': {
                        controller: 'usuariosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'usuarios.create.html'
                    }
                }
            });
        }]);

})(window.angular);