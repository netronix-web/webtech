package Controale;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JLabel;

public class utiliz_buton_v1 extends JApplet {
	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; 	// panel_1 cu controale plasate
	private JButton but_1 = null; 		// butonul 1
	private JLabel etich_1 = null; 		//eticheta 1

	/**
	 * Constructorul implicit pentru "utiliz_buton_v1"
	 */
	
	public utiliz_buton_v1() {
		super();
	}

	/**
	 * Aceasta metoda initializeaza: this
	 * 
	 * @returneaza  void
	 */
	
	public void init() {
		this.setSize(300, 200);
		this.setContentPane(init_panel_1());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	
	private JPanel init_panel_1() {
		if ( c_panel_1 == null) {
			etich_1 = new JLabel();
			etich_1.setText("JLabel");
			c_panel_1 = new JPanel();
			c_panel_1.setLayout(new BorderLayout());
			c_panel_1.add(creaza_but_1(), BorderLayout.SOUTH);
			c_panel_1.add(etich_1, BorderLayout.NORTH);
		}
		return  c_panel_1;
	}

	/**
	 * 	
	 * Aceasta metoda creaza panelul: "but_1"	
	 * Returneaza but_1 de tipul:	javax.swing.JButton
	 */
	
	private JButton creaza_but_1() {
		if (but_1 == null) {
			but_1 = new JButton();
			but_1.setText("Start");
			but_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					etich_1.setText("Ati apasat butonul start.");				
				}
			});
		}
		return but_1;
	}
}
