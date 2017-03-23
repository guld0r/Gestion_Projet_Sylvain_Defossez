<?php
include("config.php");
   session_start();
/*
 * Following code will create a new product row
 * All product details are read from HTTP Post Request
 */
 
// array for JSON response
$response = array();
 
// check for required fields
if (isset($_POST['tache']) && isset($_POST['nature']) && isset($_POST['date_debut'])&& isset($_POST['date_fin'])&& isset($_POST['id_projet'])) {
 
    $tache = $_POST['tache'];
    $nature = $_POST['nature'];
    $date_debut = $_POST['date_debut'];
	$date_fin = $_POST['date_fin'];
	$id_projet = $_POST['id_projet'];
 
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $db = new DB_CONNECT();
 
    // mysql inserting a new row
    $result = mysql_query("INSERT INTO planification(tache, nature, date_debut, date_fin, id_projet) VALUES('$tache', '$nature', '$date_debut', '$date_fin', '$id_projet')");
 
    // check if row inserted or not
    if ($result) {
        // successfully inserted into database
        $response["success"] = 1;
        $response["message"] = "Planification successfully created.";
 
        // echoing JSON response
        echo json_encode($response);
    } else {
        // failed to insert row
        $response["success"] = 0;
        $response["message"] = "Oops! An error occurred.";
 
        // echoing JSON response
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}
?>