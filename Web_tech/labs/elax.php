<?php
Header("Content-type: image/png");

//creare obiect im
 
$im_Width=200; 
$im_Height=200; 
$im=ImageCreate($im_Width+1,$im_Height+1);

// Creare culori
 
$cWhite=ImageColorAllocate($im,255,255,255);
$cBlue=ImageColorAllocate($im,0,0,255); 
$cBlack=ImageColorAllocate($im,0,0,0);

// creare fundal alb

ImageFilledRectangle($im,0,0,$im_Width+1,$im_Height+1,$cWhite); 

// trasare sinus

$x=-$im_Width/2;
$xv=$x;
$yv=$im_Height/2; 
for($pt=0;$pt<$im_Width;$pt++){ 
	$x=$x+1;
	$y=($im_Height/2)+(1-exp(deg2rad($x)))*(1-sin(deg2rad(20*$x))*($im_Height/10)); 
	//$y=($im_Height/2)+(1-exp($x))*(sin(10*$x)*($im_Height/2)); 
	ImageLine($im,$xv+$im_Width/2,$yv,$x+$im_Width/2,$y,$cBlue); 
	$xv=$x; 
	$yv=$y; 
}
 
// trasare axe
 
ImageLine($im,0,0,0,$im_Height,$cBlack); 
ImageLine($im,0,$im_Height/2,$im_Width,$im_Height/2,$cBlack);

// creare imagine 

ImagePNG($im); 
ImageDestroy($im); 
?>
