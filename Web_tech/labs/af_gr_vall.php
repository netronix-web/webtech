<?php # Script: - af_gr_vall.php 
echo '
<div id="Continut_p">';
// Se verifica daca form-ul a fost trimis
if (isset($_POST['trimis'])) {

	// Validare mimimala form.
	if ( is_numeric($_POST['max']) && is_numeric($_POST['val']) ) {
	
		// Calcularea rezultatelor.
		$val = $_POST['val'] ;
		$max = $_POST['max'] ;	
	} else { // S-au trimis valori invalide.
		echo '<h1>Eroare !</h1>
		<p class="error">Va rog introduceti Valoarea si Valoarea maxima.</p><p><br /></p>';
	}
}
?>
<center><table bgcolor="#D9E3EE" border =1 width="635"><tr><td>
<h2><center>Afisare grafica valoare</center></h2><hr>
<form action="af_gr_vall.php" method="post">
	<table align ="center"><tr><td width="635">	
	<p>Valoarea:<input type="text" name="val" size="5" maxlength="10" value="<?php if (isset($_POST['val'])) echo $_POST['val']; ?><?php if (!isset($_POST['val'])) echo'100'; ?>" </p>
	</td></tr><tr><td>
	<p>Valoara maxima :<input type="text" name="max" size="5" maxlength="10" value="<?php if (isset($_POST['max'])) echo $_POST['max']; ?><?php if (!isset($_POST['max'])) echo '500'; ?>" </p>
	</td></tr><tr><td>
	<table border=1>
	<tr>
	 <td width="100"> Valoare:<?php if (isset($_POST['val'])) echo $_POST['val']; ?></td>
	 <td width="500"> <hr color ="red" size="5" align="left" width="<?php if (isset($_POST['val'])) echo 500*$_POST['val']/$_POST['max']; ?>" color ="red"></td>  	
	</tr>
</table>
	</td></tr></table><hr>
	<p><input type="submit" name="trimite" value="Afiseaza!" /></p>
	<input type="hidden" name="trimis" value="TRUE" />
</form>
</td></tr></table></center>
</div>
