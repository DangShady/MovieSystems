
app.controller("customer-detail-ctrl", function($scope,$routeParams,$location,$http){
  
  $scope.customer = {};
 
  $scope.load = function(){
    $http.get("/rest/admin/customer/"+ $routeParams.username).then(res => {
      $scope.customer = res.data;
      console.log(res.data);
    });
  }
       
  $scope.load();
  
})