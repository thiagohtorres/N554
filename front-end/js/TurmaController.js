app.controller('TurmaController', function($scope,$http){

	$scope.listaTurmas = [];

 $scope.turma = {}; 
 $scope.turma.disciplina = {};
 $scope.listaAlunos = [];

$scope.listaSemestres = [  
  {valor: "2016.1"},
  {valor: "2016.2"},
  {valor: "2017.1"},
  {valor: "2017.2"},
  {valor: "2018.1"},
  {valor: "2018.2"}
];




$scope.listarDisciplina = function(){
  $http.get('http://localhost:8080/ExemploRest/rest/disciplinas').success(
    function(dados){
      $scope.listaDisciplinas = dados;


    }

    );

}

$scope.listar = function(){
  $http.get('http://localhost:8080/ExemploRest/rest/turmas').success(
    function(dados){
      $scope.listaTurmas = dados;

    }


    );
}

$scope.gravar = function(){

  $scope.turma.disciplina = JSON.parse($scope.turma.disciplina);

  $http.post('http://localhost:8080/ExemploRest/rest/turmas', $scope.turma).success(
    function(dados){
      $scope.turma = {};
      $scope.listar();
      alert(dados);

    }

    );
  

}

$scope.remover = function(turma){
	
	$http.delete('http://localhost:8080/ExemploRest/rest/turmas/'+turma.id).success(
    function(dados){
      $scope.listar();
      alert(dados);
    }




    );




}

$scope.buscar = function(turma){

  $http.get('http://localhost:8080/ExemploRest/rest/turmas/'+turma.id).success(

    function(dados){
      $scope.turma = dados;

    }

    );
    $http.get('http://localhost:8080/ExemploRest/rest/alunos/turm/'+turma.id).success(

    		function(dados){
      			$scope.listaAlunos = dados;

    		}

    		);

}

$scope.alterar = function(){
  $scope.turma.disciplina = JSON.parse($scope.turma.disciplina);

  $http.put('http://localhost:8080/ExemploRest/rest/turmas',$scope.turma).success(

      function(dados){
        $scope.turma = {};
        $scope.listar();
        alert(dados);
      }



      );

}

$scope.listarDisciplina();

$scope.listar();

})