<?php # Script: - afis_tens.php 
echo '
<div id="Continut_p">';
// Se verifica daca form-ul a fost trimis
if (isset($_POST['trimis'])) {

	// Validare mimimala form.
	if ( is_numeric($_POST['val_max']) && is_numeric($_POST['val']) ) {
	
		// Calcularea rezultatelor.

		$total = ($_POST['val_max'] * $_POST['val']) ;
		
		// Afisarea rezultatelor.
		echo '<center><img src="voltmetru.php?vm='.$_POST['val_max'].'&vl='.$_POST['val'].'">';
	
	} else { // S-au trimis valori invalide.
		echo '<center><img src="voltmetru.php?vm=200&vl=100">
		<p class="error">Va rog introduceti valoarea maxima, si valoarea de afisat</p>';
	}
	
} else {
	echo '<center><img src="voltmetru.php?vm=100&vl=25">';
}

?>
<script>
function trimit() {
  document.getElementById("date").submit();
}
</script>
<center><table  border =1 width="404"><tr><td bgcolor="#D9E3EE">
<form id="date" action="afis_tens.php" method="post">
	<table align ="center"width="310"><tr><td align="left">
	Valoarea maxima: </td><td><input type="text" name="val_max" size="5" maxlength="10" value="<?php if (isset($_POST['val_max'])) echo $_POST['val_max']; ?><?php if (!isset($_POST['val_max'])) echo '100'; ?>" />
	</td></tr><tr><td align="left">
	<input type="range" name="val" value="<?php if (isset($_POST['val'])) echo $_POST['val'];?><?php if (!isset($_POST['val'])) echo '25'; ?>" id="per" min="0" max="<?php if (isset($_POST['val_max'])) echo $_POST['val_max']; ?><?php if (!isset($_POST['val_max'])) echo '100'; ?>"  onchange="trimit()"/> 
	</td></tr><tr><td align="left">
	<input type="hidden" name="trimis" value="TRUE" />
	</td></tr></table>
</form>
</td></tr></table></center>
</div>
