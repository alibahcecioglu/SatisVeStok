package tr.com.nemesisyazilim.frontEnd;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.nemesisyazilim.dal.UrunlerDal;
import tr.com.nemesisyazilim.dal.YetkilerDal;
import tr.com.nemesisyazilim.interfaces.FrontEndInterfaces;
import tr.com.nemesisyazilim.types.KategoriContract;
import tr.com.nemesisyazilim.types.UrunlerContract;
import tr.com.nemesisyazilim.types.YetkilerContract;

public class yetkiEkleFe extends JDialog implements FrontEndInterfaces {

	JTextField adiField;
	public yetkiEkleFe() {
		initPencere();
	}

	public void initPencere() {
		
		JPanel panel = initPanel();
		
		panel.setBorder(BorderFactory.createTitledBorder("Yetki Alaný"));
		
		add(panel);

		setModalityType(DEFAULT_MODALITY_TYPE);
		setTitle("Yetki Ekle");
		pack();
		setLocationRelativeTo(null);// Pencere acildiginda ortada dursun
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	public JPanel initPanel() {
		
		JPanel panel = new JPanel(new GridLayout(2,2));
		JLabel adiLabel = new JLabel("Adý : ", JLabel.RIGHT);
		panel.add(adiLabel);
	    adiField = new JTextField(10);
		panel.add(adiField);
		
		JButton kaydetBtn = new JButton("Kaydet");
		panel.add(kaydetBtn);
		JButton iptalBtn = new JButton("Ýptal");
		panel.add(iptalBtn);
		
		kaydetBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				YetkilerContract yetki=new YetkilerContract();
				
				yetki.setAdi(adiField.getText());
				
				
				new YetkilerDal().Insert(yetki);
				JOptionPane.showMessageDialog(null, yetki.getAdi()+" yetkisi eklenmiþtir.");
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
