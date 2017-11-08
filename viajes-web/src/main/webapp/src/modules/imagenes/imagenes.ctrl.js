(function (ng) {
    var mod = ng.module("imagenModule");
    mod.constant("imagenesContext", "api/imagenes");
    mod.controller('imagenCtrl', ['$scope', '$http', 'imagenesContext', '$state',
        function ($scope, $http, imagenesContext, $state) {
            $http.get(imagenesContext).then(function (response) {
                $scope.imagenesRecords = response.data;
            });
            
            if (($state.params.imagenId !== undefined)&& ($state.params.imagenId !== null)) {
                $http.get(imagenesContext + '/' + $state.params.imagenId).then(function (response) {
                    $scope.currentImagen = response.data;
                });
            }
        }
    ]);
}
)(window.angular);