(
        function (ng) {
            var mod = ng.module("entretenimientosModule");
            mod.constant("entretenimientosContext", "api/entretenimientos");
            mod.controller('entretenimientoUpdateCtrl', ['$scope', '$http', 'entretenimientosContext', '$state',  '$rootScope', '$filter',
                function ($scope, $http, entretenimientosContext, $state, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idE = $state.params.entretenimientoId;
                    //Consulto el autor a editar.
                    $http.get(entretenimientosContext + '/' + idE).then(function (response) {
                        var entretenimiento = response.data;
                        $scope.entretenimientoNombre = entretenimiento.nombre;
                        $scope.entretenimientoValor = entretenimiento.valor;
                        $scope.entretenimientoFechaInicio = entretenimiento.fechaInicio;
                        $scope.entretenimientoFechaFinal = entretenimiento.fechaFinal;
                    });

                    //funciones para el drag and drop de HTML5 nativo
                    $scope.allowDrop = function (ev) {
                        ev.preventDefault();
                    };

                    $scope.drag = function (ev) {
                        ev.dataTransfer.setData("text", ev.target.id);
                    };

                    $scope.createEntretenimiento = function () {
                        /*Se llama a la función newBooks() para buscar cada uno de los ids de los books
                         en el array que tiene todos los books y así saber como queda la lista final de los books asociados al autor.
                         */
                        
                        $http.put(entretenimientosContext + "/" + idE, {
                            nombre: $scope.entretenimientoNombre,
                            valor: $scope.entretenimientoValor,
                            fechaInicio: $scope.entretenimientoFechaInicio,
                            fechaFinal: $scope.entretenimientoFechaFinal
                        }).then(function (response) {
                            //Author created successfully
                            $state.go('entretenimientosList', {entretenimientoId: response.data.id}, {reload: true});
                        });
                    };

                }
            ]);
        }
)(window.angular);