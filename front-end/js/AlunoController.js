app.controller('AlunoController',function($scope){

	$scope.listaAlunos = [];

	$scope.listaTurmas = [
       {semestre:"2016.1",codigo:"T017",nome:"Arquitetura de Aplicações"},
       {semestre:"2016.2",codigo:"T008",nome:"Redes I"},
       {semestre:"2017.1",codigo:"T409",nome:"Prog. Web"}


	];

	$scope.gravar = function(){

		$scope.listaAlunos.push($scope.aluno);
		$scope.aluno = {};
	}

	$scope.remover = function(aluno){
		var alu = $scope.listaAlunos.indexOf(aluno);
		$scope.listaAlunos.splice(alu,1);
	}







	
})