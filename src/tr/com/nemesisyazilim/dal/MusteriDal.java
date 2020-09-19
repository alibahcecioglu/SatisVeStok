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
import tr.com.nemesisyazilim.types.MusteriContract;

public class MusteriDal extends ObjectHelper implements DALInterfaces<MusteriContract> {

	public void Insert(MusteriContract entity) {

		Connection connection=getconnection();
		try {
			
			Statement statement=connection.createStatement();
			statement.executeUpdate("INSERT INTO Musteri (AdiSoyadi,Telefon,Adres,SehirId) VALUES('"
			+entity.getAdiSoyadi()+"','"+entity.getTelefon()+"','"+entity.getAdres()+"','"+entity.getSehirId()+"')");
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<MusteriContract> getAll() {
		List<MusteriContract> dataContract=new ArrayList<MusteriContract>();
		Connection connection=getconnection();
		MusteriContract musteri;
		
		try {
			
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT * FROM Musteri");
			while(result.next()){
				
				musteri=new MusteriContract();
				musteri.setId(result.getInt("Id"));
				musteri.setAdiSoyadi(result.getString("AdiSoyadi"));
				musteri.setAdres(result.getString("Adres"));
				musteri.setSehirId(result.getInt("sehirId"));
				musteri.setTelefon(result.getString("Telefon"));
				
				dataContract.add(musteri);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataContract;
	}

	public MusteriContract Delete(MusteriContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void Update(MusteriContract entity) {
		// TODO Auto-generated method stub
		
	}

	public List<MusteriContract> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
