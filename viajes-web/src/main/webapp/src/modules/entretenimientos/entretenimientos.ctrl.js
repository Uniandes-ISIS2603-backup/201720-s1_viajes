(function (ng) {
    var mod = ng.module("entretenimientosModule");
    mod.constant("entretenimientosContext", "api/entretenimientos");
    mod.controller('entretenimientoCtrl', ['$scope', '$http', 'entretenimientosContext', '$state',
        function ($scope, $http, entretenimientosContext, $state) {
            $http.get(entretenimientosContext).then(function (response) {
                $scope.records = response.data;
            });

            if (($state.params.entretenimientoId !== undefined) && ($state.params.entretenimientoId !== null)) {
                $http.get(entretenimientosContext + '/' + $state.params.entretenimientoId).then(function (response) {                    
                    $scope.currentRecord = response.data;
                    $http.get(entretenimientosContext + '/' + $state.params.entretenimientoId+ '/imagenes').then(function (response) {
                    $scope.imagenesRecords = response.data;});
                
                });
            }
        }
    ]);
}
)(window.angular);