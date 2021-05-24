<?php # Script: - af_gr_val.php 
echo '
<div id="Continut_p">';
// Se verifica daca form-ul a fost trimis
if (isset($_POST['trimis'])) {

	// Validare mimimala form.
	if ( is_numeric($_POST['max']) && is_numeric($_POST['min']) && is_numeric($_POST['val']) ) {
	
		// Calcularea rezultatelor.
		$val = $_POST['val'] ;
		$max = $_POST['max'] ;
		$min = $_POST['min'] ;
		$val_s=(550/($max-$min))*($val-$min);

		// Afisarea rezultatelor.
echo'
<center>
<table bgcolor="WhiteSmoke" border =1 width="700"><tr><td colspan="2">
<center>
 <font size=4 color="blue"> Reprezentare grafica </font><br> Valoarea minima='.$min.'  Valoarea maxima='.$max.'
</td></tr><tr><td>
<table border=0><tr><td>
<table border=1>
	<tr>
	 <td width="100"> Valoare:'.$val.'</td>
	 <td width=550> <hr color ="red" size="5" align="left" width="'.$val_s.'" color ="red"></td>  	
	</tr>
</table>
</center> 
</td></tr></table></center>  
</body>
</html></td></tr></table></center><br><br>';
	
	} else { // S-au trimis valori invalide.
		echo '<h1>Eroare !</h1>
		<p class="error">Va rog introduceti val_min, val_max si val.</p><p><br /></p>';
	}
	
} else {
	echo '<h1>Afisare grafica valoare </h1>
	<p class="error">Introduceti val_min, val_max si val.</p><p><br /></p>';
}
?>
<center><table bgcolor="#D9E3EE" border =1 width="400"><tr><td>
<h2><center>Afisare grafica valoare</center></h2><hr>
<form action="af_gr_val.php" method="post">
	<table align ="center"><tr><td>
	<p>Valoara maxima: </td><td><input type="text" name="max" size="5" maxlength="10" value="<?php if (isset($_POST['max'])) echo $_POST['max']; ?>" /></p>
	</td></tr><tr><td>
	<p>Valoarea minima: </td><td><input type="text" name="min" size="5" maxlength="10" value="<?php if (isset($_POST['min'])) echo $_POST['min']; ?>" /></p>
	</td></tr><tr><td>
	<p>Valoarea: </td><td><input type="text" name="val" size="5" maxlength="10" value="<?php if (isset($_POST['val'])) echo $_POST['val']; ?>" /> </p>
	</td></tr></table><hr>
	<p><input type="submit" name="trimite" value="Afiseaza!" /></p>
	<input type="hidden" name="trimis" value="TRUE" />
</form>
</td></tr></table></center>
</div>
