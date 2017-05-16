var app = angular.module('SistemaAcademico',['ngRoute']);

app.config(['$routeProvider',
      function($routeProvider) {
    $routeProvider.
      when('/cadastro_disciplina', {
        templateUrl: 'disciplina.html',
        controller: 'DisciplinaController'
      }).
      when('/cadastro_turma', {
        templateUrl: 'turma.html',
        controller: 'TurmaController'
      }).
      when('/cadastro_aluno', {
        templateUrl: 'aluno.html',
        controller: 'AlunoController'
      });
}]);

