// Se utilizeaza clasa vxvoltm2 pentru a afisa un voltmetru virtual
// De fiecare data, se reafiseaza imaginea de fundal 
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
import javax.swing.JButton;
import java.util.Random;


public class vx_voltm_v2 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; 	// panel_1 cu controale plasate
	private JPanel panel_1 = null; 		// panoul 1
	private JButton but_1 = null; 		// butonul 1
	private vxvoltm2 vxvoltm_2;
	private Random rand;				// obiectul random 
	private double vr;

	/**
	 * Constructorul implicit 
	*/ 
	
	public vx_voltm_v2() {
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
			but_1.setBounds(new Rectangle(75, 180, 150, 30));
			but_1.setText("Afiseaza val");
			but_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					vxvoltm_2.afis_im("voltmeter.jpg");
					vr=rand.nextDouble()*250.0;
					vxvoltm_2.set_val(vr);
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
			vxvoltm_2 = new vxvoltm2(60,10,175,150,0,250.0,this);
			vxvoltm_2.afis_im("voltmeter.jpg");
			c_panel_1.add(creaza_but_1(), null);
			c_panel_1.add(creaza_panel_1(), null);
			c_panel_1.setLayout(new BorderLayout());
		}
		return c_panel_1;
	}
	
}

class vxvoltm2
{
	private int x1,y1,w,h;
	double val,val_max;
	private vx_voltm_v2 frm;
	private Graphics  desen = null;
	private Image img = null;
	
	 vxvoltm2(int x1,int y1,int w, int h, double val, double val_max, vx_voltm_v2 frm)
		{
			this.x1 = x1;
			this.y1 = y1;
			this.w = w;
			this.h = h;
			this.val_max = val_max;
			this.val = val;
			this.frm = frm;
		}
	 public void afis_im(String nume_i)
	 	{
		 	if (img==null){
		 		img = frm.getImage(frm.getCodeBase(), nume_i);
		 	}
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
		 desen.drawLine((int)(x1+(w/val_max)*val) ,y1+50, (int)(x1+w/2), y1+h-30);
		 desen.drawString(Integer.toString((int)val), x1+w-40, y1+h-8);
	 }
	 
}



