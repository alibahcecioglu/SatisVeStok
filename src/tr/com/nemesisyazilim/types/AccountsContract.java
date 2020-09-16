package tr.com.nemesisyazilim.types;

public class AccountsContract {
	
	private int id;
	private int personelId;
	private String sifre;
	private int yetkiId;
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
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public int getYetkiId() {
		return yetkiId;
	}
	public void setYetkiId(int yetkiId) {
		this.yetkiId = yetkiId;
	}
	public String toString() {
		return "AccountsContact [id=" + id + ", personelId=" + personelId
				+ ", sifre=" + sifre + ", yetkiId=" + yetkiId + "]";
	}

	
	
}
