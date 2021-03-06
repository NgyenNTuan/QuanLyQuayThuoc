package class_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_connectDB.ConnectDB;
import class_entity.ThongKeThuocBanNhieuNhat;

public class ThongKeThuocBanNhieuNhat_DAO {
	private ArrayList<ThongKeThuocBanNhieuNhat> dsThongKe;
	public ThongKeThuocBanNhieuNhat_DAO() {
		dsThongKe = new ArrayList<ThongKeThuocBanNhieuNhat>();
	}
	public ArrayList<ThongKeThuocBanNhieuNhat> getAllThuocBan(Date ngayBD, Date ngayEnd) {
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql="select * from [dbo].[ThongKeTop10ThuocMuaNhieuNhat]('"+ngayBD+"','"+ngayEnd+"')";
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while (rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String tenNSX=rs.getString(3);
				String tenLoai=rs.getString(4);
				int soLuong=rs.getInt(5);
				
				ThongKeThuocBanNhieuNhat tk = new ThongKeThuocBanNhieuNhat(ma, ten, tenNSX, tenLoai, soLuong);
				dsThongKe.add(tk);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsThongKe;
	}
}
