// Se utilizeaza clasa vxvoltm1 pentru a afisa un voltmetru virtual
// Se afiseaza imagine de fundal
// La prima rulare se deseneaza voltmetrul dupa care se traseaza numai valoarea
// La fiecare trasare a valorii, se sterge vechea trasare.

package Vx_voltmetru;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import java.util.Random;


public class vx_voltm_v1 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; 	// panel_1 cu controale plasate
	private JPanel panel_1 = null; 		// panoul 1
	private JButton but_1 = null; 		// butonul 1
	private vxvoltm1 vxvoltm_1;
	private Random rand;				// obiectul random 
	private double vr;
	private int af_v=0;

	/**
	 * Constructorul implicit 
	*/ 
	
	public vx_voltm_v1() {
		super();
	}
	
	/**
	 * Aceasta metoda initializeaza: this
	 * 
	 * @returneaza  void
	 */
	
	public void init() {
		this.setSize(320,270);
		this.setContentPane(init_panel_1());
	}

	/**
	 * 
	 * Aceasta metoda creaza panelul: "but_1"	
	 * Returneaza but_1 de tipul:	javax.swing.JButton
	 */
	
	private JButton creaza_but_1() {
		if (but_1 == null) {
			but_1 = new JButton();
			but_1.setBounds(new Rectangle(100, 180, 110, 30));
			but_1.setText("Next_val");
			but_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (af_v==0){
						vxvoltm_1.af_vxvoltm();
						af_v=1;
					}
					vr=rand.nextDouble()*250.0;
					vxvoltm_1.set_val(vr);
				}
			});
		}
		return but_1;
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
			vxvoltm_1 = new vxvoltm1(60,10,175,150,0,250.0,this);
			c_panel_1.add(creaza_but_1(), null);
			c_panel_1.add(creaza_panel_1(), null);
			c_panel_1.setLayout(new BorderLayout());
		}
		return c_panel_1;
	}
	
}

class vxvoltm1
{
	private int x1,y1,w,h;
	double val,val_max;
	private vx_voltm_v1 frm;
	private Graphics  desen = null;
	private double val_v;
	
	 vxvoltm1(int x1,int y1,int w, int h, double val, double val_max, vx_voltm_v1 frm)
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
	 public void afis_im(String nume_i)
	 	{
		 	if (desen==null){
		 		desen = frm.getGraphics();
		 	}
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
		 if (desen==null){
			 desen = frm.getGraphics();
		 }
		 desen.setColor(Color.white);
		 // sterg textul
		 desen.clearRect(x1+w-40, y1+h-20,40,10);
		 // sterg vechea indicatie 
		 desen.drawLine((int)(x1+(w/val_max)*val_v) ,y1+50, (int)(x1+w/2), y1+h-30);
		 // desenez noua indicatie
		 desen.setColor(Color.RED);
		 desen.drawLine((int)(x1+(w/val_max)*val) ,y1+50, (int)(x1+w/2), y1+h-30);
		 // scriu noul text
		 desen.drawString(Integer.toString((int)val), x1+w-40, y1+h-10);
		 val_v=val;
	 } 
}