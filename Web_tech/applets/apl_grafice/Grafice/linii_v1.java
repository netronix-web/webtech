package Grafice;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.Timer;

import java.awt.Graphics;

public class linii_v1 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; 	// panel_1 cu controale plasate
	private JPanel panel_1 = null; 		// panoul 1
    private int delay=500;				// temporizare
    private Timer timer_1=null;			// timer 1
	private Graphics grf=null;


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
	 * Constructorul implicit pentru "linii_v2"
	 */
	public linii_v1() {
		super();
	}
	private void deseneaza()
	{
		if(grf==null){
			grf=panel_1.getGraphics();
		}
		grf.clearRect(0, 0, getSize().width, getSize().height);
		grf.setColor(Color.BLUE);
		grf.drawRect(10, 10, 220, 190);// dreptungi cu coordonatele:(x,y,w,h)
		grf.setColor(Color.RED);
		grf.drawLine(20, 20, 290, 180);// linie cu coordonatele:(x,y,x2,y2)
		grf.setColor(Color.green);
		grf.drawLine( 90,170, 185, 18);// linie cu coordonatele:(x,y,x2,y2)
		grf.setColor(Color.magenta);
		grf.drawOval(40, 30, 240, 110);// elipsa cu coordonatele:(x,y,w,h)
		//timer_1.stop();
	}
	
	
	/**
	 * 	/**
	 * Aceasta metoda creaza panelul: "but_1"	
	 * Returneaza but_1 de tipul:	javax.swing.JButton
	 */
	
	
	private void creaza_timer_1() {

		if (timer_1 == null) {
				timer_1 = new Timer(delay, null);
				//timer_1.setInitialDelay(delay *1); // Temporizare initiala
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
			//this.setBackground(c_panel_1.getBackground());
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
			creaza_timer_1();
			timer_1.start();
		}
		return c_panel_1;
	}
}





