package by.jonline.itcompany.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Class creates a list of employees  and calculates price of the project.
 * 
 * @author admin
 *
 */
public class Project {

	private int effortEstimate; // evaluated man/hours value of the project
	private int projectValue; // price of the project
	private List<Employee> projectStaff; // list of employees put to work

	private Project(int effortEstimate, List<Employee> companyStaff) {
		
		projectStaff = new ArrayList<Employee>();
		projectValue = 0;
		this.effortEstimate = effortEstimate;

		for (int i = 0; i < companyStaff.size(); i++) {
			if (i % 2 == 0) {
				projectStaff.add(companyStaff.get(i));
				effortEstimate -= companyStaff.get(i).getPersonalHourCompensation();
				projectValue += companyStaff.get(i).getPersonalHourCompensation();
			}	
		}
	}

	public static Project buildProject(int effortEstimate, List<Employee> companyStaff) {
		return new Project(effortEstimate, companyStaff);
	}
	
	public void printEmployeeInformation () {
		for (Employee e : projectStaff) {
			System.out.println(e);
		}
	}

	@Override
	public String toString() {
		return "Project [effortEstimate=" + effortEstimate + ", projectValue=" + projectValue + ", projectStaff="
				+ projectStaff + "]";
	}

}
