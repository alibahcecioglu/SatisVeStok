package tr.com.nemesisyazilim.complex.types;

import java.sql.Date;

public class SatisContractComplex {

	private int id;
	private String personelAdi;
	private String musteriAdi;
	private String urunAdi;
	private String tarih;
	private int adet;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonelAdi() {
		return personelAdi;
	}
	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}
	public String getMusteriAdi() {
		return musteriAdi;
	}
	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}
	public String getUrunAdi() {
		return urunAdi;
	}
	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	public int getAdet() {
		return adet;
	}
	public void setAdet(int adet) {
		this.adet = adet;
	}
	public Object[] getVeriler(){
		Object[] veriler={id,personelAdi,musteriAdi,urunAdi,tarih,adet};
				
		return veriler;
	}
	

	
}
