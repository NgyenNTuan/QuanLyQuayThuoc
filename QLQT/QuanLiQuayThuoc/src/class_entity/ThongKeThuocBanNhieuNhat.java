package class_entity;

public class ThongKeThuocBanNhieuNhat {
	private String maThuoc,tenThuoc,tenNSX,loaiThuoc;
	private int soLuong;
	
	public String getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}
	public String getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	public String getTenNSX() {
		return tenNSX;
	}
	public void setTenNSX(String tenNSX) {
		this.tenNSX = tenNSX;
	}
	public String getLoaiThuoc() {
		return loaiThuoc;
	}
	public void setLoaiThuoc(String loaiThuoc) {
		this.loaiThuoc = loaiThuoc;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public ThongKeThuocBanNhieuNhat(String maThuoc, String tenThuoc, String tenNSX, String loaiThuoc, int soLuong) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.tenNSX = tenNSX;
		this.loaiThuoc = loaiThuoc;
		this.soLuong = soLuong;
	}
	public ThongKeThuocBanNhieuNhat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
