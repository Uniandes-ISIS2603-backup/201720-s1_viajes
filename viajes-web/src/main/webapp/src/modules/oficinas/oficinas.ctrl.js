(function (ng) {

    var mod = ng.module("oficinasModule");
    mod.constant("oficinasContext", "api/oficinas");
    mod.controller("oficinasCtrl", ['$scope', '$state', '$stateParams', '$http', 'oficinasContext',
        function ($scope, $state, $stateParams, $http, context) {

            // inicialmente el listado de oficinas está vacio
            $scope.records = {};
            // carga las oficinas 
            $http.get(context).then(function (response) {
                $scope.records = response.data;
            });

            if ($stateParams.oficinaId !== null && $stateParams.oficinaId !== undefined) {

                // toma el id del parámetro
                var id = $stateParams.oficinaId;
                // obtiene el dato del recurso REST
                $http.get(context + "/" + id)
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentRecord
                            $scope.currentRecord = response.data;
                        });
            } else {
                // el registro actual debe estar vacio
                $scope.currentRecord = {
                    id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                    nombreLugar: '' /*Tipo String*/,
                    nombreEncargado: '' /*Tipo String*/
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
                                $state.go('oficinasList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    return $http.post(context, currentRecord)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('oficinasList');
                            });

                    // ejecuta PUT en el recurso REST
                    
                }
                ;
            };

            this.deleteRecord = function (id) {
                $http.delete(context + "/" + id);
                $state.reload('oficinasList');

            };

// Código continua con las funciones de despliegue de errores


        }]);
})(window.angular);