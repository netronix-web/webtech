package Controale;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JLabel;

public class utiliz_label_v2 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; 	// panel_1 cu controale plasate
	private JLabel etich_1 = null; 		// eticheta 1
	private JPanel panel_1 = null; 		// panoul 1
	
	/**
	 * Constructorul implicit pentru "utiliz_label_v2"
	 */
	
	public utiliz_label_v2() {
		super();
	}

	/**
	 * Aceasta metoda initializeaza: this
	 * 
	 * @returneaza  void
	 */
	
	public void init() {
		this.setSize(300,200);
		this.setContentPane(init_panel_1());
	}


	/**
	 * Aceasta metoda creaza panelul: "panel_1"	
	 * Returneaza panel_1 de tipul:	javax.swing.JPanel
	 */
	
	private JPanel creaza_panel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridBagLayout());
			panel_1.setBounds(new Rectangle(0, 20, 450, 200));
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
			etich_1.setBounds(new Rectangle(15, 10, 250, 10));
			etich_1.setText("Text in eticheta la pozitia: 15-10-250-10");
			c_panel_1 = new JPanel();
			c_panel_1.setLayout(null);
			c_panel_1.add(etich_1, null);
			c_panel_1.add(creaza_panel_1(), null);
			c_panel_1.setLayout(new BorderLayout());
		}
		return c_panel_1;
	}
}


