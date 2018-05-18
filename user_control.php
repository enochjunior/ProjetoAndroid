<?php

require_once 'conexao2.php';



class User {

	private $db;
	private $connection;

	
	function __construct() {

		$this->db = new DB_Connection();
		$this->connection = $this->db->get_connection();
	}
}

$user = new User();
if (isset($_POST["nome"], $_POST["senha"])) {

	$nome = $_POST["nome"];
	$senha = $_POST["senha"];

	if (!empty($nome) && !empty(&senha)) {

		$crip = md5($senha);
		$user -> user_exist($nome, $crip);


	}else{


		echo jason_encode("Preencha todos os campos");
	}

}






?>