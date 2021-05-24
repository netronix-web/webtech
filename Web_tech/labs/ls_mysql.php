<html>
<title> Laborator MySQL </title>
<body>

<table width="100%">
<tr><td height="50" background="../../Images/imm_s.bmp"><center><font color= "white" size=5> Laborator MySQL </Center></TD></TR>
</table>
<a name="start"></a>
<font color= "Blue" size=5> Tematica lucrari  </font><br><br>

<li>Instalare XAMPP 
<ol>
<li> Se descarca de pe net <a href="https://www.apachefriends.org/ro/download.html" target="download">https://www.apachefriends.org/ro/download.html</a>
<li> Se lanseaza xampp-setup
<li> Se lanseaza xampp-start
<li> Se verifica existenta folder-ului htdocs in care se gaseste index.html si index.php
<li> Se lanseaza  http://localhost sau http://127.0.0.1
<li> Se lanseaza phpMyAdmin
<li> Se creaza baza de date "cons_el"

</ol> 

<li> Aplicatii pentru gestionarea tabelei "sondaj"
<ol>
<li> Utilizati phpMyAdmin pentru crearea tabelei "sondaj" in cadrul bazei de date "cons_el"
<li> Se creaza tabela "sondaj" cu urmatoarele campuri
 <ol>
	<li> v_id		integer
    <li> v_rasp 	text
	<li> proc 	decimal 5,2
 </ol>
<br>&nbsp;&nbsp;&nbsp;&nbsp; -  unde <b> v_id </b> cheie primara,  <b> v_rasp </b> varianta de raspuns  <b>proc </b> procentul cu care s-a raspuns la 
respectiva varianta de raspuns.

<br>&nbsp;&nbsp;&nbsp;&nbsp; - conectarea la baza de date "cons_el", se face cu:

<br><br><!------------------------------------------------------------------->
<textarea style="width:100%;height:240px" name="code" wrap="logical" rows="12" cols="42">
&lt?php # Script con_mysqli.php
// Acest script realizeaza conectarea la baza de date "cons_el"
// Setarea informatiilor necesare conectarii la baza de date.
DEFINE ('DB_USER', 'student');
DEFINE ('DB_PASSWORD', 'psw');
DEFINE ('DB_HOST', '127.0.0.1');
DEFINE ('DB_NAME', 'cons_el');
$db = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME);

if (!$db) {
    die('Connect Error (' . mysqli_connect_errno() . ') '. mysqli_connect_error());
}
?&gt
</textarea>
<!------------------------------------------------------------------->
<li> Utilizati phpMyAdmin pentru a introduce 5 linii in tabela sondaj.
<li> Se citesc date din tabela "sondaj" si se afiseaza rezultat sub forma:
<!---------------------Rulare aplicatie-----------------------------------------><br><br>
<?php # Script sondaj_afis.php
include ('meniu.php');
require_once ('con_mysqli.php'); // Conectare la baza de date.
$query = "SELECT v_id, v_rasp, proc FROM sondaj ";
	
$result = mysqli_query ($db,$query); // Rulare query.
$bg = '#dddddd'; // Seare culoare background.
echo '<center><table border =1 ><tr>
<td height="30" width="500" bgcolor="magenta"><font color= "white" size="4" ><center><b> Afisrea tabelei "sondaj" </></center></font>
</td></tr><tr><td><font color= "blue" size="3" >';
echo $query;
echo '</td></tr><tr><td><center><table border=1>';
while ($row = mysqli_fetch_array($result)) {
	$bg = ($bg=='#dddddd' ? '#ffffff' : '#dddddd'); // Schimbare culoare background.
	echo '<tr bgcolor="' . $bg . '" >
		<td align="center" width="40">' . $row['v_id'] . '</td>
		<td align="left" width="400"> - ' . $row['v_rasp'] . '</td>
		<td align="right" width="60">' . $row['proc'] . '</td>
	</tr>
	';
}
echo '</table></center></table></center>';
mysqli_free_result ($result); // Eliberarea resurselor.
//mysqli_close($db); // Inchiderea conexiunii spre baza de date
?>
<!---------------------Sfarsit aplicatie---------------------------------------->


<li> Se citesc date din tabela "sondaj" si se afiseaza rezultat sub forma:

<!---------------------Rulare aplicatie-----------------------------------------><br><br>

<?php # Script sondaj_afis.php
include ('meniu.php');
require_once ('con_mysqli.php'); // Conectare la baza de date.
$query = "SELECT v_id, v_rasp, proc FROM sondaj ";
	
$result = mysqli_query ($db,$query); // Rulare query.
$bg = '#dddddd'; // Seare culoare background.
echo '<center><table border =1 ><tr>
<td height="30" width="500" bgcolor="magenta"><font color= "white" size="4" ><center><b> Afisrea tabelei "sondaj" </></center></font>
</td></tr><tr><td><font color= "blue" size="3" >';
echo '</td></tr><tr><td><center><table border=1>';
while ($row = mysqli_fetch_array($result)) {
  $pr=400/100*$row['proc'];
  echo'
	<tr>
	 <td width="280">'. $row['v_rasp'] .'</td><td width="70">'.$row['proc'].'%</td> 
	 <td width=400> <hr color ="red" size="5" align="left" width="'.$pr.'"></td>  	
	</tr>';
}
echo '</table></center></table></center>';
mysqli_free_result ($result); // Eliberarea resurselor.
//mysqli_close($db); // Inchiderea conexiunii spre baza de date
?>
</ol> 
<!---------------------Sfarsit aplicatie---------------------------------------->

<li> Aplicatii pentru gestionarea tabelei "electr"
<ol>
<li> Crearea tabelei "electr" in cadrul bazei de date "cons_el" 
<!------------------------------------------------------------------->
<br><br>&nbsp;&nbsp;&nbsp;&nbsp; - se creaza tabela electr din PhpMyAdmin sau din comanda SQL:
<br><br><!------------------------------------------------------------------->
<textarea style="width:100%;height:650px" name="code" wrap="logical" rows="12" cols="42">
-- phpMyAdmin SQL Dump
-- version 2.11.4
-- http://www.phpmyadmin.net
--
-- Gazda (Host): localhost
-- Timp de generare: Mai 26, 2010 at 09:35 AM
-- Versiune server: 5.0.51
-- Versiune PHP: 5.2.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Baza de date: `cnos_el`
--

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `electr`
--

CREATE TABLE IF NOT EXISTS `electr` (
  `id_el` int(10) unsigned NOT NULL,
  `val` decimal(14,2) NOT NULL,
  `min` decimal(14,2) NOT NULL,
  `max` decimal(14,2) NOT NULL,
  `um` varchar(10) NOT NULL,
  PRIMARY KEY  (`id_el`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `electr`
--

INSERT INTO `electr` (`id_el`, `val`, `min`, `max`, `um`) VALUES
(1, 20.25, 20.00, 250.00, 'Volt'),
(2, 24.22, 10.00, 200.00, 'Volt'),
(3, 2.25, 0.25, 15.00, 'mV');
</textarea>
<li> Se citeste max, val, um din baza de date si se afiseaza grafic. 

<!---------------------Rulare aplicatie-----------------------------------------><br><br>
<center><table bgcolor="WhiteSmoke" border =1 width="700"><tr><td>
<?php
echo'
<html>
<body> ';
require_once ('con_mysql.php'); // Conectare la baza de date.
$query = "SELECT id_el, val, max, min, um FROM electr ";		
$result = @mysql_query ($query); // Rulare query.
$row = mysql_fetch_array($result, MYSQL_ASSOC); 
$max=$row['max'];
$val=$row['val'];
$um=$row['um'];
$consum=400/$max*$val;
echo'
<center> 
<table bgcolor="WhiteSmoke" border ="0" width="700"><tr><td colspan="2">
<center>
<font size=4 color="blue"> Grafic</font>
</td></tr><tr>
<td align="left">
	<table border ="1" width="100%">
	 <tr>
		<td width="75">'.$row['max'].'</td>
		<td width="75">'.$row['val'].'</td>
		<td width="400"><hr color ="red" size="5" align="left" width="'.$consum.'"color ="red"></td>
		<td align="center">' . $row['um'] . '</td>
	 </tr>
    </table>
</td>
</center>
</td></tr></table></center>  
</body>
</html></td></tr></table></center>  ';
?>
</table></center>
<!---------------------Sfarsit aplicatie---------------------------------------->


<li>Afisarea valorica a tuturor inregistrarilor 


<!---------------------Rulare aplicatie-----------------------------------------><br><br>
<?php # Script electr_afis.php
require_once ('con_mysqli.php'); // Conectare la baza de date.
$query = "SELECT id_el, val, max, min, um FROM electr ";
	
$result = mysqli_query ($db,$query); // Rulare query.
$bg = '#dddddd'; // Seare culoare background.
echo '<center><table border =1 ><tr>
<td height="20" width="400" bgcolor="magenta"><font color= "white" size="4" ><center><b> Afisrea tabelei "electr" </></center></font>
</td></tr><tr><td><font color= "blue" size="3" >';
echo $query;
echo '</td></tr><tr><td><center><table border=1>';
while ($row = mysqli_fetch_array($result)) {
	$bg = ($bg=='#dddddd' ? '#ffffff' : '#dddddd'); // Schimbare culoare background.
	echo '<tr bgcolor="' . $bg . '" >
		<td align="center" width="40">' . $row['id_el'] . '</td>
		<td align="center" width="90">' . $row['val'] . '</td>
		<td align="center" width="90">' . $row['max'] . '</td>
		<td align="center" width="90">' . $row['min'] . '</td>
		<td align="center" width="90">' . $row['um'] . '</td>
	</tr>
	';
}
echo '</table></center></table></center>';
mysqli_free_result ($result); // Eliberarea resurselor.
//mysqli_close($db); // Inchiderea conexiunii spre baza de date
?><!---------------------Sfarsit aplicatie---------------------------------------->

<li>Citirea valorica a tuturor inregistrarilor si afisarea grafica a acestora

<!---------------------Rulare aplicatie-----------------------------------------><br><br>
<center><table bgcolor="WhiteSmoke" border =1 width="700"><tr><td>
<?php # Script afisare.php
require_once ('con_mysql.php'); // Conectare la baza de date.
$query = "SELECT id_el, val, max, min, um FROM electr ";		
$result = @mysql_query ($query); // Rulare query.
$bg = '#dddddd'; // Seare culoare background.
echo '<center><table border=1 width="700" ><tr><td><h5>Id_el</td><td><h5>Max</td><td><h5>Min</td><td><h5>Valoare</td><td><h5>Um</td></tr>';

while ($row = mysql_fetch_array($result, MYSQL_ASSOC)) {
	$bg = ($bg=='#dddddd' ? '#ffffff' : '#dddddd'); // Schimbare culoare background.
	$consum=$row['val']*400/$row['max'];
	echo '<tr bgcolor="' . $bg . '">
		<td align="left">' . $row['id_el'] . '</td>
		<td align="center">' . $row['max'] . '</td>
		<td align="center">' . $row['min'] . '</td>
		<td align="left"><table border="1" width="600"><tr><td width="75">'.$row['val'].'</td><td width="400"><hr color ="red" size="5" align="left" width="'.$consum.'"color ="red"></td></tr></table></td>
		<td align="center">' . $row['um'] . '</td>
	</tr>
	';
}
echo '</table>';
echo '</table></center>';
mysql_free_result ($result); // Eliberarea resurselor.
//mysqli_close($db); // Inchiderea conexiunii spre baza de date
?>
</table></center>
<!---------------------Sfarsit aplicatie---------------------------------------->

<br><br>&nbsp;&nbsp;&nbsp;&nbsp; Setarea campurilor val si afisarea grafica a acestora

<br><br><center><iframe src="electr_set_m.php" width="600" height="220"></iframe></center>

<li> Afisarea dinamica a campurilor val

<!---------------------Rulare aplicatie----------------------------------------->
<br><br>
<?php echo '
<script>
function afis_im3(){
	im3.src="electr_im.php?id=2"+"&sid="+Math.random();
	setTimeout("afis_im3()",300);
}
</script>
<center><table border =1 width="500">
	<tr><td height="20" bgcolor="magenta"><center><font color="white" font size="4">
		<b> Afisarea campurilor val din tabela "electr"</b>
	</td></tr>
	<tr><td>
		<center><img src="electr_im.php?id=2"  name="im3">
		<INPUT onclick=afis_im3() type=button value=Start>
	</td></tr>
</center></table></cener>';
?></center>
</ol>
</html>