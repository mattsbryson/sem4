
public class Class 
{
	private Student [] students; 
	private Course course;
	private String teacher; 
	private int limit; 
	private int room;
	
	public Class(){};
	
	public Class(Student [] s, Course c, String t, int lim, int r)
	{
		this.students = s;
		this.course = c;
		this.teacher = t;
		this.limit = lim;
		this.room = r;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

}
