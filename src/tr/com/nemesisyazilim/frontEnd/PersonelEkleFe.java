package tr.com.nemesisyazilim.frontEnd;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.nemesisyazilim.dal.PersonelDal;
import tr.com.nemesisyazilim.interfaces.FrontEndInterfaces;
import tr.com.nemesisyazilim.types.PersonelContract;

public class PersonelEkleFe extends JDialog implements FrontEndInterfaces {

	JTextField adiSoyadiField;
	JTextField emailField;
	public PersonelEkleFe() {
		
		initPencere();
		
	}

	public void initPencere() {
       
		JPanel panel = initPanel();	
		panel.setBorder(BorderFactory.createTitledBorder("Personel Kayýt Alaný"));
		add(panel);
		
		setTitle("Personel Ekle");
		setModalityType(DEFAULT_MODALITY_TYPE);	
		pack();
		setLocationRelativeTo(null);// Pencere acildiginda ortada dursun
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	public JPanel initPanel() {

		JPanel panel=new JPanel(new GridLayout(3,2));
		
		JLabel adiSoyadiLabel=new JLabel("Adý Soyadi : ", JLabel.RIGHT);
		adiSoyadiField=new JTextField(10);
		panel.add(adiSoyadiLabel);
		panel.add(adiSoyadiField);
		
		JLabel emailLabel=new JLabel("Email :",JLabel.RIGHT);
		emailField=new JTextField(20);
		panel.add(emailLabel);
		panel.add(emailField);
		
		JButton kaydetBtn = new JButton("Kaydet");
		panel.add(kaydetBtn);
		JButton iptalBtn = new JButton("Ýptal");
		panel.add(iptalBtn);
		
		
		kaydetBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				PersonelContract personel=new PersonelContract();
				personel.setAdSoyad(adiSoyadiField.getText());
				personel.setEmail(emailField.getText());
				
				new PersonelDal().Insert(personel);
				JOptionPane.showMessageDialog(null, personel.getAdSoyad()+" Personel eklenmiþtir.");
			}
			
			
		});
		
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
 