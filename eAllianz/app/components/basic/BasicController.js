BasicModule.controller('BasicController',['BasicService','$scope', function(BasicService,$scope){
    
    var me=this;
    
    //me.greeting='This message is comming from angular controller';
    //if it resolve from backend then only the value would be assigned to this variable
    BasicService.getGreeting().then(

        function(greeting){
            me.greeting=greeting;
        },
        function(error){
            console.log(error);
        }
    );

        }
    ]

);
