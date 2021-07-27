
app.controller("order-detail-ctrl", function($scope,$routeParams,$location,$http){
  
  $scope.details = [];
  $scope.description = '';
 
 $scope.accept = function(){
  $http.put("/rest/admin/order/"+ $routeParams.orderId).then(res => {
      
      alert("Xác nhận thành công");
      $location.path('/order');
    }).catch(error => {
      alert("Xác nhận thất bại");
    })
}
 
 
  $scope.load = function(){
    $http.get("/rest/admin/order/"+ $routeParams.orderId).then(res => {
      $scope.details = res.data;
     
      console.log($scope.details);
    });
  }
       
  $scope.load();
  
})