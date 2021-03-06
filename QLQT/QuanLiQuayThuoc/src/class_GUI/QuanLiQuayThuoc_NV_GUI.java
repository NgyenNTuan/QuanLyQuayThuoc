package class_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.awt.event.InputEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.DisplayMode;

import javax.swing.Box;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import class_DAO.DangNhap_DAO;
import class_DAO.QuanLyNV_DAO;
import class_connectDB.ConnectDB;
import class_entity.DangNhap;
import class_entity.NhanVien;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuanLiQuayThuoc_NV_GUI extends JFrame {
	
	public static String signing1;
	private DangNhap_DAO dn_DAO;
	private List<DangNhap> ldn;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String signing) {
//		signing1 = signing;
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QuanLiQuayThuoc_NV_GUI frame = new QuanLiQuayThuoc_NV_GUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public QuanLiQuayThuoc_NV_GUI(String signing) {
		
		signing1 = signing;
		
		ConnectDB.getInstance().connect();
		dn_DAO = new DangNhap_DAO();
		ldn = dn_DAO.getalltabledangnhap();
		
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\iconimange.png"));
		//menuBar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setForeground(Color.RED);
		menuBar.setBackground(new Color(176, 224, 230));
        setJMenuBar(menuBar);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("data\\icons\\system.png"));
        label.setForeground(SystemColor.textHighlight);
        menuBar.add(label);
        
        JMenu menu = new JMenu("H\u1EC7 Th\u1ED1ng");
        menu.setForeground(SystemColor.textHighlight);
        menu.setFont(new Font("Arial", Font.PLAIN, 12));
        menu.setBackground(SystemColor.textHighlight);
        menuBar.add(menu);
        
        JMenuItem menuItem = new JMenuItem("Nh\u00E2n Vi\u00EAn");
        menuItem.setIcon(new ImageIcon("data\\icons\\employee2.png"));
        menuItem.setFont(new Font("Arial", Font.PLAIN, 12));
        menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				NhanVien_GUI nv = new NhanVien_GUI();
				nv.setVisible(true);
			}
		});
        menu.add(menuItem);
        
        JMenuItem menuItem_1 = new JMenuItem("T\u00E0i Kho\u1EA3n");
        menuItem_1.setIcon(new ImageIcon("data\\icons\\account.png"));
        menuItem_1.setFont(new Font("Arial", Font.PLAIN, 12));
        menu.add(menuItem_1);
        
        JMenuItem menuItem_2 = new JMenuItem("Ph\u00E2n Quy\u1EC1n");
        menuItem_2.setIcon(new ImageIcon("data\\icons\\phanquyen.png"));
        menuItem_2.setFont(new Font("Arial", Font.PLAIN, 12));
        menu.add(menuItem_2);
        
        JSeparator separator = new JSeparator();
        menu.add(separator);
        
        JMenuItem menuItem_3 = new JMenuItem("\u0110\u0103ng Nh\u1EADp");
        menuItem_3.setIcon(new ImageIcon("data\\icons\\login.png"));
        menuItem_3.setFont(new Font("Arial", Font.PLAIN, 12));
        menu.add(menuItem_3);
        
        JMenuItem menuItem_4 = new JMenuItem("\u0110\u1ED5i M\u1EADt Kh\u1EA9u");
        menuItem_4.setIcon(new ImageIcon("E:\\Documents\\eclipse1\\QuanLyNhaThuoc1\\data\\icons\\changekey.png"));
        menuItem_4.setFont(new Font("Arial", Font.PLAIN, 12));
        menu.add(menuItem_4);
        
        JMenuItem menuItem_5 = new JMenuItem("\u0110\u0103ng Xu\u1EA5t");
        menuItem_5.setIcon(new ImageIcon("E:\\Documents\\eclipse1\\QuanLyNhaThuoc1\\data\\icons\\logout.png"));
        menuItem_5.setFont(new Font("Arial", Font.PLAIN, 12));
        menu.add(menuItem_5);
        
        JSeparator separator_1 = new JSeparator();
        menu.add(separator_1);
        
        JMenuItem menuItem_6 = new JMenuItem("Giao Ca");
        menuItem_6.setIcon(new ImageIcon("E:\\Documents\\eclipse1\\QuanLyNhaThuoc1\\data\\icons\\changeca.png"));
        menuItem_6.setFont(new Font("Arial", Font.PLAIN, 12));
        menu.add(menuItem_6);
        
        JSeparator separator_2 = new JSeparator();
        menu.add(separator_2);
        
        JMenuItem menuItem_7 = new JMenuItem("C\u00E0i \u0110\u1EB7t");
        menuItem_7.setIcon(new ImageIcon("E:\\Documents\\eclipse1\\QuanLyNhaThuoc1\\data\\icons\\setting.png"));
        menuItem_7.setFont(new Font("Arial", Font.PLAIN, 12));
        menu.add(menuItem_7);
        
        JMenuItem menuItem_8 = new JMenuItem("Sao L\u01B0u D\u1EEF Li\u1EC7u");
        menuItem_8.setIcon(new ImageIcon("E:\\Documents\\eclipse1\\QuanLyNhaThuoc1\\data\\icons\\backup.png"));
        menuItem_8.setFont(new Font("Arial", Font.PLAIN, 12));
        menu.add(menuItem_8);
        
        JMenuItem menuItem_9 = new JMenuItem("Ph\u1EE5c H\u1ED3i D\u1EEF Li\u1EC7u");
        menuItem_9.setIcon(new ImageIcon("E:\\Documents\\eclipse1\\QuanLyNhaThuoc1\\data\\icons\\restore.png"));
        menuItem_9.setFont(new Font("Arial", Font.PLAIN, 12));
        menu.add(menuItem_9);
        
        JMenuItem menuItem_10 = new JMenuItem("Gi\u1EDBi Thi\u1EC7u");
        menuItem_10.setIcon(new ImageIcon("E:\\Documents\\eclipse1\\QuanLyNhaThuoc1\\data\\icons\\about.png"));
        menuItem_10.setFont(new Font("Arial", Font.PLAIN, 12));
        menu.add(menuItem_10);
        
        JMenuItem menuItem_11 = new JMenuItem("Tho\u00E1t");
        menuItem_11.setIcon(new ImageIcon("E:\\Documents\\eclipse1\\QuanLyNhaThuoc1\\data\\icons\\exit.png"));
        menuItem_11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
        menuItem_11.setFont(new Font("Arial", Font.PLAIN, 12));
        menu.add(menuItem_11);
        
        JMenu menu_2 = new JMenu("H\u00F3a \u0110\u01A1n Xu\u1EA5t");
        menu_2.setFont(new Font("Arial", Font.PLAIN, 12));
        menuBar.add(menu_2);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("B\u00E1n H\u00E0ng");
        mntmNewMenuItem.setFont(new Font("Arial", Font.PLAIN, 12));
        mntmNewMenuItem.setIcon(new ImageIcon("data\\icons\\sale1.png"));
        mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				HoaDon_ADD_GUI hdadd = new HoaDon_ADD_GUI(signing1);
				hdadd.setVisible(true);
			}
		});
        menu_2.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("T\u00ECm H\u00F3a \u0110\u01A1n B\u00E1n H\u00E0ng");
        mntmNewMenuItem_1.setFont(new Font("Arial", Font.PLAIN, 12));
        mntmNewMenuItem_1.setIcon(new ImageIcon("data\\icons\\searchsale1.png"));
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				HoaDon_GUI hd = new HoaDon_GUI(signing1);
				hd.setVisible(true);
			}
		});
        menu_2.add(mntmNewMenuItem_1);
        
        JMenu mnSnPhm = new JMenu("S\u1EA3n Ph\u1EA9m");
        mnSnPhm.setFont(new Font("Arial", Font.PLAIN, 12));
        menuBar.add(mnSnPhm);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("T\u00ECm Ki\u1EBFm S\u1EA3n Ph\u1EA9m");
        mntmNewMenuItem_2.setIcon(new ImageIcon("E:\\Documents\\eclipse1\\QuanLyNhaThuoc1\\data\\icons\\search.png"));
        mntmNewMenuItem_2.setFont(new Font("Arial", Font.PLAIN, 12));
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Thuoc_GUI th = new Thuoc_GUI();
				th.setVisible(true);
			}
		});
        mnSnPhm.add(mntmNewMenuItem_2);
        
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Th\u00EAm S\u1EA3n Ph\u1EA9m M\u1EDBi");
        mntmNewMenuItem_3.setIcon(new ImageIcon("E:\\Documents\\eclipse1\\QuanLyNhaThuoc1\\data\\icons\\add.png"));
        mntmNewMenuItem_3.setFont(new Font("Arial", Font.PLAIN, 12));
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Thuoc_ADD_GUI thadd = new Thuoc_ADD_GUI();
				thadd.setVisible(true);
			}
		});
        mnSnPhm.add(mntmNewMenuItem_3);
        
        JMenu mnNewMenu = new JMenu("Kh\u00E1ch H\u00E0ng");
        mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 12));
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem_4 = new JMenuItem("Qu\u1EA3n L\u00ED Kh\u00E1ch H\u00E0ng");
        mntmNewMenuItem_4.setFont(new Font("Arial", Font.PLAIN, 12));
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
//				KhachHang_GUI kh = new KhachHang_GUI();
//				kh.setVisible(true);
				JOptionPane.showMessageDialog(null, "Ch??a c???p quy???n truy c???p!");
			}
		});
        mnNewMenu.add(mntmNewMenuItem_4);
        
        JMenu mnNewMenu_1 = new JMenu("Danh M\u1EE5c");
        mnNewMenu_1.setFont(new Font("Arial", Font.PLAIN, 12));
        menuBar.add(mnNewMenu_1);
        
        JMenuItem mntmNewMenuItem_8 = new JMenuItem("Nh\u00E0 S\u1EA3n Xu\u1EA5t");
        mntmNewMenuItem_8.setFont(new Font("Arial", Font.PLAIN, 12));
        mntmNewMenuItem_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				NhaSanXuat_GUI nsx = new NhaSanXuat_GUI();
//				nsx.setVisible(true);
				JOptionPane.showMessageDialog(null, "Ch??a c???p quy???n truy c???p!");
			}
		});
        mnNewMenu_1.add(mntmNewMenuItem_8);
        
        JSeparator separator_5 = new JSeparator();
        mnNewMenu_1.add(separator_5);
        
        JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u0110\u01A1n V\u1ECB T\u00EDnh");
        mntmNewMenuItem_9.setFont(new Font("Arial", Font.PLAIN, 12));
        mntmNewMenuItem_9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DonViTinh_GUI dvt = new DonViTinh_GUI();
				dvt.setVisible(true);
			}
		});
        mnNewMenu_1.add(mntmNewMenuItem_9);
        
        JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u0110\u01A1n V\u1ECB Quy \u0110\u1ED5i");
        mntmNewMenuItem_10.setFont(new Font("Arial", Font.PLAIN, 12));
        mnNewMenu_1.add(mntmNewMenuItem_10);
        
        JMenu mnNewMenu_2 = new JMenu("B\u00E1o C\u00E1o");
        mnNewMenu_2.setFont(new Font("Arial", Font.PLAIN, 12));
        menuBar.add(mnNewMenu_2);
        
        JMenuItem mntmToBoCo = new JMenuItem("Th???ng k?? doanh thu");
        mntmToBoCo.setFont(new Font("Arial", Font.PLAIN, 12));
        mntmToBoCo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ThongKeDoanhThu_GUI dt = new ThongKeDoanhThu_GUI();
				dt.setVisible(true);
			}
		});
        mnNewMenu_2.add(mntmToBoCo);
        
        JMenuItem mntmXemBoCo = new JMenuItem("Th???ng k?? thu???c");
        mntmXemBoCo.setFont(new Font("Arial", Font.PLAIN, 12));
        mntmXemBoCo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ThongKeThuocDuocBanNhieuNhat_GUI t = new ThongKeThuocDuocBanNhieuNhat_GUI();
				t.setVisible(true);
			}
		});
        mnNewMenu_2.add(mntmXemBoCo);
        
        //toolBar
        JToolBar toolbar = new JToolBar();
        toolbar.setBackground(Color.WHITE);
        toolbar.setForeground(Color.WHITE);
        getContentPane().add(toolbar, BorderLayout.NORTH);
        
        JLabel lblNewLabel_1 = new JLabel("    ");
        toolbar.add(lblNewLabel_1);
        
        JButton btnBH1 = new JButton("B\u00E1n H\u00E0ng");
        btnBH1.setBackground(Color.WHITE);
        btnBH1.setFont(new Font("Arial", Font.PLAIN, 13));
        btnBH1.setIcon(new ImageIcon("data\\icons\\sale2.png"));
        btnBH1.setToolTipText("B\u00E1n H\u00E0ng");
        btnBH1.setFocusable(false);
        btnBH1.setBorder(new LineBorder(Color.white));
        btnBH1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				HoaDon_ADD1_GUI hdadd = new HoaDon_ADD1_GUI(signing1);
				hdadd.setVisible(true);
			}
		});
        toolbar.add(btnBH1);
        
        JLabel label_1 = new JLabel("  ");
        toolbar.add(label_1);
        JLabel label_2 = new JLabel("    ");
        toolbar.add(label_2);
        
        JButton btnSearchHDN1 = new JButton("T??m H??a ????n");
        btnSearchHDN1.setBackground(Color.WHITE);
        btnSearchHDN1.setIcon(new ImageIcon("data\\icons\\searchsale2.png"));
        btnSearchHDN1.setToolTipText("T??m H??a ????n");
        btnSearchHDN1.setFont(new Font("Arial", Font.PLAIN, 13));
        btnSearchHDN1.setFocusable(false);
        btnSearchHDN1.setBorder(new LineBorder(Color.white));
        btnSearchHDN1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				HoaDon_GUI hd = new HoaDon_GUI(signing1);
				hd.setVisible(true);
			}
		});
        toolbar.add(btnSearchHDN1);
        
        JLabel label_3 = new JLabel("  ");
        toolbar.add(label_3);
        
        JButton btnSearchSP1 = new JButton("T\u00ECm S\u1EA3n Ph\u1EA9m");
        btnSearchSP1.setBackground(Color.WHITE);
        btnSearchSP1.setToolTipText("");
        btnSearchSP1.setIcon(new ImageIcon("data\\icons\\searchproduct.png"));
        btnSearchSP1.setFont(new Font("Arial", Font.PLAIN, 13));
        btnSearchSP1.setFocusable(false);
        btnSearchSP1.setBorder(new LineBorder(Color.white));
        btnSearchSP1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Thuoc_GUI th = new Thuoc_GUI();
				th.setVisible(true);
			}
		});
        toolbar.add(btnSearchSP1);
        
        Component horizontalGlue = Box.createHorizontalGlue();
        toolbar.add(horizontalGlue);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("data\\icons\\logo3.png"));
        toolbar.add(lblNewLabel);
        
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.setBorder(null);
        horizontalBox.setBackground(Color.WHITE);
        getContentPane().add(horizontalBox, BorderLayout.SOUTH);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setVgap(12);
        flowLayout.setHgap(10);
        horizontalBox.add(panel);
        
        JButton btnNV = new JButton("Nh\u00E2n Vi\u00EAn");
        btnNV.setToolTipText("Nh\u00E2n Vi\u00EAn");
        btnNV.setIcon(new ImageIcon("data\\icons\\employee1.png"));
        btnNV.setFocusable(false);
        btnNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
//				NhanVien_GUI nv = new NhanVien_GUI();
//				nv.setVisible(true);
				JOptionPane.showMessageDialog(null, "Ch??a c???p quy???n truy c???p!");
			}
		});
        panel.add(btnNV);
        
        JButton btnTK = new JButton("T\u00E0i Kho\u1EA3n");
        btnTK.setToolTipText("T\u00E0i Kho\u1EA3n");
        btnTK.setIcon(new ImageIcon("data\\icons\\account.png"));
        btnTK.setFocusable(false);
        btnTK.addActionListener(new ActionListener() {
			
        	ThongTinTaiKhoan iftk;
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(DangNhap s : ldn) {
					if(s.getQuanLy()==0) 
						iftk = new ThongTinTaiKhoan(signing1, 0);
					else
						iftk = new ThongTinTaiKhoan(signing1, 1);
				}
				iftk.setVisible(true);
			}
		});
        panel.add(btnTK);
        
        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        panel.add(horizontalStrut_1);
        
        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        panel.add(horizontalStrut_2);
        
        Component horizontalGlue_1 = Box.createHorizontalGlue();
        horizontalBox.add(horizontalGlue_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.WHITE);
        FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
        flowLayout_1.setVgap(12);
        flowLayout_1.setHgap(10);
        horizontalBox.add(panel_1);
        
        Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        panel_1.add(horizontalStrut_3);
        
        Component horizontalStrut = Box.createHorizontalStrut(20);
        panel_1.add(horizontalStrut);
        
        JButton btnSetting = new JButton("Help");
        btnSetting.setIcon(new ImageIcon("data\\icons\\setting.png"));
        btnSetting.setToolTipText("");
        btnSetting.setFocusable(false);
        btnSetting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try
		        {
		            String path = new File("").getAbsolutePath() + "\\data\\Help\\Help.chm";
		            File file = new File(path);
		            
		            if(file.exists())
		            {
		                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + path);
		            }
		            else
		            {
		                throw new Exception("File \"Help.chm\" not found!");
		            }
		        }
		        catch(Exception ex)
		        {
		            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Notice", JOptionPane.OK_OPTION);
		        }
			}
		});
        panel_1.add(btnSetting);
        
        JButton btnDangXuat = new JButton("\u0110\u0103ng Xu\u1EA5t");
        btnDangXuat.setIcon(new ImageIcon("data\\icons\\logout.png"));
        btnDangXuat.setToolTipText("\u0110\u0103ng Xu\u1EA5t");
        btnDangXuat.setFocusable(false);
        btnDangXuat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DangNhap_GUI dn = new DangNhap_GUI();
				dn.setVisible(true);
				dispose();
			}
		});
        panel_1.add(btnDangXuat);
        
        JButton btnExit = new JButton("Tho\u00E1t");
        btnExit.setIcon(new ImageIcon("data\\icons\\exit.png"));
        btnExit.setToolTipText("Tho\u00E1t");
        btnExit.setFocusable(false);
        btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
        panel_1.add(btnExit);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.controlShadow));
        panel_2.setBackground(Color.WHITE);
        getContentPane().add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(null);
        
        JLabel lblDanhMc = new JLabel("Danh M\u1EE5c:");
        lblDanhMc.setToolTipText("Danh M\u1EE5c");
        lblDanhMc.setFont(new Font("Arial", Font.BOLD, 13));
        lblDanhMc.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDanhMc.setBounds(84, 53, 123, 27);
        panel_2.add(lblDanhMc);
        
        JButton btnNSX = new JButton("Nh\u00E0 S\u1EA3n Xu\u1EA5t");
        btnNSX.setIcon(new ImageIcon("data\\icons\\ncc.png"));
        btnNSX.setHorizontalAlignment(SwingConstants.LEFT);
        btnNSX.setFont(new Font("Arial", Font.PLAIN, 12));
        btnNSX.setBackground(Color.WHITE);
        btnNSX.setToolTipText("");
        btnNSX.setBounds(217, 27, 182, 34);
        btnNSX.setFocusable(false);
        btnNSX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				NhaSanXuat_GUI nsx = new NhaSanXuat_GUI();
				nsx.setVisible(true);
			}
		});
        panel_2.add(btnNSX);
        
        JButton btnDVT = new JButton("\u0110\u01A1n V\u1ECB T\u00EDnh");
        btnDVT.setBackground(Color.WHITE);
        btnDVT.setIcon(new ImageIcon("data\\icons\\calculating.png"));
        btnDVT.setToolTipText("\u0110\u01A1n V\u1ECB T\u00EDnh");
        btnDVT.setHorizontalAlignment(SwingConstants.LEFT);
        btnDVT.setFont(new Font("Arial", Font.PLAIN, 12));
        btnDVT.setBounds(420, 27, 182, 34);
        btnDVT.setFocusable(false);
        btnDVT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DonViTinh_GUI dvt = new DonViTinh_GUI();
				dvt.setVisible(true);
			}
		});
        panel_2.add(btnDVT);
        
        JButton btnDVQD = new JButton("\u0110\u01A1n V\u1ECB Quy \u0110\u1ED5i");
        btnDVQD.setBackground(Color.WHITE);
        btnDVQD.setIcon(new ImageIcon("data\\icons\\donvidoi.png"));
        btnDVQD.setToolTipText("\u0110\u01A1n V\u1ECB Quy \u0110\u1ED5i");
        btnDVQD.setHorizontalAlignment(SwingConstants.LEFT);
        btnDVQD.setFont(new Font("Arial", Font.PLAIN, 12));
        btnDVQD.setBounds(624, 27, 182, 34);
        btnDVQD.setFocusable(false);
        panel_2.add(btnDVQD);
        
        JLabel lblSan = new JLabel("S\u1EA3n Ph\u1EA9m:");
        lblSan.setToolTipText("S\u1EA3n Ph\u1EA9m");
        lblSan.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSan.setFont(new Font("Arial", Font.BOLD, 13));
        lblSan.setBounds(84, 134, 123, 27);
        panel_2.add(lblSan);
        
        JButton btnAddSP = new JButton("Th\u00EAm S\u1EA3n Ph\u1EA9m");
        btnAddSP.setHorizontalAlignment(SwingConstants.LEFT);
        btnAddSP.setIcon(new ImageIcon("data\\icons\\add1.png"));
        btnAddSP.setToolTipText("Th\u00EAm S\u1EA3n Ph\u1EA9m");
        btnAddSP.setFont(new Font("Arial", Font.PLAIN, 12));
        btnAddSP.setBackground(Color.WHITE);
        btnAddSP.setBounds(217, 134, 182, 34);
        btnAddSP.setFocusable(false);
        btnAddSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Thuoc_ADD_GUI thadd = new Thuoc_ADD_GUI();
				thadd.setVisible(true);
			}
		});
        panel_2.add(btnAddSP);
        
        JButton btnSearchSP2 = new JButton("T\u00ECm S\u1EA3n Ph\u1EA9m");
        btnSearchSP2.setBackground(Color.WHITE);
        btnSearchSP2.setHorizontalAlignment(SwingConstants.LEFT);
        btnSearchSP2.setIcon(new ImageIcon("data\\icons\\search2.png"));
        btnSearchSP2.setToolTipText("T\u00ECm S\u1EA3n Ph\u1EA9m");
        btnSearchSP2.setFont(new Font("Arial", Font.PLAIN, 12));
        btnSearchSP2.setBounds(420, 134, 182, 34);
        btnSearchSP2.setFocusable(false);
        btnSearchSP2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Thuoc_GUI th = new Thuoc_GUI();
				th.setVisible(true);
			}
		});
        panel_2.add(btnSearchSP2);
        
        JLabel lblNhCungCp = new JLabel("Nh?? S???n Xu???t:");
        lblNhCungCp.setToolTipText("Nh?? S???n Xu???t");
        lblNhCungCp.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNhCungCp.setFont(new Font("Arial", Font.BOLD, 13));
        lblNhCungCp.setBounds(84, 203, 123, 27);
        panel_2.add(lblNhCungCp);
        
        JButton btnAddNSX = new JButton("Th\u00EAm Nh\u00E0 S\u1EA3n Xu\u1EA5t");
        btnAddNSX.setIcon(new ImageIcon("data\\icons\\add1.png"));
        btnAddNSX.setHorizontalAlignment(SwingConstants.LEFT);
        btnAddNSX.setToolTipText("Th\u00EAm Nh\u00E0 Cung C\u1EA5p");
        btnAddNSX.setFont(new Font("Arial", Font.PLAIN, 12));
        btnAddNSX.setBackground(Color.WHITE);
        btnAddNSX.setBounds(217, 199, 182, 34);
        btnAddNSX.setFocusable(false);
        btnAddNSX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
//				NhanVien_ADD_GUI nsxAdd = new NhanVien_ADD_GUI();
//				nsxAdd.setVisible(true);
				JOptionPane.showMessageDialog(null, "Ch??a c???p quy???n truy c???p!");
			}
		});
        panel_2.add(btnAddNSX);
        
        JButton btnSearchNSX = new JButton("T\u00ECm Nh\u00E0 S\u1EA3n Xu\u1EA5t");
        btnSearchNSX.setBackground(Color.WHITE);
        btnSearchNSX.setHorizontalAlignment(SwingConstants.LEFT);
        btnSearchNSX.setIcon(new ImageIcon("data\\icons\\searchncc.png"));
        btnSearchNSX.setToolTipText("");
        btnSearchNSX.setFont(new Font("Arial", Font.PLAIN, 12));
        btnSearchNSX.setBounds(420, 199, 182, 34);
        btnSearchNSX.setFocusable(false);
        btnSearchNSX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
//				NhaSanXuat_GUI nsx = new NhaSanXuat_GUI();
//				nsx.setVisible(true);
				JOptionPane.showMessageDialog(null, "Ch??a c???p quy???n truy c???p!");
			}
		});
        panel_2.add(btnSearchNSX);
        
        JLabel lblHanXut = new JLabel("H\u00F3a \u0110\u01A1n Xu\u1EA5t:");
        lblHanXut.setToolTipText("H\u00F3a \u0110\u01A1n Xu\u1EA5t");
        lblHanXut.setHorizontalAlignment(SwingConstants.RIGHT);
        lblHanXut.setFont(new Font("Arial", Font.BOLD, 13));
        lblHanXut.setBounds(84, 269, 123, 27);
        panel_2.add(lblHanXut);
        
        JButton btnBH = new JButton("B\u00E1n H\u00E0ng");
        btnBH.setHorizontalAlignment(SwingConstants.LEFT);
        btnBH.setIcon(new ImageIcon("data\\icons\\sale2.png"));
        btnBH.setToolTipText("B\u00E1n H\u00E0ng");
        btnBH.setFont(new Font("Arial", Font.PLAIN, 12));
        btnBH.setBackground(Color.WHITE);
        btnBH.setBounds(217, 265, 182, 34);
        btnBH.setFocusable(false);
        btnBH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				HoaDon_ADD1_GUI hdadd = new HoaDon_ADD1_GUI(signing1);
				hdadd.setVisible(true);
			}
		});
        panel_2.add(btnBH);
        
        JButton btnSearchHDX = new JButton("T??m H??a ????n");
        btnSearchHDX.setBackground(Color.WHITE);
        btnSearchHDX.setIcon(new ImageIcon("data\\icons\\searchsale2.png"));
        btnSearchHDX.setToolTipText("T??m H??a ????n");
        btnSearchHDX.setHorizontalAlignment(SwingConstants.LEFT);
        btnSearchHDX.setFont(new Font("Arial", Font.PLAIN, 12));
        btnSearchHDX.setBounds(420, 265, 182, 34);
        btnSearchHDX.setFocusable(false);
        btnSearchHDX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				HoaDon_GUI hd = new HoaDon_GUI(signing1);
				hd.setVisible(true);
			}
		});
        panel_2.add(btnSearchHDX);
        
        JLabel lblKhchHng = new JLabel("Kh\u00E1ch H\u00E0ng:");
        lblKhchHng.setToolTipText("Kh\u00E1ch H\u00E0ng");
        lblKhchHng.setHorizontalAlignment(SwingConstants.RIGHT);
        lblKhchHng.setFont(new Font("Arial", Font.BOLD, 13));
        lblKhchHng.setBounds(84, 331, 123, 27);
        panel_2.add(lblKhchHng);
        
        JButton btnAddKH = new JButton("Th\u00EAm Kh\u00E1ch H\u00E0ng");
        btnAddKH.setHorizontalAlignment(SwingConstants.LEFT);
        btnAddKH.setIcon(new ImageIcon("data\\icons\\add1.png"));
        btnAddKH.setToolTipText("Th\u00EAm Kh\u00E1ch H\u00E0ng");
        btnAddKH.setFont(new Font("Arial", Font.PLAIN, 12));
        btnAddKH.setBackground(Color.WHITE);
        btnAddKH.setBounds(217, 327, 182, 34);
        btnAddKH.setFocusable(false);
        btnAddKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				KhachHang_ADD_GUI khadd = new KhachHang_ADD_GUI();
				khadd.setVisible(true);
			}
		});
        panel_2.add(btnAddKH);
        
        JButton btnQLKH = new JButton("Qu\u1EA3n L\u00ED Kh\u00E1ch H\u00E0ng");
        btnQLKH.setBackground(Color.WHITE);
        btnQLKH.setIcon(new ImageIcon("data\\icons\\employee.png"));
        btnQLKH.setHorizontalAlignment(SwingConstants.LEFT);
        btnQLKH.setToolTipText("Qu\u1EA3n L\u00ED Kh\u00E1ch H\u00E0ng");
        btnQLKH.setFont(new Font("Arial", Font.PLAIN, 12));
        btnQLKH.setFocusable(false);
        btnQLKH.setBounds(420, 327, 182, 34);
        btnQLKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				KhachHang_GUI kh = new KhachHang_GUI();
				kh.setVisible(true);
			}
		});
        panel_2.add(btnQLKH);
        
        JLabel lblQunL = new JLabel("B\u00E1o C\u00E1o:");
        lblQunL.setToolTipText("B\u00E1o C\u00E1o");
        lblQunL.setHorizontalAlignment(SwingConstants.RIGHT);
        lblQunL.setFont(new Font("Arial", Font.BOLD, 13));
        lblQunL.setBounds(84, 394, 123, 27);
        panel_2.add(lblQunL);
        
        JButton btnAddBC = new JButton("Th???ng K?? Doanh Thu");
        btnAddBC.setHorizontalAlignment(SwingConstants.LEFT);
        btnAddBC.setIcon(new ImageIcon("data\\icons\\add1.png"));
        btnAddBC.setToolTipText("T\u1EA1o B\u00E1o C\u00E1o");
        btnAddBC.setFont(new Font("Arial", Font.PLAIN, 12));
        btnAddBC.setBackground(Color.WHITE);
        btnAddBC.setBounds(217, 390, 182, 34);
        btnAddBC.setFocusable(false);
        //btnAddBC.disable();
        btnAddBC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ThongKeDoanhThu_GUI dt = new ThongKeDoanhThu_GUI();
				dt.setVisible(true);
			}
		});
        panel_2.add(btnAddBC);
        
        JButton btnXemBC = new JButton("Th???ng K?? Thu???c");
        btnXemBC.setHorizontalAlignment(SwingConstants.LEFT);
        btnXemBC.setIcon(new ImageIcon("data\\icons\\searchsale2.png"));
        btnXemBC.setBackground(Color.WHITE);
        btnXemBC.setToolTipText("Xem B\u00E1o C\u00E1o");
        btnXemBC.setFont(new Font("Arial", Font.PLAIN, 12));
        btnXemBC.setBounds(420, 390, 182, 34);
        btnXemBC.setFocusable(false);
        //btnXemBC.disable();
        btnXemBC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ThongKeThuocDuocBanNhieuNhat_GUI t = new ThongKeThuocDuocBanNhieuNhat_GUI();
				t.setVisible(true);
			}
		});
        panel_2.add(btnXemBC);
        
        JButton btnNgH = new JButton("Ng\u00E0nh H\u00E0ng");
        btnNgH.setIcon(new ImageIcon("data\\icons\\ngj.png"));
        btnNgH.setToolTipText("");
        btnNgH.setHorizontalAlignment(SwingConstants.LEFT);
        btnNgH.setFont(new Font("Arial", Font.PLAIN, 12));
        btnNgH.setFocusable(false);
        btnNgH.setBackground(Color.WHITE);
        btnNgH.setBounds(217, 69, 182, 34);
        btnNgH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				LoaiThuoc_GUI lt = new LoaiThuoc_GUI();
				lt.setVisible(true);
			}
		});
        panel_2.add(btnNgH);
        
        JButton btnDieuKienBQ = new JButton("\u0110i\u1EC1u Ki\u1EC7n B\u1EA3o Qu\u1EA3n");
        btnDieuKienBQ.setIcon(new ImageIcon("data\\icons\\dkbq.png"));
        btnDieuKienBQ.setToolTipText("");
        btnDieuKienBQ.setHorizontalAlignment(SwingConstants.LEFT);
        btnDieuKienBQ.setFont(new Font("Arial", Font.PLAIN, 12));
        btnDieuKienBQ.setFocusable(false);
        btnDieuKienBQ.setBackground(Color.WHITE);
        btnDieuKienBQ.setBounds(420, 69, 182, 34);
        panel_2.add(btnDieuKienBQ);
        
        JButton btnHC = new JButton("Ho\u1EA1t Ch\u1EA5t");
        btnHC.setIcon(new ImageIcon("data\\icons\\hc.png"));
        btnHC.setToolTipText("");
        btnHC.setHorizontalAlignment(SwingConstants.LEFT);
        btnHC.setFont(new Font("Arial", Font.PLAIN, 12));
        btnHC.setFocusable(false);
        btnHC.setBackground(Color.WHITE);
        btnHC.setBounds(624, 69, 182, 34);
        btnHC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				HoatChat_GUI hc = new HoatChat_GUI();
				hc.setVisible(true);
			}
		});
        panel_2.add(btnHC);
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Pharmacy Management 1.0.0");
        setSize(908, 537);
        setMinimumSize(new Dimension(1050, 650));
        setLocationRelativeTo(null);
        
	}
}
