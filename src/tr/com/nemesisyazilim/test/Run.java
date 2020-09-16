package tr.com.nemesisyazilim.test;

import javax.swing.SwingUtilities;

import tr.com.nemesisyazilim.frontEnd.AnaPencereFE;

public class Run {
	
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run(){
				new AnaPencereFE();
			}
			
		});
				
	}

}
