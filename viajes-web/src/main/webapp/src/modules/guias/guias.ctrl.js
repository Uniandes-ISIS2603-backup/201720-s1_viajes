(function (ng) {

    var mod = ng.module("guiasModule");
    mod.constant("guiasContext", "api/guias");
    mod.controller("guiasCtrl", ['$scope', '$state', '$stateParams', '$http', 'guiasContext',
        function ($scope, $state, $stateParams, $http, guiasContext) {

            // inicialmente el listado de transportes está vacio
            $scope.records = {};
            // carga los transportes
            $http.get(guiasContext).then(function (response) {
                $scope.records = response.data;
            });

            if ($stateParams.guiaId !== null && $stateParams.guiaId !== undefined) {

                // toma el id del parámetro
                var id = $stateParams.guiaId;
                // obtiene el dato del recurso REST
                $http.get(guiasContext + "/" + id)
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentRecord
                            $scope.currentRecord = response.data;
                        });
            } else {
                // el registro actual debe estar vacio
                $scope.currentRecord = {
                    id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                    nombre: '' /*Tipo String*/,
                    valor: 0 /*Tipo Double*/,
                    lenguaje: '' /*Tipo String*/,
                    fechaInicio: '',
                    fechaFinal:'',
                    calificacion:'',
                    comentarios:'',
                    descripcion:''
                };
                $scope.alerts = [];
            }


            this.saveRecord = function (id) {
                var currentRecord = $scope.currentRecord;
                // si el id es null, es un registro nuevo, entonces lo crea
                if (id !== null && id !== undefined) {

                    // ejecuta POST en el recurso REST
                    return $http.put(guiasContext + "/" + currentRecord.id, currentRecord)
                            .then(function () {
                                // $http.put es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('guiasList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    return $http.post(guiasContext, currentRecord)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('guiasList');
                            });

                    // ejecuta PUT en el recurso REST
                    
                }
                ;
            };

            this.deleteRecord = function (id) {
                $http.delete(guiasContext + "/" + id);
                $state.reload('guiasList');

            };

// Código continua con las funciones de despliegue de errores


        }]);
})(window.angular);
