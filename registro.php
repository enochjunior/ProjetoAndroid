<?php

require "conexao.php";

$nome = $_POST["nome"];
$senha = md5($_POST["senha"]);
$permissao = $_POST["permissao"];
//$status = $_POST["status"];

$sql_query1 = "select * from usuario where nome = '$nome' ";


$result = mysqli_query($con, $sql_query1);

if (mysqli_num_rows($result) > 0 ){
	
	echo "Usuário já cadastrado";

	

}else{

    
	$sql_query = "insert into usuario(nome, senha, permissao) values ('$nome','$senha','$permissao');";
	$result2 = mysqli_query($con, $sql_query);

if($result2){

echo "Dados inseridos com sucesso!";

}

else{

echo "Erro ao registrar dados ".mysqli_error($con);

}

}

?>