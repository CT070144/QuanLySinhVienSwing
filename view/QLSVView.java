package view;


import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.SinhVien;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.QLSVController;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;


public class QLSVView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    public QLSVModel model;
    private SinhVien sinhVienGoc;
    private JTextField masinhvien;
    private JTable table;
    private JTextField masinhvien2;
    private JTextField hovaten;
    private JTextField ngaysinh;
    private JTextField diem1;
    private JTextField diem2;
    private JTextField diem3;
	private JLabel quequan2;
	private JComboBox comboBox2;
	private ButtonGroup group;
	private ArrayList<Tinh> dstinh;
	private JRadioButton nu;
	private JRadioButton nam;
	private ArrayList<SinhVien> danhSach2;
	private JComboBox comboBox;
	/**
	 * Create the frame.
	 */	
		public QLSVView() {
			
			this.model = new QLSVModel();
			this.setTitle("QUẢN LÝ SINH VIÊN");
			URL url = QLSVView.class.getResource("Image.png");
			Image img = Toolkit.getDefaultToolkit().createImage(url);
			this.setIconImage(img);
			
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 711);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	    QLSVController actionListener = new QLSVController(this);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 0, 101, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mntmNewMenuItem.addActionListener(actionListener);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save as");
		mntmNewMenuItem_1.addActionListener(actionListener);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit");
		mntmNewMenuItem_2.addActionListener(actionListener);
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("About");
	
		mnNewMenu_1.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Được phát triển bởi NguyenVanPhuc");
		mntmNewMenuItem_3.addActionListener(actionListener);
		mntmNewMenuItem_3.setFont(new Font("Cambria", Font.ITALIC, 12));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 32, 1026, 54);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quê quán ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 17, 89, 29);
		panel.add(lblNewLabel);
		
		JLabel lblMSinhVin = new JLabel("Mã sinh viên ");
		lblMSinhVin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMSinhVin.setBounds(402, 17, 122, 29);
		panel.add(lblMSinhVin);
		
		masinhvien = new JTextField();
		masinhvien.setColumns(10);
		masinhvien.setBounds(506, 19, 298, 29);
		panel.add(masinhvien);
		
		JButton btnNewButton = new JButton("Fetch");
		btnNewButton.setFont(new Font("Microsoft Tai Le", Font.BOLD, 16));
		btnNewButton.addActionListener(actionListener);
		btnNewButton.setBounds(814, 14, 89, 36);
		panel.add(btnNewButton);
		
		 comboBox = new JComboBox();
	       comboBox.addItem(" ");
		 dstinh = Tinh.getDSTinh();
		
		for(Tinh t : dstinh) {
			comboBox.addItem(t.getTenTinh());
		}
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(90, 18, 278, 30);
		panel.add(comboBox);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(actionListener);
		btnReturn.setFont(new Font("Microsoft Tai Le", Font.BOLD, 15));
		btnReturn.setBounds(913, 18, 83, 29);
		panel.add(btnReturn);
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách sinh viên");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 111, 189, 22);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 138, 1026, 2);
		contentPane.add(separator_1);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 sinh vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3"
			}
		));
		table.setBounds(10, 155, 1026, 193);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 150, 1026, 216);
		contentPane.add(scrollPane);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 402, 1026, 16);
		contentPane.add(separator_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thông tin sinh viên");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 376, 189, 22);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mã sinh viên");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(20, 408, 72, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Họ và tên");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(20, 448, 72, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ngày sinh");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(20, 528, 72, 30);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Giới tính");
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(20, 574, 72, 30);
		contentPane.add(lblNewLabel_2_3);
		
		 quequan2 = new JLabel("Quê quán");
		quequan2.setFont(new Font("Arial", Font.BOLD, 12));
		quequan2.setBounds(20, 488, 72, 30);
		contentPane.add(quequan2);
		
		JLabel lblNewLabel_2_5 = new JLabel("Điểm 1");
		lblNewLabel_2_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_5.setBounds(443, 408, 72, 30);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Điểm 2");
		lblNewLabel_2_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_6.setBounds(443, 448, 72, 30);
		contentPane.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("Điểm 3");
		lblNewLabel_2_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_7.setBounds(443, 488, 72, 30);
		contentPane.add(lblNewLabel_2_7);
		
		JLabel lblNewLabel_2_8 = new JLabel("Tổng điểm");
		lblNewLabel_2_8.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_8.setBounds(443, 528, 72, 30);
		contentPane.add(lblNewLabel_2_8);
		
		masinhvien2 = new JTextField();
		masinhvien2.setBounds(105, 412, 238, 24);
		contentPane.add(masinhvien2);
		masinhvien2.setColumns(10);
		
		hovaten = new JTextField();
		hovaten.setColumns(10);
		hovaten.setBounds(105, 454, 238, 24);
		contentPane.add(hovaten);
		
		ngaysinh = new JTextField();
		ngaysinh.setColumns(10);
		ngaysinh.setBounds(105, 534, 238, 24);
		contentPane.add(ngaysinh);
		
		diem1 = new JTextField();
		diem1.setColumns(10);
		diem1.setBounds(536, 414, 146, 24);
		contentPane.add(diem1);
		
		diem2 = new JTextField();
		diem2.setColumns(10);
		diem2.setBounds(536, 454, 146, 24);
		contentPane.add(diem2);
		
		diem3 = new JTextField();
		diem3.setColumns(10);
		diem3.setBounds(536, 494, 146, 24);
		contentPane.add(diem3);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(20, 614, 1016, 22);
		contentPane.add(separator_3);
		
		JButton edit = new JButton("Update");
		edit.addActionListener(actionListener);
		edit.setFont(new Font("Arial", Font.BOLD, 16));
		edit.setBounds(242, 634, 91, 30);
		contentPane.add(edit);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(actionListener);
		cancel.setFont(new Font("Arial", Font.BOLD, 16));
		cancel.setBounds(919, 634, 91, 30);
		contentPane.add(cancel);
		
		JButton save = new JButton("Save");
		save.addActionListener(actionListener);
		save.setFont(new Font("Arial", Font.BOLD, 16));
		save.setBounds(816, 634, 91, 30);
		contentPane.add(save);
		
		 nam = new JRadioButton("Nam");
		 group = new ButtonGroup();
		nam.setFont(new Font("Arial", Font.BOLD, 12));
		nam.setBounds(108, 579, 103, 21);
		
		
	 nu = new JRadioButton("Nữ");
		nu.setFont(new Font("Arial", Font.BOLD, 12));
		nu.setBounds(211, 579, 103, 21);
		
		group.add(nu);
		group.add(nam);
        contentPane.add(nu);
        contentPane.add(nam);


		
		JButton delete = new JButton("Delete");
		delete.addActionListener(actionListener);
		delete.setFont(new Font("Arial", Font.BOLD, 16));
		delete.setBounds(131, 634, 91, 30);
		contentPane.add(delete);
		
		JButton insert = new JButton("Insert");
		insert.setFont(new Font("Arial", Font.BOLD, 16));
		insert.setBounds(20, 634, 91, 30);
		insert.addActionListener(actionListener);
		contentPane.add(insert);
		
		 comboBox2 = new JComboBox();
		for(Tinh t : dstinh) {
			comboBox2.addItem(t.getTenTinh());
		}
		comboBox2.setBounds(105, 488, 238, 30);
		contentPane.add(comboBox2);
		
	this.setVisible(true);	
		
	}

	public void xoaThongTin() {
		masinhvien2.setText("");
		hovaten.setText("");
		comboBox2.setSelectedIndex(-1);
	    group.clearSelection();
		ngaysinh.setText("");
		diem1.setText("");
		diem2.setText("");
		diem3.setText("");
		
	}

	public void themThiSinhVaoTable(SinhVien ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { ts.getMaSinhVien() + "", ts.getTenSinhVien(), ts.getQueQuan().getTenTinh(),
				ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
						+ (ts.getNgaySinh().getYear() + 1900),
				(ts.isGioiTinh() ? "Nam" : "Nữ"), ts.getDiemMon1() + "", ts.getDiemMon2() + "",
				ts.getDiemMon3() + "", });
	}
	
	public SinhVien taoSinhVien() {
		
	      String masv = masinhvien2.getText()+"";
	      String ten = hovaten.getText()+"";
	      int que = this.comboBox2.getSelectedIndex();
	      Tinh tinh = Tinh.getTinhbyId(que);
	      Date ngay = new Date(ngaysinh.getText());
	      boolean gt = true;
	      if(nu.isSelected())
	    	  gt = false;
	      float d1 = Float.valueOf(diem1.getText());
	      float d2 = Float.valueOf(diem2.getText());
	      float d3 = Float.valueOf(diem3.getText());
	      SinhVien sv= new SinhVien(masv,ten,tinh,ngay,gt,d1,d2,d3);
	      return sv;
 
	}
	
	public void themHoacUpdateSinhVien() {
		SinhVien sv= taoSinhVien();
		try {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		  if(!this.model.kiemTraTonTai(sv)) {
	      this.model.insert(sv);
	      this.themThiSinhVaoTable(sv);
	      }
		  else {
		// sv hiện tại đang là sinhVien có thông tin mới nên sẽ khác sinhvien cũ => không thể dùng hàm remove
			this.model.update(sv);
			int soLuongDong = model_table.getRowCount();
			String id = sv.getMaSinhVien()+"";
			for(int i=0; i<soLuongDong; i++) {
				if(id.equals(model_table.getValueAt(i, 0))) {
					model_table.setValueAt(sv.getMaSinhVien() + "", i, 0);
					model_table.setValueAt(sv.getTenSinhVien() + "", i, 1);
					model_table.setValueAt(sv.getQueQuan().getTenTinh() + "", i, 2);
					model_table.setValueAt(sv.getNgaySinh().getDate() + "/" + (sv.getNgaySinh().getMonth() + 1) + "/"
							+ (sv.getNgaySinh().getYear() + 1900) + "", i, 3);
					model_table.setValueAt((sv.isGioiTinh() ? "Nam" : "Nữ"), i, 4);
					model_table.setValueAt(sv.getDiemMon1() + "", i, 5);
					model_table.setValueAt(sv.getDiemMon2() + "", i, 6);
					model_table.setValueAt(sv.getDiemMon3() + "", i, 7);
				}
			}
		  }  
		
	}
		catch(Exception e){
			System.out.println("Dữ liệu không đúng định dạng");
		}
	}
	
	public SinhVien getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		String maThiSinh = model_table.getValueAt(i_row, 0) + "";
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
		String s_ngaySinh = model_table.getValueAt(i_row, 3) + "";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		SinhVien ts = new SinhVien(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}
	public void xoaSinhVien() {
		 int dialogDelete = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa sinh viên ?", "XÓA SINH VIÊN", JOptionPane.YES_NO_OPTION);
		 if (dialogDelete == JOptionPane.YES_OPTION) {      
		SinhVien sv = getThiSinhDangChon();
		this.model.delete(sv);
		DefaultTableModel model_1 = (DefaultTableModel)table.getModel();
		int row = table.getSelectedRow();
		int modelRow = table.convertRowIndexToModel(row);
		model_1.removeRow( modelRow );}
		
	}
	public void setThongTinSinhVien() {
        SinhVien ts = this.getThiSinhDangChon();
		this.masinhvien2.setText(ts.getMaSinhVien());
		this.hovaten.setText(ts.getTenSinhVien());
		this.comboBox2.setSelectedItem(ts.getQueQuan().getTenTinh()+"");
		String s_ngaySinh = ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
				+ (ts.getNgaySinh().getYear() + 1900);
		this.ngaysinh.setText(s_ngaySinh);
		if(ts.isGioiTinh()) {
			this.nam.isSelected();
		}
		else {
			this.nu.isSelected();
		}
		this.diem1.setText(ts.getDiemMon1()+"");
		this.diem2.setText(ts.getDiemMon2()+"");
		this.diem3.setText(ts.getDiemMon3()+"");
		
	}
	
	public void xoaBang() {
		
		while (table.getRowCount() > 0) {
		                    ((DefaultTableModel) table.getModel()).removeRow(0);
		                }
	
	}
	public void taoBangLoc(ArrayList<SinhVien> arr) {
		for(SinhVien a: arr) {
			this.themThiSinhVaoTable(a);
		}
	}
	
	public void locTinh(String tinh){
		danhSach2 = new ArrayList<SinhVien>();
		for(SinhVien a: model.getDanhSach()) {
			if(a.getQueQuan().getTenTinh().equals(tinh)) {
				danhSach2.add(a);
			}
		}
		taoBangLoc(danhSach2);
		
	}
	public void locMaSinhVien(String MaSV) {
		danhSach2 = new ArrayList<SinhVien>();
		for(SinhVien a: model.getDanhSach()) {
			if(a.getMaSinhVien().equals(MaSV)) {
				danhSach2.add(a);
			}
		}
		taoBangLoc(danhSach2);
	}
	public void Fetching() {
		String tinh = String.valueOf(comboBox.getSelectedItem());
		String MaSV = masinhvien.getText();
		
		if(MaSV.isEmpty() && comboBox.getSelectedItem()==" " ) return;
		if(!MaSV.isEmpty() && comboBox.getSelectedItem()==" ") {
			this.xoaBang();
			this.locMaSinhVien(MaSV);
			
		}
		else if(MaSV.isEmpty()) {
			this.xoaBang();
			this.locTinh(tinh);
		}
		else {
			danhSach2 = new ArrayList<SinhVien>();
			this.xoaBang();
			for(SinhVien a: model.getDanhSach()) {
				if(a.getMaSinhVien().equals(MaSV) && a.getQueQuan().getTenTinh().equals(tinh)) {
					danhSach2.add(a);
				}
			}
			taoBangLoc(danhSach2);
		}
		
	}
	public void exit() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Thoát mần chiiiiiiiiiiiiiii ☘️🐷😗😊😛☘️☘️😥😆🥹🫁😛😶😶😊",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	
	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "---QUẢN LÝ SINH VIÊN--- \n Nguyễn Văn Phúc đz😊");
	}

	
	public void in() {
		System.out.println(this.model.toString()); 
	}
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (SinhVien ts : this.model.getDanhSach()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	public void openFile(File file) {
		ArrayList ds = new ArrayList();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			SinhVien ts = null;
			while((ts = (SinhVien) ois.readObject())!=null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDanhSach(ds);
	}
	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			this.xoaBang();
			this.taoBangLoc(this.model.getDanhSach());
		} 
	}
}

