BlogModule.controller('BlogController', ['BlogService', '$location', '$rootScope', function (BlogService, $location, $rootScope) {

    var me = this;
    me.blog = {};
    me.message = '';
    me.blogsD = {};
    me.blogsA = {};
    me.singleBlogC = {};
    $rootScope.demo;
    me.blogComment={};

    me.blogAdd = function () {
        console.log(me.blog);
        BlogService.blogAdd(me.blog).then(
            function (response) {
                me.message = response;
                console.log(me.message);
            },
            function (error) {
                console.log(me.blog);
            }
        );
    }

    BlogService.viewD().then(
        function (response) {
            me.blogsD = response;
            console.log(response);
        },
        function (error) {
            console.log(error);
        }
    );

    me.deleteBlog = function (id) {
        BlogService.deleteBlog(id).then(
            function (response) {
                console.log(response);
                window.location.reload();
            },
            function (error) {
                console.log(error);
            }
        );
    }

    me.activateBlog = function (id) {
        BlogService.activateBlog(id).then(
            function (response) {
                console.log(response);
                window.location.reload();
            },
            function (error) {
                console.log(error);
            }
        );
    }

    BlogService.viewA().then(
        function (response) {
            me.blogsA = response;
            console.log(response);
        },
        function (error) {
            console.log(error);
        }
    );

    me.singleBlog = function (id) {
        console.log(id);
        BlogService.singleBlogV(id).then(
            function (response) {
                me.singleBlogC = response;
                //console.log(response); 
                //  alert(me.singleBlogC); 
                console.log(me.singleBlogC);
                $rootScope.demo = response;
                //sessionStorage.setItem('blog', $rootScope.demo);
                $location.path("/singleBlogView");
               // $rootScope.demo=sessionStorage.getItem('blog');
            },
            function (error) {
                console.log(error);
            }
        );
    }

    me.likeBlog = function (id) {
        BlogService.likeBlog(id).then(
            function (response) {
                console.log(response);
                me.singleBlog(id);
                me.blogComment.blogId=me.singleBlog.blogId;
                $location.path("/singleBlogView");
                me.blogComment.blogId=me.singleBlog.blogId;
            },
            function (error) {
                console.log(error);
            }
        );
    }

me.blogCommentAdd = function () {
        console.log(me.blogComment);
        BlogService.blogCommentAdd(me.blogComment).then(
            function (response) {
                me.message = response;
                console.log(me.message);
            },
            function (error) {
                console.log(me.blogComment);
            }
        );
    }

}]);