app.controller('ProdutoController',function($scope,$http){

	
	$scope.produto = {};
	$scope.produto.categoria = {};

	$scope.listaCategoria = [];
	

	$scope.gravar = function(){	
		$scope.produto.valor = parseFloat($scope.produto.valor).toFixed(2);
		$scope.produto.categoria = JSON.parse($scope.produto.categoria);	
		$http.post('http://localhost:8080/ExemploRest/rest/produto', $scope.produto).success(
			function(dados){
				$scope.produto = {};				
				alert(dados);
			}

			);
	}

	$scope.listarCategorias = function(){

$http.get('http://localhost:8080/ExemploRest/rest/categoria').success(
			function(dados){
				$scope.listaCategoria = dados;
			}


			);

}
$scope.listarCategorias();

})