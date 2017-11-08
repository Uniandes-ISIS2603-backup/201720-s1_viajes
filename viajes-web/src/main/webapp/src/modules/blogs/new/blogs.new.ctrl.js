(function (ng) {
    var mod = ng.module("blogModule");
    mod.constant("blogsContext", "api/blogs");
    mod.controller('blogNewCtrl', ['$scope', '$http', 'blogsContext', '$state', '$rootScope',
        function ($scope, $http, blogsContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createBlog = function () {
                $http.post(blogsContext, {
                    titulo: $scope.blogTitle,
                    comentario: $scope.blogComentario,
                    imagenes: []
                }).then(function (response) {
                    //Author created successfully
                    $state.go('blogsList', {blogId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);