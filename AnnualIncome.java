import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class EmployeeVo{
	String empid,empname;
	double annualincome,incometax;
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getAnnualincome() {
		return annualincome;
	}
	public void setAnnualincome(double annualincome) {
		this.annualincome = annualincome;
	}
	public double getIncometax() {
		return incometax;
	}
	public void setIncometax(double incometax) {
		this.incometax = incometax;
	}
	public EmployeeVo(String empid, String empname, double annualincome, double incometax) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.annualincome = annualincome;
		this.incometax = incometax;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(annualincome);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeVo other = (EmployeeVo) obj;
		if (Double.doubleToLongBits(annualincome) != Double.doubleToLongBits(other.annualincome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EmployeeVo [empid=" + empid + ", empname=" + empname + ", annualincome=" + annualincome + ", incometax="
				+ incometax + "]";
	}
	
}
class EmployeeBo{
	public void calincomeTax(EmployeeVo e1) {
		e1.incometax=e1.annualincome*.10;
		
	}
}
class EmployeeSort implements Comparator<EmployeeVo>{


	@Override
	public int compare(EmployeeVo o1, EmployeeVo o2) {
		if (o1.incometax==o2.incometax) 
			return 0; 
		if (o1.incometax>o2.incometax) 
			return -1;
		else
			return 1; 
		
	}
	
	
}
public class AnnualIncome {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String empid,empname;
		double annualIncome,incomeTax=0.0;
		System.out.println("Enter number of employees");
		int num1=Integer.parseInt(br.readLine());
		ArrayList<EmployeeVo> e=new ArrayList<EmployeeVo>(num1);
		for (int i = 0; i < num1; i++) {
			System.out.println("Enter id of employee");
			empid=br.readLine();
			System.out.println("Enter name of employee");
			empname=br.readLine();
			System.out.println("Enter annual income of employee");
			annualIncome=Double.parseDouble(br.readLine());
			EmployeeBo eb=new EmployeeBo();
			e.add(new EmployeeVo(empid, empname, annualIncome, incomeTax));
			eb.calincomeTax(e.get(i));	
		}
		
			System.out.println(e);
			
			Collections.sort(e, new EmployeeSort() );
			
			System.out.println(e);
		
		
	}
}
