package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="mentor")
public class Mentor {

	/*
	@Id
	@Column(name="mid")
	@GenericGenerator(name="gen1",strategy="assigned")
	@GeneratedValue(generator="gen1")
	*/
	
	/*
	@Id
	@Column(name="mid")
	@GenericGenerator(name="gen1", strategy="increment")
	@GeneratedValue(generator="gen1")
	*/
	
	@Id
	@Column(name="mid")
	@GenericGenerator(name="gen1", strategy="identity")
	@GeneratedValue(generator="gen1")
	private Integer mid;
	@Column(name="mname")
	private String mname;
	@Column(name="lectures")
	private Integer noOfLectures;
	@Column(name="salary")
	private double salary;
	
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Integer getNoOfLectures() {
		return noOfLectures;
	}
	public void setNoOfLectures(Integer noOfLectures) {
		this.noOfLectures = noOfLectures;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Mentor [mid=" + mid + ", mname=" + mname + ", noOfLectures=" + noOfLectures + ", salary=" + salary
				+ "]";
	}

	
}
