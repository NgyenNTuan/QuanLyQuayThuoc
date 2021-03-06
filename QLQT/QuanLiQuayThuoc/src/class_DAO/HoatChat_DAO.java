                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          package class_DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_connectDB.ConnectDB;
import class_entity.HoatChat;

public class HoatChat_DAO{
	public HoatChat_DAO() {
	}
	public ArrayList<HoatChat> getalltbHC() {
		ArrayList<HoatChat> listhc = new ArrayList<HoatChat>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();	
			String sql = "Select * from HoatChat";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHC = rs.getString(1);
				String tenHC = rs.getString(2);
				HoatChat hc = new HoatChat(maHC, tenHC);	 		
				listhc.add(hc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		return listhc;
	}
	public boolean create(HoatChat hc) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into HoatChat(MaHC, TenHoatChat)"
					+ "values(?, ?);");
			stmt.setString(1, hc.getMaHC().trim());
			stmt.setString(2, hc.getTenHC().trim());
			n = stmt.executeUpdate();	
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0; 
	}
	public boolean update(HoatChat hc) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update HoatChat set TenHoatChat=? where MaHC=?");
			stmt.setString(1, hc.getTenHC());
			stmt.setString(2, hc.getMaHC());
			n = stmt.executeUpdate();	
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0; 
	}
	public boolean delete(String maHC) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE HoatChat WHERE MaHC=?");
			stmt.setString(1, maHC);
			n = stmt.executeUpdate();	
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0; 
	}
}

