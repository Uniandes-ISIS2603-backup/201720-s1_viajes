(function (ng) {
    var mod = ng.module("imagenModule", ['ui.router']);
    mod.constant("imagenesContext", "api/imagenes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/imagenes/';
            $urlRouterProvider.otherwise("/imagenesList");

            $stateProvider.state('imagenes', {
                url: '/imagenes',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'imagenes.html',
                        controller: 'imagenCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('imagenesList', {
                url: '',
                parent: 'imagenes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'imagenes.list.html'
                    }
                }
            }).state('imagenDetail', {
                url: '/{imagenId:int}',
                parent: 'imagenes',
                param: {
                    imagenId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'imagenes.detail.html',
                        controller: 'imagenCtrl',
                        controllerAs: 'ctrl'
                    }

                }

            });
        }]);
})(window.angular);
