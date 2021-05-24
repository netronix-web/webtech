<?php # Script - electr_set_m.php
// Aceasta pagina modifica toate campurile val din tabela "electr".
echo'
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
	<title>  Valori </title>
</head>
<body>';
//include ('meniu.php');
require_once ('con_mysqli.php'); // Conectare la baza de date.
// Manipularea form-ului.
if (isset($_POST['trimis'])) {
		for($i=1;$i<5;$i++){
			$a="val_".$i;
			$b="v".$i;
			$$b=$_POST[$a]; // inscriu variabilele v1..v7 cu valorile $_POST['v1']...$_POST['v7']
		}

			// Realizare query.		
			$n_c=0;
			$i=1;
			for($i=1;$i<5;$i++){	
				$a="v".$i;
				$v=$$a;
				$query = "UPDATE electr SET val='$v' WHERE id_el=$i";
				$result = @mysqli_query ($db,$query); // rularea query-ului.
				if (mysqli_affected_rows($db) == 1){
					$n_c++;
				}
			}									
			if ($n_c >=0) { // Daca au rulat corect toate queryurile.
				$url = 'http://' . $_SERVER['HTTP_HOST'] . dirname($_SERVER['PHP_SELF']);
				if ((substr($url, -1) == '/') OR (substr($url, -1) == '\\') ) {
					$url = substr ($url, 0, -1); // Chop off the slash.
				}
													
			} else { // Daca nu a rulat corect
				echo '<p><font color="red" size="2"> Nu s-a putut face inregistrarea din cauza unei erori de sistem. Ne cerem scuze !.</font></p>'; 
				mysqli_close($db); // Inchiderea conectarii spre baza de date.
				echo '</td></tr></table></center>
				</div>';		
				exit();
			}		

}
// Afisare form tot timpul
// Obtinerea informatiilor din baza de date.
$query = "SELECT id_el, val, max, min, um FROM electr ";
$result = mysqli_query ($db,$query); // Rulare query.
echo '
<center><table border =1 ><tr>
<td height="20" width="500" bgcolor="magenta"><font color= "white" size="4" ><center><b> Setarea tuturor campurilor val din tabela "electr" </></center></font>
</td></tr><tr><td><font color= "blue" size="3" >
<form id="dte" action="electr_set_m.php" method="post" >
<table border=1 width="550">';
$i=1;
echo'
	<tr>
		<td width="50" align="center">id_el</td>
		<td width="200" align="center"></td>
		<td width="75" align="center">val</td>
		<td width="75" align="center">max</td>
		<td width="50" align="center">um</td>
	</tr>';
while ($row = mysqli_fetch_array($result)) {
	echo '
	<tr>
		<td width="50"><center><font color="Black" size="2">' . $row['id_el'] . '</center></td>
		<td width="200"><input type="range" name="val_' .$i. '" value="' . $row['val'] . '" id="fr_id' .$i. '" min="'. $row['min'] .'" max="'. $row['max'] .'"  onchange="trimit()"/></td>
		<td width="75" align="right">' . $row['val']. '</td>
		<td width="75" align="right">' . $row['max']. '</td>
		<td width="50" align="right">' . $row['um']. '</td>';
		$i++;
}
echo'
<input type="hidden" name="trimis" value="TRUE" />
<script>
function trimit() {
	document.getElementById("dte").submit();
}
</script>
</td></tr></table>
</form>
</center></td></tr></table>';
mysqli_free_result ($result); // Eliberarea resurselor.	
mysqli_close($db); // Close the database connection.
echo '</td></tr></table></center>
</body>
</html>';
?>