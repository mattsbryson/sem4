import java.util.*;

public class Student {
	//Fields
	private List<Double> grades;
	private double gpa;
	private String name;
	private int id;
	private Date enrollmentDate;
	private String address;

	public double gpa(){
		double sum = 0;
		for(double d : grades){
			sum += d;
		}
		
		return sum / grades.size();
	}
	public void addGrade(double g){
		this.grades.add(g);
	}

	//Constructor
	public Student(List<Double> grades, String name, int id, Date enrollmentDate, String address, boolean enrolled){
		this.grades = new LinkedList<Double>();
		this.gpa = gpa;
		this.name = name;
		this.id = id;
		this.enrollmentDate = enrollmentDate;
		this.address = address;

	}
	public Student(String n, int i, Date ed, String a){
		this(new LinkedList<Double>(),n, i, ed , a , true);

	}

	
	public List<Double> getGrades() {
		return grades;
	}
	public void setGrades(List<Double> grades) {
		this.grades = grades;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
