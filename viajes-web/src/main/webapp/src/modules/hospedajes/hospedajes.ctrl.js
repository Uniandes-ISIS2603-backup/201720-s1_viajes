(function (ng) {
    
    var mod = ng.module("hospedajesModule");
    
  mod.constant("hospedajesContext", "api/hospedajes");
    
    mod.controller('hospedajesCtrl', ['$scope', '$state', '$http', 'hospedajesContext', function ($scope, $state, $http, hospedajesContext ) {
            // inicialmente el listado de ciudades está vacio
            $scope.hospedajesRecords = {};
            // carga las ciudades
            $http.get(hospedajesContext).then(function (response) {
                $scope.hospedajesRecords = response.data;
            });
            

            // el controlador recibió un entretenimientoId ??
            // revisa los parámetros (ver el :entretenimientoId en la definición de la ruta)
//            console.log($state.params.);
            if ($state.params.hospedajesId !== null && $state.params.hospedajesId !== undefined) {
                // toma el id del parámetro
                id = $state.params.hospedajesId;
                // obtiene el dato del recurso REST
                $http.get(hospedajesContext + "/" + id)
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentRecord
                            $scope.currentRecord = response.data;
                        });

                // el controlador no recibió un entretenimientoId
            } else {
                // el registro actual debe estar vacio
                $scope.currentRecord = {
                    id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                    nombre: '' /*Tipo String*/,
                    valor: 0 /*Tipo Double*/,
                    fechaInicio: '' /*Tipo String*/,
                    fechaFin: '' /*Tipo String*/,
                    calificacion: 0 /*Tipo Double*/
                };

            }


            this.saveRecord = function (id) {
                var currentRecord = $scope.currentRecord;

                // si el id es null, es un registro nuevo, entonces lo crea
                if (id == null) {

                    // ejecuta POST en el recurso REST
                    return $http.post(hospedajesContext, currentRecord)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('hospedajesList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    // ejecuta PUT en el recurso REST
                    return $http.put(hospedajesContext + "/" + currentRecord.id, currentRecord)
                            .then(function () {
                                // $http.put es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('hospedajesList');
                            });
                }
                ;
            };

            this.deleteRecord = function (id) {
                $http.delete(hospedajesContext + "/" + id);
                $state.reload('hospedajesList');

            };
        }
    ]);
}
)(angular);