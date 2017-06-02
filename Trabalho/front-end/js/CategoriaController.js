app.controller('CategoriaController',function($scope,$http){
	$scope.listaCategoria = [];

	
$scope.listarCategorias = function(){
  $http.get('http://localhost:8080/ExemploRest/rest/categoria').success(
			function(dados){
				$scope.listaCategoria = dados;
			}


			);

}

$scope.remover = function(categoria){

	$http.delete('http://localhost:8080/ExemploRest/rest/categoria/'+categoria.id).success(
    function(dados){
      $scope.listarCategorias();
      alert(dados);
    }
	);
	
}

$scope.gravar = function(){			
		$http.post('http://localhost:8080/ExemploRest/rest/categoria', $scope.categoria).success(
			function(dados){
				$scope.categoria = {};
                $scope.listarCategorias();				
				alert(dados);
			}

			);
	}


$scope.listarCategorias();

});