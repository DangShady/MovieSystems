
app.controller("dashboard-ctrl", function($scope,$http){
  
  
  $scope.topProduct = [];
  $scope.recentOrder = [];
  $scope.total = {};
  
  $scope.loadTopProduct = function(){
    $http.get(`/rest/admin/dashboard/topProduct`).then(res => {
      $scope.topProduct = res.data;
      console.log("Top Product",res.data);
    }).catch(error => {
      console.log("Error",error);
    })
  }
  
  $scope.loadRecentOrder = function(){
    $http.get(`/rest/admin/dashboard/recentOrder`).then(res => {
      $scope.recentOrder = res.data;
      console.log("Recent Order",res.data);
    }).catch(error => {
      console.log("Error",error);
    })
  }
  
  $scope.loadTotal = function(){
    $http.get(`/rest/admin/dashboard/total`).then(res => {
      $scope.total = res.data;
      console.log("Total",res.data);
    }).catch(error => {
      console.log("Error",error);
    })
  }
  
  $scope.loadTotal();
  $scope.loadRecentOrder();
  $scope.loadTopProduct();
  
})