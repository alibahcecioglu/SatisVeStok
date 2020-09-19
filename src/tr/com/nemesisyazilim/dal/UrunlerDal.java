package tr.com.nemesisyazilim.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.nemesisyazilim.core.ObjectHelper;
import tr.com.nemesisyazilim.interfaces.DALInterfaces;
import tr.com.nemesisyazilim.types.KategoriContract;
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

		List<UrunlerContract> dataContract=new ArrayList<UrunlerContract>();
		Connection connection=getconnection();
		UrunlerContract uContract;
		
		try {
			
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT * FROM Urunler");
			while(result.next()){
				
				uContract=new UrunlerContract();
				uContract.setId(result.getInt("Id"));
				uContract.setAdi(result.getString("Adi")); 
				uContract.setKategoriId(result.getInt("KategoriId"));
				uContract.setTarih(result.getString("Tarih"));
				
				dataContract.add(uContract);
				
				System.out.println(result.getString("Adi"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataContract;
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
