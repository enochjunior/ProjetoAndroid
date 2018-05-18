<?php

require "conexao.php";

$codigo = "HEM";//$_POST["codigo"];


$sql_query = "select * from exame where codigo = '$codigo';";

$result = mysqli_query($con, $sql_query);


if(mysqli_num_rows($result) > 0){

while ($row = mysqli_fetch_array($result)) {
$row = json_encode("HEM");


echo $codigo;

}


} else {

	
echo "não há exames cadastrados";

}


?>