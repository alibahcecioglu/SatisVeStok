package tr.com.nemesisyazilim.frontEnd;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import tr.com.nemesisyazilim.interfaces.FrontEndInterfaces;
import tr.com.nemesisyazilim.utilities.FeMenu;

public class AnaPencereFE extends JFrame implements FrontEndInterfaces{

	
	public AnaPencereFE() {
	 
		initPencere();
		
	}

	public void initPencere() {
		
		//JTabbedPane tabs=initTabs();
		JMenuBar bar=initBar();
		
		//add(tabs);
		setJMenuBar(bar);
		
		
		setTitle("Satýþ ve Stok Programi");
		//pack();//pencere otomatik boyutlansin diye
		setSize(600,250);
		setVisible(true);
		setLocationRelativeTo(null);//panelin merkezde durmasi icin
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}

	public JPanel initPanel() {
		
		JPanel panel=new JPanel();
		
		
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
		
		return null;
	}

}
