(function (ng) {
    var mod = ng.module("ubicacionModule");
    mod.constant("ubicacionContext", "api/ubicaciones");
    mod.controller('ubicacionDeleteCtrl', ['$scope', '$http', 'ubicacionContext', '$state',
        function ($scope, $http, ubicacionContext, $state) {
            var idUbicacion = $state.params.ubicacionId;
            $scope.deleteUbicacion = function () {
                $http.delete(ubicacionContext + '/' + idUbicacion, {}).then(function (response) {
                    $state.go('ubicacionList', {ubicacionId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
