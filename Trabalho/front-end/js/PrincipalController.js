app.controller('PrincipalController',function($scope,$http){
$scope.listaProdutos = [];

	$scope.produto = {};
	$scope.produto.categoria = {};

$scope.listaCategorias = [
	{nome:"Hardware"},
	{nome:"Software"},
	{nome:"Periféricos"}
];

$scope.adicionar = function(produto){	
	
	
		$http.get('http://localhost:8080/ExemploRest/rest/produto/carrinho/'+produto.id).success(
			function(dados){
			
				$scope.produto = {};
				$scope.listar();
					alert(dados);
				
			}

			);	
}

$scope.listar = function(){

$http.get('http://localhost:8080/ExemploRest/rest/produto').success(
			function(dados){
				$scope.listaProdutos = dados;
			}


			);
 

}


$scope.listar();




})