// Se utilizeaza clasa vxvoltm3 pentru a afisa un voltmetru virtual
// Valoarea pentru afisat, se genereaza aleator la intervale furnizate de un timer.

package Vx_voltmetru;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.Timer;
import java.util.Random;

//import tcp_client_v1.j_client;

public class vx_voltm_v3 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; 	// panel_1 cu controale plasate
	private JPanel panel_1 = null; 		// panoul 1
	private vxvoltm3 vxvoltm_1;
	private Random rand;				// obiectul random 
	private double vr;					// valoare random pentru afisare.
    private int delay=500;				// temporizare
    private Timer timer_1=null;			// timer 1

	/**
	 * Constructorul implicit
	 */
	
	public vx_voltm_v3() {
		super();
	}
	
	/**
	 * Aceasta metoda initializeaza: this
	 * 
	 * @returneaza  void
	 */
	
	public void init() {
		this.setSize(320,200);
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
							vxvoltm_1.af_vxvoltm();
							vr=rand.nextDouble()*250.0;
							vxvoltm_1.set_val(vr);	
							
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
			vxvoltm_1 = new vxvoltm3(60,10,175,150,0,250.0,this);
			c_panel_1.add(creaza_panel_1(), null);
			c_panel_1.setLayout(new BorderLayout());
			creaza_timer_1();
			timer_1.start();
		}
		return c_panel_1;
	}
}

class vxvoltm3
{
	private int x1,y1,w,h;
	double val,val_max;
	private vx_voltm_v3 frm;
	private Graphics  desen = null;
	private double val_v;
	
	 vxvoltm3(int x1,int y1,int w, int h, double val, double val_max, vx_voltm_v3 frm)
		{
			this.x1 = x1;
			this.y1 = y1;
			this.w = w;
			this.h = h;
			this.val_max = val_max;
			this.val = val;
			this.frm = frm;
			val_v=val;
		}
	 public void af_vxvoltm()
		{
	        if (desen==null){
	        	desen = frm.getGraphics();
	        }
	        desen.setColor(Color.BLUE);
	        desen.clearRect(x1, y1, w, h);
	        desen.drawRect(x1, y1, w, h);
	        desen.setColor(Color.RED);	
		}
	 public void set_val(double val)
	 {	 
		 desen.setColor(Color.WHITE);
		 // sterg textul
		 desen.clearRect(x1+w-40, y1+h-18,40,10);
		 desen.drawLine((int)(x1+(w/val_max)*val_v) ,y1+50, (int)(x1+w/2), y1+h-30);
		 desen.setColor(Color.RED);
		 desen.drawLine((int)(x1+(w/val_max)*val) ,y1+50, (int)(x1+w/2), y1+h-30);
		 desen.drawString(Integer.toString((int)val), x1+w-40, y1+h-8);
		 val_v=val;
	 } 
}