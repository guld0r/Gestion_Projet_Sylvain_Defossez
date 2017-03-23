<?php
error_reporting(0);
require "db_config.php";
 
$id = $_POST["id"];
$mot_de_passe = $_POST["mot_de_passe"];
 
// get all projet from projet table
$result = mysql_query("SELECT * FROM projet WHERE `id`='".$id."' AND `mot_de_passe`='".$mot_de_passe."';") or die(mysql_error());

 
while($row = mysqli_fetch_array($result)){
    $response = array("id"=>$row[0],"nom"=>$row[1], "date_debut"=>$row[2], "date_fin"=>$row[3], "description"=>$row[4]);
	}
    echo json_encode(array("user"=>$response, "nom"=>$response,"date_debut"=>$response,"d"=>$response,"user"=>$response,));
?>