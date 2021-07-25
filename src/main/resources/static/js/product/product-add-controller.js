app.controller("product-add-ctrl", function($scope,$routeParams,$location,$http){

  $scope.form = {};
  $scope.cates = {};
  
  $scope.form.image = 'no-image.png';
    
  
  //Load cate
  $http.get("/rest/admin/categories/").then(res => {
      $scope.cates = res.data;
      console.log($scope.cates);
  });
  
  $scope.create = function(){
    var item = angular.copy($scope.form);
    $http.post(`/rest/admin/products`,item).then(res => {
      res.data.productdate = new Date(res.data.productdate);
      $scope.reset();
      alert("Thêm mới thành công");
      $location.path('/product');
    }).catch(error => {
      alert("Lỗi thêm sản phẩm");
    })
  }
  
  
  $scope.reset = function(){
    $scope.form = {
      productdate: new Date(),
      image: 'no-image.png'
    };
    
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