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
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


import class_DAO.HoatChat_DAO;
import class_connectDB.ConnectDB;
import class_entity.HoatChat;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.border.EtchedBorder;

public class HoatChat_GUI extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JButton btnclose;
	private static DefaultTableModel model;
	public static List<HoatChat> lhc;
	private static HoatChat_DAO hc_DAO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoatChat_GUI frame = new HoatChat_GUI();
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
	public HoatChat_GUI() {
		
		ConnectDB.getInstance().connect();
		hc_DAO = new HoatChat_DAO();
		DocDLDB();
		
		setResizable(false);
		setTitle("Thông tin hoạt chất");
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 594, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		horizontalBox.setBackground(Color.WHITE);
		contentPane.add(horizontalBox, BorderLayout.NORTH);
		
		JLabel label = new JLabel("   ");
		horizontalBox.add(label);
		
		JLabel lblnVQuy = new JLabel("THÔNG TIN HOẠT CHẤT");
		lblnVQuy.setToolTipText("");
		lblnVQuy.setForeground(Color.BLUE);
		lblnVQuy.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblnVQuy.setBackground(Color.WHITE);
		horizontalBox.add(lblnVQuy);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("data\\icons\\logo3.png"));
		label_1.setBackground(Color.WHITE);
		horizontalBox.add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch ho\u1EA1t ch\u1EA5t", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(0, 11, 578, 401);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 558, 370);
		panel_1.add(scrollPane);
		
		model = new DefaultTableModel(new String[] {
				"STT", "Mã Hoạt Chất", "Tên Hoạt Chất"
			}, 0);
		model = new DefaultTableModel() {
			   public Class<?> getColumnClass(int column) {
			    switch (column) {
			    case 0:
			     return Integer.class;
			    case 1:
			     return String.class;
			    case 2:
			     return String.class;
			    default:
			     return String.class;
			    }
			   }
			  };
		model.addColumn("STT");
		model.addColumn("Mã Hoạt Chất");
		model.addColumn("Tên Hoạt Chất");
		int i=1;
		for(HoatChat s : lhc) {
			model.addRow(new Object[] {
					i++, "  " + s.getMaHC(), "  " + s.getTenHC()
				});
		}
		table = new JTable(model);
		table.setBackground(Color.WHITE);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setMaxWidth(27);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JTableHeader Theader = table.getTableHeader();
		Theader.setBackground(Color.white);
		Theader.setFont(new Font("Tahome", Font.BOLD, 13));
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Thêm Mới");
		btnAdd.setIcon(new ImageIcon("data\\icons\\add1.png"));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(46, 423, 123, 39);
		btnAdd.setFocusable(false);
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HoatChat_ADD_GUI hcadd = new HoatChat_ADD_GUI();
				hcadd.setVisible(true);
			}
		});
		panel.add(btnAdd);
		
		JButton btnEdit = new JButton("Cập Nhật");
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setIcon(new ImageIcon("data\\icons\\searchsale2.png"));
		btnEdit.setBounds(179, 423, 123, 39);
		btnEdit.setFocusable(false);
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub		
				int row = table.getSelectedRow();
				if(row != -1) {
					HoatChat_EDIT_GUI.NewScreen(model.getValueAt(row, 1).toString().trim());
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 loại Hợp Chất để sửa!");
				}
			}
		});
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setIcon(new ImageIcon("data\\icons\\delete1.png"));
		btnDelete.setBounds(312, 423, 122, 39);
		btnDelete.setFocusable(false);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row != -1) {
					String hc = model.getValueAt(row, 1).toString().trim();
					int nhacnho = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
					if(nhacnho == JOptionPane.YES_OPTION) {
						try {
							if (!hc_DAO.delete(hc))
								throw new Exception();
							updateDL();
							JOptionPane.showMessageDialog(null,"Xóa thành công!");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Xóa không thành công!");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 đơn vị tính cần xóa!");
				}
			}
		});
		panel.add(btnDelete);
		
		btnclose = new JButton("Đóng");
		btnclose.setBackground(Color.WHITE);
		btnclose.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnclose.setBounds(444, 423, 124, 39);
		btnclose.setFocusable(false);
		btnclose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		panel.add(btnclose);
	}
	private static void DocDLDB() {
		lhc = hc_DAO.getalltbHC();
	}
	private static void XoaHetDuLieuTrenTableModel() {
		model.getDataVector().removeAllElements();
	}
	public static void updateDL() {
		XoaHetDuLieuTrenTableModel();
		DocDLDB();
		int i=1;
		for(HoatChat s : lhc) {
//			if(s.getMacDinh()==1)
//				model.addRow(new Object[] {
//						i++, "  " + s.getHoatChat(), true
//					});
//			else
				model.addRow(new Object[] {
						i++, "  " + s.getMaHC(), "  " + s.getTenHC()
					});
		}
		table.setModel(model);
	}
}
