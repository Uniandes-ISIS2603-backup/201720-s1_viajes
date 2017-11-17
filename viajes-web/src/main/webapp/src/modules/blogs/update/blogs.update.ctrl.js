(
        function (ng) {
            var mod = ng.module("blogModule");
            mod.constant("blogsContext", "api/blogs");
            mod.controller('blogUpdateCtrl', ['$scope', '$http', 'blogsContext', '$state',  '$rootScope', '$filter',
                function ($scope, $http, blogsContext, $state, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idBlog = $state.params.blogId;
                    //Consulto el autor a editar.
                    $http.get(blogsContext + '/' + idBlog).then(function (response) {
                        var blog = response.data;
                        $scope.blogTitle = blog.titulo;
                        $scope.blogComentario = blog.comentario;
                    });

                    //funciones para el drag and drop de HTML5 nativo
                    $scope.allowDrop = function (ev) {
                        ev.preventDefault();
                    };

                    $scope.drag = function (ev) {
                        ev.dataTransfer.setData("text", ev.target.id);
                    };

                    $scope.createBlog = function () {
                        /*Se llama a la función newBooks() para buscar cada uno de los ids de los books
                         en el array que tiene todos los books y así saber como queda la lista final de los books asociados al autor.
                         */
                        
                        $http.put(blogsContext + "/" + idBlog, {
                            titulo: $scope.blogTitle,
                            comentario: $scope.blogComentario,
                        }).then(function (response) {
                            //Author created successfully
                            $state.go('blogsList', {blogId: response.data.id}, {reload: true});
                        });
                    };

                }
            ]);
        }
)(window.angular);