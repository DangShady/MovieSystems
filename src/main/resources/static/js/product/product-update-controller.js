app.controller("product-update-ctrl", function($scope,$routeParams,$location,$http){

 
  $scope.form = {};
  $scope.cates = {};
  
  $http.get("/rest/admin/products/"+$routeParams.productId).then(res => {
      $scope.form = res.data;
      console.log($scope.form);
  });
    
    
  //Load cate
  $http.get("/rest/admin/categories/").then(res => {
      $scope.cates = res.data;
      console.log($scope.cates);
  });
  
  
  $scope.update = function(){
    var item = angular.copy($scope.form);
    $http.put(`/rest/admin/products/${item.id}`,item).then(res => {
      alert("Cập nhập thành công");
      $location.path('/product');
    }).catch(error => {
      alert("Lỗi cập nhập");
    })
  }
  
  
  $scope.imageChanged = function(files){
    var data = new FormData();
    data.append('file',files[0]);
    $http.post('/rest/upload/products',data,{
      transformRequest: angular.identity,
      headers: {'Content-Type':undefined}
    }).then(res => {
      $scope.form.image = res.data.name;
    }).catch(error =>{
      alert("Lỗi upload");
      console.log("Error",error);
    })
  }
  
})