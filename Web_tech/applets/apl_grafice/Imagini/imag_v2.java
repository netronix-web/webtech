package Imagini;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;

public class imag_v2 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; 	// panel_1 cu controale plasate
	private JPanel panel_1 = null; 		// panoul 1
	private JLabel etich_1 = null; 		// eticheta 1
	private JButton but_1 = null; 		// butonul 1
	private JButton but_2 = null; 		// butonul 1
	private ImageIcon icon = null;
	private Graphics  grf = null;

	/**
	 * Constructorul implicit pentru "imag_v2"
	 
	*/
	public imag_v2() {
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
			but_1.setBounds(new Rectangle(120, 180, 90, 30));
			but_1.setText("Imagine");
			but_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
			        if (icon != null) {
			        	etich_1.setText("");
						etich_1.setIcon(icon);
						etich_1.repaint(10, 10, 350, 150);
			        } else { //image not found
			        	etich_1.setText("voltmeter.jpg - not found");
			        }
				}
			});
		}
		return but_1;
	}
	/**
	 * 
	 * Aceasta metoda creaza panelul: "but_2"	
	 * Returneaza but_1 de tipul:	javax.swing.JButton
	 */
	
	private JButton creaza_but_2() {
		if (but_2 == null) {
			but_2 = new JButton();
			but_2.setBounds(new Rectangle(120, 220, 90, 30));
			but_2.setText("Linie");
			but_2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) { 
			        if (grf == null){
			        	grf = panel_1.getGraphics();
			        }
					grf.setColor(Color.RED);
					grf.drawLine(20, 20, 200, 300);
				}
			});
		}
		return but_2;
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
			etich_1 = new JLabel();
			etich_1.setBounds(new Rectangle(10, 10, 350, 150));
			etich_1.setText("");
			icon = new ImageIcon("voltmeter.jpg","Volmeter");
			c_panel_1 = new JPanel();
			c_panel_1.setLayout(null);
			c_panel_1.add(creaza_but_1(), null);
			c_panel_1.add(creaza_but_2(), null);
			c_panel_1.add(etich_1, null);
			c_panel_1.add(creaza_panel_1(), null);
			c_panel_1.setLayout(new BorderLayout());
		}
		return c_panel_1;
	}
}




