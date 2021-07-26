app.controller("category-update-ctrl", function($scope,$routeParams,$location,$http){

 
  $scope.cate = {};
  
  $http.get("/rest/admin/categories/"+$routeParams.cateId).then(res => {
      $scope.cate = res.data;
      console.log($scope.cate);
  });

  $scope.update = function(){
    var item = angular.copy($scope.cate);
    $http.put(`/rest/admin/categories/${item.id}`,item).then(res => {
      alert("Cập nhập thành công");
      $location.path('/category');
    }).catch(error => {
      alert("Lỗi cập nhập");
    })
  }
  
})