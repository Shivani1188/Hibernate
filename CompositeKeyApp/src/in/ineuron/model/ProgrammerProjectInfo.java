package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProgrammerProjectInfo implements Serializable{

	@EmbeddedId
	private ProjectInfo info;
	
	@Column(name="pname",length=20)
	private String ProgrammerName;
	
	@Column(name="deptNo")
	private Integer deptNo;
	
	@Column(name="projName",length=20)
	private String projectName;

	public ProgrammerProjectInfo()
	{
		
	}
	public ProgrammerProjectInfo(ProjectInfo info, String programmerName, Integer deptNo, String projectName) {
		super();
		this.info = info;
		ProgrammerName = programmerName;
		this.deptNo = deptNo;
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "ProgrammerProjectInfo [info=" + info + ", ProgrammerName=" + ProgrammerName + ", deptNo=" + deptNo
				+ ", projectName=" + projectName + "]";
	}
	
	
	
}
