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
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import class_DAO.DonViQuyDoi_DAO;
import class_connectDB.ConnectDB;
import class_entity.DonViQuyDoi;

import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DonViQuyDoi_GUI extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JButton btnclose;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonViQuyDoi_GUI frame = new DonViQuyDoi_GUI();
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
	public DonViQuyDoi_GUI() {
		
		setResizable(false);
		setTitle("Đơn Vị Quy Đổi");
		setIconImage(Toolkit.getDefaultToolkit().getImage("data\\icons\\about.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 584);
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
		
		JLabel lblnVQuy = new JLabel("ĐƠN VỊ QUY ĐỔI");
		lblnVQuy.setToolTipText("ĐƠN VỊ QUY ĐỔI");
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
		panel_1.setBorder(new TitledBorder(null, "\u0110\u01A1n V\u1ECB Quy \u0110\u1ED5i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 11, 688, 401);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 668, 370);
		panel_1.add(scrollPane);
		
		model = new DefaultTableModel(new String[] {
				"", "Tên Quy Đổi", "Số Lượng Sản Phẩm Bán Lẻ Trên Một Đơn Vị Quy Đổi"
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
		
		JButton btnAdd = new JButton("Thêm Mới");
		btnAdd.setIcon(new ImageIcon("data\\icons\\add1.png"));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(156, 423, 123, 39);
		btnAdd.setFocusable(false);
		panel.add(btnAdd);
		
		JButton btnEdit = new JButton("Cập Nhật");
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setIcon(new ImageIcon("data\\icons\\searchsale2.png"));
		btnEdit.setBounds(289, 423, 123, 39);
		btnEdit.setFocusable(false);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setIcon(new ImageIcon("data\\icons\\delete1.png"));
		btnDelete.setBounds(422, 423, 122, 39);
		btnDelete.setFocusable(false);
		panel.add(btnDelete);	
		btnclose = new JButton("Đóng");
		btnclose.setBackground(Color.WHITE);
		btnclose.setIcon(new ImageIcon("data\\icons\\exit1.png"));
		btnclose.setBounds(554, 423, 124, 39);
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
}
