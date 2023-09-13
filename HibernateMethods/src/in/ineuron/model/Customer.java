package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@Column(name="cid")
	private Integer cid;
	@Column(name="cname")
	private String cname;
	@Column(name="pname")
	private String pname;
	@Column(name="pcost")
	private Double pcost;
	
	static
	{
		System.out.println("Customer.class file is loading...");
	}
	public Customer()
	{
		System.out.println("Constructor is called...");
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getPcost() {
		return pcost;
	}
	public void setPcost(Double pcost) {
		this.pcost = pcost;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", pname=" + pname + ", pcost=" + pcost + "]";
	}
	
}
