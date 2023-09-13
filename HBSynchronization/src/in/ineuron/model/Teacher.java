package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Teacher")
public class Teacher {

	@Id
	@Column(name="tid")
	private Integer tid;
	@Column(name="tname")
	private String tname;
	@Column(name="lectures")
	private Integer noOfLectures;
	@Column(name="salary")
	private Double salary;
	
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Integer getNoOfLectures() {
		return noOfLectures;
	}
	public void setNoOfLectures(Integer noOfLectures) {
		this.noOfLectures = noOfLectures;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", noOfLectures=" + noOfLectures + ", salary=" + salary
				+ "]";
	}
	
	
}
