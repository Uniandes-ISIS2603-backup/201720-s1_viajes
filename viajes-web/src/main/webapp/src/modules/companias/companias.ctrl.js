(function (ng) {

    var mod = ng.module("companiaModule");
    mod.constant("companiasContext", "api/companias");
    mod.controller("companiasCtrl", ['$scope', '$state', '$stateParams', '$http', 'companiasContext',
        function ($scope, $state, $stateParams, $http, companiasContext) {

            // inicialmente el listado de transportes está vacio
            $scope.records = {};
            // carga los transportes
            $http.get(companiasContext).then(function (response) {
                $scope.records = response.data;
            });

            if ($stateParams.companiaId !== null && $stateParams.companiaId !== undefined) {

                // toma el id del parámetro
                id = $stateParams.companiaId;
                // obtiene el dato del recurso REST
                $http.get(companiasContext + "/" + id)
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentRecord
                            $scope.currentRecord = response.data;
                        });
            } else {
                // el registro actual debe estar vacio
                $scope.currentRecord = {
                    id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                    email: '' /*Tipo String*/,
                    telefono: 0 /*Tipo Double*/,
                    nombre: '' /*Tipo String*/
                };
                $scope.alerts = [];
            }


            this.saveRecord = function (id) {
                currentRecord = $scope.currentRecord;
                // si el id es null, es un registro nuevo, entonces lo crea
                if (id !== null && id !== undefined) {

                    // ejecuta POST en el recurso REST
                    return $http.put(companiasContext + "/" + currentRecord.id, currentRecord)
                            .then(function () {
                                // $http.put es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('companiasList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    return $http.post(companiasContext, currentRecord)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('companiasList');
                            });

                    // ejecuta PUT en el recurso REST
                    
                }
                ;
            };

            this.deleteRecord = function (id) {
                $http.delete(companiasContext + "/" + id);
                $state.reload('companiasList');

            };

// Código continua con las funciones de despliegue de errores


        }]);
})(window.angular);