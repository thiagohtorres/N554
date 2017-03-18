app.controller('DisciplinaController',function($scope, $http)
{
	//$scope.disciplina={};
    $scope.listaDisciplinas = [];
	

	$scope.remover = function(disciplina)	{

		$scope.listaDisciplinas.splice($scope.listaDisciplinas.indexOf(disciplina),1);


	}


	$scope.gravar =function(){


		$http.post('http://localhost:8080/ExemploRest/rest/disciplinas', $scope.disciplina).success(

			function(dados){
				$scope.disciplina = {};
				$scope.listar();
				alert(dados);

			}


			);

	}




	$scope.listar =function(){


		$http.get('http://localhost:8080/ExemploRest/rest/disciplinas').success(

			function(dados){
				$scope.listaDisciplinas = dados;
			}


			);

	}

	$scope.listar();



});
