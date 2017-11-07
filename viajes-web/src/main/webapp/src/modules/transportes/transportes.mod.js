(function (ng) {
var mod = ng.module("transportesModule", []);
    mod.constant("transportesContext", "api/transportes");
    mod.config(['$stateProvider', '$urlRouterProvider', 
        function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/transportes/';
            $urlRouterProvider.otherwise("/transportesList");

            $stateProvider.state('transportesList', {
                url: '/transportes',
                views: {
                    'mainView': {
                        controller: 'transportesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'transportes.list.html'
                    }
                }
            }).state('transporteCreate', {
                url: '/transportes/create',
                views: {
                    'mainView': {
                        controller: 'transportesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'transportes.create.html'
                    }
                }

            }).state('transporteEdit', {
                url: '/transportes/:transporteId',
                param: {
                    transporteId: null
                },
                views: {
                    'mainView': {
                        controller: 'transportesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'transportes.create.html'
                    }
                }
            });
        }]);

})(window.angular);

