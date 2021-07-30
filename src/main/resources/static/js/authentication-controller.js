
app.controller("authority-ctrl", function($scope,$http,$location){
  
  $scope.roles = [];
  $scope.admins = [];
  $scope.authorities = [];
  
  $scope.load = function(){
    
    //Load roles
    $http.get(`/rest/roles`).then(res => {
      $scope.roles = res.data;
      console.log("Role",res.data);
    })
    
    //Load vai trò
    
    $http.get(`/rest/accounts?admin=true`).then(res => {
      $scope.admins = res.data;
    })
    
    $http.get(`/rest/authorities?admin=true`).then(res => {
      $scope.authorities = res.data;
      console.log("Authorities",res.data);
    }).catch(error => {
      $location.path('/authentication');
    })
    
  }
  
  
  $scope.authority_of = function(acc,role){
    if($scope.authorities){
      return $scope.authorities.find(au => au.account.username == acc.username && au.role.id == role.id);
    }
  }
  
  $scope.authority_changed = function(acc,role){
    var authority = $scope.authority_of(acc,role);
    if(authority){
      $scope.revoke_authority(authority);
      console.log("Quyền sử dụng", authority);
    }
    else{
      authority = {account: acc, role: role};
      $scope.grant_authority(authority);
    }
  }
  
  $scope.revoke_authority = function(authority){
    $http.delete(`/rest/authorities/${authority.id}`).then(res =>{
      var index = $scope.authorities.findIndex(a => a.id == authority.id);
      $scope.authorities.splice(index,1);
      alert("Thu hổi quyền sử dụng thành công");
    }).catch(error => {
      alert("Xóa thất bại");
      console.log("Error",error);
    })
  }
  
  $scope.grant_authority = function(authority){
    $http.post(`/rest/authorities`,authority).then(res => {
      $scope.authorities.push(res.data);
      alert("Cấp quyền sử dụng thành công");
    }).catch(error => {
      alert("Cấp quyền sử dụng thất bại");
    })
  }
  
  $scope.load();
  
})