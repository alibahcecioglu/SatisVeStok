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

public class KategoriDal extends ObjectHelper implements DALInterfaces<KategoriContract> {

	public void Insert(KategoriContract entity) {
		
		Connection connection=getconnection();
		try {
			
			Statement statement=connection.createStatement();
			statement.executeUpdate("INSERT INTO Kategori (Adi,ParentId) VALUES('"+entity.getAdi()+"',"+entity.getParentId()+")");
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public List<KategoriContract> getAll() {

		List<KategoriContract> dataContract=new ArrayList<KategoriContract>();
		Connection connection=getconnection();
		KategoriContract kContract;
		
		try {
			
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT * FROM Kategori");
			while(result.next()){
				
				kContract=new KategoriContract();
				kContract.setId(result.getInt("Id"));
				kContract.setAdi(result.getString("Adi")); 
				kContract.setParentId(result.getInt("ParentId"));
				
				dataContract.add(kContract);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataContract;
	}

	public List<KategoriContract> getAllParentId() {

		List<KategoriContract> dataContract=new ArrayList<KategoriContract>();
		Connection connection=getconnection();
		KategoriContract kContract;
		
		try {
			
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT * FROM Kategori WHERE parentId=0");
			while(result.next()){
				
				kContract=new KategoriContract();
				kContract.setId(result.getInt("Id"));
				kContract.setAdi(result.getString("Adi")); 
				kContract.setParentId(result.getInt("ParentId"));
				
				dataContract.add(kContract);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataContract;
	}
	
	public KategoriContract Delete(KategoriContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void Update(KategoriContract entity) {
		// TODO Auto-generated method stub
		
	}

	public List<KategoriContract> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
