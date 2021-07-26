
app.controller("order-ctrl", function($scope,$routeParams,$location,$http){
  
    $scope.orders = [];
  
    $scope.load = function(){
      $http.get(`/rest/admin/order`).then(res =>{
        $scope.orders = res.data;
        console.log(res.data)
      }).catch(error => {
        alert("Lỗi truy xuất")
      })
    }
    
    $scope.load();
  
})