package tr.com.nemesisyazilim.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.nemesisyazilim.core.ObjectHelper;
import tr.com.nemesisyazilim.interfaces.DALInterfaces;
import tr.com.nemesisyazilim.types.PersonelContract;
import tr.com.nemesisyazilim.types.YetkilerContract;

public class YetkilerDal extends ObjectHelper implements DALInterfaces<YetkilerContract> {

	public void Insert(YetkilerContract entity) {
		
		Connection connection=getconnection();
		try {
			
			Statement statement=connection.createStatement();
			statement.executeUpdate("INSERT INTO yetkiler (Adi) VALUES('"+entity.getAdi()+"')");
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public List<YetkilerContract> getAll() {
		
		List<YetkilerContract> dataContract=new ArrayList<YetkilerContract>();
		Connection connection=getconnection();
		YetkilerContract yContract;
		
		try {
			
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT * FROM yetkiler");
			while(result.next()){
				
			yContract=new YetkilerContract();
			yContract.setId(result.getInt("Id"));
			yContract.setAdi(result.getString("Adi"));
			
			dataContract.add(yContract);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataContract;
	}

	public YetkilerContract Delete(YetkilerContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void Update(YetkilerContract entity) {
		// TODO Auto-generated method stub
		
	}

	public List<YetkilerContract> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
