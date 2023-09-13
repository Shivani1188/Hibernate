package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="children")
public class Children {

	@Id
	@Column(name="cid")
	private Integer cid;
	@Column(name="cname")
	private String cname;
	@Column(name="cmarks")
	private Integer cmarks;
	
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
	public Integer getCmarks() {
		return cmarks;
	}
	public void setCmarks(Integer cmarks) {
		this.cmarks = cmarks;
	}
	@Override
	public String toString() {
		return "Children [cid=" + cid + ", cname=" + cname + ", cmarks=" + cmarks + "]";
	}
	
	
	
}
