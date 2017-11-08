(function (ng) {
var mod = ng.module("companiasModule", []);
    mod.constant("companiasContext", "api/companias");
    mod.config(['$stateProvider', '$urlRouterProvider', 
        function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/companias/';
//            $urlRouterProvider.otherwise("/companiasList");

            $stateProvider.state('companiasList', {
                url: '/companias',
                views: {
                    'mainView': {
                        controller: 'companiasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'companias.list.html'
                    }
                }
            }).state('companiasCreate', {
                url: '/companias/create',
                views: {
                    'mainView': {
                        controller: 'companiasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'companias.create.html'
                    }
                }

            }).state('companiasEdit', {
                url: '/companias/:companiaId',
                param: {
                    companiaId: null
                },
                views: {
                    'mainView': {
                        controller: 'companiasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'companias.create.html'
                    }
                }
            });
        }]);

})(window.angular);

