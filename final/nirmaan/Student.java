package nirmaan;

import java.util.ArrayList;

public class Student extends Person {
	private String idNum;
	private String teacher;
	public Student(String name, String idNum, String teacher,String contact) {
		this.setName(name);
		this.setContactNumber(contact);
		this.idNum = idNum;
		this.teacher = teacher;
	}
	public void register() {
		ArrayList<Student> students;
		students = (ArrayList<Student>)Utility.deserialize("students.ser");
		if(students == null) {
			students = new ArrayList<Student>();
		}
		students.add(this);
		Utility.serialize(students, "students.ser");
	}
	public static ArrayList<Student> getAll() {
		ArrayList<Student> students;
		students = (ArrayList<Student>)Utility.deserialize("students.ser");
		return students;
	}
	public String toString() {
		return "Name" + this.getName() + "   ID: " + this.idNum + "   Teacher" + teacher;
	}
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
