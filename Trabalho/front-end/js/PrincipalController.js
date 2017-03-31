app.controller('PrincipalController',function($scope){
$scope.listaProdutos = [];

	
$scope.listaCategorias = [
{categoria:" ",nome:"Todos"},
{categoria:"hardware",nome: "Hardware"},
{categoria:"software",nome: "Software"},
{categoria:"periferico",nome: "Periferico"}

];



$scope.adicionar = function(produto){
	alert("Foi adicionado "+produto.nome+" ao carrinho com sucesso!");
}

$scope.listarProdutos = function(){
  $scope.listaProdutos = [

{categoria: "Hardware ",codigo:"001",nome:'SSD SanDisk',valor:399.99},
{categoria: "Hardware ",codigo:'145',nome:'Placa de Vídeo Gtx 1080Ti',valor:2999.90},
{categoria: "Hardware ",codigo:"235",nome:'Processador i5 7600k',valor:1499.90},
{categoria: "Hardware ",codigo:"876",nome:'Memória DDR4 16GB ',valor:299.90},
{categoria: "Software ",codigo:"100",nome:'anti-virus',valor:29.90},
{categoria: "Software ",codigo:"951",nome:'S.O',valor:290.90},
{categoria: "Periferico ",codigo:"355",nome:'Teclado',valor:39.90},
{categoria: "Periferico ",codigo:"777",nome:'Mouse',valor:390.90},
{categoria: "Periferico ",codigo:"223",nome:'Web Cam',valor:390.90}
];

}


$scope.listarProdutos();

$scope.teste = function(){
	alert($scope.produto.categoria);

}

})