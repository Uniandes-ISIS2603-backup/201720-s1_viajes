(function (ng) {
    var mod = ng.module("pagoModule");
    mod.constant("pagosContext", "api/pagos");
    mod.controller('pagoUpdateCtrl', ['$scope', '$http', 'pagosContext', '$state', '$rootScope',
        function ($scope, $http, pagosContext, $state, $rootScope) {
            $rootScope.edit = true;

            var idPago = $state.params.pagoId;
            //Consulto el usuario a editar.
            $http.get(pagosContext + '/' + idPago).then(function (response) {
                var pago = response.data;
                $scope.pagoName = pago.nombre;
                $scope.pagoDate = pago.fecha;
                $scope.pagoValor = pago.valor;
            });

            //funciones para el drag and drop de HTML5 nativo
            $scope.allowDrop = function (ev) {
                ev.preventDefault();
            };

            $scope.drag = function (ev) {
                ev.dataTransfer.setData("text", ev.target.id);
            };

            $scope.createPago = function () {
                /*Se llama a la función newBooks() para buscar cada uno de los ids de los books
                 en el array que tiene todos los books y así saber como queda la lista final de los books asociados al usuario.
                 */

                $http.put(pagosContext + "/" + idPago, {
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


