package Controale;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JLabel;

public class utiliz_label_v1 extends JApplet {
	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; // panel_1 cu controale plasate
	private JLabel etich_1 = null;   // eticheta 1

	/**
	 * Constructorul implicit pentru "utiliz_slider_v1"
	 */
	
	public utiliz_label_v1() {
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
			etich_1.setText("Text plasat in pozitia NORTH");
			c_panel_1 = new JPanel();
			c_panel_1.setLayout(new BorderLayout());
			c_panel_1.add(etich_1, BorderLayout.NORTH);
		}
		return  c_panel_1;
	}
}