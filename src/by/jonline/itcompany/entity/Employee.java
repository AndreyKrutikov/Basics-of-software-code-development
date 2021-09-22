package by.jonline.itcompany.entity;

/**
 * Class describes an employee. 
 * The field MIN_HOUR_COMPENSATION is common for any employee.
 *
 * @author admin
 *
 */
public class Employee {
	private static final int MIN_HOUR_COMPENSATION = 5; //
	private final int id;
	private final String fullName;
	private final JobTitle jobTitle;
	private final EmployeeGrade grade;
	private int personalHourCompensation;

	public Employee(int id, String fullName, JobTitle jobTitle, EmployeeGrade grade) {
		this.id = id;
		this.fullName = fullName;
		this.jobTitle = jobTitle;
		this.grade = grade;
		personalHourCompensation = setPersonalHourCompensation(this.grade);
	}

	private int setPersonalHourCompensation(EmployeeGrade grade) {
		switch (grade) {
		case DIRECTOR:
			personalHourCompensation = MIN_HOUR_COMPENSATION * 6;
			break;
		case ADMINISTRATOR:
			personalHourCompensation = MIN_HOUR_COMPENSATION * 5;
			break;
		case TEAM_LEAD:
			personalHourCompensation = MIN_HOUR_COMPENSATION * 4;
			break;
		case SENIOR:
			personalHourCompensation = MIN_HOUR_COMPENSATION * 3;
			break;
		case MIDDLE:
			personalHourCompensation = MIN_HOUR_COMPENSATION * 2;
			break;
		case JUNIOR:
			personalHourCompensation = MIN_HOUR_COMPENSATION * 1;
			break;
		default:
			personalHourCompensation = MIN_HOUR_COMPENSATION * 1;
		}
		return personalHourCompensation;
	}

	public static int getMinHourCompensation() {
		return MIN_HOUR_COMPENSATION;
	}

	public int getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public EmployeeGrade getGrade() {
		return grade;
	}

	public int getPersonalHourCompensation() {
		return personalHourCompensation;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", jobTitle=" + jobTitle + ", grade=" + grade
				+ ", personalHourCompensation=" + personalHourCompensation + "]";
	}
}
