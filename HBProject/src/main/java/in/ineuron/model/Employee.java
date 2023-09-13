package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emptab")
public class Employee {

	@Id
	@Column(name="eid")
	private Integer empid;
	
	@Column(name="ename")
	private String empname;
	
	@Column(name="esal")
	private double empsal;
	
	static
	{
		System.out.println("Employee.class file is loading...");
	}
	public Employee()
	{
		System.out.println("Zero parameter constructor is called by hibernate");
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getEmpsal() {
		return empsal;
	}
	public void setEmpsal(double empsal) {
		this.empsal = empsal;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empsal=" + empsal + "]";
	}
	
}
