(function (ng) {
var mod = ng.module("hospedajesModule", ['ui.router']);
    mod.constant("hospedajesContext", "api/hospedajes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/hospedajes/';
            $stateProvider.state('hospedajesList',{
                url: '/hospedajes/list',
                views: {
                    'mainView': {
                        controller: 'hospedajesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'hospedajes.list.html'
                    }
                }
            });
        }]);

})(window.angular);