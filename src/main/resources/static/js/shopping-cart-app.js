const app = angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl", function($scope,$http){
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
		}	
	};
	
		$scope.cart.loadFromLocalStorage();
});