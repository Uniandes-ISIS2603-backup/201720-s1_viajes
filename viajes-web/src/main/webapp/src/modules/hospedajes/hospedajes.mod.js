(function (ng) {
var mod = ng.module("hospedajesModule", []);
    mod.constant("hospedajesContext", "api/hospedajes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/hospedajes/';
            
            $stateProvider.state('hospedajesList',{
                url: '/hospedajes',
                views: {
                    'mainView': {
                        controller: 'hospedajesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'hospedajes.list.html'
                    }
                }
            }).state('hospedajesCreate', {
                url: '/hospedajes/create',
                views: {
                    'mainView': {
                        controller: 'hospedajesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'hospedajes.create.html'
                    }
                }

            }).state('hospedajesEdit', {
                url: '/hospedajes/:hospedajesId',
                param: {
                    hospedajesId: null
                },
                views: {
                    'mainView': {
                        controller: 'hospedajesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'hospedajes.create.html'
                    }
                }
            }).state('hospedajeDetail', {
                url: '/{hospedajesId:int}/detail',
//                parent: 'hospedajes',
                param: {
                    hospedajesId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'hospedajes.list.html',
                        controller: 'hospedajesCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'hospedaje.detail.html',
                        controller: 'hospedajesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);

})(window.angular);