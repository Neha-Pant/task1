RegisterModule.controller('RegisterController',['RegisterService',function(RegisterService){

var me=this;
me.user={};
me.message='';
me.users={};
me.usersA={};
me.usersD={};

me.register=function(){
    console.log(me.user);
    RegisterService.register(me.user).then(
        function(response){
            me.message=response;
            console.log(me.message);
        },
        function(error)
        {
            console.log(me.user);
        }
    );
}

RegisterService.viewAll().then(
    function(response)
    {
        me.users=response;
        console.log(response);
    },
        function(error)
        {
            console.log(error);
        }
);

RegisterService.viewA().then(
    function(response)
    {
        me.usersA=response;
        console.log(response);
    },
        function(error)
        {
            console.log(error);
        }
);

RegisterService.viewD().then(
    function(response)
    {
        me.usersD=response;
        console.log(response);
    },
        function(error)
        {
            console.log(error);
        }
);

me.deleteUser=function(id){
    RegisterService.deleteUser(id).then(
    function(response)
    {
        console.log(response);
              window.location.reload();
    },
        function(error)
        {
            console.log(error);
        }
);
}

me.activateUser=function(id){
    RegisterService.activateUser(id).then(
    function(response)
    {
        console.log(response);
              window.location.reload();
    },
        function(error)
        {
            console.log(error);
        }
);
}

me.userNameError = false;

me.CheckUserName = function()
  {
    var reg = /^[a-z A-Z]{4,12}$/;
    me.UserNameError = !reg.test( $scope.cvv );
  }

}]);