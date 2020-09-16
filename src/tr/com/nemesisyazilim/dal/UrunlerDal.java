package tr.com.nemesisyazilim.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import tr.com.nemesisyazilim.core.ObjectHelper;
import tr.com.nemesisyazilim.interfaces.DALInterfaces;
import tr.com.nemesisyazilim.types.UrunlerContract;

public class UrunlerDal extends ObjectHelper implements DALInterfaces<UrunlerContract> {

	public void Insert(UrunlerContract entity) {
	
		   Connection connection=getconnection();
			
		try {
			
		    Statement statement=connection.createStatement();
			statement.executeUpdate("INSERT INTO Urunler(Adi,KategoriId,Tarih,Fiyat) VALUES('"+entity.getAdi()+"',"+entity.getKategoriId()+",'"+entity.getTarih()+"','"+entity.getFiyat()+"')");
			
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public List<UrunlerContract> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public UrunlerContract Delete(UrunlerContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void Update(UrunlerContract entity) {
		// TODO Auto-generated method stub
		
	}

	public List<UrunlerContract> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
