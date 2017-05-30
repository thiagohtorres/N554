app.controller('ProdutoController',function($scope,$http){

	
	$scope.produto = {};
	$scope.produto.categoria = {};

	$scope.listaCategorias = [
	{nome:"Hardware"},
	{nome:"Software"},
	{nome:"Periféricos"}
];
	

	$scope.gravar = function(){	
		$scope.produto.valor = parseFloat($scope.produto.valor).toFixed(2);	
		$http.post('http://localhost:8080/ExemploRest/rest/produto', $scope.produto).success(
			function(dados){
				$scope.produto = {};				
				alert(dados);
			}

			);
	}	
})