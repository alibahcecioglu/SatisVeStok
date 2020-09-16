package tr.com.nemesisyazilim.frontEnd;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import tr.com.nemesisyazilim.interfaces.FrontEndInterfaces;

public class musteriEkleFe extends JDialog implements FrontEndInterfaces {

	
	JComboBox sehirlerBox;
	JTextField adiSoyadiField;
	JTextField telefonField;
	JTextArea adresArea;
	public musteriEkleFe() {
	
		initPencere();
		
	}

	public void initPencere() {
      
		JPanel panel = initPanel();
		
		panel.setBorder(BorderFactory.createTitledBorder("Müþteri Ekleme Ekraný "));
		
		add(panel);

		
		setTitle("Müþteri Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);// Pencere acildiginda ortada dursun
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	public JPanel initPanel() {

		JPanel panel = new JPanel(new BorderLayout());
		JPanel fieldPanel=new JPanel(new GridLayout(5,2));
		JPanel butonPanel=new JPanel(new GridLayout(1,2));
		
		JLabel adiSoyadiLabel = new JLabel("Adi Soyadi : ", JLabel.RIGHT);
		adiSoyadiField=new JTextField(15);
	    JLabel telefonLabel=new JLabel("Telefon : ",JLabel.RIGHT);
	    telefonField=new JTextField(15);
	    JLabel sehirSecLabel=new JLabel("Þehir Seç : ",JLabel.RIGHT);
		sehirlerBox=new JComboBox();
		JLabel adresLabel=new JLabel("");
	    adresArea=new JTextArea(7,2);
	    JScrollPane pane=new JScrollPane(adresArea);
	    
	    fieldPanel.add(adiSoyadiLabel);
	    fieldPanel.add(adiSoyadiField);
	    fieldPanel.add(telefonLabel);
	    fieldPanel.add(telefonField);
	    fieldPanel.add(sehirSecLabel);
	    fieldPanel.add(sehirlerBox);
	    fieldPanel.add(adresLabel);
	    
	    JButton kaydetBtn = new JButton("Kaydet");
	    butonPanel.add(kaydetBtn);
		JButton iptalBtn = new JButton("iptal");
		butonPanel.add(iptalBtn);
	    
	    panel.add(fieldPanel,BorderLayout.NORTH);
	    panel.add(pane,BorderLayout.CENTER);
	    panel.add(butonPanel,BorderLayout.SOUTH);
	    
		return panel;
	}

	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}

	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

}
