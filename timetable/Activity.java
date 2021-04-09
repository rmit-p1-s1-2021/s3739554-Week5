package timetable;

public class Activity {

	private int id;
	private String name;
	private String time;
	private Student[] students; 
	private int studentCount;

	public Activity(int id, String name, String time) {
		this.id = id;
		this.name = name;
		this.time = time;
		this.students = new Student[10];
		this.studentCount = 0;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTime() {
		return time;
	}

	public Student[] getStudents() {
		return students;
	}
	
	public int getStudentCount() {
		return studentCount;
	}
	
	public Student getStudents(String studentId) {
		for (int i = 0; i < studentCount; i++) {
			if (students[i].getId().equals(studentId)) 
				return students[i];
		}
		return null;
	}

	public boolean addStudent(Student student) {
		if (studentCount == students.length)
			return false;
		
		if (getStudents(student.getId()) != null)
			return false;
		
		students[studentCount] = student;
		studentCount++;
		
		return true;
	}

	@Override
	public String toString() {
		return id + ": " + name + ", " + time;
	}
	
	
}
