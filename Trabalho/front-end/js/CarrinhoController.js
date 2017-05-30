app.controller('CarrinhoController',function($scope,$http){
	$scope.listaProdutos = [];

	
$scope.listarProdutos = function(){
  $http.get('http://localhost:8080/ExemploRest/rest/produto/carrinho').success(
			function(dados){
				$scope.listaProdutos = dados;
			}


			);

}

$scope.remover = function(produto){

	$http.delete('http://localhost:8080/ExemploRest/rest/produto/'+produto.id).success(
    function(dados){
      $scope.listarProdutos();
      alert(dados);
    }
	);
	
}

$scope.comprar = function(){
	$scope.listaProdutos = [];
	alert("Obrigado pela Compra!");
}


$scope.listarProdutos();

});