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
	protected int classNumber;
	protected String timeAndDays;
	protected String lengthOfCourse;
	protected double creditValue;
	protected List<Student> studentsEnrolled;
	
	/**
	 * Constructor for Course class
	 * @param professor
	 * @param classNumber
	 * @param timeAndDays
	 * @param lengthOfCourse
	 * @param creditValue
	 */
	public Course(String professor, int classNumber, String timeAndDays, String lengthOfCourse, double creditValue) {
		super();
		this.professor = professor;
		this.classNumber = classNumber;
		this.timeAndDays = timeAndDays;
		this.lengthOfCourse = lengthOfCourse;
		this.creditValue = creditValue;
		this.studentsEnrolled = new ArrayList<>();
	}

	/* Getters and Setters */
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

	public String getLengthOfCourse() {
		return lengthOfCourse;
	}

	public void setLengthOfCourse(String lengthOfCourse) {
		this.lengthOfCourse = lengthOfCourse;
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
