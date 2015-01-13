
public class Course 
{
	private String name; 
	private String department; 
	private String school; 
	private int CourseNumber;
	private String [] materials; 

	
	public Course(){}
	
	public Course(String n, String d, String s, int CN, String [] m)
	{
		this.name  = n; 
		this.department = d; 
		this.school = s; 
		this.CourseNumber = CN;
		this.materials = m;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getCourseNumber() {
		return CourseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		CourseNumber = courseNumber;
	}

	public String[] getMaterials() {
		return materials;
	}

	public void setMaterials(String[] materials) {
		this.materials = materials;
	}
}
