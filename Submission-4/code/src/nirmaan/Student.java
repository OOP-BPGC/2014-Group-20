package nirmaan;

import java.util.ArrayList;

/**
 * @author Sreejith
 *
 */
public class Student extends Person {
	private String idNum;
	private String teacher;
	
	/**
	 * Class Constructor
	 * @param name Name of the student
	 * @param idNum BITS ID no. of the student
	 * @param teacher Teacher name
	 * @param contact Contact number
	 */
	public Student(String name, String idNum, String teacher,String contact) {
		this.setName(name);
		this.setContactNumber(contact);
		this.idNum = idNum;
		this.teacher = teacher;
	}
	
	/**
	 * Register student details in the database
	 */
	public void register() {
		ArrayList<Student> students;
		students = (ArrayList<Student>)Utility.deserialize("students.ser");
		if(students == null) {
			students = new ArrayList<Student>();
		}
		students.add(this);
		Utility.serialize(students, "students.ser");
	}
	
	/**
	 * @return ArrayList of all students
	 */
	public static ArrayList<Student> getAll() {
		ArrayList<Student> students;
		students = (ArrayList<Student>)Utility.deserialize("students.ser");
		return students;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Name" + this.getName() + "   ID: " + this.idNum + "   Teacher" + teacher;
	}
	
	/**
	 * Searches the database for matching student names
	 * @param query The search parameter (name of the student)
	 * @return ArrayList containing matching queries
	 */
	public static ArrayList<Student> search(String query) {
		ArrayList<Student> students;
		ArrayList<Student> result = new ArrayList<Student>();
		students = (ArrayList<Student>)Utility.deserialize("students.ser");
		for(Student student: students) {
		
			if(student.getName().contains(query) || student.teacher.contains(query)) {
				
				result.add(student);
				
			}
			
		}
		return result;
	}
}
