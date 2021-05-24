<?php
if ( (isset($_GET['id'])) && (is_numeric($_GET['id'])) ) { 	$id = $_GET['id'];
} elseif ( (isset($_POST['id'])) && (is_numeric($_POST['id'])) ) { 
	$id = $_POST['id'];
} else { // Nu se face acces la baza de date
	echo '<p><font color="red" size="2"><br>Pagina accesata din greseala ! </font></p>';
	$id=1;
	//exit;
}
$page_title = 'Grafic rating';
if ($id==1){
	$val_m=rand(10,100);
	$nr_m=rand(10,100);
  	$dat_m=date('Y-m-d H:i:s');
 }
$dimx=330;
$dimy=225;
$dimh=100; // inaltime histograma
$pad=10; // padding
$x0=0;
$y0=0;
$img = imagecreatetruecolor($dimx, $dimy);
$red = imagecolorallocate($img, 255, 0, 0);
$blue = imagecolorallocate($img, 0, 0, 255);
$white = imagecolorallocate($img, 255, 255, 255);
$green = imagecolorallocate($img, 0, 255, 0);
$blue = imagecolorallocate($img, 0, 0, 255);
$grey = imagecolorallocate($img, 211, 211, 211);
$l_grey = imagecolorallocate($img, 200, 200, 200);
$black = imagecolorallocate($img, 0, 0, 0);

// desen rama

imagefill( $img, 0, 0,  $white);
imagesetthickness($img, 1);
imagerectangle($img, $x0+1, $y0+1, $dimx-1, $dimy-1, $black);
imagesetthickness($img, 4);
imagerectangle($img, $x0+4, $y0+4, $dimx-4, $dimy-4, $l_grey);
imagesetthickness($img, 1);
imagerectangle($img, $x0+7, $y0+7, $dimx-7, $dimy-7, $black);

// axe histograma 

$x=$x0+12;
$y=$y0+110;
imagesetthickness($img, 2);
imageLine($img, $x, $y+3, $dimx-7, $y+3, $blue);
imageLine($img, $x, $y+3, $x, $y-$dimh, $blue);
imagesetthickness($img, 5);
$x=$x+3;

// histograma

require_once ('con_mysqli.php'); // Conectare la baza de date.
$query = "SELECT id_el, val, max, min, um FROM electr ";
$result = @mysqli_query ($db,$query); // Rulare query.
$vm=0;
$nr_m=0;

while ($row = mysqli_fetch_array($result)) {
		$val=$row['val'];
		$val_m=$row['max'];
		$val_c=$dimh/$val_m*$val;
		$nr_m=$nr_m+1;
		$vm=$vm+$val_c;
		imageLine($img, $x, $y,  $x, $y-$val_c, $red);
		$x=$x+10;
}
$vm=$vm/$nr_m;

// t_meter

$x=$x0+12;
$y=$y0+145;

imagesetthickness($img, 1);
imagerectangle($img, $x+2, $y+33, $dimx-11, $y+48, $blue);
imagesetthickness($img, 7);
imagerectangle($img, $x+7, $y+38, $dimx-18, $y+43, $white);
imagerectangle($img, $x+7, $y+38,($vm*($dimx-14))/$dimh, $y+43, $red);
imagestring($img, 5, $x+7,$y+55, "Nr.inreg:".$nr_m, $red);
imagestring($img, 5, $x+265,$y+55, round($vm). " %", $blue);

// gradatii

imagesetthickness($img, 1);
$x=$x0+12;
$y=$y0+170;
$px=$x+4;
$nrd=0;
imageline($img, $x+6, $y, $dimx-16, $y, $l_grey);
while ($px<=$dimx-13){
	if ($nrd % 5 == 0){
		imageLine($img, $px, $y, $px, $y-15, $l_grey);
		if(2*$nrd==100){
			imagestring($img, 4, $px-17,$y-40, round(2*$nrd), $blue);
		}
		else{
			imagestring($img, 4, $px-7,$y-40, round(2*$nrd), $blue);
		}
	}
	else{
		imageLine($img, $px, $y, $px, $y-5, $l_grey);
	}
	$nrd=$nrd+1;
	
	$px=$px+6;
}
// output image in the browser
header("Content-type: image/png");
imagepng($img);
// free memory
imagedestroy($img);
mysqli_close($db); // Close the database connection.
?>