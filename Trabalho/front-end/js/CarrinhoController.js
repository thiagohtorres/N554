app.controller('CarrinhoController',function($scope){
	$scope.listaProdutos = [];

	
$scope.listarProdutos = function(){
  $scope.listaProdutos = [

{codigo:'001',nome:'SSD SanDisk',valor:399.99},
{codigo:'002',nome:'Placa de Vídeo Gtx 1080Ti',valor:3999.90},
{codigo:'003',nome:'Processador i5 7600k',valor:1299.90},
{codigo:'004',nome:'Memória DDR4 16GB 2133Mhz',valor:399.90},
{codigo:'005',nome:'Fonte Corsair 600W',valor:390.90}

];

}

$scope.remover = function(produto){
	$scope.listaProdutos.splice(produto,1);
	
}
$scope.comprar = function(){
	$scope.listaProdutos = [];
	alert("Obrigado pela Compra!");
}


$scope.listarProdutos();

});