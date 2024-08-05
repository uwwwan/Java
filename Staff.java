package exam;
	
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
	
	abstract class Staff {
		
		private String id;
		private String name;
		private String department;
		
		public Staff(String id, String name, String department) {
			this.id = id;
			this.name = name;
			this.department = department;
			
		}
		public void setid(String id) {
			this.id = id;
		}
		public void setname(String name) {
			this.name = name;
		}
		public void setdepartment (String department) {
			this.department = department;
		}
		
		public String getid() {
			return id;
		}
		
		public String getname() {
			return name;
		}
		
		public String getdepartment() {
			return department;
		}
		
		public abstract String getRole();
		public void addStaff(Staff staffs) {
			// TODO Auto-generated method stub
			
		}
		
			
		}
	

	
	class Doctor extends Staff {
			private String specialization;
		    
		    public Doctor(String id, String name, String department, String specialization){
		        super(id, name, department);
		        this.specialization = specialization;
		        	        
		    }
		    public String getSpecialization() {
		    	return specialization;
		    }
		    
		    public void setSpecialization(String specialization) {
		    	this.specialization = specialization;
		    }
		    
		    @Override
		    public String getRole() {
		    	return "Doctor";
		    }		
			
			
	}
		
	class Nurse extends Staff {
			private String shift;
		    
		    public Nurse(String id, String name, String department, String shift){
		        super(id, name, department);
		        this.shift = shift;
		        	        
		    }
		    public String getShift() {
		    	return shift;
		    }
		    
		    public void setSpecialization(String shift) {
		    	this.shift = shift;
		    }
		    
		    @Override
		    public String getRole() {
		    	return "Nurse";
		    }	
			
	}		
	class Hospital {
			private List<Staff> staffs;
			
			public Hospital() {
				this.staffs = new ArrayList<>();
			}
			
			public void addStaff (Staff staff) {
				staffs.add(staff);
			}
			
			public void removeStaff (String id) {
				staffs.removeIf(staffs -> staffs.getid().equals(id));
			}
			
			public void displayStaff() {
				for (Staff staff : staffs) {
					System.out.println("ID: " + staff.getid() + " Name: " + staff.getname() + " Department: " + staff.getdepartment());
							
			if (staffs instanceof Doctor) {
	            System.out.println("Doctor: " + ((Doctor) staffs).getSpecialization());
	        } else if (staffs instanceof Nurse) {
	            System.out.println("Nurse: " + ((Nurse) staffs).getShift());
		        }
		    }
		}		
		
	public class Main {
		public static void main(String[] args) {
			Hospital hospital = new Hospital();
			Scanner s = new Scanner(System.in);
			
			while(true) {
				System.out.println("Hospital Management System");
			System.out.println("1. ADD DOCTOR");
			System.out.println("2. ADD NURSE");
			System.out.println("3. REMOVE STAFF");
			System.out.println("4. DISPLAY STAFF");
			System.out.println("5. EXIT");
			
		int deci =  Integer.parseInt(s.nextLine());
		
		switch(deci) {
		case 1:
			System.out.println("Enter ID: ");
			String docId = s.nextLine();		
			System.out.println("Enter Name: ");
			String docName = s.nextLine();
			System.out.println("Enter Department: ");
			String docDept = s.nextLine();
			System.out.println("Enter Specialization: ");
			String docSpec = s.nextLine();			
			
			hospital.addStaff(new Doctor (docId, docName, docDept, docSpec));
			break;
		
		case 2:
			System.out.println("Enter ID: ");
			String nurseId = s.nextLine();
			System.out.println("Enter name: ");
			String nurseName = s.nextLine();
			System.out.println("Enter Department: ");
			String nurseDept = s.nextLine();
			System.out.println("Enter Shift: ");
			String nurseShift = s.nextLine();
			
			hospital.addStaff(new Nurse (nurseId, nurseName, nurseDept, nurseShift));
			break;
			
		case 3:
			System.out.println("Enter ID to remove: ");
			String removeId = s.nextLine();
			
			hospital.removeStaff(removeId);
			break;
			
		case 4:
			hospital.displayStaff();;
			break;
		
		default:
			System.out.println("Thank You Have a Nice Day");
				s.close();
				return;
				
					}
				}
			}
	}
}
	
