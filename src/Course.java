import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Dawson
 *
 */
public class Course {
	
	/* variables for course class */
	protected String professor;
	protected String administrator;
	protected int classNumber;
	protected String timeAndDays;
	protected String lengthOfCourse;
	protected double creditValue;
	protected List<Student> studentsEnrolled;
	protected String subject;
	protected String name;
	
	/**
	 * Constructor for Course class
	 * @param professor
	 * @param classNumber
	 * @param timeAndDays
	 * @param lengthOfCourse
	 * @param creditValue
	 * @param subject
	 */
	public Course(String professor, String administrator, int classNumber, String timeAndDays, double creditValue, String subject, String name) {
		super();
		this.professor = professor;
		this.administrator = administrator;
		this.classNumber = classNumber;
		this.timeAndDays = timeAndDays;
		this.creditValue = creditValue;
		this.studentsEnrolled = new ArrayList<>();
		this.subject = subject;
		this.name = name;
	}

	/* Getters and Setters */
	public String getAdministrator() {
		return administrator;
	}

	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public String getTimeAndDays() {
		return timeAndDays;
	}

	public void setTimeAndDays(String timeAndDays) {
		this.timeAndDays = timeAndDays;
	}

	public double getCreditValue() {
		return creditValue;
	}

	public void setCreditValue(double creditValue) {
		this.creditValue = creditValue;
	}

	public List<Student> getStudentsEnrolled() {
		return studentsEnrolled;
	}

	public void setStudentsEnrolled(List<Student> studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}
	
	
}
