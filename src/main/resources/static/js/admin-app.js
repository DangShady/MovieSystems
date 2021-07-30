var app = angular.module("admin-app",["ngRoute","angularUtils.directives.dirPagination"])

app.config(function ($locationProvider,$routeProvider,$qProvider){
  $qProvider.errorOnUnhandledRejections(false);
  $routeProvider
  .when("/home", {
    templateUrl: "/admin/assets/index.html",
    controller: "dashboard-ctrl"
  })
  .when("/product", {
    templateUrl: "/admin/assets/product/product.html",
    controller: "product-ctrl"
  })
  .when("/add-product", {
    templateUrl: "/admin/assets/product/add-product.html",
    controller: "product-add-ctrl"
  })
  .when("/product/:productId", {
    templateUrl: "/admin/assets/product/update-product.html",
    controller: "product-update-ctrl"
  })
  .when("/category", {
    templateUrl: "/admin/assets/category/category.html",
    controller: "category-ctrl"
  })
  .when("/add-category", {
    templateUrl: "/admin/assets/category/add-category.html",
    controller: "category-add-ctrl"
  })
  .when("/category/:cateId", {
    templateUrl: "/admin/assets/category/update-category.html",
    controller: "category-update-ctrl"
  })
  .when("/customer", {
    templateUrl: "/admin/assets/customers/customer.html",
    controller: "customer-ctrl"
  })
  .when("/customer/:username", {
    templateUrl: "/admin/assets/customers/customer-detail.html",
    controller: "customer-detail-ctrl"
  })
  .when("/add-customer", {
    templateUrl: "/admin/assets/customers/add-customer.html",
    controller: "customer-add-ctrl"
  })
  .when("/order", {
    templateUrl: "/admin/assets/orders/orders.html",
    controller: "order-ctrl"
  })
  .when("/order/:orderId", {
    templateUrl: "/admin/assets/orders/order-detail.html",
    controller: "order-detail-ctrl"
  })
  .when("/authentication", {
    templateUrl: "/admin/assets/authentication.html",
    controller: "authority-ctrl"
  })
  .when("/setting", {
    templateUrl: "/admin/assets/setting.html",
  })
  .otherwise({
    redirectTo: "/home"
  })
  
  
  
  
})