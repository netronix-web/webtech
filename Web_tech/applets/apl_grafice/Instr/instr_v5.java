package Instr;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class instr_v5 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JLabel etich_1 = null; 		// eticheta 1
	private JLabel etich_2 = null; 		// eticheta 2
	private JSlider slider_1 = null; 	// slider-ul 1
	private JPanel panel_1 = null; 		// panoul 1
	private JPanel c_panel_1 = null; 	// panoul 1 cu controale plasate
    private int delay=1000;				// temporizare
    private Timer timer_1=null;			// timer 1
	private DocumentBuilderFactory dbf; 
	private DocumentBuilder db;
	private Document doc;
	private NodeList n1=null;
	//private String xmlDocURI = "http://193.226.19.159/tmp/vimeter_v0.xml";
	//private String xmlDocURI = "http://www.science.upm.ro/~traian/web_curs/vimeter_v0.xml";
	//private String xmlDocURI = "http://www.science.upm.ro/~traian/web_curs/vimeter.xml";
	//private String xmlDocURI = "http://www.science.upm.ro/~traian/web_curs/Web_tech/xml/xml_php/ap_electric.php";
	private String xmlDocURI = "http://www.science.upm.ro/~traian/web_curs/vimeter.php";

    

	/**
	 * Constructorul implicit pentru "instr_v5"
	 */
	public instr_v5() {
		super();
	}
	
	/**
	 * Aceasta metoda initializeaza: this
	 * 
	 * @returneaza  void
	 */
	
	
	public void init() {
		this.setSize(500,350);
		this.setContentPane(init_panel_1());
	    try {
	        dbf = DocumentBuilderFactory.newInstance();
	        db = dbf.newDocumentBuilder();
	    }
	      	catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * Aceasta metoda:
	 * - citeste continutl fisierului de la URL-ul:xmlDocURI  
	 * - citeste Tag-ul "val" 
	 * - afiseaza valoarea citta in etich_1
	 */
	
	  public void start()
	  {
	    try {
	      doc = db.parse(xmlDocURI);
	      n1= doc.getElementsByTagName("val");
	      //etich_1.setText(n1.item(0).getTextContent());
	      etich_2.setText("A reusit conectarea!");
	    } catch(Exception e) {
	      e.printStackTrace();
	      etich_2.setText(e.getMessage());
	    } 
	  }


	/**
	 * Aceasta metoda initializeaza controlul de tip slider: slider_1
	 * @returneaza slider_1 de tipul: javax.swing.JSlider	
	 */
	private JSlider creaza_slider_1() {
		if (slider_1 == null) {
			//slider_1 = new JSlider(JSlider.HORIZONTAL,0,50,25); // (amplasare, minim, maxim, val_initiala)
			slider_1 = new JSlider(JSlider.VERTICAL,0,250,25); // (amplasare, minim, maxim, val_initiala)
			slider_1.setMajorTickSpacing(50);
			slider_1.setMinorTickSpacing(5);
			slider_1.setPaintTicks(true);
			slider_1.setPaintLabels(true); 
			//slider_1.setBounds(new Rectangle(10, 140, 270, 60));
			slider_1.setBounds(new Rectangle(10, 50, 80, 270));
			// Invalidez evenimentele de la slider
			//slider_1.addChangeListener(new javax.swing.event.ChangeListener() {
				//public void stateChanged(javax.swing.event.ChangeEvent e) {
					//etich_2.setText(Integer.toString(slider_1.getValue()));
			//	}
			//});
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
							start();
							String tn1=n1.item(0).getTextContent();
							etich_2.setText(tn1);
							slider_1.setValue(Integer.parseInt(tn1));
							Graphics grf= panel_1.getGraphics();
							grf.setColor(Color.BLUE);
							grf.drawLine(250, 40, 80+2*slider_1.getValue(), 300);
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
			etich_1 = new JLabel("Valoarea citita:");
			etich_1.setBounds(new Rectangle(10, 10, 100, 10));		
			etich_2 = new JLabel("Se asteapta conectarea.");
			etich_2.setBounds(new Rectangle(110, 10, 400, 10));	
			c_panel_1 = new JPanel();
			c_panel_1.setLayout(null);
			c_panel_1.add(etich_1, null);
			c_panel_1.add(etich_2, null);
			c_panel_1.add(creaza_slider_1(), null);
			c_panel_1.add(creaza_panel_1(), null);
			c_panel_1.setLayout(new BorderLayout());
			creaza_timer_1();
			timer_1.start();
		}
		return c_panel_1;
	}	
}




