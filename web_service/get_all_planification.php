<?php
include("config.php");
   session_start(); 
/*
 * Following code will list all the products
 */
 
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/db_connect.php';
 
// connecting to db
$db = new DB_CONNECT();
 
// get all planification from planification table
$result = mysql_query("SELECT *FROM planification") or die(mysql_error());
 
// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // planification node
    $response["planification"] = array();
 
    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $planification = array();
        $planification["id"] = $row["id"];
        $planification["tache"] = $row["tache"];
        $planification["nature"] = $row["nature"];
        $planification["date_debut"] = $row["date_debut"];
        $planification["date_fin"] = $row["date_fin"];
		$planification["id_projet"] = $row["id_projet"];
 
        // push single planification into final response array
        array_push($response["planification"], $planification);
    }
    // success
    $response["success"] = 1;
 
    // echoing JSON response
    echo json_encode($response);
} else {
    // no planificaation found
    $response["success"] = 0;
    $response["message"] = "No planification found";
 
    // echo no users JSON
    echo json_encode($response);
}
?>