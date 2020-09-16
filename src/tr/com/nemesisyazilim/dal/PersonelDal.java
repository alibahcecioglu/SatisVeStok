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
import tr.com.nemesisyazilim.types.PersonelContract;

public class PersonelDal extends ObjectHelper implements DALInterfaces<PersonelContract> {

	public void Insert(PersonelContract entity) {
		Connection connection=getconnection();
		try {
			
			Statement statement=connection.createStatement();
			statement.executeUpdate("INSERT INTO Personel (AdiSoyadi,Email) VALUES('"+entity.getAdSoyad()+"','"+entity.getEmail()+"')");
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<PersonelContract> getAll() {
		
		List<PersonelContract> dataContract=new ArrayList<PersonelContract>();
		Connection connection=getconnection();
		PersonelContract pContract;
		
		try {
			
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT * FROM Personel");
			while(result.next()){
				
				pContract=new PersonelContract();
				pContract.setId(result.getInt("Id"));
				pContract.setAdSoyad(result.getString("AdiSoyadi"));
				pContract.setEmail(result.getString("Email"));
				
				dataContract.add(pContract);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataContract;
	}

	public PersonelContract Delete(PersonelContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void Update(PersonelContract entity) {
		// TODO Auto-generated method stub
		
	}

	public List<PersonelContract> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
}
