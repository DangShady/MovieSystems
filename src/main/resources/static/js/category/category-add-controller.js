app.controller("category-add-ctrl", function($scope,$routeParams,$location,$http){

  $scope.cate = {};
 
  $scope.create = function(){
    var item = angular.copy($scope.cate);
    $http.post(`/rest/admin/categories`,item).then(res => {      
      alert("Thêm mới thành công");
      $scope.reset();
      $location.path('/category');
    }).catch(error => {
      alert("Lỗi thêm sản phẩm");
    })
  }
  
  
  $scope.reset = function(){
    $scope.cate = {};
  }
  
})