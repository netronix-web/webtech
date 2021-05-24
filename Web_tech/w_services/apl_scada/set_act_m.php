<?php # Script - val_tp.php
// Aceasta pagina modifica valorile tuturor punctelor de masura . 
echo'
<head>
	<script type="text/javascript" src="wz_jsgraphics.js"></script>
	<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
	<title> ACTUATOARE </title>
</head>';
require_once ('mysql_con_cons_el.php'); // Conectare la baza de date.
// Manipularea form-ului.
if (isset($_POST['trimis'])) {
	for($i=1;$i<15;$i++){
	// inscriu variabilele rc1,ro1,rcl1,rop1 ... rc14,ro14,rcl41,rop14 cu valorile extrase din $_POST['rd1']...$_POST['rd14']
			$v="rc".$i;
			$x="ro".$i;
			$y="rcl".$i;
			$z="rop".$i;
			$w="rw".$i;
			$a="rd_".$i;
			
			$$v=0;
			$$x=0;
			$$y=0;
			$$z=0;
			$$w=0;			
							
		if($_POST[$a]==1){
			$$v=1;
			$$x=0;
			$$y=0;
			$$z=0;
			$$w=0;
		}
		if($_POST[$a]==2){
			$$v=0;
			$$x=1;
			$$y=0;
			$$z=0;
			$$w=0;
		}
		if($_POST[$a]==3){
			$$v=0;
			$$x=0;
			$$y=1;
			$$z=0;
			$$w=0;
		}
		if($_POST[$a]==4){
			$$v=0;
			$$x=0;
			$$y=0;
			$$z=1;
			$$w=0;
		}
		if($_POST[$a]==5){
			$$v=0;
			$$x=0;
			$$y=0;
			$$z=0;
			$$w=1;
		}	
		
								
	}// gata for

// Realizare query.		
			$n_c=0;
			for($i=1;$i<15;$i++){
				
			$v="rc".$i;
			$vv=$$v;
			$x="ro".$i;
			$xx=$$x;
			$y="rcl".$i;
			$yy=$$y;
			$z="rop".$i;
			$zz=$$z;
			$w="rw".$i;
			$ww=$$w;
			
			$query = "UPDATE actuators SET valve_close='$vv',  valve_open='$xx', valve_closing='$yy', valve_opening='$zz', warnings='$ww' WHERE act_id=$i";
			$result = @mysql_query ($query); // rularea query-ului.
				if (mysql_affected_rows() == 1){
					$n_c++;
				}
			}
													
			if ($n_c >=0) { // Daca au rulat corect toate queryurile.
							// Print a message.
				//echo '<p><font color="navy" size="2"> Va multumim! <br>Noile valori au fost inregistrate!.</p>';
				//mysql_close(); // Close the database connection.
				echo '</td></tr></table></center>
				</div>';
				$url = 'http://' . $_SERVER['HTTP_HOST'] . dirname($_SERVER['PHP_SELF']);
				if ((substr($url, -1) == '/') OR (substr($url, -1) == '\\') ) {
					$url = substr ($url, 0, -1); // Chop off the slash.
				}
				// Add the page.
				//$url .= '/set_act_m.php';
				//mysql_close(); // Close the database connection.
				//ob_end_clean(); // Delete the buffer.
				//echo '<center><table border=1><tr><td colspan="2"><center> <font color="Red" size="2">Valorile au fost trimise!</center></td></tr>';
				//echo '<tr><td><font color="Blue" size="2">Trimite alte valori </td><td><a href="set_act_m.php"> <img src="sg.gif"> </a> </td> </tr>';
				//echo '</table></center>';
				//exit();	
				//header("Location: $url");
				//exit(); // Quit the script.

													
			} else { // Daca nu a rulat corect
				echo '<p><font color="red" size="2"> Nu s-a putut face inregistrarea din cauza unei erori de sistem. Ne cerem scuze !.</font></p>'; 
				mysql_close(); // Inchiderea conectarii spre baza de date.
				echo '</td></tr></table></center>
				</div>';		
				exit();
			}		

}

// Afisare form tot timpul
// Obtinerea informatiilor din baza de date.
$query = "SELECT act_id, valve_close, valve_open, valve_closing, valve_opening , warnings FROM actuators ORDER BY act_id LIMIT 0, 14";		
$result = @mysql_query ($query); // Rulare query.
echo '
<form name="fm" action="set_act_m.php"  method="post">
<table bgcolor="#D9E3EE" border=1><tr><td><font color="Black" size="1">
<img src="config.bmp">';
$i=0;
for($i=1;$i<15;$i++){
$row = mysql_fetch_array($result, MYSQL_ASSOC);
echo '</td><td align="center"><font color="Black" size="2">' . $row['act_id'].'<br>' ;
echo'<INPUT TYPE = "radio" NAME="rd_'.$i.'" VALUE = "1"'; if ($row['valve_close']==1) echo ' checked'; echo'/><br>';
echo'<INPUT TYPE = "radio" NAME="rd_'.$i.'" VALUE = "2"'; if ($row['valve_open']==1) echo ' checked'; echo'/><br>';
echo'<INPUT TYPE = "radio" NAME="rd_'.$i.'" VALUE = "3"'; if ($row['valve_closing']==1) echo ' checked'; echo'/><br>';
echo'<INPUT TYPE = "radio" NAME="rd_'.$i.'" VALUE = "4"'; if ($row['valve_opening']==1) echo ' checked'; echo'/><br>';
echo'<INPUT TYPE = "radio" NAME="rd_'.$i.'" VALUE = "5"'; if ($row['warnings']>0) echo ' checked'; echo'/><br>';
}

echo '</td><td><center><input type="submit" name="submit" value="Modific" /></center>';
echo '<input type="hidden" name="trimis" value="TRUE" />';
echo '</form>';

mysql_free_result ($result); // Eliberarea resurselor.	
mysql_close(); // Close the database connection.
echo '</td></tr></table></center>';

?>