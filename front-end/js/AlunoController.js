app.controller('AlunoController',function($scope,$http){

	$scope.listaAlunos = [];
	$scope.aluno = {};
	$scope.aluno.turma = {};

	$scope.listarTurma = function(){
		$http.get('http://localhost:8080/ExemploRest/rest/turmas').success(

			function(dados){
				$scope.listaTurmas = dados;

			}


			);
	}

	$scope.listar = function(){
		$http.get('http://localhost:8080/ExemploRest/rest/alunos').success(
			function(dados){
				$scope.listaAlunos = dados;
			}


			);
	}

	$scope.gravar = function(){
		$scope.aluno.turma = JSON.parse($scope.aluno.turma);
		$http.post('http://localhost:8080/ExemploRest/rest/alunos', $scope.aluno).success(
			function(dados){
				$scope.aluno = {};
				$scope.listar();
				alert(dados);
			}

			);
	}

	$scope.remover = function(aluno){
		$http.delete('http://localhost:8080/ExemploRest/rest/alunos/'+aluno.id).success(
			function(dados){
				$scope.listar();
				alert(dados);

			}


			);
	}

	$scope.alterar = function(){
		$http.put('http://localhost:8080/ExemploRest/rest/alunos', $scope.aluno).success(
			function(dados){
				$scope.aluno = {};
				$scope.listar();
				alert(dados);
			}

			);
	}

	$scope.buscar = function(aluno){
		$http.get('http://localhost:8080/ExemploRest/rest/alunos/'+aluno.id).success(
			function(dados){
				$scope.alunos = dados;

			}

			);

	}


	$scope.listarTurma();
	$scope.listar();



	
})