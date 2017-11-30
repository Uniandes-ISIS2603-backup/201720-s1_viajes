(function (ng) {
var mod = ng.module("transportesModule", []);
    mod.constant("transportesContext", "api/transportes");
    mod.config(['$stateProvider', '$urlRouterProvider', 
        function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/transportes/';
            var basePathImagenes = 'src/modules/imagenes/';
            $urlRouterProvider.otherwise("/transportesList");

             $stateProvider.state('transportes', {
                url: '/transportes',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'transportes.html',
                        controller: 'transportesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('transportesList', {
                url: '',
                parent: 'transportes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'transportes.list.html'
                    }
                }
            }).state('transporteDetail', {
                url: '/{transporteId:int}',
                parent: 'transportes',
                param: {
                    transporteId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePathImagenes + 'imagenes.list.html',
                        controller: 'transportesCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'transportes.detail.html',
                        controller: 'transportesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('transporteCreate', {
                url: '',
                parent: 'transportes',
                views: {
                    'detailView': {
                        controller: 'transportesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'transportes.create.html'
                    }
                }

            }).state('transporteEdit', {
                url: '/{transporteId:int}/update',
                parent: 'transportes',
                param: {
                    transportesId: null
                },
                views: {
                    'detailView': {
                        controller: 'transportesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'transportes.create.html'
                    }
                }
            });
        }]);
})(window.angular);

