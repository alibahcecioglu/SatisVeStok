package tr.com.nemesisyazilim.types;

public class KategoriContract {

	private int id;
	private String Adi;
	private int parentId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdi() {
		return Adi;
	}
	public void setAdi(String adi) {
		this.Adi = adi;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String toString() {
		return Adi;
	}
	
	
	
}
