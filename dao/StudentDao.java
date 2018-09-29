package by.TeachMeSkills.school.dao;

import by.TeachMeSkills.school.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getStudents();
    void add (Student student);
    void updateStudent (Student student);
    void deleteStudent (Student student);
    List<Student> getStudents (String name);
    Student getStudentById (int id_student);
    List<Student> getStudents (int id_group);
}
