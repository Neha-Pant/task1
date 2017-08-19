window.routes =
    {
        "/home":
        {
            templateUrl: 'app/components/basic/home.html',
            controller: 'BasicController',
            controllerAs: 'basicCtrl',
            requireLogin: false,
            roles: ['GUEST', 'ADMIN', 'STAFF', 'STUDENT']
        },
        "/about":
        {
            templateUrl: 'app/components/basic/about.html',
            controller: 'BasicController',
            controllerAs: 'basicCtrl',
            requireLogin: false,
            roles: ['GUEST', 'ADMIN', 'STAFF', 'STUDENT']
        },
        "/register":
        {
            templateUrl: 'app/components/register/register.html',
            controller: 'RegisterController',
            controllerAs: 'regCtrl',
            requireLogin: false,
            roles: ['GUEST']
        },
        "/users":
        {
            templateUrl: 'app/components/register/users.html',
            controller: 'RegisterController',
            controllerAs: 'regCtrl',
            requireLogin: false,
            roles: ['GUEST']
        },
        "/blogAdd":
        {
            templateUrl: 'app/components/blog/blog.html',
            controller: 'BlogController',
            controllerAs: 'blogCtrl',
            requireLogin: false,
            roles: ['GUEST']
        },
         "/blogs":
        {
            templateUrl: 'app/components/blog/blogs.html',
            controller: 'BlogController',
            controllerAs: 'blogCtrl',
            requireLogin: false,
            roles: ['GUEST']
        },
         "/viewBlogs":
        {
            templateUrl: 'app/components/blog/viewBlogs.html',
            controller: 'BlogController',
            controllerAs: 'blogCtrl',
            requireLogin: false,
            roles: ['GUEST']
        },
          "/singleBlogView":
        {
            templateUrl: 'app/components/blog/singleBlog.html',
            controller: 'BlogController',
            controllerAs: 'blogCtrl',
            requireLogin: false,
            roles: ['GUEST']
        },
        "/login":
        {
            templateUrl: 'app/components/login/login.html',
            // controller: 'LoginController',
            // controllerAs: 'loginCtrl',
            requireLogin: false,
            roles: ['GUEST', 'ADMIN', 'STAFF', 'STUDENT']
        }
    };

//specify the the backend url from where you are going to get the values
app.constant('REST_URI', 'http://localhost:9090/socialnetworking');



app.config(['$routeProvider', function ($routeProvider) {
    for (var path in window.routes) {
        $routeProvider.when(path, window.routes[path]);
    }
    $routeProvider.otherwise({ redirectTo: '/home' });
}]);

// app.run(['$route', '$rootScope', '$location', function ($route, $rootScope, $location) {
//     var original = $location.path;
//     $location.path = function (path, reload) {
//         if (reload === false) {
//             var lastRoute = $route.current;
//             var un = $rootScope.$on('$locationChangeSuccess', function () {
//                 $route.current = lastRoute;
//                 un();
//             });
//         }
//         return original.apply($location, [path]);
//     };
// }])