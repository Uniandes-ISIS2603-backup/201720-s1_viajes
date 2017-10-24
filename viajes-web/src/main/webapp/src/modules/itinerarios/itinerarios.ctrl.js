(function (ng) {
    var mod = ng.module("itinerariosModule");
    mod.constant("itinerariosContext", "api/itinerarios");
    mod.controller('itinerariosCtrl', ['$scope', '$http', 'itinerariosContext',
        function ($scope, $http, itinerariosContext) {
            // inicialmente el listado de ciudades está vacio
            $scope.records = {};
            // carga las ciudades
            $http.get(itinerariosContext).then(function (response) {
                $scope.records = response.data;
            });
        }
    ]);
})(angular);

