app.controller('ProdutoController',function($scope,$http){

	
	$scope.produto = {};
	$scope.produto.categoria = {};

	

	$scope.gravar = function(){
		$scope.produto.categoria = JSON.parse($scope.produto.categoria);
		$http.post('http://localhost:8080/ExemploRest/rest/produto', $scope.produto).success(
			function(dados){
				$scope.produto = {};				
				alert(dados);
			}

			);
	}	
})