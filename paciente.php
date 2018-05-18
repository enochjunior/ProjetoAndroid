</<?php 

require "conexao.php";

$nome = $_POST["nome"];
$rg = $_POST["rg"];
$sus = $_POST["sus"];
$dn = implode("-", array_reverse(explode("/", $_POST["dn"])));
$sexo = $_POST["sexo"];



$sql_query1 = "select * from paciente where nome = '$nome' and rg = '$rg' and sus = '$sus' ";


$result = mysqli_query($con, $sql_query1);

if (mysqli_num_rows($result) > 0 ){
	
	echo "Paciente já cadastrado";

	

}else{


$sql_query = "insert into paciente (nome,rg, sus, dn, sexo) values ('$nome','$rg','$sus','$dn','$sexo' );";

$result2 = mysqli_query($con, $sql_query);

if($result2){

echo "Dados inseridos com sucesso!";

}

else{

echo "Erro ao registrar dados ".mysqli_error($con);

}

}

 ?>