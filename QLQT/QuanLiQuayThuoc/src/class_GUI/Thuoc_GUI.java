package class_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import class_DAO.DangNhap_DAO;
import class_DAO.DonViTinh_DAO;
import class_DAO.HoatChat_DAO;
import class_DAO.LoaiThuoc_DAO;
import class_DAO.NhaSanXuat_DAO;
import class_DAO.QuocGia_DAO;
import class_DAO.Thuoc_DAO;
import class_connectDB.ConnectDB;
import class_entity.DonViTinh;
import class_entity.HoatChat;
import class_entity.LoaiThuoc;
import class_entity.NhaSanXuat;
import class_entity.QuocGia;
import class_entity.Thuoc;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Thuoc_GUI extends JFrame {

	public static List<Thuoc> lstT;
	private static Thuoc_DAO Thuoc_dao;
	private static List<HoatChat> lstHC;
	private static HoatChat_DAO HoatChat_dao;
	private static List<NhaSanXuat> lstNSX;
	private static NhaSanXuat_DAO NSX_dao;
	private static List<QuocGia> lstQG;
	private static QuocGia_DAO QG_dao;
	private static List<LoaiThuoc> lstLT;
	private static LoaiThuoc_DAO LT_dao;
	private static List<DonViTinh> lstDV;
	private static DonViTinh_DAO DV_dao;

	private JPanel contentPane;
	private static JComboBox cboNameSP,cboHC,cboNSX,cboNgH;
	private static DefaultTableModel model;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thuoc_GUI frame = new Thuoc_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Thuoc_GUI() {
		ConnectDB.getInstance().connect();
		Thuoc_dao = new Thuoc_DAO();
		HoatChat_dao = new HoatChat_DAO();
		NSX_dao = new NhaSanXuat_DAO();
		DV_dao = new DonViTinh_DAO();
		QG_dao = new QuocGia_DAO();
		LT_dao = new LoaiThuoc_DAO();
		DocDLDB();

		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setBackground(Color.WHITE);
		setTitle("Qu???n l?? s???n ph???m");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		horizontalBox.setBackground(Color.WHITE);
		contentPane.add(horizontalBox, BorderLayout.NORTH);

		JLabel label = new JLabel("   ");
		horizontalBox.add(label);

		JLabel lblNameTag = new JLabel("QU???N L?? S???N PH???M");
		lblNameTag.setToolTipText("QU???N L?? S???N PH???M");
		lblNameTag.setForeground(Color.BLUE);
		lblNameTag.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNameTag.setBackground(Color.WHITE);
		horizontalBox.add(lblNameTag);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("data\\icons\\logo3.png"));
		label_2.setBackground(Color.WHITE);
		horizontalBox.add(label_2);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 11, 974, 137);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNameSP = new JLabel("T??n thu???c:");
		lblNameSP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameSP.setBounds(20, 28, 120, 26);
		panel_1.add(lblNameSP);

		JButton btnSearch = new JButton("T??m");
		btnSearch.setIcon(new ImageIcon("data\\icons\\search3.png"));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(821, 22, 125, 38);
		btnSearch.setFocusable(false);
//		btnSearch.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//
//				String tenThuoc = (String) cboNameSP.getSelectedItem();
//				if(tenThuoc.equals("--------------"))
//					tenThuoc = "";
//				String tenNSX = (String) cboNSX.getSelectedItem();
//				if(tenNSX.equals("--------------"))
//					tenNSX = "";
//				String tenLoai = (String) cboNgH.getSelectedItem();
//				if(tenLoai.equals("--------------"))
//					tenLoai = "";
//				String tenHC = (String) cboHC.getSelectedItem();
//				if(tenHC.equals("--------------"))
//					tenHC = "";
//
//				if(tenThuoc.trim().equals("") && tenNSX.trim().equals("") && tenLoai.trim().equals("") && tenHC.trim().equals("")) {
//					JOptionPane.showMessageDialog(null, "Vui l??ng ch???n th??ng tin t??m ki???m!");
//				}
//				else {					
//					if(lstT.size()!=0) {
//						lstT = Thuoc_dao.timKiem(tenThuoc, tenNSX, tenLoai, tenHC);
//						XoaHetDuLieuTrenTableModel();
//						int i=1	;
//						for(Thuoc t : lstT) {
//							model.addRow(new Object[] {i++, t.getMaThuoc(), t.getTenThuoc(), t.getGiaBan(), t.getSoLuong(),
//									t.getMaNSX(), t.getMaDV(),t.getMaLoai() });
//						}
//						table.setModel(model);
//					}
//					else {
//						XoaHetDuLieuTrenTableModel();
//						table.setModel(model);
//						JOptionPane.showMessageDialog(null, "Kh??ng t??m th???y!");
//					}
//				}
//			}
//		});
		panel_1.add(btnSearch);

		JButton btnAdd = new JButton("Th??m m???i");
		btnAdd.setIcon(new ImageIcon("data\\icons\\add1.png"));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(821, 71, 125, 38);
		btnAdd.setFocusable(false);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Thuoc_ADD_GUI tADD = new Thuoc_ADD_GUI();
				tADD.setVisible(true);
			}
		});
		panel_1.add(btnAdd);

		cboNameSP = new JComboBox();
		cboNameSP.setBackground(Color.WHITE);
		cboNameSP.setBounds(150, 28, 249, 26);
		cboNameSP.setFocusable(false);
		panel_1.add(cboNameSP);

		JLabel lblNSX = new JLabel("Nh?? s???n xu???t:");
		lblNSX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNSX.setBounds(409, 28, 120, 26);
		panel_1.add(lblNSX);

		cboNSX = new JComboBox();
		cboNSX.setBackground(Color.WHITE);
		cboNSX.setBounds(539, 28, 249, 26);
		cboNSX.setFocusable(false);
		panel_1.add(cboNSX);

		JLabel lblHC = new JLabel("Ho???t ch???t:");
		lblHC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHC.setBounds(20, 77, 120, 26);
		panel_1.add(lblHC);

		cboHC = new JComboBox();
		cboHC.setBackground(Color.WHITE);
		cboHC.setBounds(150, 77, 249, 26);
		cboHC.setFocusable(false);
		panel_1.add(cboHC);

		JLabel lblNgH = new JLabel("Ng??nh h??ng:");
		lblNgH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgH.setBounds(409, 77, 120, 26);
		panel_1.add(lblNgH);

		cboNgH = new JComboBox();
		cboNgH.setBackground(Color.WHITE);
		cboNgH.setBounds(539, 77, 249, 26);
		cboNgH.setFocusable(false);
		panel_1.add(cboNgH);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 159, 974, 320);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 954, 288);
		panel_2.add(scrollPane);

		model = new DefaultTableModel(new String[] {
				"STT", "M?? s???n ph???m", "T??n s???n ph???m", "Gi?? b??n", "S??? l?????ng",
				"Nh?? s???n xu???t", "Lo???i thu???c", "????n v??? t??nh", "H???p ch???t", "M?? t???"
		}, 0);
		table = new JTable(model);
		table.setBackground(Color.WHITE);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setMaxWidth(27);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JTableHeader Theader = table.getTableHeader();
		Theader.setBackground(Color.white);
		Theader.setFont(new Font("Tahome", Font.BOLD, 11));
		scrollPane.setViewportView(table);

		JButton btnPrint = new JButton("In Danh S??ch");
		btnPrint.setFocusable(false);
		btnPrint.setBackground(Color.WHITE);
		btnPrint.setBounds(309, 490, 123, 39);
		panel.add(btnPrint);

		JButton btnChoose = new JButton("Ch???n");
		btnChoose.setFocusable(false);
		btnChoose.setBackground(Color.WHITE);
		btnChoose.setBounds(442, 490, 123, 39);
		panel.add(btnChoose);

		JButton btnUpdate = new JButton("C???p Nh???t");
		btnUpdate.setIcon(new ImageIcon("data\\icons\\searchsale2.png"));
		btnUpdate.setFocusable(false);
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(575, 490, 123, 39);
		btnUpdate.addActionListener(new ActionListener() { //xu ly su kien button sua thong tin thuoc

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row != -1) {
					String maThuoc = model.getValueAt(row, 1).toString().trim();
					Thuoc_EDIT_GUI tEdit = new Thuoc_EDIT_GUI(maThuoc);
					tEdit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui l??ng ch???n thu???c c???n s???a!");
				}
			}
		});
		panel.add(btnUpdate);

		JButton btnDel = new JButton("X??a");
		btnDel.setIcon(new ImageIcon("data\\icons\\delete1.png"));
		btnDel.setFocusable(false);
		btnDel.setBackground(Color.WHITE);
		btnDel.setBounds(708, 490, 123, 39);
		btnDel.addActionListener(new ActionListener() { //xu ly su kien button xoa thuoc

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row != -1) {
					String maThuoc = model.getValueAt(row, 1).toString().trim();
					int nhacnho = JOptionPane.showConfirmDialog(null, "B???n c?? ch???c mu???n x??a kh??ng?", "Ch?? ??", JOptionPane.YES_NO_OPTION);
					if(nhacnho == JOptionPane.YES_OPTION) {
						try {
							if (!Thuoc_dao.xoa(maThuoc))
								throw new Exception();
							else
								updateDL();
							JOptionPane.showMessageDialog(null,"X??a th??nh c??ng!");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "X??a kh??ng th??nh c??ng!");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui l??ng ch???n m???t thu???c c???n x??a!");
				}
			}
		});
		panel.add(btnDel);

		JButton btnClose = new JButton("????ng");
		btnClose.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnClose.setFocusable(false);
		btnClose.setBackground(Color.WHITE);
		btnClose.setBounds(841, 490, 123, 39);
		btnClose.addActionListener(new ActionListener() { //xu ly su kien button Dong

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		panel.add(btnClose);
		updateDL();
		updateDLCbo();
	}

	private static void DocDLDB() {
		//maThuoc,tenThuoc,giaBan,soLuong,moTa,NSX,loaiThuoc,donViTinh,QG,HoatChat
		lstT = Thuoc_dao.getAlltbThuoc();
		lstHC = HoatChat_dao.getalltbHC();
		lstNSX = NSX_dao.docTuBang();
		lstDV = DV_dao.getalltbDVT();
		lstQG = QG_dao.getAllQuocGia();
		lstLT = LT_dao.getAllLoaiThuoc();
	}

	private static void XoaHetDuLieuTrenTableModel() {
		model.getDataVector().removeAllElements();
	}

	public static void updateDL() {
		XoaHetDuLieuTrenTableModel();
		DocDLDB();
		updateDLCbo();
		int i=1;
		for(Thuoc t : lstT) {
			model.addRow(new Object[] {i++, t.getMaThuoc(), t.getTenThuoc(), t.getGiaBan(), t.getSoLuong(),
				 getNSX(t.getMaNSX()), getLT(t.getMaLoai()), getDV(t.getMaDV()), getHC(t.getMaHC()), t.getMoTa() });
		}
		table.setModel(model);
	}

	private static void updateDLCbo() {
		//	cboNameSP,cboHC,cboNSX,cboNgH
		cboNameSP.removeAllItems();
		cboHC.removeAllItems();
		cboNSX.removeAllItems();
		cboNgH.removeAllItems();

		cboNameSP.addItem("Kh??ng ch???n");
		cboHC.addItem("Kh??ng ch???n");
		cboNSX.addItem("Kh??ng ch???n");
		cboNgH.addItem("Kh??ng ch???n");

		for(Thuoc t : lstT) {
			cboNameSP.addItem(t.getTenThuoc().trim());
		}
		for(HoatChat h :lstHC) {
			cboHC.addItem(h.getTenHC().trim());
		}
		for(NhaSanXuat n :lstNSX) {
			cboNSX.addItem(n.getTenNSX().trim());
		}
		for(LoaiThuoc l :lstLT) {
			cboNgH.addItem(l.getTenLoaiThuoc().trim());
		}

		cboNameSP.setSelectedIndex(-1);
		cboHC.setSelectedIndex(-1);
		cboNSX.setSelectedIndex(-1);
		cboNgH.setSelectedIndex(-1);
	}
	public static String getNSX(String ma) {
		for(NhaSanXuat s : lstNSX) {
			if(s.getMaNSX().trim().equalsIgnoreCase(ma.trim())) {
				return s.getTenNSX().trim();
			}
		}
		return "";
	}
	public static String getDV(String ma) {
		for(DonViTinh s : lstDV) {
			if(s.getMaDV().trim().equalsIgnoreCase(ma.trim())) {
				return s.getTenDonVi().trim();
			}
		}
		return "";
	}
	public static String getLT(String ma) {
		for(LoaiThuoc s : lstLT) {
			if(s.getMaLoai().trim().equalsIgnoreCase(ma.trim())) {
				return s.getTenLoaiThuoc().trim();
			}
		}
		return "";
	}
	public static String getHC(String ma) {
		for(HoatChat s : lstHC) {
			if(s.getMaHC().trim().equalsIgnoreCase(ma.trim())) {
				return s.getTenHC().trim();
			}
		}
		return "";
	}
	public static String getQG(String ma) {
		for(QuocGia s : lstQG) {
			if(s.getMaQG().trim().equalsIgnoreCase(ma.trim())) {
				return s.getTenQuocGia().trim();
			}
		}
		return "";
	}
}
