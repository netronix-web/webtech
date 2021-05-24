<?php
include ('voltm_clss.php');
// creare imagine 300*350
$img = imagecreatetruecolor(420, 220);
// definire culori
$white = imagecolorallocate($img, 255, 255, 255);
// fundal alb imagine
imagefill($img, 0, 0,  $white);
if (isset($_GET['vm'])) {
	$vmax=$_GET['vm'];
}
else{
	$vmax=500; // Valoarea maxima afisata
}
if (isset($_GET['vl'])) {
	$val=$_GET['vl'];
}
else{
	$val=rand(0,$vmax); // Valoarea maxima afisata
}
$voltm = new voltmetru($img,  10,  0,  380,  40,  $vmax);
$voltm->init_instr();
$voltm->set_val($val);
// output image in the browser
header("Content-type: image/png");
imagepng($img);

// free memory
imagedestroy($img);
?>
