package tr.com.nemesisyazilim.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.nemesisyazilim.complex.types.StokContractComplex;
import tr.com.nemesisyazilim.complex.types.StokContractTotal;
import tr.com.nemesisyazilim.core.ObjectHelper;
import tr.com.nemesisyazilim.interfaces.DALInterfaces;
import tr.com.nemesisyazilim.types.StokContract;

public class StokDal extends ObjectHelper implements DALInterfaces<StokContract> {

	public void Insert(StokContract entity) {
		Connection connection=getconnection();
		try {
			
			Statement statement=connection.createStatement();
			statement.executeUpdate("INSERT INTO Stok (PersonelId,UrunId,Tarih,Adet) VALUES("+entity.getPersonelId()+","
			+entity.getUrunId()+",'"+entity.getTarih()+"',"+entity.getAdet()+")");
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

  
	public List<StokContractComplex> getAllStok(){	
		
		List<StokContractComplex> dataContract=new ArrayList<StokContractComplex>();
		Connection connection=getconnection();
		StokContractComplex stokComplex;
		
		try {
			
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT stok.Id,AdiSoyadi,Adi,Adet,stok.Tarih FROM stok LEFT JOIN urunler on stok.UrunId = urunler.Id "+ "LEFT JOIN personel on stok.PersonelId = personel.Id");
			while(result.next()){
				
				stokComplex=new StokContractComplex();
				stokComplex.setId(result.getInt("Id"));
				stokComplex.setPersonelAdi(result.getString("AdiSoyadi")); 
				stokComplex.setUrunAdi(result.getString("Adi"));
				stokComplex.setAdet(result.getInt("Adet"));
				stokComplex.setTarih(result.getString("stok.Tarih"));
				
				dataContract.add(stokComplex);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataContract;
	}
	
    public List<StokContractTotal> getTotalStok(){	
		
		List<StokContractTotal> dataContract=new ArrayList<StokContractTotal>();
		Connection connection=getconnection();
		StokContractTotal stokTotal;
		
		try {
			
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT SUM(Adet) as toplam, stok.Id,AdiSoyadi,Adi,Adet,stok.Tarih FROM stok LEFT JOIN urunler on stok.UrunId = urunler.Id LEFT JOIN personel on stok.PersonelId = personel.Id");
			while(result.next()){
				
				stokTotal=new StokContractTotal();
				stokTotal.setId(result.getInt("Id"));
				stokTotal.setPersonelAdi(result.getString("AdiSoyadi")); 
				stokTotal.setUrunAdi(result.getString("Adi"));
				stokTotal.setAdet(result.getInt("Adet"));
				stokTotal.setTarih(result.getString("stok.Tarih"));
				stokTotal.setToplam(result.getInt("toplam"));
				dataContract.add(stokTotal);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataContract;
	}
	
	
	public List<StokContract> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public StokContract Delete(StokContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void Update(StokContract entity) {
		// TODO Auto-generated method stub
		
	}

	public List<StokContract> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
