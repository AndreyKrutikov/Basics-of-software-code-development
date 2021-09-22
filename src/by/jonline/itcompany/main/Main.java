package by.jonline.itcompany.main;

import java.util.List;
import java.util.Scanner;

import by.jonline.itcompany.entity.CompanyStaff;
import by.jonline.itcompany.entity.Employee;
import by.jonline.itcompany.entity.Project;
import by.jonline.itcompany.parser.XMLParser;

public class Main {

	public static void main(String[] args) {
		XMLParser parser = new XMLParser();
		List<Employee> allEmployees = parser.parsXML();
		CompanyStaff companyStaff = new CompanyStaff(allEmployees);
		companyStaff.getAllEmployees().forEach(employee -> {
			System.out.println(employee);
		});
		
		System.out.print("Press any key to build a project -> ");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			sc.next();
			break;
		}
		
		Project project = Project.buildProject(1, companyStaff.getAllEmployees());
		project.printEmployeeInformation();
		
				
	}
}
