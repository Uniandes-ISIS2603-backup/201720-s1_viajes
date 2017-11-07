(function (ng) {
var mod = ng.module("transportesModule", ['ui.router']);
    mod.constant("transportesContext", "api/transportes");
    mod.config(['$stateProvider', '$urlRouterProvider', 
        function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/transportes/';
            //$urlRouterProvider.otherwise("/transportesList");

            $stateProvider.state('transportesList', {
                url: '/transportes',
                views: {
                    'mainView': {
                        controller: 'transportesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'transportes.list.html'
                    }
                }
            });
        }]);

})(window.angular);


