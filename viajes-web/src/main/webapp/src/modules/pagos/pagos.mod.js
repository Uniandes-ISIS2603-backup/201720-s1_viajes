(function (ng){
    var mod = ng.module("pagoModule", ['ui.router']);
    mod.constant("pagosContext", "api/pagos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/pagos/';
            $urlRouterProvider.otherwise("/pagosList");

            $stateProvider.state('pagos', {
                url: '/pagos',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'pagos.html',
                        controller: 'pagoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('pagosList', {
                url: '',
                parent: 'pagos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'pagos.list.html'
                    }
                }
            }).state('pagoDetail', {
                url: '/{pagoId:int}',
                parent: 'pagos',
                param: {
                    pagoId: null
                },
                views: {                    
                    'detailView': {
                        templateUrl: basePath + 'pagos.detail.html',
                        controller: 'pagoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('pagoDelete', {
                url: '/{pagoId:int}/delete',
                parent: 'pagos',
                param: {
                    pagoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/pago.delete.html',
                        controller: 'pagoDeleteCtrl'
                    }
                }
            }).state('pagosCreate', {
                url: '',
                parent: 'pagos',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/pagos.new.html',
                        controller: 'pagoNewCtrl'
                    }
                }
            }).state('pagoUpdate', {
                url: '/{pagoId:int}/update',
                parent: 'pagos',
                param: {
                    pagoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/pagos.new.html',
                        controller: 'pagoUpdateCtrl'
                    }
                }
            });
        }]);
})(window.angular);


