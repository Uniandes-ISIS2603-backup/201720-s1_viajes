(function (ng) {
    var mod = ng.module("entretenimientosModule");
    mod.constant("entretenimientosContext", "api/entretenimientos");
    mod.controller('entretenimientoNewCtrl', ['$scope', '$http', 'entretenimientosContext', '$state', '$rootScope',
        function ($scope, $http, entretenimientosContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createEntretenimiento = function () {
                $http.post(entretenimientosContext, {
                    nombre: $scope.entretenimientoNombre,
                    valor: $scope.entretenimientoValor,
                    fechaInicio: $scope.entretenimientoFechaInicio,
                    fechaFinal: $scope.entretenimientoFechaFinal,
                    imagenes: []
                }).then(function (response) {
                    //Author created successfully
                    $state.go('entretenimientosList', {entretenimientoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);