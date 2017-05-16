app.controller('DisciplinaController',function($scope, $http)
{
	//$scope.disciplina={};
    $scope.listaDisciplinas = [];
	$scope.listaTurmas = [];
	

	$scope.remover = function(disciplina)	{

		$http.delete('http://localhost:8080/ExemploRest/rest/disciplinas/'+disciplina.id).success(

			function(dados){				
				$scope.listar();
				alert(dados);


			}


			);		


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
	

	$scope.busca = function(disciplina){

		$http.get('http://localhost:8080/ExemploRest/rest/disciplinas/'+ disciplina.id).success(
			function(dados){
				$scope.disciplina = dados;
				
			}

			);

			$http.get('http://localhost:8080/ExemploRest/rest/turmas/disc/'+disciplina.id).success(

    		function(dados){
      			$scope.listaTurmas = dados;

    		}

    		);
	}		

  		

	


	

	

	$scope.alterar = function(){


		$http.put('http://localhost:8080/ExemploRest/rest/disciplinas',$scope.disciplina).success(

			function(dados){
				$scope.disciplina = {};
				$scope.listar();
				alert(dados);
			}



			);

	}

	$scope.listar();
	



});
