(function (ng) {
    var mod = ng.module("usuarioModule");
    mod.constant("usuariosContext", "api/usuarios");
    mod.controller('usuarioUpdateCtrl', ['$scope', '$http', 'usuariosContext', '$state', '$rootScope',
        function ($scope, $http, usuariosContext, $state, $rootScope) {
            $rootScope.edit = true;

            var idUsuario = $state.params.usuarioId;
            //Consulto el usuario a editar.
            $http.get(usuariosContext + '/' + idUsuario).then(function (response) {
                var usuario = response.data;
                $scope.usuarioName = usuario.nombre;
            });

            //funciones para el drag and drop de HTML5 nativo
            $scope.allowDrop = function (ev) {
                ev.preventDefault();
            };

            $scope.drag = function (ev) {
                ev.dataTransfer.setData("text", ev.target.id);
            };

            $scope.createUsuario = function () {
                /*Se llama a la función newBooks() para buscar cada uno de los ids de los books
                 en el array que tiene todos los books y así saber como queda la lista final de los books asociados al usuario.
                 */

                $http.put(usuariosContext + "/" + idUsuario, {
                    nombre: $scope.usuarioName
                }).then(function (response) {
                    //Usuario created successfully
                    $state.go('usuariosList', {usuarioId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
})(window.angular);

