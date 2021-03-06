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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.border.LineBorder;

import class_DAO.HoatChat_DAO;
import class_connectDB.ConnectDB;
import class_entity.HoatChat;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import class_GUI.HoatChat_GUI;

public class HoatChat_ADD_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaHC;
	private HoatChat_DAO hc_DAO;
	private JTextField txtTenHC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoatChat_ADD_GUI frame = new HoatChat_ADD_GUI();
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
	public HoatChat_ADD_GUI() {
		ConnectDB.getInstance().connect();
		hc_DAO = new HoatChat_DAO();
		
		setTitle("Thêm hoạt chất");
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 472, 318);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBackground(Color.WHITE);
		contentPane.add(horizontalBox, BorderLayout.NORTH);
		
		JLabel label = new JLabel("   ");
		horizontalBox.add(label);
		
		JLabel lblNgnhHng = new JLabel("HOẠT CHẤT");
		lblNgnhHng.setToolTipText("");
		lblNgnhHng.setForeground(Color.BLUE);
		lblNgnhHng.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgnhHng.setBackground(Color.WHITE);
		horizontalBox.add(lblNgnhHng);
		
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
		panel_1.setBorder(new LineBorder(UIManager.getColor("activeCaption")));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 23, 426, 121);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMaHC = new JLabel("Mã hoạt chất:");
		lblMaHC.setBounds(21, 22, 97, 27);
		panel_1.add(lblMaHC);
		
		txtMaHC = new JTextField();
		txtMaHC.setBackground(Color.WHITE);
		txtMaHC.setBounds(128, 22, 260, 27);
		panel_1.add(txtMaHC);
		txtMaHC.setColumns(10);
		
		JLabel lblTenHC = new JLabel("Tên hoạt chất:");
		lblTenHC.setBounds(21, 72, 97, 27);
		panel_1.add(lblTenHC);
		
		txtTenHC = new JTextField();
		txtTenHC.setColumns(10);
		txtTenHC.setBackground(Color.WHITE);
		txtTenHC.setBounds(128, 72, 260, 27);
		panel_1.add(txtTenHC);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setBackground(Color.WHITE);
		btnLuu.setIcon(new ImageIcon("data\\icons\\save1.png"));
		btnLuu.setBounds(222, 155, 102, 37);
		panel.add(btnLuu);
		btnLuu.addActionListener(new ActionListener() {
			
			private HoatChat hc;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(validData()) {
					hc = new HoatChat(txtMaHC.getText().trim(), txtTenHC.getText().trim());
					try {
						if(!hc_DAO.create(hc))
							throw new Exception();
						HoatChat_GUI.updateDL();
						JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
						dispose();		
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Cập nhật không thành công!!");
					}
				}
			}
		});
		
		JButton btnBoQua = new JButton("Bỏ qua");
		btnBoQua.setBackground(Color.WHITE);
		btnBoQua.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnBoQua.setBounds(334, 155, 102, 37);
		btnBoQua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		panel.add(btnBoQua);
	}
	private boolean validData() {
		String txtMa = txtMaHC.getText().trim();
		String txtTen = txtTenHC.getText().trim();
		if(!(txtMa.length() > 0)) {
			JOptionPane.showMessageDialog(null, "Mã Hoạt Chất không được rỗng!");
			return false;
		}
		if(!(txtTen.length() > 0)) {
			JOptionPane.showMessageDialog(null, "Tên Hoạt Chất không được rỗng!");
			return false;
		}
		for(HoatChat s : HoatChat_GUI.lhc) {
			if(s.getMaHC().equals(txtMa)) {
				JOptionPane.showMessageDialog(null, "Trùng mã!");
				return false;
			}
			if(s.getTenHC().equals(txtTen)) {
				JOptionPane.showMessageDialog(null, "Trùng tên!");
				return false;
			}
		}
		return true;
	}
}
