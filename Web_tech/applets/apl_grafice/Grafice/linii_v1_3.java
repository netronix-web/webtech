package Grafice;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Graphics;

public class linii_v1_3 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; // panel_1 cu controale plasate
	private JPanel panel_1 = null; // panoul 1
	private JLabel etich_1 = null; // eticheta 1
	private JButton but_1 = null; // butonul 1
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
	public linii_v1_3() {
		super();
	}
	    public void deseneaza() {
			if(grf==null){
				grf=panel_1.getGraphics();
			}
			//grf.clearRect(0, 0, getSize().width, getSize().height);
	    	grf.setColor(Color.MAGENTA);
	        for (int x = 0 ; x < getSize().width/2 ; x+=10) {    
		    grf.drawOval(150-x/2, 100-x/2, x, x);
	        }
	    }
	
	
	/**
	 * 	/**
	 * Aceasta metoda creaza panelul: "but_1"	
	 * Returneaza but_1 de tipul:	javax.swing.JButton
	 */
	
	
	private JButton creaza_but_1() {
		if (but_1 == null) {
			but_1 = new JButton();
			but_1.setBounds(new Rectangle(120, 260, 70, 30));
			but_1.setText("Start");
			
			but_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					deseneaza();
					
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
			panel_1.setBounds(new Rectangle(20, 30, 300, 220));
			// se forteaza culoarea fundalului 
			this.setBackground(c_panel_1.getBackground());
		}
		return panel_1;
	}

	/**
	 * Aceasta metoda initializeaza panel_1 plasand controalele dorite 
	 * Returneaza c_panel_1 de tipul: javax.swing.JPanel 
	 */
	
	
	private JPanel init_panel_1() {
		if (c_panel_1 == null) {
			etich_1 = new JLabel();
			etich_1.setBounds(new Rectangle(10, 10, 200, 10));
			etich_1.setText("Apasati butonul Start");
			c_panel_1 = new JPanel();
			c_panel_1.setLayout(null);
			c_panel_1.add(creaza_but_1(), null);
			c_panel_1.add(etich_1, null);
			c_panel_1.add(creaza_panel_1(), null);
			c_panel_1.setLayout(new BorderLayout());
		}
		return c_panel_1;
	}
}





