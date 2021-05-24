package Controale;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.Timer;

public class utiliz_slider_v4 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JLabel etich_1 = null; 		// eticheta 1 
	private JSlider slider_1 = null; 	// slider-ul 1
	private JPanel panel_1 = null; 		// panoul 1
	private JPanel c_panel_1 = null; 	// panoul 1 cu controale plasate
    private int delay=50;				// temporizare
    private Timer timer_1=null;			// timer 1

	/**
	 * Constructorul implicit pentru "utiliz_slider_v4"
	 */
	public utiliz_slider_v4() {
		super();
	}
	
	/**
	 * Aceasta metoda initializeaza: this
	 * 
	 * @returneaza  void
	 */
	
	public void init() {
		this.setSize(150,300);
		this.setContentPane(init_panel_1());
	}

	/**
	 * Aceasta metoda initializeaza controlul de tip slider: slider_1
	 * @returneaza slider_1 de tipul: javax.swing.JSlider	
	 */
	private JSlider creaza_slider_1() {
		if (slider_1 == null) {
			//slider_1 = new JSlider(JSlider.HORIZONTAL,0,50,25); // (amplasare, minim, maxim, val_initiala)
			slider_1 = new JSlider(JSlider.VERTICAL,0,50,25); // (amplasare, minim, maxim, val_initiala)
			slider_1.setMajorTickSpacing(10);
			slider_1.setMinorTickSpacing(1);
			slider_1.setPaintTicks(true);
			slider_1.setPaintLabels(true); 
			//slider_1.setBounds(new Rectangle(10, 140, 270, 60));
			slider_1.setBounds(new Rectangle(10, 10, 80, 270));
			slider_1.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					etich_1.setText(Integer.toString(slider_1.getValue()));
				}
			});
		}
		return slider_1;
	}
	
	/**
	* Aceasta metoda creaza "timer_1"	
	* nu returneaza nimic
	*/
		
	private void creaza_timer_1() {

			if (timer_1 == null) {
					timer_1 = new Timer(delay, null);
					//timer_1.setInitialDelay(delay *1); // Temporizare initiala
					timer_1.setCoalesce(true);
					timer_1.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							etich_1.setText(Integer.toString(slider_1.getValue()));
							if(slider_1.getValue()==slider_1.getMaximum()){
								slider_1.setValue(0);
								}
							else{
								slider_1.setValue(slider_1.getValue()+1);
							}
						}
					});					
    }
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
			etich_1.setBounds(new Rectangle(100, 12, 150, 10));
			etich_1.setText("Utilizare slider");
			c_panel_1 = new JPanel();
			c_panel_1.setLayout(null);
			c_panel_1.add(etich_1, null);
			c_panel_1.add(creaza_slider_1(), null);
			c_panel_1.add(creaza_panel_1(), null);
			c_panel_1.setLayout(new BorderLayout());
			creaza_timer_1();
			timer_1.start();
		}
		return c_panel_1;
	}	
}




