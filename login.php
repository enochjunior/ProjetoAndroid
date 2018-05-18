<?php

require "conexao.php";

$usuario = $_POST["nome"];
$senha = md5($_POST["senha"]);

$sql_query = "select * from usuario where nome = '$usuario' and senha = '$senha';";

$result = mysqli_query($con, $sql_query);

if(mysqli_num_rows($result) > 0){
//$row = mysqli_fetch_assoc($result);

//$nome = $row["nome"];

echo "logado ";//.$nome;


}

else {

	

echo "Erro no login, usuário ou senha inválidos";
}

?>