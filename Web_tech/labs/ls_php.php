<html>
<title> Laborator php </title>
<head>
<script type="text/javascript" src="../l_java/wz_jsgraphics.js"></script>
</head>
<body>

<table width="100%">
<tr><td height="50" background="../../Images/imm_s.bmp"><center><font color= "white" size=5> Laborator php </Center></TD></TR>
</table>
<a name="start"></a>
<font color= "Blue" size=5> Tematica lucrari </font><br><br>

<li><font color="blue" size="3"> Instalare XAMPP </font>
<ol>
<li> Se descarca de pe net <a href="https://www.apachefriends.org/ro/download.html" target="download">https://www.apachefriends.org/ro/download.html</a>
<li> Se lanseaza xampp-setup
<li> Se lanseaza xampp-start
<li> Se verifica existenta folder-ului htdocs in care se gaseste index.html si index.php
<li> Se lanseaza  http://localhost sau http://127.0.0.1
</ol> 

<li><font color="blue" size="3">Instructiuni if, instructiuni repetitive</font> 
<ol>
<li> afisarea unui tabel 10 X 10 cu numere , cu patratele numerelor, cu valori aleatoare
<li> colorarea celulelor cu numere pare

<!---------------------Rulare aplicatie-----------------------------------------><br><br>
<html>
<body>
<center><table bgcolor="WhiteSmoke" border =1 width="400"><tr><td>
<center>
 Primele 100 de numere naturale
<hr>
<?php
echo"<table border=1>";
$i=1;
$j=1;
$k=1;
  do {
   echo"<tr>";
   $i=1; 	
   do {
	 if($i%2==0)  
       echo"<td bgcolor=\"yellow\">";  
     else
     	echo"<td>";
       echo $k."</td>";  
     $i+=1; 
     $k+=1;
    } while ($i<=10);
   $j+=1; 
   echo"</tr>";  
  }while ($j<=10);
echo"</table>"; 
?>
</td></tr></table></center>  
</body>
</html>
<!---------------------Sfarsit aplicatie----------------------------------------><br><br>

<li> colorare tabla de sah

<!---------------------Rulare aplicatie-----------------------------------------><br><br>
<html>
<body>
<center><table bgcolor="WhiteSmoke" border =1 width="400"><tr><td>
<center>
 Primele 100 de numere naturale
<hr>
<?php
echo"<table border=1>";
$i=1;
$j=1;
$k=1;
  do {
   echo"<tr>";
   $i=1; 	
   do {
	 if((($k%2==0)&&($j%2==1))||(($k%2==1)&&($j%2==0)))  
       echo"<td bgcolor=\"yellow\">";  
     else
     	echo"<td>";
       echo $k."</td>";  
     $i+=1; 
     $k+=1;
    } while ($i<=10);
   $j+=1; 
   echo"</tr>";  
  }while ($j<=10);
echo"</table>"; 
?>
</td></tr></table></center>  
</body>
</html>
<!---------------------Sfarsit aplicatie----------------------------------------><br><br>
<li> colorarea diagonalei principale, secundare
<!---------------------Rulare aplicatie-----------------------------------------><br><br>
<html>
<body>
<center><table bgcolor="WhiteSmoke" border =1 width="400"><tr><td>
<center>
 Primele 100 de numere naturale
<hr>
<?php
echo"<table border=1>";
$i=1;
$j=1;
$k=1;
  do {
   echo"<tr>";
   $i=1; 	
   do {
	 if(($j==$i)||($j==11-$i)) 
       echo"<td bgcolor=\"yellow\">";  
     else
     	echo"<td>";
       echo $k."</td>";  
     $i+=1; 
     $k+=1;
    } while ($i<=10);
   $j+=1; 
   echo"</tr>";  
  }while ($j<=10);
echo"</table>"; 
?>
</td></tr></table></center>  
</body>
</html>

<!---------------------Sfarsit aplicatie----------------------------------------><br><br>

<li> colorarea unor dreptunghiuri concentrice

<!---------------------Rulare aplicatie-----------------------------------------><br><br>
<center><table bgcolor="WhiteSmoke" border =1 width="400"><tr><td></center>
<center>
 Patrate concentrice
<hr>
<?php
echo"<table border=1>";
$i=0;
$j=0;
$k=rand(99,0);
$imax=10; //Nr. max de linii
$jmax=10; //Nr. max de coloane
$n=0;
$m=$jmax;
for($i=0;$i<=$imax-1;$i++)
{       
   echo"<tr>";
	for($j=0;$j<=$jmax-1;$j++)
	{
	    if (($i%2==0)&&($j>=$n)&&($j<=$m-1))
			echo"<td bgcolor=\"yellow\">";
	    else{ 
		if (($i%2==1)&&($j>=$m-1)&&($j<=$n))
			echo"<td bgcolor=\"yellow\">";
		else{
			if (($j%2==0)&&($i>=$j+1)&&($i<=$jmax-$j-1))
				echo"<td bgcolor=\"yellow\">";
			else{
				if (($j%2==1)&&($i>=$jmax-$j)&&($i<=$j))
					echo"<td bgcolor=\"yellow\">";
				else
					echo"<td>";
			}
		}
	    } 
     	    echo $k."</td>"; 
     	   $k=rand(99,0);
	} 
	echo"</tr>"; 	
	$n+=1;
	$m-=1; 
}
echo"</center></table></center>";
?>
</center></table></center>  
<br><br>
<!---------------------Sfarsit aplicatie----------------------------------------><br><br>

<li> colorarea unei spirale

<!---------------------Rulare aplicatie-----------------------------------------><br><br>
<center><table bgcolor="WhiteSmoke" border =1 width="400"><tr><td></center>
<center>
 Spirala
<hr>
<?php
echo"<table border=1>";
$i=0;
$j=0;
$k=rand(99,0);
$imax=10; //Nr. max de linii
$jmax=10; //Nr. max de coloane
$n=0;
$m=$jmax;
for($i=0;$i<=$imax-1;$i++)
{       
   echo"<tr>";
	for($j=0;$j<=$jmax-1;$j++)
	{
	    if (($i%2==0)&&($j>=$n-1)&&($j<=$m-1))
			echo"<td bgcolor=\"yellow\">";
	    else{ 
		if (($i%2==1)&&($j>=$m-1)&&($j<=$n))
			echo"<td bgcolor=\"yellow\">";
		else{
			if (($j%2==0)&&($i>=$j+2)&&($i<=$jmax-$j-1))
				echo"<td bgcolor=\"yellow\">";
			else{
				if (($j%2==1)&&($i>=$jmax-$j)&&($i<=$j))
					echo"<td bgcolor=\"yellow\">";
				else
					echo"<td>";
			} 
		}
	   }
     	   echo $k."</td>"; 
     	   $k=rand(99,0);
	} 
	echo"</tr>"; 	
	$n+=1;
	$m-=1;
}
echo"</table></table>";
?>
</center>  
<!---------------------Sfarsit aplicatie----------------------------------------><br><br>
</ol>
<li><font color="blue" size="3">Generarea listelor </font> 
<ol>

<li> generarea unei liste simple

<br><br>&nbsp;&nbsp;&nbsp;&nbsp;Avand urmatoarul vector, afisati continutul acestuia sub forma unei liste: <br><br>
<textarea style="width:100%;height:60px" name="code" wrap="logical" rows="12" cols="42">
         
$stud = array( "Andrea","Marius","Vlad");
</textarea>
<!------------------------------------------------------------------->
<!---------------------Rulare aplicatie-----------------------------------------><br><br>
<body>
<center><table bgcolor="WhiteSmoke" border =1 width="700"><tr><td>
<?php
		$stud = array( "Andrea","Marius","Vlad");
		echo '<font color="red">Studenti </font> <ul>';
		foreach ($stud as $num){ 
			 echo '<li>'.$num ;
		}
		echo '</ul>';?>
</td></tr></table></center>
</body>
</html>  
<!---------------------Sfarsit aplicatie----------------------------------------><br><br>


<li> generarea unei liste pe doua nivele
</ol>
<br><br>&nbsp;&nbsp;&nbsp;&nbsp;Initializati o matrice 3x3 cu numere aleatoare intre 100-200 dupa care afisati continutul 
matricii sub forma unei liste: <br><br>

<!---------------------Rulare aplicatie-----------------------------------------><br><br>
<body>
<center><table bgcolor="WhiteSmoke" border =1 width="700"><tr><td>
<?php
		 for($j=0;$j<3;$j++){
			for($i=0;$i<3;$i++){
				$matr[$j][$i]=rand(100,200);
			}
		 }
		 echo '<ul>';
		 for($j=0;$j<3;$j++){
			echo '<li>Linia: ' .$j;
			echo '<ul>';
			for($i=0;$i<3;$i++){
				echo '<li>'. $matr[$j][$i];
			}
			echo '</ul>';
		 }
?>
</td></tr></table></center>
</body>
</html>  
<!---------------------Sfarsit aplicatie----------------------------------------><br><br>




<br><br>&nbsp;&nbsp;&nbsp;&nbsp;Avand urmatoarele tablouri, afisati continutul acestora sub forma de lista pe doua nivele: <br><br>
<textarea style="width:100%;height:400px" name="code" wrap="logical" rows="12" cols="42">
         
	$stud = array( "Andrea","Marius","Vlad");
	$materii = array( "fizica","matematica","chimie");
	$note = array(
			
            "Andrea" => array (
               "fizica" => 9,
               "matematica" => 7,	
               "chimie" => 10
            ),
            
            "Marius" => array (
               "fizica" => 6,
               "matematica" => 9,
               "chimie" => 5
            ),
            
            "Vlad" => array (
               "matematica" => 9,
               "fizica" => 10,
               "chimie" => 8
            )
         );
</textarea>
<!------------------------------------------------------------------->
<!---------------------Rulare aplicatie-----------------------------------------><br><br>
<body>
<center><table bgcolor="WhiteSmoke" border =1 width="700"><tr><td>
<?php
         $stud = array( "Andrea","Marius","Vlad");
		 $materii = array( "fizica","matematica","chimie");
		 $note = array(
			
            "Andrea" => array (
               "fizica" => 9,
               "matematica" => 7,	
               "chimie" => 10
            ),
            
            "Marius" => array (
               "fizica" => 6,
               "matematica" => 9,
               "chimie" => 5
            ),
            
            "Vlad" => array (
               "matematica" => 9,
               "fizica" => 10,
               "chimie" => 8
            )
         );
		echo '<ul>';
		foreach ($stud as $num){	 
			 echo '<li><font color="red">'.$num .'</font>';
			 echo '<ul>';
			 foreach ($materii as $m){
				echo '<li>'.$m. ':'.$note[$num][$m];
			 }
			 echo '</ul>';
		}
		echo '</ul>';	 
?>
</td></tr></table></center>
</body>
</html>  
<!---------------------Sfarsit aplicatie----------------------------------------><br><br>


<li><font color="blue" size="3"> Afisari grafice in PHP </font>
<ul>
<b>Afisare consum</b><br><br>
<li> Avand variabilele :
<ol>
<li> $val=270;
<li> $min=20;
<li> $max=500;
</ol>
<br> Realizati o aplicatie pe partea server-ului care sa afiseze grafic valoarea $val
<!---------------------Rulare aplicatie-----------------------------------------><br><br>
<body>
<center><table bgcolor="WhiteSmoke" border =1 width="700"><tr><td>
<?php
$val=270;
$min=20;
$max=500;
// numarul de pixeli in care se afiseaza hr este 550
$consum=(550/($max-$min))*($val-$min);
echo'
<center> 
<table bgcolor="WhiteSmoke" border =1 width="700"><tr><td colspan="2">
<center>
 <font size=4 color="blue"> Reprezentare grafica </font><br> Valoarea minima='.$min.'  Valoarea maxima='.$max.'
</td></tr><tr><td>
<table border=1><tr><td>
</td><td>
<table border=1>
	<tr>
	 <td width="100"> Valoare:'.$val.'</td>
	 <td width=550> <hr color ="red" size="5" align="left" width="'.$consum.'" color ="red"></td>  	
	</tr>
</table>
</center> 
</td></tr></table></center>  
</body>
</html></td></tr></table></center>  ';
?>
</td></tr></table></center>
</body>
</html>  
<!---------------------Sfarsit aplicatie----------------------------------------><br><br>
<font color="red"> Sugestie:</font> Folositi marcatorul hr in care schimbati din aplicatia php parametrul width " ".
<xmp>
	       <hr color ="red" size="5" align="left" width=" " color ="red">
</xmp>
<br><br><b> Aplicatie pentru afisare sondaj procentual sub forma grafica.</b><br><br>
<li> Sa presupunem ca avem urmatoarele variabile:
<br>$intreb=array("Proiectare pagini WEB ", "Aplicatii WEB ", "Tehnologii avansate WEB ", "Servicii WEB ","Aplicatii industriale si monitorizari web ");
<br>$rasp=array(61.54,7.69,23.08,0,7.69);
<br><br>Unde $intreb-intrebarile la chestionar si $rasp procentul reprezentand raspunsurile la fiecare varianta.
<li> Realizati o aplicatie pentru afisare sondaj procentual sub forma grafica.
<!---------------------Rulare aplicatie-----------------------------------------><br><br>
<html>
<body>
<center><table bgcolor="WhiteSmoke" border =1 width="750"><tr><td>
<?php
$intreb=array("Proiectare pagini WEB ", "Aplicatii WEB ", "Tehnologii avansate WEB ", "Servicii WEB ","Aplicatii industriale si monitorizari web ");
$rasp=array(61.54,7.69,23.08,0,7.69);

echo'
<center> 
<table bgcolor="WhiteSmoke" border =1 width="750"><tr><td colspan="2">
<center>
 <font size=4 color="blue"> Ce asteptari aveti de la disciplina: "Tehnologii WEB"</font> <br> Raspunsuri la sondaj <br>
</td></tr><tr><td>
<table border=1><tr><td>
</td><td>
<table border=1>';
// numarul de pixeli in care se afiseaza hr este 400
for ($j=0;$j<=4;$j++){
  $proc=400/100*$rasp[$j];
  echo'
	<tr>
	 <td width="280">'.$intreb[$j].'</td><td width="70">'.$rasp[$j].'%</td> 
	 <td width=400> <hr color ="red" size="5" align="left" width="'.$proc.'"></td>  	
	</tr>';
}
echo'	
</table>
</center> 
</td></tr></table></center>  
</body>
</html></td></tr></table></center>  ';
?>
</td></tr></table></center>
</body>
</html>  
<!---------------------Sfarsit aplicatie----------------------------------------><br><br>

<li>Afisati graficul functiei functia (1-e<sup>x</sup>)*sin(k*x) unde k=20 si x apartine intervalului [-2 +2]
<center><img src="elax.php"></center>


<li>Realizati o imagini dinamica de genul:
<br><br><center>
<script>
function afis_im(){
	im.src="sinus_v2.php"+"?sid="+Math.random();
	setTimeout("afis_im()",300);
}

</script>
<div>
	<center><img src="sinus_v2.php"  name="im">
		<INPUT onclick=afis_im() type=button value=Start>
	</center>
</div>
</center><br><br>
</ol>

<li><font color="blue" size="3"> Form-uri php <br> </font>
<br><br>
<ol>
<li> Se va realiza o aplicatie client cu un form in care se introduc diverse date si aplicatia pe partea de server care prelucreaza datele din form
exemple: 
<ul>
   <li> se introduce in form lungimea si latimea unui dreptunghi dupa care aplicatia pe partea de server calculeaza aria si o afiseaza 
   <li> se introduce in form temperatura in gr C dupa care aplicatia pe partea de server afiseaza temperatura in in gr K si gr F
   <li> ...
 </ul>
<li> se introduce in form val_min, val_max si val dupa care aplicatia pe partea de server afiseaza grafic valoarea scalat tinand cont de val_min si val_max
<br><br><center><iframe src="af_gr_val.php" width="800" height="380"></iframe></center><br><br>

<li> reluati aplicatia anterioara si afisati sub forma:

<br><br><center><iframe src="af_gr_vall.php" width="800" height="250"></iframe></center><br><br>
 
</ol>

<li><font color="blue" size="3"> Programare obiect in php  </font>
<br><br>
<ul>
	<li> Realizati in php o clasa care afiseaza numere intr-un tabel cu dimensiunea n1 X n2 (n1,n2 se vor transmite la instantierea clasei). 
	Numarul  de inceput va fi dat la invocarea metodei care afiseaza tabelul. 
	<br>De exemplu, daca se creaza clasa "tabel" si se realizeaza obiectul: 
	<center> <b> $tb = new tabel(8,5); </b></center>
	<br> prin invocarea metodei "afis"
 	<center> <b> $tb->afis(123);</b></center>
	<br> se obtine:
<?php
   class tabel {

      	/* Constructor */

	function __construct($dimx,$dimy){


      /* Variable membru */

 		$this->dx = $dimx;
		$this->dy = $dimy;
	}
      /* Functie membru */
    
      function afis($nr_start){
		  
		  echo'<center><table bgcolor="WhiteSmoke" border =1 width="400"><tr><td>
				<center>'.$this->dx*$this->dy.' de numere naturale incepand cu: '.$nr_start.'<hr>';
			echo"<table border=1>";
			$k=$nr_start;
			$i=1;
			$j=1;
			do {
				echo"<tr>";
				$i=1; 	
				do {
					if((($k%2==0)&&($j%2==1))||(($k%2==1)&&($j%2==0)))  
						echo"<td bgcolor=\"yellow\">";  
					else
						echo"<td>";
					echo $k."</td>";  
					$i+=1; 
					$k+=1;
				}while ($i<=$this->dx);
				$j+=1; 
				echo"</tr>";  
			}while ($j<=$this->dy);
		echo"</table>"; 
		echo '</td></tr></table></center>  ';
      }
   }
$tb = new tabel(8,5);
$tb->afis(123);
?>

<br><br>
	<li> Folosind clasa "voltmetru" si marcatorul input type="range", 
</ul>

<xmp>
	       	<input type="range" name="" value="" id="" min="" max=""/>

</xmp>realizati aplicatia:

<br><br>
<br><br><center><iframe src="afis_tens.php" width="600" height="350"></iframe></center><br><br>
<p> Clasa "voltmetru" fiind:</p>
<!------------------------------------------------------------------->
<table width="100%" border=1><tr><td bgcolor="#D9E3EE">
<font size="3" color="Blue">
<pre>
&lt?php
class voltmetru{

    /* Constructor */

	function __construct($i,$x,$y,$w,$u,$vm){

	/* Variabile membru */

		$this->imag = $i;
 		$this->x0 = $x;
		$this->y0 = $y;
		$this->wx = $w;
		$this->hy = $w/1.7;
		$this->alfa = $u;
		$this->val_max = $vm;

	/* Variabile locale */

		$this->white  = imagecolorallocate($this->imag, 255, 255, 255);
		$this->blue  = imagecolorallocate($this->imag, 0, 0, 255);
		$this->red  = imagecolorallocate($this->imag, 255, 0, 0);
		$this->gray  = imagecolorallocate($this->imag, 130, 130, 130);
		$this->l_gray  = imagecolorallocate($this->imag, 220, 220, 220);
		$this->black = imagecolorallocate($this->imag, 0, 0, 0);
	}
function init_instr()
{ 
 $lg = 5;
 $xc = $this->x0 + $this->wx / 2;
 $yc = $this->y0 + $this->hy-20;
 $raza = $this->wx / 2;
 $val_a = 0; // valoarea pentru afisat

// desen rama

 imagefill( $this->imag, 0, 0,  $this->white);
 imagerectangle( $this->imag, $this->x0, $this->y0+1, $this->x0+$this->wx+20, $this->y0+$this->hy-10, $this->black );
 imagerectangle( $this->imag, $this->x0+4, $this->y0+5, $this->x0+$this->wx+16, $this->y0+$this->hy-14, $this->l_gray);
 imagerectangle( $this->imag, $this->x0+7, $this->y0+8, $this->x0+$this->wx+13, $this->y0+$this->hy-17, $this->black);
 imagerectangle( $this->imag, $this->x0+9, $this->y0+10, $this->x0+$this->wx+11, $this->y0+$this->hy-19, $this->gray);
 imagesetthickness($this->imag, 1);

 	// alfa_gr unghiul in grade

	$alfa_gr =180-$this->alfa;
	$nrd = 0;
	while ($alfa_gr >= $this->alfa)
		{
			if ($nrd % 5 == 0)
			{
				$xt = $xc + ($raza-0*$lg) * cos(deg2rad($alfa_gr))-10;
				$yt = $yc - ($raza-0*$lg) * sin(deg2rad($alfa_gr));
				$x1 = $xc + ($raza-5*$lg) * cos(deg2rad($alfa_gr));
				$y1 = $yc - ($raza-5*$lg) * sin(deg2rad($alfa_gr));
				imagestring($this->imag, 5, $xt,$yt, $val_a, $this->blue);
			}
			else
            {
				$x1 = $xc + ($raza-7*$lg) * cos(deg2rad($alfa_gr));
				$y1 = $yc - ($raza-7*$lg) * sin(deg2rad($alfa_gr));
			}
			$x2 = $xc + ($raza - 9 * $lg) * cos(deg2rad($alfa_gr));
			$y2 = $yc - ($raza - 9 * $lg) * sin(deg2rad($alfa_gr));
			imageline($this->imag, $x1, $y1, $x2, $y2, $this->gray);
			$val_a=$val_a+round(2*$this->val_max/((180-2*$this->alfa)));
            $alfa_gr= $alfa_gr- 2;
            $nrd=$nrd+1;
		}
		// redefinesc valoarea maxima in functie de maximul posibil de afisat pe ecran
		$val_a=$val_a-round(2*$this->val_max/((180-2*$this->alfa)));
		$this->val_max=$val_a;
	}
	function set_val($val)
	{
		$lg = 5;
		$xc = $this->x0 + $this->wx / 2;
		$yc = $this->y0 + $this->hy-20;
		$raza = $this->wx / 2;

		// $alfa_gr unghiul in grade

		$alfa_gr =(180-$this->alfa)-($val*(round((180-2*$this->alfa)/$this->val_max,2)));
		$x = $xc + ($raza-10*$lg) * cos(deg2rad($alfa_gr));
 		$y = $yc - ($raza-10*$lg) * sin(deg2rad($alfa_gr));
		imageline($this->imag, $xc, $yc, $x, $y, $this->red); 
		imagefilledarc($this->imag, $xc,  $yc,  50,  50,  180, 0, $this->l_gray, IMG_ARC_PIE);
		imagestring($this->imag, 5, $xc+$raza-50,$yc-30, $val, $this->red);
	}
}
?>
</pre></font>
</td></tr></table>
<!------------------------------------------------------------------->

<ul>
<br><br>
	<li> Realizati in php o clasa care sa afiseze un instrument virtual
</ul>
<br><br>
<li><font color="blue" size="3"> Pagini web responsiv </font>
<br><br>
<ul>
	<li> Realizati in php o pagina dinamica web responsiv
</ul>

<br><br><!------------------------------------------------------------------->
<table width="100%" border=1><tr><td bgcolor="#D9E3EE">
<font size="3" color="Blue"><xmp>

</xmp> </font>
</td></tr></table>
<!------------------------------------------------------------------->


