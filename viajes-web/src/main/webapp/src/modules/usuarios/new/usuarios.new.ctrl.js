(function (ng) {
    var mod = ng.module("usuarioModule");
    mod.constant("usuariosContext", "api/usuarios");
    mod.controller('usuarioNewCtrl', ['$scope', '$http', 'usuariosContext', '$state', '$rootScope',
        function ($scope, $http, usuariosContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createUsuario = function () {
                $http.post(usuariosContext, {
                    nombre: $scope.usuarioName,
                    tarjetasCredito: [],
                    itinerarios: []
                }).then(function (response) {
                    //Usuario created successfully
                    $state.go('usuariosList', {usuarioId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
})(window.angular);


