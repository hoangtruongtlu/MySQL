package entity;

public class Employee extends User {

	private String projectID;
	private String proSkill;

	public Employee(int id, String fullName, String email, String passWord) {
		super(id, fullName, email, passWord);
		this.projectID = projectID;
		this.proSkill = proSkill;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;

	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	@Override
	public String toString() {
		return super.toString() + "ProjectID: " + projectID + "ProSkill: " + proSkill + "\n";
	}
}
