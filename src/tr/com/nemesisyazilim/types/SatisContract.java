package tr.com.nemesisyazilim.types;

import java.sql.Date;

public class SatisContract {

	private int id;
	private int personelId;
	private int musteriId;
	private int urunId;
	private String tarih;
	private int adet;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPersonelId() {
		return personelId;
	}
	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}
	public int getMusteriId() {
		return musteriId;
	}
	public void setMusteriId(int musteriId) {
		this.musteriId = musteriId;
	}
	public int getUrunId() {
		return urunId;
	}
	public void setUrunId(int urunId) {
		this.urunId = urunId;
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
	
	
	
}
