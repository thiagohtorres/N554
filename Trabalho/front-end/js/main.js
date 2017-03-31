var app = angular.module('LojaOnline',['ngRoute']);

app.config(['$routeProvider',
    function($routeProvider) {
    $routeProvider.
      when('/meu_carrinho', {
        templateUrl: 'carrinho.html',
        controller: 'CarrinhoController'
      }).
      when('/home', {
        templateUrl: 'principal.html',
        controller: 'PrincipalController'
      });
}]);
