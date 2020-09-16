package tr.com.nemesisyazilim.types;

import java.sql.Date;

public class UrunlerContract {

	private int id;
	private String adi;
	private int kategoriId;
	private String tarih;
	private float fiyat;
	
	
	public float getFiyat() {
		return fiyat;
	}
	public float setFiyat(float fiyat) {
		this.fiyat = fiyat;
		return fiyat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public int getKategoriId() {
		return kategoriId;
	}
	public void setKategoriId(int kategoriId) {
		this.kategoriId = kategoriId;
	}
	
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	public String toString() {
		return "UrunlerContract [id=" + id + ", adi=" + adi + ", kategoriId="
				+ kategoriId + ", tarih=" + tarih + ", fiyat=" + fiyat + "]";
	}
	
	
}