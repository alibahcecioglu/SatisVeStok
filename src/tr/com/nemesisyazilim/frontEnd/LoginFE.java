package tr.com.nemesisyazilim.frontEnd;

import java.awt.BorderLayout;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.nemesisyazilim.dal.AccountsDal;
import tr.com.nemesisyazilim.dal.PersonelDal;
import tr.com.nemesisyazilim.interfaces.FrontEndInterfaces;
import tr.com.nemesisyazilim.types.PersonelContract;

public class LoginFE extends JDialog implements FrontEndInterfaces {

	JPanel panel;
	JTextField paswordField;
	public static JComboBox emailBox;
	public LoginFE() {
		
		initPencere();
		
	}

	public void initPencere() {
		
      JPanel panel = initPanel();
		
		panel.setBorder(BorderFactory.createTitledBorder("Login Ekraný "));
		
		add(panel);

		
		setTitle("Giriþ Yap");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);// Pencere acildiginda ortada dursun
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	public JPanel initPanel() {
		
		panel = new JPanel(new GridLayout(5,2));
		
		JLabel emailLabel = new JLabel("Email : ", JLabel.RIGHT);
		emailBox=new JComboBox(new PersonelDal().getAll().toArray());
	    JLabel passwordLabel=new JLabel("Þifre : ", JLabel.RIGHT);
		paswordField=new JTextField(15);
	    
		panel.add(emailLabel);
		panel.add(emailBox);
		panel.add(passwordLabel);
		panel.add(paswordField);
		
		JButton loginBtn=new JButton("Giriþ Yap");
		JButton iptalBtn=new JButton("Iptal");
		panel.add(loginBtn);
		panel.add(iptalBtn);
		
		loginBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				PersonelContract personel=(PersonelContract) emailBox.getSelectedItem();
				String sifre=paswordField.getText();
				if(new AccountsDal().getPersonelIdveSifre(personel.getId(),sifre).getId()!=0){
					setVisible(false);
					new AnaPencereFE();
				}else{
					JOptionPane.showMessageDialog(null,"Giriþ Baþarýsýz");
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
