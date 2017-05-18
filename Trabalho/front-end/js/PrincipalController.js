app.controller('PrincipalController',function($scope){
$scope.listaProdutos = [];

	
$scope.listaCategorias = function(){
	$http.get('http://localhost:8080/ExemploRest/rest/categoria').success(

			function(dados){
				$scope.listaCategoria = dados;

			}


			);
}



$scope.adicionar = function(produto){

	$scope.produto.categoria = JSON.parse($scope.produto.categoria);
		$http.post('http://localhost:8080/ExemploRest/rest/produto/carrinho', $scope.produto).success(
			function(dados){
				$scope.produto = {};
				$scope.listar();
				alert(dados);
			}

			);	
}

$scope.listarProdutos = function(){

$http.get('http://localhost:8080/ExemploRest/rest/produto').success(
			function(dados){
				$scope.listaProdutos = dados;
			}


			);
 

}


$scope.listarProdutos();
$scope.listaCategoria();



})