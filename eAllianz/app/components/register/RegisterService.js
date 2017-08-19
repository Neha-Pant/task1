var RegisterModule = angular.module('RegisterModule', []);
RegisterModule.service('RegisterService', ['$http', '$q', 'REST_URI', function ($http, $q, REST_URI) {

    this.register = function (user) {
        var deffered = $q.defer();
        console.log(user);
        $http.post(REST_URI + '/user/add', user).then(
            function (response) {
                deffered.resolve(response.data.responseMessage);
            },
            function (error) {
                deffered.reject(error);
            }
        );
        return deffered.promise;
    }

    this.viewAll = function () {
        var deffered = $q.defer();
        $http.get(REST_URI + '/user/view').then(
            function (response) {
                deffered.resolve(response.data);
            },
            function (error) {
                deffered.reject(error);
            }
        );
        return deffered.promise;
    }

    this.init = function () {
        this.viewA();
        this.viewD();
    }
    this.viewA = function () {
        var deffered = $q.defer();
        $http.get(REST_URI + '/user/viewA').then(
            function (response) {
                deffered.resolve(response.data);
            },
            function (error) {
                deffered.reject(error);
            }
        );
        return deffered.promise;
    }

    this.viewD = function () {
        var deffered = $q.defer();
        $http.get(REST_URI + '/user/viewD').then(
            function (response) {
                deffered.resolve(response.data);
            },
            function (error) {
                deffered.reject(error);
            }
        );
        return deffered.promise;
    }

    this.deleteUser = function (id) {
        var deffered = $q.defer();
        console.log(id);
        $http.post(REST_URI + '/user/delete', id).then(
            function (response) {
                deffered.resolve(response.data.text());

            },
            function (error) {
                deffered.reject(error);
            }
        );
        this.init();
        return deffered.promise;
    }

    this.activateUser = function (id) {
        var deffered = $q.defer();
        console.log(id);
        $http.post(REST_URI + '/user/activate', id).then(
            function (response) {
                deffered.resolve(response.data.text());
            },
            function (error) {
                deffered.reject(error);
            }
        );
        this.init();
        return deffered.promise;
    }

    //         $http({
    //             method: 'post',
    //             url: REST_URI+'/user/delete/',
    //   transformResponse:[function(data){
    //       return data;
    //   }]
    // })
    //         return deffered.promise;
    //     }

}]);