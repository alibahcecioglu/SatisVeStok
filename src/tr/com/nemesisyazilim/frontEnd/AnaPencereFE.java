package tr.com.nemesisyazilim.frontEnd;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import tr.com.nemesisyazilim.complex.types.SatisContractComplex;
import tr.com.nemesisyazilim.complex.types.StokContractComplex;
import tr.com.nemesisyazilim.complex.types.StokContractTotal;
import tr.com.nemesisyazilim.dal.MusteriDal;
import tr.com.nemesisyazilim.dal.SatisDal;
import tr.com.nemesisyazilim.dal.StokDal;
import tr.com.nemesisyazilim.dal.UrunlerDal;
import tr.com.nemesisyazilim.interfaces.FrontEndInterfaces;
import tr.com.nemesisyazilim.types.KategoriContract;
import tr.com.nemesisyazilim.types.MusteriContract;
import tr.com.nemesisyazilim.types.PersonelContract;
import tr.com.nemesisyazilim.types.SatisContract;
import tr.com.nemesisyazilim.types.StokContract;
import tr.com.nemesisyazilim.types.UrunlerContract;
import tr.com.nemesisyazilim.utilities.FeMenu;

public class AnaPencereFE extends JFrame implements FrontEndInterfaces{

	JComboBox stokUrunAdiBox;
	JDateChooser stokTarihField;
	JTextField stokAdetField;
	DefaultTableModel model;
	JComboBox musteriAdiBox;
	JTextField satisAdetField;
	DefaultTableModel satisModel;
	JDateChooser satisTarihField;
	public AnaPencereFE() {
	 
		initPencere();
		
	}

	public void initPencere() {
		
		JPanel panel=initPanel();
		JMenuBar bar=initBar();
		
		add(panel);
		setJMenuBar(bar);
		
		setTitle("Satýþ ve Stok Programi");
		//pack();//pencere otomatik boyutlansin diye
		setSize(600,250);
		setVisible(true);
		setLocationRelativeTo(null);//panelin merkezde durmasi icin
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}

	public JPanel initPanel() {
		
		JPanel panel=new JPanel(new BorderLayout());
		JTabbedPane pane=initTabs();
		panel.add(pane,BorderLayout.CENTER);
		
		return panel;
	}

	public JMenuBar initBar() {
		
		//JMenuBar menuBar=new JMenuBar();
		//menuBar=FeMenu.initBar();
		//yada 
		JMenuBar menuBar=FeMenu.initBar();
		
		return menuBar;
	}

	public JTabbedPane initTabs() {
		
		JTabbedPane pane =new JTabbedPane();
		
		
		JPanel stokPanel =new JPanel(new BorderLayout());
		JPanel satisPanel=new JPanel(new BorderLayout());
		JPanel stokSolPanel=new JPanel(new BorderLayout());
		JPanel stokSolUstPanel=new JPanel(new GridLayout(5,2));
		JPanel stokSolAltPanel=new JPanel();
		
		stokSolPanel.setBorder(BorderFactory.createTitledBorder("Stok iþlemleri"));
		
		Object[] stokKolonlari={"Id","Ürün Adi","Personel Adi","Adeti","Tarih","Adet"};
		model=new DefaultTableModel(stokKolonlari,0);
		JTable table=new JTable(model);
		
		
		JScrollPane stokTablePane=new JScrollPane(table);
		
		
		for(StokContractComplex stok : new StokDal().getAllStok()){
			
			model.addRow(stok.getVeriler());
		}
		
		
		
		JLabel stokUrunAdiLabel=new JLabel("Ürün Adi:",JLabel.RIGHT);
		stokSolUstPanel.add(stokUrunAdiLabel);
		stokUrunAdiBox=new JComboBox(new UrunlerDal().getAll().toArray());
		stokSolUstPanel.add(stokUrunAdiBox);
		
		JLabel stokAdetLabel=new JLabel("Adet:",JLabel.RIGHT);
		stokAdetField=new JTextField(10);
		JLabel stokTarihLabel=new JLabel("Stok Tarihi:",JLabel.RIGHT);
		stokTarihField=new JDateChooser();
		stokSolUstPanel.add(stokAdetLabel);
		stokSolUstPanel.add(stokAdetField);
		stokSolUstPanel.add(stokTarihLabel);
		stokSolUstPanel.add(stokTarihField);
		
		JButton stokEkleButton=new JButton("Stok Ekle");
		JButton stokYenileButton=new JButton("Yenile");
		JButton stokTotalButton=new JButton("Hesapla");
		stokSolUstPanel.add(stokEkleButton);
		stokSolUstPanel.add(stokYenileButton);
		stokSolUstPanel.add(stokTotalButton);
		
		stokYenileButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				for(SatisContractComplex satis: new SatisDal().getAllSatis()){
					
					satisModel.addColumn(satis.getVeriler());
				}
				
				
			}
			
		});
		
		
		stokTotalButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {

              int satir=model.getRowCount();
				
				for(int i=0; i < satir ; i++){
					
					model.removeRow(0);
					
				}
				
				for(StokContractTotal stokTotal : new StokDal().getTotalStok()){
					
					model.addRow(stokTotal.getVeriler());
				}
				
			}
			
			
		});
		
		stokYenileButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {

				int satir=model.getRowCount();
				
				for(int i=0; i < satir ; i++){
					
					model.removeRow(0);
					
				}
				
				for(StokContractComplex stokComp : new StokDal().getAllStok()){
					
					model.addRow(stokComp.getVeriler());
				}
			}		
			
		});
		
		stokEkleButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				StokContract stok=new StokContract();
				UrunlerContract urunler=(UrunlerContract) stokUrunAdiBox.getSelectedItem();
				PersonelContract personel=(PersonelContract) LoginFE.emailBox.getSelectedItem();
	            
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				String date=format.format(stokTarihField.getDate());
				
				stok.setPersonelId(personel.getId());
				stok.setUrunId(urunler.getId());
				stok.setTarih(date.toString());
				stok.setAdet(Integer.parseInt(stokAdetField.getText()));
				new StokDal().Insert(stok);
				
				JOptionPane.showMessageDialog(null,urunler.getAdi()+ "ürünü eklendi");
				
                int satir=model.getRowCount();
				
				for(int i=0; i < satir ; i++){
					
					model.removeRow(0);
					
				}
				
				for(StokContractComplex stokComp : new StokDal().getAllStok()){
					
					model.addRow(stokComp.getVeriler());
				}
			}
		});
		
		
		JPanel satisSagPanel=new JPanel(new BorderLayout());
		JPanel satisSagUstPanel=new JPanel(new GridLayout(6,2));
		JPanel satisSagAltPanel=new JPanel();
		
		Object[] satisKolonlari={"Id","Müþteri Adi","Personel Adi","Ürün Adi","Adeti","Tarih"};
		satisModel=new DefaultTableModel(satisKolonlari,0);
		JTable satisTable=new JTable(satisModel);
		
		JLabel musteriLabel=new JLabel("Müþteri Adi:",JLabel.RIGHT);
		satisSagUstPanel.add(musteriLabel);
		musteriAdiBox=new JComboBox(new MusteriDal().getAll().toArray());
		satisSagUstPanel.add(musteriAdiBox);
		JScrollPane satisTablePane=new JScrollPane(satisTable);
		JLabel satisUrunAdiLabel=new JLabel("Ürün Adi:",JLabel.RIGHT);
		satisSagUstPanel.add(satisUrunAdiLabel);
		JComboBox satisUrunAdiBox=new JComboBox(new UrunlerDal().getAll().toArray());
		satisSagUstPanel.add(satisUrunAdiBox);
		
		JLabel satisAdetLabel=new JLabel("Adet:",JLabel.RIGHT);
		satisAdetField=new JTextField(10);
		JLabel satisTarihLabel=new JLabel("Satis Tarihi:",JLabel.RIGHT);
		satisTarihField=new JDateChooser();
		satisSagUstPanel.add(satisAdetLabel);
		satisSagUstPanel.add(satisAdetField);
		satisSagUstPanel.add(satisTarihLabel);
		satisSagUstPanel.add(satisTarihField);
		
		JButton satisEkleButton=new JButton("Satiþ Yap");
		JButton satisYenileButton=new JButton("Yenile");
		
		satisYenileButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
			int satir=satisModel.getRowCount();
							
			for(int i=0; i < satir ; i++){
				
				satisModel.removeRow(0);
				
			}
			for(StokContractComplex stokComp : new StokDal().getAllStok()){
				
				satisModel.addRow(stokComp.getVeriler());
			}	
		}
				
		});
		
		satisEkleButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				PersonelContract personel=(PersonelContract) LoginFE.emailBox.getSelectedItem();
				UrunlerContract urunler=new UrunlerContract();
				MusteriContract musteri=new MusteriContract();
				SatisContract satis=new SatisContract();
				JOptionPane.showMessageDialog(null,null+ "1");
				
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				String date=format.format(satisTarihField.getDate());
				
				JOptionPane.showMessageDialog(null,null+ "11");
				satis.setMusteriId(musteri.getId());
				satis.setPersonelId(personel.getId());
				satis.setUrunId(urunler.getId());
				satis.setAdet(Integer.parseInt(satisAdetField.getText()));
				satis.setTarih(date);
				JOptionPane.showMessageDialog(null,null+ "2");
				new SatisDal().Insert(satis);
				JOptionPane.showMessageDialog(null,null+ "3");
				JOptionPane.showMessageDialog(null,musteri.getAdiSoyadi()+ " ürün satin aldi");
				StokContract stok=new StokContract();
							
				stok.setPersonelId(personel.getId());
				stok.setUrunId(urunler.getId());
				stok.setAdet(-Integer.parseInt(satisAdetField.getText()));
				stok.setTarih(date);
				
				new StokDal().Insert(stok);
				
				int satir=satisModel.getRowCount();
				
				for(int i=0; i < satir ; i++){
					
					satisModel.removeRow(0);
					
				}
				for(StokContractComplex stokComp : new StokDal().getAllStok()){
					
					satisModel.addRow(stokComp.getVeriler());
				}
			}
			
		});
		
		
		satisSagUstPanel.add(satisEkleButton);
		satisSagUstPanel.add(satisYenileButton);
		
		stokPanel.add(stokSolPanel,BorderLayout.WEST);
		stokPanel.add(stokTablePane,BorderLayout.CENTER);
		
		satisPanel.add(satisSagPanel,BorderLayout.EAST);
		satisPanel.add(satisTablePane,BorderLayout.CENTER);
		
		satisSagPanel.add(satisSagUstPanel,BorderLayout.NORTH);
		satisSagPanel.add(satisSagAltPanel,BorderLayout.SOUTH);
		
		
		stokSolPanel.add(stokSolUstPanel,BorderLayout.NORTH);
		stokSolPanel.add(stokSolAltPanel,BorderLayout.SOUTH);
		
		pane.addTab("Stoklar",null,stokPanel,"Does nothing");
		pane.addTab("Satýþlar",null,satisPanel,"Does nothing");
		
		return pane;
	}

}
