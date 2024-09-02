package model;

import java.util.ArrayList;
import java.util.Iterator;

public class QLSVModel {
        private ArrayList<SinhVien> danhSach;
        private String tenFile;
		public QLSVModel(ArrayList<SinhVien> danhSach) {
			this.danhSach = danhSach;
		}
		
		public String getTenFile() {
			return tenFile;
		}

		public void setTenFile(String tenFile) {
			this.tenFile = tenFile;
		}

		public QLSVModel() {
			this.danhSach = new ArrayList<SinhVien>();
			this.tenFile="";
		}
		public ArrayList<SinhVien> getDanhSach() {
			return danhSach;
		}
		
		public void setDanhSach(ArrayList<SinhVien> danhSach) {
			this.danhSach = danhSach;
		}
		
		public void insert(SinhVien sinhVien) {
			this.danhSach.add(sinhVien);
		}
		public void delete(SinhVien sinhVien) {
			 for(SinhVien x : danhSach) {
				 if( x.getMaSinhVien().equals(sinhVien.getMaSinhVien()))
				 {
					 this.danhSach.remove(x);
					 break;
				 }
 
		}}
		public void update(SinhVien sinhVien) {
			
			 for(SinhVien x : danhSach) {
				  if(x.getMaSinhVien().equals(sinhVien.getMaSinhVien()))
				  {	 this.danhSach.remove(x);
				  break;}
				  }
			this.danhSach.add(sinhVien);
		}

		@Override
		public String toString() {
			String res = "";
			for(SinhVien sv: danhSach) {
				res += sv.toString();
			}
			return res;
		}

		public boolean kiemTraTonTai(SinhVien sv) {
			  for(SinhVien x : danhSach) {
				  if(x.getMaSinhVien().equals(sv.getMaSinhVien()))
					  return true;
				  }
			  return false;
			 
		}

	
		
		
        
}
