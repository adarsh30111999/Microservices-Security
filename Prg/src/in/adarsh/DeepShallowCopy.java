package in.adarsh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student {
	int id;
	List<String> subjects;

	public Student(int id, List<String> subjects) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.subjects = new ArrayList<>(subjects);
	}

	public int getId() {
		return id;
	}

	public List<String> getSubjects() {
		return new ArrayList<String>(subjects);
	}

}

public class DeepShallowCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student(101, Arrays.asList("Java", "Spring boot"));

	}

}
