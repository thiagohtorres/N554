app.controller('TurmaController', function($scope){

	$scope.listaTurmas = [];

$scope.listaSemestres = [  
  {valor: "2016.1"},
  {valor: "2016.2"},
  {valor: "2017.1"}
];


$scope.listaDisciplinas = [

  {codigo:"T017", nome:"Arquitetura de Aplicações"},
  {codigo:"T008", nome:"Redes I"},
  {codigo:"T409", nome:"Prog. Web"}
];


$scope.gravar = function(){


  $scope.listaTurmas.push($scope.turma);
  $scope.turma = {};

}

$scope.remover = function(turma){
	
	$scope.listaTurmas.splice($scope.listaTurmas.indexOf(turma),1);



}

})