(function (ng) {
var mod = ng.module("guiasModule", []);
    mod.constant("guiasContext", "api/guias");
    mod.config(['$stateProvider', '$urlRouterProvider', 
        function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/guias/';
//            $urlRouterProvider.otherwise("/companiasList");

            $stateProvider.state('guiasList', {
                url: '/guias',
                views: {
                    'mainView': {
                        controller: 'guiasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'guias.list.html'
                    }
                }
            }).state('guiasCreate', {
                url: '/guias/create',
                views: {
                    'mainView': {
                        controller: 'guiasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'guias.create.html'
                    }
                }

            }).state('guiasEdit', {
                url: '/guias/:guiaId',
                param: {
                    guiaId: null
                },
                views: {
                    'mainView': {
                        controller: 'guiasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'guias.create.html'
                    }
                }
            }).state('guiasDetail', {
                url: '/guias/:guiaId/detail',
                param: {
                    guiaId: null
                },
                views: {
                    'mainView': {
                        controller: 'guiasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'guias.detail.html'
                    }
                }
            });
        }]);

})(window.angular);



