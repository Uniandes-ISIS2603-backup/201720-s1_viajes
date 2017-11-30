(function (ng) {
var mod = ng.module("companiaModule", []);
    mod.constant("companiasContext", "api/companias");
    mod.config(['$stateProvider', '$urlRouterProvider', 
        function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/companias/';
             var basePathImagenes = 'src/modules/oficinas/';
             $urlRouterProvider.otherwise("/companiasList");

            $stateProvider.state('companias', {
                url: '/companias',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'companias.html',
                        controller: 'companiasCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('companiasList', {
                url: '',
                parent: 'companias',
                views: {
                    'detailView': {
                        controller: 'companiasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'companias.list.html'
                    }
                }
            }).state('companiasCreate', {
                url: '/companias/create',
                parent: 'companias',
                views: {
                    'detailView': {
                        controller: 'companiasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'companias.create.html'
                    }
                }

            }).state('companiasEdit', {
                url: '/:companiaId/update',
                parent: 'companias',
                param: {
                    companiaId: null
                },
                views: {
                    'detailView': {
                        controller: 'companiasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'companias.create.html'
                    }
                }
            }).state('companiasDetail', {
                url: '/{companiaId:int}',
                parent: 'companias',
                param: {
                    companiaId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePathImagenes + 'oficinas.list.html',
                        controller: 'companiasCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'companias.detail.html',
                        controller: 'companiasCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);

})(window.angular);