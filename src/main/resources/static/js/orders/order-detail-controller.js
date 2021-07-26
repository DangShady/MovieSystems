
app.controller("order-detail-ctrl", function($scope,$routeParams,$location,$http){
  
  $scope.details = [];
  $scope.description = '';
 
  $scope.load = function(){
    $http.get("/rest/admin/order/"+ $routeParams.orderId).then(res => {
      $scope.details = res.data;
     
      console.log($scope.details);
    });
  }
       
  $scope.load();
  
})