(function (ng) {
    var mod = ng.module("pagoModule");
    mod.constant("pagosContext", "api/pagos");
    mod.controller('pagoNewCtrl', ['$scope', '$http', 'pagosContext', '$state', '$rootScope',
        function ($scope, $http, pagosContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createPago = function () {
                $http.post(pagosContext, {
                    nombre: $scope.pagoName,
                    fecha: $scope.pagoDate,
                    valor: $scope.pagoValor
                }).then(function (response) {
                    //Usuario created successfully
                    $state.go('pagosList', {pagoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
})(window.angular);


