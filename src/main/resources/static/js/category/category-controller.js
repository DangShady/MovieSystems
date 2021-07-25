
app.controller("category-ctrl", function($scope,$routeParams,$location,$http){
  
  $scope.items = [];
  $scope.form = {};
  
  $scope.initialize = function(){
    $http.get("/rest/admin/categories").then(res => {
      $scope.items = res.data;
    });
  }
       
  $scope.initialize();
  
})