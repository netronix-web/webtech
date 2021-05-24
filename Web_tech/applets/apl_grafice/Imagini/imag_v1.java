package Imagini;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;

public class imag_v1 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; 	// panel_1 cu controale plasate
	private JPanel panel_1 = null; 		// panoul 1
	private JLabel etich_1 = null; 		// eticheta 1
	private JButton but_1 = null; 		// butonul 1
	private ImageIcon icon = null;

	/**
	 * Constructorul implicit pentru "imag_v1"
	 */
	
	public imag_v1() {
		super();
	}
	
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
	 * 
	 * Aceasta metoda creaza panelul: "but_1"	
	 * Returneaza but_1 de tipul:	javax.swing.JButton
	 */
	
	private JButton creaza_but_1() {
		if (but_1 == null) {
			but_1 = new JButton();
			but_1.setBounds(new Rectangle(120, 180, 70, 30));
			but_1.setText("Start");
			but_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
			        if (icon != null) {
			        	etich_1.setText("");
						etich_1.setIcon(icon);
			        } else { //image not found
			        	etich_1.setText("voltmeter.jpg - not found");
			        }
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
			panel_1.setBounds(new Rectangle(0, 20, 250, 310));
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
			etich_1.setText("Apasati butonul -Start-");
			icon = new ImageIcon("voltmeter.jpg","Voltmetru analogic");			
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




