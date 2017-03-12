<?php
	function send_notification ($tokens,$message){
		$url = "https://fcm.googleapis.com/fcm/send";
		$fields = array(
			'registration_ids' => $tokens,
			'notification' => $message
			);
		$headers = array(
			'Authorization:key=AIzaSyBX5yQAwIGjvVZ2-S0kWel1yShC06Tw400',
			'Content-Type:application/json'
			);
		$ch = curl_init();
       	curl_setopt($ch, CURLOPT_URL, $url);
       	curl_setopt($ch, CURLOPT_POST, true);
       	curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
       	curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
       	curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);  
       	curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
       	curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($fields));
       	$result = curl_exec($ch);           
       	if ($result === FALSE) {
   	    	die('Curl failed: ' . curl_error($ch));
       	}
       	curl_close($ch);
       	return $result;
	}
	
	$conn = mysqli_connect("localhost","root","","trackerapp");
	$sql = " Select Token From users";	
	$result = mysqli_query($conn,$sql);
	$tokens = array();
	if(mysqli_num_rows($result) > 0 ){
		while ($row = mysqli_fetch_assoc($result)) {
			$tokens[] = $row["Token"];
		}
	}
	mysqli_close($conn);
	if(isset($_POST["DATA"])){
		$message = $_POST["DATA"];
	}
	else{
		$message = "hello";
	}
	$notification = array("text" => $message,"sound" => "default","icon" => "applaunchericon");
	$message_status = send_notification($tokens, $notification);
	echo $message_status;


?>