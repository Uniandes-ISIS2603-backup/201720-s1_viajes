(function (ng) {

    var mod = ng.module("transportesModule");
    mod.constant("transportesContext", "api/transportes");
    mod.controller("transportesCtrl", ['$scope','$http', 'transportesContext','$state',
        function ($scope, $http, transportesContext, $state) {

            // inicialmente el listado de transportes está vacio
            //$scope.records = {};
            // carga los transportes
            $http.get(transportesContext).then(function (response) {
                $scope.transportesRecords = response.data;
            });
        }]);
})(window.angular);