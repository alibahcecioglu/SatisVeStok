package tr.com.nemesisyazilim.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import tr.com.nemesisyazilim.core.ObjectHelper;
import tr.com.nemesisyazilim.interfaces.DALInterfaces;
import tr.com.nemesisyazilim.types.AccountsContract;

public class AccountsDal extends ObjectHelper implements DALInterfaces<AccountsContract> {

	public void Insert(AccountsContract entity) {
		
		Connection connection=getconnection();
		try {
			
			Statement statement=connection.createStatement();
			statement.executeUpdate("INSERT INTO Accounts (PersonelId,YetkiId,Sifre) VALUES("
			+entity.getPersonelId()+","+entity.getYetkiId()+",'"+entity.getSifre()+"')");
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<AccountsContract> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountsContract Delete(AccountsContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void Update(AccountsContract entity) {
		// TODO Auto-generated method stub
		
	}

	public List<AccountsContract> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
