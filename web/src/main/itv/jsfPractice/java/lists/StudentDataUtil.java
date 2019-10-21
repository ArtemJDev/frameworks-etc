package main.itv.jsfPractice.java.lists;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class StudentDataUtil {

  private List<Student> students;

  public StudentDataUtil() {
    loadSampleData();
  }

  public void loadSampleData() {
    students = new ArrayList<Student>();

    students.add(new Student("Mary", "Public", "mary@unl.ru"));
    students.add(new Student("Ted", "Don", "ted@unl.ru"));
    students.add(new Student("Li", "Key", "li@unl.ru"));
  }

  public List<Student> getStudents() {
    return students;
  }
}
