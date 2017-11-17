(function (ng) {
    var mod = ng.module("entretenimientosModule");
    mod.constant("entretenimientosContext", "api/entretenimientos");
    mod.controller('entretenimientoDeleteCtrl', ['$scope', '$http', 'entretenimientosContext', '$state',
        function ($scope, $http, entretenimientosContext, $state) {
            var idEntretenimiento = $state.params.entretenimientoId;
            $scope.deleteEntretenimiento = function () {
                $http.delete(entretenimientosContext + '/' + idEntretenimiento, {}).then(function (response) {
                    $state.go('entretenimientosList', {entretenimientoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);