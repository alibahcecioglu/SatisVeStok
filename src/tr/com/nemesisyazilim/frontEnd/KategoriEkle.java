package tr.com.nemesisyazilim.frontEnd;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import tr.com.nemesisyazilim.dal.*;
import tr.com.nemesisyazilim.interfaces.*;
import tr.com.nemesisyazilim.types.*;

public class KategoriEkle extends JDialog implements FrontEndInterfaces {

	 JComboBox kategoriBox;
	 JTextField adiField;
	public KategoriEkle() {

		initPencere();
		
	}

	public void initPencere() {
		JPanel panel = initPanel();
		
		panel.setBorder(BorderFactory.createTitledBorder("Kategori Kay�t Alan�"));
		
		add(panel);

		
		setTitle("Kategori Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);// Pencere acildiginda ortada dursun
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	public JPanel initPanel() {
		
		JPanel panel = new JPanel(new GridLayout(3,2));
		
		JLabel adiLabel = new JLabel("Kategori Ad� : ", JLabel.RIGHT);
		panel.add(adiLabel);
		adiField = new JTextField(10);
		panel.add(adiField);
		
		JLabel kategoriLabel = new JLabel("Kategori Se� : ", JLabel.RIGHT);
		panel.add(kategoriLabel);
	    kategoriBox=new JComboBox (new KategoriDal().getAllParentId().toArray());
		kategoriBox.insertItemAt("Kategori Se�",0);
		kategoriBox.setSelectedIndex(0);
		panel.add(kategoriBox);
		
		
		JButton kaydetBtn = new JButton("Kaydet");
		panel.add(kaydetBtn);
		
		kaydetBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
					
				
				KategoriContract contract = new KategoriContract();
				
				if(kategoriBox.getSelectedIndex()!=0){
					
					KategoriContract casContract = (KategoriContract) kategoriBox.getSelectedItem();
					
					contract.setAdi(adiField.getText());
					
					contract.setParentId(casContract.getId());
					
					new KategoriDal().Insert(contract);
					
					JOptionPane.showMessageDialog(null,contract.getAdi()+"Kategori Eklendi");
					
				}else{
					
					contract.setAdi(adiField.getText());
					
					contract.setParentId(kategoriBox.getSelectedIndex());
					
					new KategoriDal().Insert(contract);
					
					JOptionPane.showMessageDialog(null,contract.getAdi()+" Kategorisi Eklendi");
					
					
				}				
				
			}
				
		});
		
		
		JButton iptalBtn = new JButton("�ptal");
		panel.add(iptalBtn);
		
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
