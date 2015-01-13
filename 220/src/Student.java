
import java.util.List;

import java.util.Date;

import java.util.LinkedList;

public class Student 
{

 // fields of the student

 private List<Double> grades;

 private String name;

 private int id;

 private Date enrollmentDate;

 private String address;

 private boolean enrolled;

 // construct a student

 public Student(List<Double> grades, String n, int i, Date ed, String a, boolean enrolled) 
 {

 this.grades = grades;

 this.name = n;

 this.id = i;

 this.enrollmentDate = ed;

 this.address = a;

 this.enrolled = enrolled;

 }

 // construct a student, with no grades and enrolled by default

 public Student(String n, int i, Date ed, String a) 
 {

 this(new LinkedList<Double>(), n, i, ed, a, true);

 }

 public String getName() {

 return name;

 }

 public List<Double> getGrades() {

 return grades;

 }

 public int getId() {

 return id;

 }

 public Date getEnrollmentDate() {

 return enrollmentDate;

 }

 public String getAddress() {

 return address;

 }

 public boolean isEnrolled() {

 return enrolled;

 }

 public double getGPA() 
 {

 double sum = 0;

 	for (double d : this.grades) 
 	{

 		sum = sum + d;
 		
 	}

 return sum / this.grades.size();

 }

 public void addGrade(double g)
 {

 this.grades.add(g);

 }

}