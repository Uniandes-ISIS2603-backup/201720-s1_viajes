(function (ng) {

    var mod = ng.module("usuariosModule");

    mod.controller("usuariosCtrl", ['$scope', '$state', '$stateParams', '$http', 'usuariosContext', function ($scope, $state, $stateParams, $http, usuariosContext) {

            // inicialmente el listado de usuarios está vacio
            $scope.records = {};
            // carga los usuarios
            $http.get(usuariosContext).then(function (response) {
                $scope.records = response.data;
            });

            // el controlador recibió un usuarioId ??
            // revisa los parámetros (ver el :usuarioId en la definición de la ruta)
            if ($stateParams.usuarioId) {

                // toma el id del parámetro
                var id = $stateParams.usuarioId;
                // obtiene el dato del recurso REST
                $http.get(usuariosContext + "/" + id)
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentRecord
                            $scope.currentRecord = response.data;
                        });

                // el controlador no recibió un usuarioId
            } else {
                // el registro actual debe estar vacio
                $scope.currentRecord = {
                    id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                    nombre: '' /*Tipo String*/
                };
            }


            this.saveRecord = function (id) {
                var currentRecord = $scope.currentRecord;

                // si el id es null, es un registro nuevo, entonces lo crea
                if (id == null) {

                    // ejecuta POST en el recurso REST
                    return $http.post(usuariosContext, currentRecord)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('usuariosList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    // ejecuta PUT en el recurso REST
                    return $http.put(usuariosContext + "/" + currentRecord.id, currentRecord)
                            .then(function () {
                                // $http.put es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('usuariosList');
                            });
                }
                ;
            };

            this.deleteRecord = function (id) {
                $http.delete(usuariosContext + "/" + id);
                $state.reload('usuariosList');
            };
        }]);
})(window.angular);