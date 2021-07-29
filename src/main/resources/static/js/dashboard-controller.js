
app.controller("dashboard-ctrl", function($scope,$http){
  
  
  $scope.topProduct = [];
  $scope.recentOrder = [];
  $scope.total = {};
  $scope.lastmonth = {};
  $scope.lastweek = {};
  $scope.count = [];
  $scope.adminInLogin = {};
  
  
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
  
  $scope.loadTotalLastMonth = function(){
    $http.get(`/rest/admin/dashboard/lastmonth`).then(res => {
      $scope.lastmonth = res.data;
      console.log("LastMonth",res.data);
    }).catch(error => {
      console.log("Error",error);
    })
  }
  
  $scope.loadTotalLastWeek = function(){
    $http.get(`/rest/admin/dashboard/lastweek`).then(res => {
      $scope.lastweek = res.data;
      console.log("LastWeek",res.data);
    }).catch(error => {
      console.log("Error",error);
    })
  }
  
  $scope.loadCountForShop = function(){
    $http.get(`/rest/admin/dashboard/count`).then(res => {
      $scope.count = res.data;
      console.log("Count",res.data);
    }).catch(error => {
      console.log("Error",error);
    })
  }
  
  $scope.loadAdminInLogin = function(){
    $http.get(`/rest/accounts/userInLogin`).then(res => {
      $scope.adminInLogin = res.data;
      console.log("AdminInLogin",res.data);
    }).catch(error => {
      console.log("Error",error);
    })
  }
  
  
  $scope.loadAdminInLogin();
  $scope.loadCountForShop();
  $scope.loadTotalLastWeek();
  $scope.loadTotalLastMonth();
  $scope.loadTotal();
  $scope.loadRecentOrder();
  $scope.loadTopProduct();
  
})