(
        function (ng) {
            var mod = ng.module("ubicacionModule");
            mod.constant("ubicacionContext", "api/ubicaciones");
            mod.controller('ubicacionUpdateCtrl', ['$scope', '$http', 'ubicacionContext', '$state',  '$rootScope',
                function ($scope, $http, ubicacionContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    var idUbicacion = $state.params.ubicacionId;
                    //Consulto el autor a editar.
                    $http.get(ubicacionContext + '/' + idUbicacion).then(function (response) {
                        var ubicacion = response.data;
                        $scope.ubicacionTitle = ubicacion.titulo;
                        $scope.ubicacionComentario = ubicacion.comentario;
                    });

                    //funciones para el drag and drop de HTML5 nativo
                    $scope.allowDrop = function (ev) {
                        ev.preventDefault();
                    };

                    $scope.drag = function (ev) {
                        ev.dataTransfer.setData("text", ev.target.id);
                    };

                    $scope.createUbicacion = function () {
                        /*Se llama a la función newBooks() para buscar cada uno de los ids de los books
                         en el array que tiene todos los books y así saber como queda la lista final de los books asociados al autor.
                         */
                        
                        $http.put(ubicacionContext + "/" + idUbicacion, {
                            titulo: $scope.ubicacionTitle,
                            comentario: $scope.ubicacionComentario,
                        }).then(function (response) {
                            //Author created successfully
                            $state.go('ubicacionList', {ubicacionId: response.data.id}, {reload: true});
                        });
                    };

                }
            ]);
        }
)(window.angular);