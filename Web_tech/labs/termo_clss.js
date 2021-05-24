function term (c,x,y,w,h,vm) {
	this.cnvs=c; // canvas
    this.x0 = x; // pozitia pe x
    this.y0 = y; // pozitia pe y
	this.wd = w; // latimea
    this.ht = h; // inaltimea
	this.valm=vm // valoarea maxima
}
term.prototype = {
    constructor: term,
    deseneaza:function ()  {
	this.cnvs.beginPath();
	this.cnvs.fillStyle = "#FFFFFF";
	this.cnvs.fillRect(this.x0-1,this.y0-1,this.wd+40,this.ht+2);
	this.cnvs.stroke();	
	// desenez contur termometru
	this.cnvs.beginPath();
	this.cnvs.moveTo(this.x0,this.y0); 
	this.cnvs.strokeStyle = "rgb(255,0,0)";
	this.cnvs.lineTo(this.x0+this.wd,this.y0);
	this.cnvs.lineTo(this.x0+this.wd,this.y0+this.ht);
	this.cnvs.lineTo(this.x0,this.y0+this.ht);
	this.cnvs.lineTo(this.x0,this.y0);
	this.cnvs.stroke();

	// desenez gradatii

	this.cnvs.beginPath();
    this.cnvs.strokeStyle = "rgb(120,120,120)";
	this.cnvs.font = "10px Arial";
	val_a=0;
    for (j = this.ht; j >=0; j -= 5)
    {
		this.cnvs.moveTo(this.x0+this.wd+2,this.y0+j); 
		if (j % 25 == 0)
		{
			this.cnvs.lineTo(this.x0 + this.wd + 12,this.y0 + j);
			this.cnvs.strokeText(val_a,this.x0 + this.wd + 20,this.y0 + j+3);
			val_a=val_a+Math.round(25*this.valm/this.ht);
       }
        else
        {
			this.cnvs.lineTo(this.x0 + this.wd + 7,this.y0 + j);
        }
    }
	this.cnvs.stroke();
	},
	set_val:function (val)  {
	// Stergerea interiorului 
	this.cnvs.beginPath();
	this.cnvs.fillStyle = "#ffffff";
	this.cnvs.fillRect(this.x0+1,this.y0,this.wd-2,this.ht);
	this.cnvs.stroke();
	// trasare valoare
	this.cnvs.beginPath();
	this.cnvs.fillStyle = "#0000ff";
	this.cnvs.fillRect(this.x0+1,this.y0+this.ht-this.ht*val/this.valm,this.wd-2,this.ht*val/this.valm);
	this.cnvs.stroke();
    }
}