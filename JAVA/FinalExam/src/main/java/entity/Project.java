package entity;

public class Project {
	private int projectID;
	private int teamSize;
	private int idManager;
	private int idEmployee;

	public Project(int projectID, int teamSize, int idManager, int idEmployee) {
		super();
		this.projectID = projectID;
		this.teamSize = teamSize;
		this.idManager = idManager;
		this.idEmployee = idEmployee;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public int getIdManager() {
		return idManager;
	}

	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	@Override
	public String toString() {
		return "ID: " + projectID + " Size: " + teamSize + " ManagerID: " + idManager + " EmployeeID: " + idEmployee + "\n";
	}
}
