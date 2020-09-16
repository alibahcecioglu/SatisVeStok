package tr.com.nemesisyazilim.frontEnd;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import tr.com.nemesisyazilim.dal.KategoriDal;
import tr.com.nemesisyazilim.dal.UrunlerDal;
import tr.com.nemesisyazilim.interfaces.FrontEndInterfaces;
import tr.com.nemesisyazilim.types.KategoriContract;
import tr.com.nemesisyazilim.types.UrunlerContract;

public class UrunEkleFe extends JDialog implements FrontEndInterfaces {

	 JComboBox kategoriBox;
	 JTextField adiField;
	 JDateChooser tarih;
	 JTextField fiyat;
	public UrunEkleFe() {

		initPencere();
		
	}

	public void initPencere() {

		JPanel panel = initPanel();
		
		panel.setBorder(BorderFactory.createTitledBorder("Ürün Kayýt Alaný"));
		
		add(panel);

		setModalityType(DEFAULT_MODALITY_TYPE);
		setTitle("Ürün Ekle");
		pack();
		setLocationRelativeTo(null);// Pencere acildiginda ortada dursun
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	public JPanel initPanel() {

		JPanel panel = new JPanel(new GridLayout(5,2));
		JLabel adiLabel = new JLabel("Adý : ", JLabel.RIGHT);
		panel.add(adiLabel);
	    adiField = new JTextField(10);
		panel.add(adiField);

		JLabel kategoriLabel = new JLabel("Kategori : ", JLabel.RIGHT);
		panel.add(kategoriLabel);
	    kategoriBox = new JComboBox(new KategoriDal().getAll().toArray());
		panel.add(kategoriBox);

		JLabel tarihLabel = new JLabel("Tarih : ", JLabel.RIGHT);
		panel.add(tarihLabel);
		tarih = new JDateChooser();
		panel.add(tarih);

		JLabel fiyatLabel = new JLabel("Fiyat : ", JLabel.RIGHT);
		panel.add(fiyatLabel);
		fiyat = new JTextField(10);
		panel.add(fiyat);

		JButton kaydetBtn = new JButton("Kaydet");
		panel.add(kaydetBtn);
		JButton iptalBtn = new JButton("Ýptal");
		panel.add(iptalBtn);

		kaydetBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				UrunlerContract urun=new UrunlerContract();
				SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
				
				KategoriContract casContract=(KategoriContract) kategoriBox.getSelectedItem();
				String date=format.format(tarih.getDate());
				urun.setAdi(adiField.getText());
				urun.setKategoriId(casContract.getId());
				urun.setFiyat(Float.parseFloat(fiyat.getText()));
				urun.setTarih(date);
				
				new UrunlerDal().Insert(urun);
				JOptionPane.showMessageDialog(null, urun.getAdi()+" ürünü eklenmiþtir.");
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
