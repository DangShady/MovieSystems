app.controller("customer-add-ctrl", function($scope,$routeParams,$location,$http){

  $scope.customer = {};
 
  $scope.create = function(){
    var item = angular.copy($scope.customer);
    $http.post(`/rest/admin/customer`,item).then(res => { 
      res.data.dateregister = new Date(res.data.dateregister); 
      alert("Thêm mới thành công");
      $scope.reset();
      $location.path('/customer');
    }).catch(error => {
      alert("Lỗi thêm customer");
    })
  }
  
  
  $scope.reset = function(){
    $scope.customer = {};
  }
  
})