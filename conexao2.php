<?php

require_once 'config.php';



class DB_Connection {

	private $connect;
	
	function __construct() {


		$this->connect = mysqli_connect(hostaname, username, password, db_name) echo "conectado"; //or die( DB_connection  error);


			}

			public function get_connection(){


				return $this->connect;
			}
}


?>