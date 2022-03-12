package class_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.border.EmptyBorder;

import class_DAO.DonViTinh_DAO;
import class_DAO.QuanLyNV_DAO;
import class_DAO.DangNhap_DAO;
import class_connectDB.ConnectDB;
import class_entity.DangNhap;
import class_entity.NhanVien;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.*;
import java.awt.*;

public class DangNhap_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private List<DangNhap> ldn;
	private DangNhap_DAO dn_DAO;
	private List<NhanVien> lnv;
	private QuanLyNV_DAO nv_DAO;
	public static String signing;

	/**
	 * Create the frame.
	 */
	public DangNhap_GUI() {
		ConnectDB.getInstance().connect();
		dn_DAO = new DangNhap_DAO();
		nv_DAO = new QuanLyNV_DAO();
		DocDLDB();
		
		JLabel background;
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\pictures\\hospital.png"));
		setTitle("Phần mềm quản lý nhà thuốc version 1.0.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 926, 565);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		
		ImageIcon img = new ImageIcon("data\\pictures\\hospital.png");
		getContentPane().setLayout(null);
		setResizable(false);
		
		txtUser = new JTextField();
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser.setBounds(382, 224, 216, 23);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		txtUser.addActionListener(new ActionListener() {
			
			QuanLiQuayThuoc_NV_GUI nv1;
			QuanLiQuayThuoc_QL_GUI ql;
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int dem=0;
				try {
					for(DangNhap dn : ldn) {
						if((txtUser.getText().trim().toString().equalsIgnoreCase(dn.getMaTK().trim())) && txtPass.getText().trim().equals(dn.getMatKhau().trim())) {
							for(NhanVien nv : lnv) {
								if(nv.getMaNV().trim().equalsIgnoreCase(txtUser.getText().trim())) {
									if(nv.getTinhTrang()==0) {
										JOptionPane.showMessageDialog(null, "Tài khoản hết hiệu lực!");
										dem++;
									}								
									else {
										dem++;
										signing = txtUser.getText().trim();
										if(dn.getQuanLy()==0) {
											nv1 = new QuanLiQuayThuoc_NV_GUI(signing);
											nv1.setVisible(true);
											dispose();
										}
										else {
											ql = new QuanLiQuayThuoc_QL_GUI(signing);
											ql.setVisible(true);
											dispose();
										}								
										dem++;
										break;
									}
								}
							}
						}
					}	
					if(dem==0)
						throw new Exception();
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Sai Tài Khoản hoặc Mật Khẩu");
				}
			}
		});
		
		txtPass = new JPasswordField();
		txtPass.setHorizontalAlignment(SwingConstants.CENTER);
		txtPass.setColumns(10);
		txtPass.setBounds(382, 263, 216, 23);
		getContentPane().add(txtPass);
		txtPass.addActionListener(new ActionListener() {
			
			private QuanLiQuayThuoc_NV_GUI nv1;
			private QuanLiQuayThuoc_QL_GUI ql;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int dem=0;
				try {
					for(DangNhap dn : ldn) {
						if((txtUser.getText().trim().toString().equalsIgnoreCase(dn.getMaTK().trim())) && txtPass.getText().trim().equals(dn.getMatKhau().trim())) {
							for(NhanVien nv : lnv) {
								if(nv.getMaNV().trim().equalsIgnoreCase(txtUser.getText().trim())) {
									if(nv.getTinhTrang()==0) {
										JOptionPane.showMessageDialog(null, "Tài khoản hết hiệu lực!");
										dem++;
									}								
									else {
										dem++;
										signing = txtUser.getText().trim();
										if(dn.getQuanLy()==0) {
											nv1 = new QuanLiQuayThuoc_NV_GUI(signing);
											nv1.setVisible(true);
											dispose();
										}
										else {
											ql = new QuanLiQuayThuoc_QL_GUI(signing);
											ql.setVisible(true);
											dispose();
										}								
										dem++;
										break;
									}
								}
							}
						}
					}	
					if(dem==0)
						throw new Exception();
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Sai Tài Khoản hoặc Mật Khẩu");
				}
			}
		});
		
		JLabel lblUserName = new JLabel("Tài khoản:");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setToolTipText("User name");
		lblUserName.setForeground(Color.BLUE);
		lblUserName.setBounds(288, 224, 84, 23);
		getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setToolTipText("Password");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setBounds(288, 263, 84, 23);
		getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setIcon(new ImageIcon("data\\icons\\login.png"));
		btnLogin.setToolTipText("Login");
		btnLogin.setForeground(new Color(0, 128, 0));
		btnLogin.setBounds(288, 325, 115, 35);
		btnLogin.setFocusable(false);
		getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			private QuanLiQuayThuoc_NV_GUI nv1;
			private QuanLiQuayThuoc_QL_GUI ql;

			public void actionPerformed(ActionEvent arg0) {
				int dem=0;
				try {
					for(DangNhap dn : ldn) {
						if((txtUser.getText().trim().toString().equalsIgnoreCase(dn.getMaTK().trim())) && txtPass.getText().trim().equals(dn.getMatKhau().trim())) {
							for(NhanVien nv : lnv) {
								if(nv.getMaNV().trim().equalsIgnoreCase(txtUser.getText().trim())) {
									if(nv.getTinhTrang()==0) {
										JOptionPane.showMessageDialog(null, "Tài khoản hết hiệu lực!");
										dem++;
									}								
									else {
										dem++;
										signing = txtUser.getText().trim();
										if(dn.getQuanLy()==0) {
											nv1 = new QuanLiQuayThuoc_NV_GUI(signing);
											nv1.setVisible(true);
											dispose();
										}
										else {
											ql = new QuanLiQuayThuoc_QL_GUI(signing);
											ql.setVisible(true);
											dispose();
										}								
										dem++;
										break;
									}
								}
							}
						}
					}	
					if(dem==0)
						throw new Exception();
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Sai Tài Khoản hoặc Mật Khẩu");
				}
			}
		});
		
		JButton btnCancel = new JButton("Thoát");
		btnCancel.setIcon(new ImageIcon("data\\icons\\exit.png"));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setForeground(Color.RED);
		btnCancel.setToolTipText("Cancel");
		btnCancel.setBounds(501, 325, 115, 35);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		getContentPane().add(btnCancel);
		
		JButton btnAbout = new JButton("About?");
		btnAbout.setForeground(Color.BLACK);
		btnAbout.setFont(new Font("Tahoma", Font.ITALIC, 9));
		btnAbout.setBounds(10, 495, 80, 20);
		btnAbout.setFocusable(false);
		btnAbout.setBackground(Color.WHITE);
		getContentPane().add(btnAbout);
		btnAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		
		JButton btnContact = new JButton("Contact?");
		btnContact.setFont(new Font("Tahoma", Font.ITALIC, 9));
		btnContact.setBounds(100, 495, 80, 20);
		btnContact.setFocusable(false);
		btnContact.setBackground(Color.WHITE);
		getContentPane().add(btnContact);
		btnContact.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		
		JLabel lblNewLabel_1 = new JLabel("Trần Công Thịnh - 17051301");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setForeground(new Color(230, 230, 250));
		lblNewLabel_1.setBounds(741, 445, 146, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblHuyen = new JLabel("Nguyễn Thị Huyên - 17082651");
		lblHuyen.setForeground(new Color(230, 230, 250));
		lblHuyen.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblHuyen.setBounds(741, 470, 146, 14);
		getContentPane().add(lblHuyen);
		
		JLabel lblTuan = new JLabel("Nguyễn Ngọc Tuấn - ");
		lblTuan.setForeground(new Color(230, 230, 250));
		lblTuan.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTuan.setBounds(741, 495, 146, 14);
		getContentPane().add(lblTuan);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(25, 25, 112));
		panel_1.setBounds(252, 139, 402, 70);
		getContentPane().add(panel_1);
		//ImageIcon img2 = new ImageIcon("data\\pictures\\logo3.png");
		
		JLabel lblNewLabel = new JLabel();
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("data\\icons\\logo3.png"));
		lblNewLabel.setBackground(new Color(0, 0, 139));
		lblNewLabel.setToolTipText("Phần mềm quản lí nhà thuốc version 1.0.0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(165, 42, 42));
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 28));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(252, 207, 402, 198);
		getContentPane().add(panel);
		background = new JLabel("", img, JLabel.CENTER);
		background.setToolTipText("");
		background.setForeground(Color.RED);
		background.setBounds(0, 0, 920, 536);
		getContentPane().add(background);
	}
	private void DocDLDB() {
		ldn = dn_DAO.getalltabledangnhap();
		lnv = nv_DAO.getAllNhanVienall();
	}
}
