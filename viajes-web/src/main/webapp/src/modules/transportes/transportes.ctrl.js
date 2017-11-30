(function (ng) {

    var mod = ng.module("transportesModule");
    mod.constant("transportesContext", "api/transportes");
    mod.controller("transportesCtrl", ['$scope', '$state', '$stateParams', '$http', 'transportesContext',
        function ($scope, $state, $stateParams, $http, context) {

            // inicialmente el listado de transportes está vacio
            $scope.records = {};
            // carga los transportes
            $http.get(context).then(function (response) {
                $scope.records = response.data;
            });

            if ($stateParams.transporteId !== null && $stateParams.transporteId !== undefined) {

                // toma el id del parámetro
                var id = $stateParams.transporteId;
                // obtiene el dato del recurso REST
                $http.get(context + "/" + id)
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentRecord
                            $scope.currentRecord = response.data;
                            $http.get(context + '/' + id+ '/imagenes').then(function (response) {
                            $scope.imagenesRecords = response.data;
                            $scope.imagen = response.data[0];});
                        });
            } else {
                // el registro actual debe estar vacio
                $scope.currentRecord = {
                    id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                    nombre: '' /*Tipo String*/,
                    valor: 0 /*Tipo Double*/,
                    fechaInicio: '' /*Tipo String*/,
                    fechaFin: '' /*Tipo String*/,
                    calificacion: 0 /*Tipo Double*/,
                    comentarios: '',
                    descripcion: ''
                };
                $scope.alerts = [];
            }


            this.saveRecord = function (id) {
                var currentRecord = $scope.currentRecord;
                // si el id es null, es un registro nuevo, entonces lo crea
                if (id !== null && id !== undefined) {

                    // ejecuta POST en el recurso REST
                    return $http.put(context + "/" + currentRecord.id, currentRecord)
                            .then(function () {
                                // $http.put es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('transportesList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    return $http.post(context, currentRecord)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('transportesList');
                            });

                    // ejecuta PUT en el recurso REST
                    
                }
                ;
            };

            this.deleteRecord = function (id) {
                $http.delete(context + "/" + id);
                $state.reload('transportesList');

            };

// Código continua con las funciones de despliegue de errores


        }]);
})(window.angular);