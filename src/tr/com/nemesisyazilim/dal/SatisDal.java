package tr.com.nemesisyazilim.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.nemesisyazilim.complex.types.SatisContractComplex;
import tr.com.nemesisyazilim.complex.types.StokContractComplex;
import tr.com.nemesisyazilim.core.ObjectHelper;
import tr.com.nemesisyazilim.interfaces.DALInterfaces;
import tr.com.nemesisyazilim.types.KategoriContract;
import tr.com.nemesisyazilim.types.MusteriContract;
import tr.com.nemesisyazilim.types.SatisContract;

public class SatisDal extends ObjectHelper implements DALInterfaces<SatisContract> {

	public void Insert(SatisContract entity) {
		Connection connection=getconnection();
		try {
			
			Statement statement=connection.createStatement();
			statement.executeUpdate("INSERT INTO Satis (UrunId,MusteriId,Tarih,Adet,PersonelId) VALUES("
			+entity.getUrunId()+","+entity.getMusteriId()+",'"+entity.getTarih()+"',"+entity.getAdet()+","+entity.getPersonelId()+")");
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public List<SatisContractComplex> getAllSatis(){
		List<SatisContractComplex> dataContract=new ArrayList<SatisContractComplex>();
		Connection connection=getconnection();
	    SatisContractComplex satis;
	 	
		try {
			
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT satis.Id,personel.AdiSoyadi,musteri.AdiSoyadi,Adi,Adet,satis.Tarih FROM satis" +
					" LEFT JOIN musteri on satis.MusteriId = musteri.Id LEFT JOIN urunler on satis.UrunId=urunler.Id"+
					"LEFT JOIN personel on satis.personelId = personel.Id");
            while(result.next()){
				
            	satis=new SatisContractComplex();
            	satis.setId(result.getInt("Id"));
            	satis.setMusteriAdi(result.getString("musteri.AdiSoyadi"));
            	satis.setPersonelAdi(result.getString("personel.AdiSoyadi"));
            	satis.setTarih(result.getString("satis.Tarih"));
            	satis.setUrunAdi(result.getString("Adi"));
				satis.setAdet(result.getInt("Adet"));
				
				dataContract.add(satis);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataContract;
			
	}
	
	
	public List<SatisContract> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public SatisContract Delete(SatisContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void Update(SatisContract entity) {
		// TODO Auto-generated method stub
		
	}

	public List<SatisContract> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
