package Grafice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class linii_v3 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; //panel_1 cu controale plasate
	private JLabel etich_1 = null; // eticheta 1 
	private JSlider slider_1 = null; // slider-ul 1
	private JPanel panel_1 = null; // panoul 1
	private Graphics grf=null;

	/**
	 * Aceasta metoda initializeaza: this
	 * 
	 * @returneaza  void
	 */
	public void init() {
		this.setSize(310,280);
		this.setContentPane(init_panel_1());
	}

	/**
	 * Constructorul implicit pentru "linii_v3"
	 */
	public linii_v3() {
		super();
	}

	/**
	 * Aceasta metoda creaza panelul: "panel_1"	
	 * Returneaza panel_1 de tipul:	javax.swing.JPanel
	 */
	private JPanel creaza_panel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridBagLayout());
			panel_1.setBounds(new Rectangle(20, 40, 250, 180));
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
			etich_1.setBounds(new Rectangle(75, 10, 100, 10));
			etich_1.setText("Utilizare slider");
			creaza_slider_1();
			slider_1.setBounds(new Rectangle(10, 240, 270, 25));
			c_panel_1 = new JPanel();
			c_panel_1.setLayout(null);
			c_panel_1.add(etich_1, null);
			c_panel_1.add(creaza_slider_1(), null);
			c_panel_1.add(creaza_panel_1(), null);
			c_panel_1.setLayout(new BorderLayout());
		}
		return c_panel_1;
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
					if(grf==null){	
						grf= panel_1.getGraphics();
					}
					grf.clearRect(0, 0, getSize().width, getSize().height);
					grf.setColor(Color.BLUE);
					int x2=panel_1.getSize().width*slider_1.getValue()/slider_1.getMaximum();
					grf.drawLine(120, 40, x2, 180);
				}
			});
		}
		return slider_1;
	}
}




