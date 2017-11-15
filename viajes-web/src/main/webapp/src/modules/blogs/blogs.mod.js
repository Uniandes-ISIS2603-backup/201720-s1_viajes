(function (ng) {
    var mod = ng.module("blogModule", ['ui.router']);
    mod.constant("blogsContext", "api/blogs");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/blogs/';
            var basePathImagenes = 'src/modules/imagenes/';
            $urlRouterProvider.otherwise("/blogsList");

            $stateProvider.state('blogs', {
                url: '/blogs',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'blogs.html',
                        controller: 'blogCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('blogsList', {
                url: '/list',
                parent: 'blogs',
                views: {
                    'listView': {
                        templateUrl: basePath + 'blogs.list.html'
                    }
                }
            }).state('blogDetail', {
                url: '/{blogId:int}/detail',
                parent: 'blogs',
                param: {
                    blogId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePathImagenes + 'imagenes.list.html',
                        controller: 'blogCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'blogs.detail.html',
                        controller: 'blogCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('blogDelete', {
                url: '/delete/{blogId:int}',
                parent: 'blogs',
                param: {
                    blogId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/blog.delete.html',
                        controller: 'blogDeleteCtrl'
                    }
                }
            }).state('blogsCreate', {
                url: '/create',
                parent: 'blogs',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/blogs.new.html',
                        controller: 'blogNewCtrl'
                    }
                }
            }).state('blogUpdate', {
                url: '/update/{blogId:int}',
                parent: 'blogs',
                param: {
                    blogId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/blogs.new.html',
                        controller: 'blogUpdateCtrl'
                    }
                }
            });
        }]);
})(window.angular);