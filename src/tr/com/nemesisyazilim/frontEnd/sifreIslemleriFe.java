package tr.com.nemesisyazilim.frontEnd;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.nemesisyazilim.dal.AccountsDal;
import tr.com.nemesisyazilim.dal.PersonelDal;
import tr.com.nemesisyazilim.dal.YetkilerDal;
import tr.com.nemesisyazilim.interfaces.FrontEndInterfaces;
import tr.com.nemesisyazilim.types.AccountsContract;
import tr.com.nemesisyazilim.types.PersonelContract;
import tr.com.nemesisyazilim.types.YetkilerContract;

public class sifreIslemleriFe extends JDialog implements FrontEndInterfaces{

	
	JComboBox personelBox;
	JComboBox yetkiBox;
	JPasswordField passField;
	JPasswordField passTekrarField;
	public sifreIslemleriFe() {
		initPencere();
	}

	public void initPencere() {
		
		JPanel panel = initPanel();
		
		panel.setBorder(BorderFactory.createTitledBorder("Þifre iþlemleri"));
		
		add(panel);

		
		setTitle("Þifre");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);// Pencere acildiginda ortada dursun
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
	}

	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(5,2));
		
		JLabel personelLabel = new JLabel("Personel Seç : ", JLabel.RIGHT);
		personelBox=new JComboBox(new PersonelDal().getAll().toArray());
		JLabel yetkiLabel = new JLabel("Yetki Seç : ", JLabel.RIGHT);
		yetkiBox=new JComboBox(new YetkilerDal().getAll().toArray());
		JLabel passwordLabel = new JLabel("Þifre Belirle : ", JLabel.RIGHT);
		passField=new JPasswordField(10);
		JLabel passwordTekrarLabel = new JLabel("Þifre Tekrarý : ", JLabel.RIGHT);
		passTekrarField=new JPasswordField(10);
		
		panel.add(personelLabel);
		panel.add(personelBox);
		panel.add(yetkiLabel);
		panel.add(yetkiBox);
		panel.add(passwordLabel);
		panel.add(passField);
		panel.add(passwordTekrarLabel);
		panel.add(passTekrarField);
		
		JButton kaydetBtn = new JButton("Kaydet");
		panel.add(kaydetBtn);
		JButton iptalBtn = new JButton("Ýptal");
		panel.add(iptalBtn);
		
		kaydetBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				AccountsContract account=new AccountsContract();
				PersonelContract personel=(PersonelContract) personelBox.getSelectedItem();
				YetkilerContract yetkiler=(YetkilerContract) yetkiBox.getSelectedItem();
				if(passField.getText().equals(passTekrarField.getText())){
					account.setPersonelId(personel.getId());
					account.setYetkiId(yetkiler.getId());
					account.setSifre(passField.getText());
					JOptionPane.showMessageDialog(null, yetkiler.getAdi()+" yetkisi verilmiþtir.");
					new AccountsDal().Insert(account);
				    }
				 else
				    {
					
					JOptionPane.showMessageDialog(null, " Þifre eþleþmiyor!!!");
		    		}
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
