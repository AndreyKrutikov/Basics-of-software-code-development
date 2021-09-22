package by.jonline.itcompany.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import by.jonline.itcompany.entity.Employee;
import by.jonline.itcompany.entity.EmployeeGrade;
import by.jonline.itcompany.entity.JobTitle;


/**
 * Class parses XML document into Employee list.
 * 
 * @author admin
 *
 */
public class XMLParser {
	
	private static final String TAG_ID = "ID";
	private static final String TAG_FULL_NAME = "FullName";
	private static final String TAG_JOB_TITLE = "JobTitle";
	private static final String TAG_EMPLOYEE_GRADE = "Grade";

	public List<Employee> parsXML() {

		List<Employee> allEmployees;
		Document doc = null;
		Node companyNode;

		try {
			doc = buildDocument();
		} catch (Exception e) {
			e.printStackTrace();
		}

		companyNode = doc.getFirstChild();
		allEmployees = parseEmployeeList(companyNode);
		return allEmployees;
	}

	private Document buildDocument() throws Exception {
		File file = new File("compay_staff.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		return dbf.newDocumentBuilder().parse(file);
	}

	private List<Employee> parseEmployeeList(Node companyNode) {

		List<Employee> allEmployees = new ArrayList<Employee>();

		NodeList companyChilds = companyNode.getChildNodes();
		for (int i = 0; i < companyChilds.getLength(); i++) {
			if (companyChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			Employee employee = parseEmployee(companyChilds.item(i));
			allEmployees.add(employee);
		}
		return allEmployees;
	}

	private Employee parseEmployee(Node companyNode) {

		int id = 0;
		String fullName = "";
		JobTitle jobTitle = null;
		EmployeeGrade employeeGrade = null;

		NodeList employeeChilds = companyNode.getChildNodes();
		for (int j = 0; j < employeeChilds.getLength(); j++) {
			if (employeeChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			switch (employeeChilds.item(j).getNodeName()) {
			case TAG_ID:
				id = Integer.valueOf(employeeChilds.item(j).getTextContent());
				break;
			case TAG_FULL_NAME:
				fullName = employeeChilds.item(j).getTextContent();
				break;
			case TAG_JOB_TITLE:
				jobTitle = JobTitle.valueOf(employeeChilds.item(j).getTextContent());
				break;
			case TAG_EMPLOYEE_GRADE:
				employeeGrade = EmployeeGrade.valueOf(employeeChilds.item(j).getTextContent());
				break;
			}
		}
		return new Employee(id, fullName, jobTitle, employeeGrade);
	}
}
