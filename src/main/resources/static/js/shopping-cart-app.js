const app = angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl", function($scope,$http){
  
  
  $scope.userInLogin = {};
  
  $http.get(`/rest/accounts/userInLogin`).then(res => {     
          $scope.userInLogin = res.data;
          console.log($scope.userInLogin);
    });
  
  
	$scope.cart = {
		items: [],
		//Thêm sản phẩm
		add(id){
			var item = this.items.find(item => item.id == id);	
			if(item){
				item.qty++;
				this.saveToLocalStorage();
			}
			else{
				$http.get(`/rest/products/${id}`).then(res => {
					res.data.qty = 1;
					this.items.push(res.data);
					this.saveToLocalStorage();
				})
			}
		},
		remove(id){
			var index = this.items.findIndex(item => item.id == id);
			this.items.splice(index,1);
			this.saveToLocalStorage();
		},
		// Số lượng trong giỏ hàng
		get count(){
			return this.items
			.map(item => item.qty)
			.reduce((total,qty)=>total += qty,0);
		},	
		//Tổng thành tiền
		get amount(){
			return this.items
			.map(item => item.qty * item.price)
			.reduce((total,qty) => total += qty,0);
		},
		//Lưu giỏ hàng vào local storage
		saveToLocalStorage(){
			var json = JSON.stringify(angular.copy(this.items));	
			localStorage.setItem("cart",json);
		},
		//Load giỏ hàng từ local
		loadFromLocalStorage(){
			var json = localStorage.getItem("cart");
			this.items = json ? JSON.parse(json) : [];
		},
    //Xóa giỏ hàng
    clear(){
      this.items = [];
      this.saveToLocalStorage();
    }
	};
	
		$scope.cart.loadFromLocalStorage();
    
    $scope.order = { 
        orderdate : new Date(),
        address: $scope.address,
        account: {username: $("#username").text()},
        fullname: $scope.fullname,
        phone : $scope.phone,
        amount: $scope.cart.amount,
        description: "",
        status: false,
        get orderDetails(){
          return $scope.cart.items.map(item =>{
            return {
              product: {id: item.id},
              price: item.price,
              quantity: item.qty
            }
          });
          
        },
        purchase(){
          var order = angular.copy(this);
          //Thực hiện đặt hàng
          $http.post("/rest/orders",order).then(res =>{
              alert("Đặt hàng thành công");
              $scope.cart.clear();
              
              location.href="/thank-buy";
              
          }).catch(error =>{
            alert("Đặt hàng thất bại");
            console.log(this);
          })
        }
    }
});