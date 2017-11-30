(function (ng) {
var mod = ng.module("oficinasModule", []);
    mod.constant("oficinasContext", "api/oficinas");
    mod.config(['$stateProvider', '$urlRouterProvider', 
        function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/oficinas/';
            $urlRouterProvider.otherwise("/oficinasList");

            $stateProvider.state('oficinasList', {
                url: '/oficinas',
                views: {
                    'mainView': {
                        controller: 'oficinasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'oficinas.list.html'
                    }
                }
            }).state('oficinasCreate', {
                url: '/oficinas/create',
                views: {
                    'mainView': {
                        controller: 'oficinasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'oficinas.create.html'
                    }
                }

            }).state('oficinasEdit', {
                url: '/oficinas/:oficinaId',
                param: {
                    oficinaId: null
                },
                views: {
                    'mainView': {
                        controller: 'oficinasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'oficinas.create.html'
                    }
                }
            }).state('oficinasDetail', {
                url: '/oficinas/{oficinaId:int}/detail',
                
                param: {
                    oficinaId: null
                },
                views: {
                    'mainView': {
                        controller: 'oficinasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'oficinas.detail.html'
                    }
                }
            });
        }]);
})(window.angular);


