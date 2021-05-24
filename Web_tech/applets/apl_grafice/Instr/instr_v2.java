package Instr;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class instr_v2 extends JApplet {

	private static final long serialVersionUID = 1L;
	private JPanel c_panel_1 = null; 	// panel_1 cu controale plasate
	private JPanel panel_1 = null; 		// panoul 1
	private JLabel etich_1 = null; 		// eticheta 1
	private JLabel etich_2 = null; 		// eticheta 2
	private JTextArea text_1 = null;    // zona de text 1
	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	private Document doc;
	//private String xmlDocURI = "http://193.226.19.159/tmp/vimeter_v0.xml";
	//private String xmlDocURI = "http://www.science.upm.ro/~traian/web_curs/vimeter_v0.xml";
	//private String xmlDocURI = "http://www.science.upm.ro/~traian/web_curs/vimeter.xml";
	//private String xmlDocURI = "http://www.science.upm.ro/~traian/web_curs/Web_tech/xml/xml_php/ap_electric.php";
	private String xmlDocURI = "http://www.science.upm.ro/~traian/web_curs/vimeter.php";
	
	/**
	 * Constructorul implicit pentru "instr_v2"
	 */
	
	public instr_v2() {
		super();
	}
	
	/**
	 * Aceasta metoda initializeaza: this
	 * 
	 * @returneaza  void
	 */
	
	public void init() {
		this.setSize(450, 200);
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
	      NodeList n1,n2,n3,n4;
	      doc = db.parse(xmlDocURI);
	      n1= doc.getElementsByTagName("val");
	      n2= doc.getElementsByTagName("caption");
	      n3= doc.getElementsByTagName("aspect");
	      n4= doc.getElementsByTagName("backcolor");
	      etich_2.setText(n1.item(0).getTextContent());
	      
	      text_1.setText(doc.getElementsByTagName("*").toString());
	      
	      text_1.setText(text_1.getText()+
	    		  "\nCaption:"+n2.item(0).getTextContent()+
	    		  "\nAspect: "+n3.item(0).getTextContent()+
	    		  "\nBackcolor: "+n4.item(0).getTextContent()+
	    		  "\nValoarea citita: "+n1.item(0).getTextContent());
	    } catch(Exception e) {
	      e.printStackTrace();
	      etich_1.setText(e.getMessage());
	    } 
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
			panel_1.setBounds(new Rectangle(0, 20, 440, 200));
		}
		return panel_1;
	}

	/**
	 * Aceasta metoda initializeaza panel_1 plasand controalele dorite 
	 * Returneaza c_panel_1 de tipul: javax.swing.JPanel 
	 */
	
	private JPanel init_panel_1() {
		if (c_panel_1 == null) {
			etich_1 = new JLabel("Valoarea citita:");
			etich_1.setBounds(new Rectangle(10, 10, 100, 10));
			etich_2 = new JLabel();
			etich_2.setBounds(new Rectangle(110, 10, 100, 10));
			text_1 = new JTextArea();
			text_1.setLineWrap(true);
			text_1.setWrapStyleWord(true); 
			text_1.setBounds(new Rectangle(10, 60, 400, 100));
			c_panel_1 = new JPanel();
			c_panel_1.setLayout(null);
			c_panel_1.add(etich_1, null);
			c_panel_1.add(etich_2, null);
			c_panel_1.add(text_1, null);
			c_panel_1.add(creaza_panel_1(), null);
			c_panel_1.setLayout(new BorderLayout());
		}
		return c_panel_1;
	}
}




