package by.jonline.itcompany.entity;

import java.util.List;

public class CompanyStaff {
	private List<Employee> allEmployees;

	public CompanyStaff(List<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}

	public List<Employee> getAllEmployees() {
		return allEmployees;
	}

	@Override
	public String toString() {
		return "CompanyStaff [allEmployees=" + allEmployees + "]";
	}
}
