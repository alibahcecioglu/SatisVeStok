package tr.com.nemesisyazilim.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.nemesisyazilim.core.ObjectHelper;
import tr.com.nemesisyazilim.interfaces.DALInterfaces;
import tr.com.nemesisyazilim.types.AccountsContract;
import tr.com.nemesisyazilim.types.KategoriContract;

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

	public AccountsContract getPersonelIdveSifre(int personelId,String sifre){
		
		AccountsContract AContract=new AccountsContract();
		List<AccountsContract> listAccount=new ArrayList<AccountsContract>();
		Connection connection=getconnection();
		
		try {
			
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT * FROM Accounts WHERE personelId="+personelId+" AND Sifre='"+sifre.trim()+"'");
			while(result.next()){
				
				AContract.setId(result.getInt("Id"));
				AContract.setPersonelId(result.getInt("PersonelId"));
				AContract.setSifre(result.getString("Sifre"));
				AContract.setYetkiId(result.getInt("YetkiId"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return AContract;
	}
	
public AccountsContract getYetkiId(int personelId){
		
		AccountsContract AContract=new AccountsContract();
		List<AccountsContract> listAccount=new ArrayList<AccountsContract>();
		Connection connection=getconnection();
		
		try {
			
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT * FROM Accounts WHERE personelId="+personelId+"");
			while(result.next()){
				
				AContract.setId(result.getInt("Id"));
				AContract.setPersonelId(result.getInt("PersonelId"));
				AContract.setYetkiId(result.getInt("YetkiId"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return AContract;
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
