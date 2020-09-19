package tr.com.nemesisyazilim.utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import tr.com.nemesisyazilim.*;
import tr.com.nemesisyazilim.dal.AccountsDal;
import tr.com.nemesisyazilim.frontEnd.KategoriDuzenleFE;
import tr.com.nemesisyazilim.frontEnd.KategoriEkle;
import tr.com.nemesisyazilim.frontEnd.LoginFE;
import tr.com.nemesisyazilim.frontEnd.PersonelEkleFe;
import tr.com.nemesisyazilim.frontEnd.UrunEkleFe;
import tr.com.nemesisyazilim.frontEnd.musteriEkleFe;
import tr.com.nemesisyazilim.frontEnd.sifreIslemleriFe;
import tr.com.nemesisyazilim.frontEnd.yetkiEkleFe;
import tr.com.nemesisyazilim.types.PersonelContract;


public class FeMenu {
	
 public static JMenuBar initBar(){
	 
	JMenuBar bar=new JMenuBar();
	
	JMenu dosyaMenu=new JMenu("Menu");
	JMenuItem cikisItem=new JMenuItem("Cikis");
	dosyaMenu.add(cikisItem);
	bar.add(dosyaMenu);
	
	JMenu urunlerMenu =new JMenu("Urunler");
		
	JMenuItem urunEkleItem=new JMenuItem("�r�n Ekle");
	JMenuItem kategoriEkleItem=new JMenuItem("Kategori Ekle");
    JMenuItem urunDuzenleItem=new JMenuItem("�r�n� D�zenle");
    JMenuItem kategoriDuzenleItem=new JMenuItem("Kategoriyi D�zenle");
     
	urunlerMenu.add(urunEkleItem);
	urunlerMenu.add(kategoriEkleItem);
	urunlerMenu.addSeparator();
	urunlerMenu.add(urunDuzenleItem);
	urunlerMenu.add(kategoriDuzenleItem);
	
	bar.add(urunlerMenu);
	
	JMenu personellerMenu=new JMenu("Personel i�lemleri");
	bar.add(personellerMenu);
	
	JMenuItem personelEkleItem=new JMenuItem("Personel Ekle");
	JMenuItem yetkiEkleItem=new JMenuItem("Yetki Ekle");
	JMenuItem sifreBelirleme=new JMenuItem("�ifre Belirleme");
	JMenuItem personelDuzenleItem=new JMenuItem("Personel D�zenle");
	JMenuItem yetkiDuzenleItem=new JMenuItem("Yetki D�zenle");
	JMenuItem sifreDuzenleItem=new JMenuItem("Sifre Duzenle");
	
	personellerMenu.add(personelEkleItem);
	personellerMenu.add(yetkiEkleItem);
	personellerMenu.add(sifreBelirleme);
	personellerMenu.addSeparator();
	personellerMenu.add(personelDuzenleItem);
	personellerMenu.add(yetkiDuzenleItem);
	personellerMenu.add(sifreDuzenleItem);

	
	JMenu musterilerMenu=new JMenu("M��teriler");
	JMenuItem musterilerEkleItem=new JMenuItem("M��teri Ekle");
	JMenuItem sehirEkleItem=new JMenuItem("�ehir Ekle");
	JMenuItem musteriDuzenleItem=new JMenuItem("M��teri D�zenle");
	JMenuItem sehirDuzenleItem=new JMenuItem("�ehir D�zenle");
	
	musterilerMenu.add(musterilerEkleItem);
	musterilerMenu.add(sehirEkleItem);
	musterilerMenu.addSeparator();
	musterilerMenu.add(musteriDuzenleItem);
	musterilerMenu.add(sehirDuzenleItem);
	bar.add(musterilerMenu);
	PersonelContract personel=(PersonelContract) LoginFE.emailBox.getSelectedItem();
	
	
	if(new AccountsDal().getYetkiId(personel.getId()).getId()==2){
		
		personellerMenu.hide();
	}else if(new AccountsDal().getYetkiId(personel.getId()).getId()==2){
		
		musterilerMenu.hide();
		personellerMenu.hide();
		urunlerMenu.hide();
		
	}
	
	

	
	
	urunEkleItem.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			
			SwingUtilities.invokeLater(new Runnable(){
				
				public void run(){
					
					new UrunEkleFe();
					
				}
			});
			
		}
				
	});
	
	kategoriEkleItem.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			
			SwingUtilities.invokeLater(new Runnable(){
				
				public void run(){
				
					new KategoriEkle();
				}
			});
			
		}
	});
	
	kategoriDuzenleItem.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
		
				SwingUtilities.invokeLater(new Runnable(){
				
				public void run(){
				
					new KategoriDuzenleFE();
				}
			});
			
		}
		
		
		
	});
	
	
	personelEkleItem.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			
			SwingUtilities.invokeLater(new Runnable(){
				
				public void run(){
					
					new PersonelEkleFe();
				}
			});
			
		}
		
	});
	
	
	yetkiEkleItem.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			
			SwingUtilities.invokeLater(new Runnable(){
				
				public void run(){
					
					new yetkiEkleFe();
				}
			});
			
		}
		
	});
	
	
	sifreBelirleme.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			
			SwingUtilities.invokeLater(new Runnable(){
				
				public void run(){
					
					new sifreIslemleriFe();
				}
			});
			
		}
		
	});
	
	musterilerEkleItem.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			
			SwingUtilities.invokeLater(new Runnable(){
				
				public void run(){
					
					new musteriEkleFe();
				}
			});
			
		}
		
	});
	
	
	return bar;

   }

}
