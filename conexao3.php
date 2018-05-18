<?php


class DadosDB{

    private $Host = "localhost";
    private $Usuario = "root";
    private $Senha = "";
    private $Database = "labfasb";
    private $ConDB = "";
	
	public $lista = array();

    function DadosDB(){
        $this->ConDB = mysqli_connect($this->Host,$this->Usuario, $this->Senha, $this->Database);
        mysqli_set_charset($this->ConDB, "utf8");

        /*$SQL = "select * from usuario where nome = '$usuario' and senha = '$senha';";

        $query = mysqli_query($this->ConDB, $SQL);
			
        while ( $resultado = mysqli_fetch_array( $query, MYSQL_ASSOC ) ) {
               $this->lista[] = $resultado;*/

        }
		mysqli_close($this->ConDB);      
    }


}





?>