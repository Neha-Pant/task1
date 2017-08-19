var BlogModule = angular.module('BlogModule', []);
BlogModule.service('BlogService', ['$http', '$q', 'REST_URI', function ($http, $q, REST_URI) {

    this.blogAdd = function (blog) {
        var deffered = $q.defer();
        console.log(blog);
        $http.post(REST_URI + '/blog/add', blog).then(
            function (response) {
                deffered.resolve(response.data.responseMessage);
            },
            function (error) {
                deffered.reject(error);
            }
        );
        return deffered.promise;
    }

    this.viewD = function () {
        var deffered = $q.defer();
        $http.get(REST_URI + '/blog/viewD').then(
            function (response) {
                deffered.resolve(response.data);
            },
            function (error) {
                deffered.reject(error);
            }
        );
        return deffered.promise;
    }

    this.deleteBlog = function (id) {
        var deffered = $q.defer();
        console.log(id);
        $http.post(REST_URI + '/blog/delete', id).then(
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

    this.activateBlog = function (id) {
        var deffered = $q.defer();
        console.log(id);
        $http.post(REST_URI + '/blog/activate', id).then(
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

    this.viewA = function () {
        var deffered = $q.defer();
        $http.get(REST_URI + '/blog/viewA').then(
            function (response) {
                deffered.resolve(response.data);
            },
            function (error) {
                deffered.reject(error);
            }
        );
        return deffered.promise;
    }

    this.singleBlogV = function (id) {
        var deffered = $q.defer();
        $http.get(REST_URI + '/blog/singleBlog/' + id).then(
            function (response) {
                deffered.resolve(response.data);
            },
            function (error) {
                deffered.reject(error);
            }
        );

        return deffered.promise;
    }

    this.likeBlog = function (id) {
        var deffered = $q.defer();
        console.log(id);
        $http.post(REST_URI + '/blog/like', id).then(
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

    this.blogCommentAdd = function (blogComment) {
        var deffered = $q.defer();
        console.log(blogComment);
        $http.post(REST_URI + '/blog/addComment/' + blogComment.blogId + '/' + blogComment.userId + '/' + blogComment.comment).then(
            function (response) {
                deffered.resolve(response.data.responseMessage);
            },
            function (error) {
                deffered.reject(error);
            }
        );
        return deffered.promise;
    }

}]); 