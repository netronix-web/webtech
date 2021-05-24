package Imagini;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.Timer;

import java.awt.Graphics;

public class imag_v4 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; 	// panel_1 cu controale plasate
	private JPanel panel_1 = null; 		// panoul 1
    private int delay=500;				// temporizare
    private Timer timer_1=null;			// timer 1
	private Graphics grf=null;
	private Image img = null;
	int val=0;							// valoarea afisata


	/**
	 * Aceasta metoda initializeaza: this
	 * 
	 * @returneaza  void
	 */
	public void init() {
		this.setSize(350, 300);
		this.setContentPane(init_panel_1());
	}

	/**
	 * Constructorul implicit
	 */
	public imag_v4() {
		super();
	}
	private void deseneaza()
	{
		int x1,y1,w,h,val_max;
		x1=70;
		y1=50;
		w=173;
		h=154;
		val_max=w;
        //grf.drawImage(img,0 ,20, 173, 154,panel_1.getBackground(),c_panel_1);
		grf.drawImage(img, x1, y1, w, h, Color.white, null);
		val+=10;
		if(val>val_max)
			val=0;
		grf.setColor(Color.RED);
		grf.drawLine((int)(x1+(w/val_max)*val) ,y1+50, (int)(x1+w/2), y1+h-30);
	}
	
	
	/**
	 * 	/**
	 * Aceasta metoda creaza panelul: "but_1"	
	 * Returneaza but_1 de tipul:	javax.swing.JButton
	 */
	
	
	private void creaza_timer_1() {

		if (timer_1 == null) {
				timer_1 = new Timer(delay, null);
				timer_1.setInitialDelay(1); // Temporizare initiala
				timer_1.setCoalesce(true);
				timer_1.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						deseneaza();
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
			panel_1.setBounds(new Rectangle(20, 30, 300, 220));
			// se forteaza culoarea fundalului 
			//panel_1.setBackground(c_panel_1.getBackground());
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
			c_panel_1.add(creaza_panel_1(), null);
			c_panel_1.setLayout(new BorderLayout());
			if(grf==null){
				grf=this.getGraphics();
			}
			if(img==null){
				img = getImage(getCodeBase(), "voltmeter.jpg");
			}	
			deseneaza();
			creaza_timer_1();
			timer_1.start();
		}
		return c_panel_1;
	}
}





