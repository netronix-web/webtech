package Controale;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JSlider;
import javax.swing.JLabel;

public class utiliz_slider_v1 extends JApplet {
	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; 	// panel_1 cu controale plasate
	private JSlider slider_1 = null;	// slider_1	
	private JLabel etich_1 = null;		// eticheta 1

	/**
	 * Constructorul implicit pentru "utiliz_slider_v1"
	 */
	
	public utiliz_slider_v1() {
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
	 * Aceasta metoda initializeaza controlul de tip slider: slider_1
	 * @returneaza slider_1 de tipul: javax.swing.JSlider	
	 */
	
	private JSlider creaza_slider_1() {
		if (slider_1 == null) {
			slider_1 = new JSlider();
			slider_1.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {

					etich_1.setText(Integer.toString(slider_1.getValue()));
				}
			});
		}
		return slider_1;
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
			 c_panel_1.add(creaza_slider_1(), BorderLayout.SOUTH);
			 c_panel_1.add(etich_1, BorderLayout.NORTH);

		}
		return  c_panel_1;
	}
}
