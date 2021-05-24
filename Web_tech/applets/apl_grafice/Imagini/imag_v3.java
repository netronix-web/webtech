package Imagini;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
//import java.awt.image.ImageObserver;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;

public class imag_v3 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; 	// panel_1 cu controale plasate
	private JPanel panel_1 = null; 		// panoul 1
	private JLabel etich_1 = null; 		// eticheta 1
	private JButton but_1 = null; 		// butonul 1
	private Image img = null;
	private Graphics grf=null;
	//private ImageObserver ob=null;

	
	/**
	 * Aceasta metoda initializeaza: this
	 * 
	 * @returneaza  void
	 */
	
	public void init() {
		this.setSize(320,230);
		this.setContentPane(init_panel_1());
	}
	/**
	 * Constructorul implicit
	 */
	public imag_v3() {
		super();
	}
	
	private void deseneaza(){
		grf.drawImage(img, 60, 20, 173, 154, Color.white, null);
		grf.setColor(Color.RED);
		//grf.drawRect(50, 50, 130, 80);
	}
	
	/**
	 * 
	 * Aceasta metoda creaza panelul: "but_1"	
	 * Returneaza but_1 de tipul:	javax.swing.JButton
	 */
	
	private JButton creaza_but_1() {
		if (but_1 == null) {
			but_1 = new JButton();
			but_1.setBounds(new Rectangle(120, 190, 70, 30));
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
			panel_1.setBounds(new Rectangle(30, 20, 180, 160));
			// se forteaza culoarea fundalului 
			panel_1.setBackground(c_panel_1.getBackground());
			//panel_1.setBackground(Color.white);
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
			etich_1.setBounds(new Rectangle(10, 0, 200, 20));
			etich_1.setText("Apasati butonul -Start-");
			if(grf==null){
				grf=this.getGraphics();
			}
			if(img==null){
				img = getImage(getCodeBase(), "voltmeter.jpg");
			}
			deseneaza();
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




