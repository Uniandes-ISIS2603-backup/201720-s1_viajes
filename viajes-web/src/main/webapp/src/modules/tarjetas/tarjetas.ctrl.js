(function (ng) {

    var mod = ng.module("tarjetasModule");

    mod.controller("tarjetasCtrl", ['$scope', '$state', '$stateParams', '$http', 'tarjetasContext', function ($scope, $state, $stateParams, $http, tarjetasContext) {

            // inicialmente el listado de tarjetas está vacio
            $scope.records = {};
            // carga las tarjetas
            $http.get(tarjetasContext).then(function (response) {
                $scope.records = response.data;
            });

            // el controlador recibió un tarjetasId ??
            // revisa los parámetros (ver el :tarjetasId en la definición de la ruta)
            if ($stateParams.tarjetasId) {

                // toma el id del parámetro
                var id = $stateParams.tarjetasId;
                // obtiene el dato del recurso REST
                $http.get(tarjetasContext + "/" + id)
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentRecord
                            $scope.currentRecord = response.data;
                        });

                // el controlador no recibió un tarjetasId
            } else {
                // el registro actual debe estar vacio
                $scope.currentRecord = {
                    id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                    numero: 0 /*Tipo Integer*/,
                    fondos: 0 /*Tipo Long*/
                };
            }

            this.saveRecord = function (id) {
                var currentRecord = $scope.currentRecord;

                // si el id es null, es un registro nuevo, entonces lo crea
                if (id == null) {

                    // ejecuta POST en el recurso REST
                    return $http.post(tarjetasContext, currentRecord)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('tarjetasList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    // ejecuta PUT en el recurso REST
                    return $http.put(tarjetasContext + "/" + currentRecord.id, currentRecord)
                            .then(function () {
                                // $http.put es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('tarjetasList');
                            });
                }
                ;
            };

            this.deleteRecord = function (id) {
                $http.delete(tarjetasContext + "/" + id);
                $state.reload('tarjetasList');
            };
        }]);
})(window.angular);