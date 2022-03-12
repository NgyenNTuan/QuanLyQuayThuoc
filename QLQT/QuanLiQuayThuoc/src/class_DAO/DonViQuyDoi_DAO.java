                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          package class_DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_connectDB.ConnectDB;
import class_entity.DonViQuyDoi;

public class DonViQuyDoi_DAO{
	public DonViQuyDoi_DAO() {
	}
	public ArrayList<DonViQuyDoi> getalltbDVQD() {
		ArrayList<DonViQuyDoi> listdvqd = new ArrayList<DonViQuyDoi>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();	
			String sql = "Select * from DONVIQUYDOI";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String dvqdtxt = rs.getString(1);
				int dvqdsle = rs.getInt(2);
				DonViQuyDoi dvqd = new DonViQuyDoi(dvqdtxt, dvqdsle);	 		
				listdvqd.add(dvqd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		return listdvqd;
	}
	public boolean create(DonViQuyDoi dvqd) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into DONVIQUYDOI(DONVIQUYDOI, SOLUONGLE)"
					+ "values(?, ?);");
			stmt.setString(1, dvqd.getDonViQuyDoi());
			stmt.setInt(2, dvqd.getSoLuongLe());
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
	public boolean update(DonViQuyDoi dvqd, String namedvqd) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update DONVIQUYDOI set DONVIQUYDOI=?, SOLUONGLE=? where DONVIQUYDOI=?");
			stmt.setString(1, dvqd.getDonViQuyDoi());
			stmt.setInt(2, dvqd.getSoLuongLe());
			stmt.setString(3, namedvqd);
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
	public boolean delete(String dvqd) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE DONVIQUYDOI WHERE DONVIQUYDOI=?");
			stmt.setString(1, dvqd);
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

