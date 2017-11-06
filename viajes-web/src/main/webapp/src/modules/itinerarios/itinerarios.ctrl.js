(function (ng) {
    var mod = ng.module("itinerariosModule");
    mod.constant("itinerariosContext", "api/itinerarios");
    mod.controller('itinerariosCtrl', ['$scope', '$http', 'itinerariosContext', '$state',
        function ($scope, $http, itinerariosContext, $state) {
            
            // carga las ciudades
             $http.get(itinerariosContext).then(function (response) {
             $scope.itinerariosRecords = response.data;
            });
        }
    ]);
})(angular);