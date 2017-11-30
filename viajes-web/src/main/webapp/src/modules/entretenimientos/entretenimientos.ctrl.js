(function (ng) {
    var mod = ng.module("entretenimientosModule");
    mod.constant("entretenimientosContext", "api/entretenimientos");
    mod.controller('entretenimientoCtrl', ['$scope', '$http', 'entretenimientosContext', '$state',
        function ($scope, $http, entretenimientosContext, $state) {
            
            var id = $state.params.entretenimientoId;
            
            $http.get(entretenimientosContext).then(function (response) {
                $scope.records = response.data;
            });

            if (($state.params.entretenimientoId !== undefined) && ($state.params.entretenimientoId !== null)) {
                $http.get(entretenimientosContext + '/' + $state.params.entretenimientoId).then(function (response) {                    
                    $scope.currentRecord = response.data;
                    $http.get(entretenimientosContext + '/' + $state.params.entretenimientoId+ '/imagenes').then(function (response) {
                    $scope.imagenesRecords = response.data;
                    $scope.imagen = response.data[0];});
                    
                
                });
            }
            
            $scope.createImagen = function () {
                $http.post('api/imagenes', {
                    ruta: $scope.ruta,
                    comentario: $scope.comentario
                }).then(function (response) {
                    //Author created successfully
                    $http.post(entretenimientosContext+ '/' +id+'/imagenes/'+response.data.id, )
                    .then(function (response) {                                                 
                    
                    $state.go('entretenimientosDetail({})', {entretenimientoId: response.data.id}, {reload: true});
                });
                    
                });
            };
        }
    ]);
}
)(window.angular);