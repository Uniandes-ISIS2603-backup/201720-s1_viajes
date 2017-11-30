(function (ng) {
    var mod = ng.module("ubicacionModule");
    mod.constant("ubicacionContext", "api/ubicaciones");
    mod.controller('ubicacionCtrl', ['$scope', '$http', 'ubicacionContext', '$state',
        function ($scope, $http, ubicacionContext, $state) {
            $http.get(ubicacionContext).then(function (response) {
                $scope.ubicacionesRecords = response.data;
            });

            if (($state.params.ubicacionId !== undefined) && ($state.params.ubicacionId !== null)) {
                $http.get(ubicacionContext + '/' + $state.params.ubicacionId).then(function (response) {                    
                    $scope.ubicacion = response.data;
                });
            }
        }
    ]);
}
)(window.angular);