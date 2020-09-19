package tr.com.nemesisyazilim.frontEnd;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.nemesisyazilim.dal.KategoriDal;
import tr.com.nemesisyazilim.interfaces.FrontEndInterfaces;

public class KategoriDuzenleFE extends JDialog implements FrontEndInterfaces{

	
	JTextField kategoriAdiField;
	JComboBox ustKategoriBox;
	JList kategoriList;
	public KategoriDuzenleFE() {
		
		initPencere();
	}

	public void initPencere() {
		
		JPanel panel = initPanel();
		add(panel);
	
		setTitle("Kategori Düzenle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);// Pencere acildiginda ortada dursun
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	public JPanel initPanel() {
		
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel ustpanel=new JPanel(new GridLayout(3,2));
		
		JLabel KategoriadiLabel = new JLabel("Kategori Adý : ", JLabel.RIGHT);
		ustpanel.add(KategoriadiLabel);
		ustpanel.setBorder(BorderFactory.createTitledBorder("Kategori Düzenle"));
		kategoriAdiField=new JTextField(10);ustpanel.add(kategoriAdiField);
		ustKategoriBox=new JComboBox(new KategoriDal().getAll().toArray()); 
		JLabel ustKategoriadiLabel = new JLabel("ust Kategori Adý : ", JLabel.RIGHT);
		ustpanel.add(ustKategoriadiLabel); ustpanel.add(ustKategoriBox);
		
		kategoriList=new JList();
		kategoriAdiField.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent arg0) {
				
				
				kategoriList.setListData(new KategoriDal().getSearchKategori(kategoriAdiField.getText()).toArray());
				kategoriList.setSelectedIndex(0);
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		
		JScrollPane pane=new JScrollPane(kategoriList);
		
		pane.setBorder(BorderFactory.createTitledBorder("Düzenlenecek Listesi"));
		panel.add(ustpanel,BorderLayout.NORTH);
		panel.add(pane,BorderLayout.CENTER);
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
