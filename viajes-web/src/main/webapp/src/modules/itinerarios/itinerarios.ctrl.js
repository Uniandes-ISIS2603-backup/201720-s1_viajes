(function (ng) {
    var mod = ng.module("itinerariosModule");
    mod.constant("itinerariosContext", "api/itinerarios");
    mod.controller('itinerariosCtrl', ['$scope', '$http', 'itinerariosContext', '$state', '$stateParams',
        function ($scope, $http, itinerariosContext, $state, $stateParams) {
            
            $scope.records = {};
            // carga las ciudades
             $http.get(itinerariosContext).then(function (response) {
             $scope.itinerariosRecords = response.data;
            });
            
             if ($stateParams.itinerarioId !== null && $stateParams.itinerarioId !== undefined) {

                // toma el id del parámetro
                var id = $stateParams.itinerarioId;
                // obtiene el dato del recurso REST
                $http.get(itinerariosContext + "/" + id)
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
                    costoTotal: 0 /*Tipo Double*/,
                    fechaInicial:'' /*Tipo String*/,
                    fechaFinal: '' /*Tipo String*/,
                    numeroVisitantes: 0 /*Tipo Integer*/
                    
                };
                
            }
            
            this.saveRecord = function (id) {
                var currentRecord = $scope.currentRecord;

                // si el id es null, es un registro nuevo, entonces lo crea
                if (id == null) {

                    // ejecuta POST en el recurso REST
                    return $http.post(itinerariosContext, currentRecord)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('itinerariosList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    // ejecuta PUT en el recurso REST
                    return $http.put(itinerariosContext + "/" + currentRecord.id, currentRecord)
                            .then(function () {
                                // $http.put es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('itinerariosList');
                            });
                }
                
            };
            
            this.deleteRecord = function (id) {
                $http.delete(itinerariosContext + "/" + id);
                $state.reload('itinerariosList');

            };
        }
    ]);
})(angular);