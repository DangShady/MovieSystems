
app.controller("product-ctrl", function($scope,$routeParams,$location,$http){
  
  $scope.items = [];
  $scope.form = {};
  
  
  $scope.delete = function(item){
    $http.delete(`/rest/admin/products/${item.id}`).then(res =>{
      
      var index = $scope.items.findIndex(p => p.id == item.id);
      $scope.items.splice(index,1);
      alert("Xóa thành công");
      $location.path('/product');
    }).catch(error => {
      alert("Xóa thất bại");
    })
  }
  
  
  $scope.initialize = function(){
    $http.get("/rest/admin/products").then(res => {
      $scope.items = res.data;
      $scope.items.forEach(item => {
        item.productdate = new Date(item.productdate);
      });
    });
  }
       
  $scope.initialize();
  
})