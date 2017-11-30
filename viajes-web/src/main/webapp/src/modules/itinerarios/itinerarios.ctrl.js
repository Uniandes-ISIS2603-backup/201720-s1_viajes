(function (ng) {
    var mod = ng.module("itinerariosModule");
    
    mod.constant("pagoContext", "api/pagos");
    mod.constant("itinerariosContext", "api/itinerarios");
    mod.controller('itinerariosCtrl', ['$scope', '$http', 'itinerariosContext','pagoContext' , '$state', '$stateParams',
        function ($scope, $http, itinerariosContext, pagoContext , $state, $stateParams) {
            
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
                            $scope.currentGuias = response.data.guias;
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
            
            this.deleteRecordGuia = function (idItinerario, idGuia) {
                $http.delete(itinerariosContext + "/" + idItinerario + "/guias/" + idGuia);
                $state.reload('itinerariosList');

            };
            
            this.deleteRecordEntretenimiento = function (idItinerario, idEntretenimiento) {
                $http.delete(itinerariosContext + "/" + idItinerario + "/entretenimientos/" + idEntretenimiento);
                $state.reload('itinerariosList');

            };
            
            this.deleteRecordHospedaje = function (idItinerario, idHospedaje) {
                $http.delete(itinerariosContext + "/" + idItinerario + "/hospedajes/" + idHospedaje);
                $state.reload('itinerariosList');

            };
            
            this.deleteRecordTransporte = function (idItinerario, idTransporte) {
                $http.delete(itinerariosContext + "/" + idItinerario + "/transportes/" + idTransporte);
                $state.reload('itinerariosList');

            };
            
            
            if($stateParams.itinerarioPago!==0 && $stateParams.itinerarioPago!==undefined){
                $scope.costo = $stateParams.itinerarioPago;
                $scope.dateD = new Date();
                $scope.date = $scope.dateD.getDay()+"/"+$scope.dateD.getMonth()+"/"+"17";
                $scope.nombrePago = "pagos";
                $scope.currentPago={
                    nombre : $scope.nombrePago,
                    valor : $scope.costo 
                }; 
                
            this.createPago=function (currentPago){
                return $http.post(pagoContext, currentPago)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('itinerariosList');
                            });
            };    
            }
            
            
        }
    ]);
})(angular);