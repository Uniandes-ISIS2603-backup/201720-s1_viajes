/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
var mod = ng.module("citiesModule", []);
    mod.constant("citiesContext", "api/itinerarios");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/itinerarios/';
            <!--$urlRouterProvider.otherwise("/citiesList");-->

            $stateProvider.state('itinerariosList', {
                url: '/itinerarios',
                views: {
                    'mainView': {
                        controller: 'citiesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'itinerarios.list.html'
                    }
                }
            })
        }]);

})(window.angular);

