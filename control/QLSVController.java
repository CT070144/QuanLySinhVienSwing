package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import view.QLSVView;

public class QLSVController implements ActionListener {
    private QLSVView view;
	
	
	public QLSVController(QLSVView view) {
		
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		JFileChooser fc = new JFileChooser();
		//JOptionPane.showMessageDialog(view,"Thao tác " + ac +" được chọn");
		switch(ac) {
		
		case "Insert":	
			{this.view.xoaThongTin();
			
			break;
			}
		case "Delete":
		{  
			this.view.xoaSinhVien();
			this.view.in();
			break;
		}
		case "Update":
		{   
			this.view.setThongTinSinhVien();
			
			break;
		}
		case "Save":			
		{    	
			this.view.themHoacUpdateSinhVien();
			this.view.in();
			break;
		}
		case "Cancel":
		{   this.view.xoaThongTin();
			break;
		}
		case "Fetch":
		{   view.Fetching();
			break;
		}
		case "Return":{
			view.xoaBang();
			view.taoBangLoc(this.view.model.getDanhSach());
			break;
		}
		case "Open" :{
			this.view.thucHienOpenFile();
			break;
		}
        case "Save as" :{
        	this.view.thucHienSaveFile();
			break;
		}
         case "Exit" :{
			this.view.exit();
			break;
		}
         case "Được phát triển bởi NguyenVanPhuc":{
 			this.view.hienThiAbout();
 			break;
 		}

		
	}}}
	
   

