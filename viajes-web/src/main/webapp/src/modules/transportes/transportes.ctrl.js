(function (ng) {
<<<<<<< HEAD
 
     var mod = ng.module("transportesModule");
 
     mod.controller("transportesCtrl", ['$scope', '$state', '$stateParams', '$http', 'transportesContext', function ($scope, $state, $stateParams, $http, context) {
 
             // inicialmente el listado de ciudades está vacio
             $scope.records = {};
             // carga las ciudades
             $http.get(context).then(function (response) {
                 $scope.records = response.data;
             });
 
             // el controlador recibió un entretenimientoId ??
             // revisa los parámetros (ver el :entretenimientoId en la definición de la ruta)
             /*if ($stateParams.transporteId !== null && $stateParams.transporteId !== undefined) {
 
                 // toma el id del parámetro
                 id = $stateParams.transporteId;
                 // obtiene el dato del recurso REST
                 $http.get(context  "/"  id
                         .then(function (response) {
                             // $http.get es una promesa
                             // cuando llegue el dato, actualice currentRecord
                             $scope.currentRecord = response.data;
                         });
 
                 // el controlador no recibió un entretenimientoId
             } else {
                 // el registro actual debe estar vacio
                 $scope.currentRecord = {
                  //   id: undefined /*Tipo Long. El valor se asigna en el backend*/ //,
                     //name: '' /*Tipo String*/,
                /* };
 
                 $scope.alerts = [];
             }
 
 
             this.saveRecord = function (id) {
                 currentRecord = $scope.currentRecord;
 
                 // si el id es null, es un registro nuevo, entonces lo crea
                 if (id == null) {
 
                     // ejecuta POST en el recurso REST
                     return $http.post(context, currentRecord)
                             .then(function () {
                                 // $http.post es una promesa
                                 // cuando termine bien, cambie de estado
                                 $state.go('transportesList');
                             });
 
                     // si el id no es null, es un registro existente entonces lo actualiza
                 } else {
 
                     // ejecuta PUT en el recurso REST
                     return $http.put(context  "/"  currentRecord.id, currentRecord)
                             .then(function () {
                                 // $http.put es una promesa
                                 // cuando termine bien, cambie de estado
                                 $state.go('transportesList');
                             });
                 }
                 ;
             };
 
             this.deleteRecord = function (id) {
                 $http.delete(context  "/"  id);
                 $state.reload('transportesList');
 
             }
                     */
 
 // Código continua con las funciones de despliegue de errores
 
 
         }]);
 })(window.angular);
=======

    var mod = ng.module("transportesModule");
    mod.constant("transportesContext", "api/transportes");
    mod.controller("transportesCtrl", ['$scope','$http', 'transportesContext','$state',
        function ($scope, $http, transportesContext, $state) {

            // inicialmente el listado de transportes está vacio
            //$scope.records = {};
            // carga los transportes
            $http.get(transportesContext).then(function (response) {
                $scope.transportesRecords = response.data;
            });
        }]);
})(window.angular);
>>>>>>> e5fd30653d64003bde7cdeb8a4807fdb3543d3da
