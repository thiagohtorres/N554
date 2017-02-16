app.controller('DisciplinaController',function($scope)
{
	//$scope.disciplina={};
    $scope.listaDisciplinas = [];


	$scope.gravar = function()	{
		$scope.listaDisciplinas.push($scope.disciplina);
		$scope.disciplina = {};
	}

	$scope.remover = function(disciplina)	{

		$scope.listaDisciplinas.splice($scope.listaDisciplinas.indexOf(disciplina),1);


	}



});
