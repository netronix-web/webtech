// Se utilizeaza clasa vxvoltm4 pentru a afisa un voltmetru virtual
// De fiecare data, se reafiseaza imaginea de fundal
// Imaginea de fundal fiind creata o singura data
// Nu mai este necesara stergerea vechii trasari

package Vx_voltmetru;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.Timer;

import java.util.Random;


public class vx_voltm_v4 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; 	// panel_1 cu controale plasate
	private JPanel panel_1 = null; 		// panoul 1
	private vxvoltm4 vxvoltm_4;
	private Random rand;				// obiectul random 
	private double vr;
    private int delay=500;				// temporizare
    private Timer timer_1=null;			// timer 1
	/**
	 * Constructorul implicit 
	*/ 
	
	public vx_voltm_v4() {
		super();
	}
	
	/**
	 * Aceasta metoda initializeaza: this
	 * 
	 * @returneaza  void
	 */
	
	public void init() {
		this.setSize(400,300);
		this.setContentPane(init_panel_1());
	}

	/**
	* Aceasta metoda creaza "timer_1"	
	* nu returneaza nimic
	*/
		
	private void creaza_timer_1() {

			if (timer_1 == null) {
					timer_1 = new Timer(delay, null);
					//timer_1.setInitialDelay(delay *1); // Temporizare initiala
					timer_1.setCoalesce(true);
					timer_1.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							vxvoltm_4.afis_im();
							vr=rand.nextDouble()*250.0;
							vxvoltm_4.set_val(vr);
							
						}
					});					
    }
}		
	

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	
	private JPanel creaza_panel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridBagLayout());
			panel_1.setBounds(new Rectangle(10, 10, 350, 150));
		}
		return panel_1;
	}

	/**
	 * Aceasta metoda initializeaza panel_1 plasand controalele dorite 
	 * Returneaza c_panel_1 de tipul: javax.swing.JPanel 
	 */
	
	private JPanel init_panel_1() {
		if (c_panel_1 == null) {
			c_panel_1 = new JPanel();
			c_panel_1.setLayout(null);
			rand= new Random();
			// se plaseaza un voltmetru la pozitia x1,y1,w,h,val,val_max
			vxvoltm_4 = new vxvoltm4(60,10,275,250,0,250.0,this);
			vxvoltm_4.cr_im();
			vxvoltm_4.afis_im();
			c_panel_1.add(creaza_panel_1(), null);
			c_panel_1.setLayout(new BorderLayout());
			creaza_timer_1();
			timer_1.start();
		}
		return c_panel_1;
	}
	
}

class vxvoltm4
{
	private int x1,y1,w,h;
	double val,val_max;
	private vx_voltm_v4 frm;
	private Graphics  desen = null;
	private Graphics  im_voltm = null;
	private Image img = null;
	
	 vxvoltm4(int x1,int y1,int w, int h, double val, double val_max, vx_voltm_v4 frm)
		{
			this.x1 = x1;
			this.y1 = y1;
			this.w = w;
			this.h = h;
			this.val_max = val_max;
			this.val = val;
			this.frm = frm;
		}
	 public void cr_im(){
		 	if (img==null){
		 	    img = frm.createImage(w,h);
		 	}
		 	if (im_voltm==null){
		 		im_voltm=img.getGraphics();
		 	}
		 	im_voltm.setColor(Color.blue);
		 	im_voltm.drawRect(2, 2, w-6, h-6);
		 	im_voltm.setColor(Color.red);
		 	im_voltm.drawRect(4, 4, w-10, h-10);
		 	for(int i=15;i<w-10;i+=5){
		 		im_voltm.drawLine(i, (int) w/4, i, (int) h/4-7);
		 	}
		 	if (desen==null){
		 		desen = frm.getGraphics();
		 	}
	 }
	 public void afis_im()
	 	{
		 	if (desen==null){
		 		desen = frm.getGraphics();
		 	}
	        desen.drawImage(img, x1, y1, w, h, frm);
	 	}
	 public void set_val(double val)
	 {
		 if (desen==null){
			 desen = frm.getGraphics();
		}
		 desen.setColor(Color.RED);
		 desen.drawString(Integer.toString((int)val), x1+w-40, y1+h-15);
		 desen.drawLine((int)(x1+(w/val_max)*val) ,y1+50, (int)(x1+w/2), y1+h-30);
	 }
	 
}



