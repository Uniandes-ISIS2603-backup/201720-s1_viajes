(function (ng) {
    var mod = ng.module("ubicacionModule");
    mod.constant("ubicacionContext", "api/ubicaciones");
    mod.controller('ubicacionNewCtrl', ['$scope', '$http', 'ubicacionContext', '$state', '$rootScope',
        function ($scope, $http, ubicacionContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createUbicacion = function () {
                $http.post(ubicacionContext, {
                    titulo: $scope.ubicacionTitle,
                    comentario: $scope.ubicacionComentario,
                    imagenes: []
                }).then(function (response) {
                    //Author created successfully
                    $state.go('ubicacionList', {ubicacionId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);