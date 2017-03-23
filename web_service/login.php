<?php
error_reporting(0);
require "db_config.php";
 
$id = $_POST["id"];
$mot_de_passe = $_POST["mot_de_passe"];
 
$sql = "SELECT * FROM `utilisateur` WHERE `id`='".$id."' AND `mot_de_passe`='".$mot_de_passe."';";
 
$result = mysqli_query($con, $sql);
 
$response = array();
 
while($row = mysqli_fetch_array($result)){
    $response = array("id"=>$row[0],"mot_de_passe"=>$row[1]);
}
 
echo json_encode(array("user"=>$response));
 
?>