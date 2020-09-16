package tr.com.nemesisyazilim.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import tr.com.nemesisyazilim.interfaces.CoreInterfaces;

public class ObjectHelper extends CoreFields implements CoreInterfaces {

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	//CoreInterface interfaceden implement edilen sinif
	public Connection getconnection() {
					
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(getUrl(),getUserName(),getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
					
	}
	
}
