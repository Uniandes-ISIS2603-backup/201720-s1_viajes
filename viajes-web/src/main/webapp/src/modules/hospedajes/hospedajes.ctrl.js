(function (ng) {
    var mod = ng.module("hospedajesModule");
    mod.constant("hospedajesContext", "api/hospedajes");
    mod.controller('hospedajesCtrl', ['$scope', '$http', 'hospedajesContext', '$state',
        function ($scope, $http, hospedajesContext, $state) {
            $http.get(hospedajesContext).then(function (response) {
                $scope.hospedajesRecords = response.data;
            });
            
//            if ($state.params.bookId !== undefined) {
//                $http.get(hospedajesContext + '/' + $state.params.bookId).then(function (response) {
//                    $scope.currentBook = response.data;
//                }); 
//            }
        }
    ]);
}
)(angular);