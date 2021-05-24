package Controale;

import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class utiliz_c_text_v1 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; 	// panel_1 cu controale plasate
	private JLabel etich_1 = null;		// eticheta 1
	private JLabel etich_2 = null;		// eticheta 2
	private JButton but_1 = null; 		// buton 1
	private JTextField text_1=null;		// campul text 1
	/**
	 * Constructorul implicit pentru "utiliz_buton_v2"
	 */
	
	public utiliz_c_text_v1() {
		super();
	}
	
	/**
	 * Aceasta metoda initializeaza: this
	 * 
	 * @returneaza  void
	 */
	
	public void init() {
		this.setSize(350, 200);
		this.setContentPane(init_panel_1());
	}

	/**
	 * 
	 * Aceasta metoda creaza butonul: "but_1"	
	 * Returneaza but_1 de tipul:	javax.swing.JButton
	 */
	
	private JButton creaza_but_1() {
		if (but_1 == null) {
			but_1 = new JButton();
			but_1.setBounds(new Rectangle(100, 140, 120, 30));
			but_1.setText("Calculeaza");
			but_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					etich_1.setText("Ati introdus: "+text_1.getText());
					Double patr = Double.parseDouble(text_1.getText());
					patr=patr*patr;
					etich_2.setText("Patratul numarului fiind: "+patr.toString());
				}
			});
		}
		return but_1;
	}
	
	/**
	 * Aceasta metoda initializeaza panel_1 plasand controalele dorite 
	 * Returneaza c_panel_1 de tipul: javax.swing.JPanel 
	 */
	
	private JPanel init_panel_1() {
		if (c_panel_1 == null) {
			etich_1 = new JLabel();
			etich_1.setBounds(new Rectangle(15, 10, 300, 10));
			etich_1.setText("Introduceti un numar si apasati butonul Calculeaza:");
			etich_2 = new JLabel();
			etich_2.setBounds(new Rectangle(15, 30, 300, 10));
			etich_2.setText("");
			text_1 = new JTextField();
			text_1.setText("0.00");
			text_1.setBounds(new Rectangle(15, 50, 75, 23));
			c_panel_1 = new JPanel();
			c_panel_1.setLayout(null);
			c_panel_1.add(etich_1, null);
			c_panel_1.add(etich_2, null);
			c_panel_1.add(text_1, null);
			c_panel_1.add(creaza_but_1(), null);		
		}
		return c_panel_1;
	}
}