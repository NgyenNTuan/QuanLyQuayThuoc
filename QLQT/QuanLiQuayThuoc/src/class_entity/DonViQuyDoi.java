package class_entity;

public class DonViQuyDoi {
	private String donViQuyDoi;
	private int soLuongLe;
	public String getDonViQuyDoi() {
		return donViQuyDoi;
	}
	public void setDonViQuyDoi(String donViQuyDoi) {
		this.donViQuyDoi = donViQuyDoi;
	}
	public int getSoLuongLe() {
		return soLuongLe;
	}
	public void setSoLuongLe(int soLuongLe) {
		this.soLuongLe = soLuongLe;
	}
	public DonViQuyDoi(String donViQuyDoi, int soLuongLe) {
		super();
		setDonViQuyDoi(donViQuyDoi);
		setSoLuongLe(soLuongLe);
	}
	public DonViQuyDoi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
