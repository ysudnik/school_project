package by.TeachMeSkills.school.controllers;

import by.TeachMeSkills.school.dao.GroupDao;
import by.TeachMeSkills.school.dao.GroupDaoImpl;
import by.TeachMeSkills.school.dao.StudentDao;
import by.TeachMeSkills.school.dao.StudentDaoImpl;
import by.TeachMeSkills.school.entity.Student;

import java.util.List;

public class StudentController {
    private StudentDao dao = new StudentDaoImpl();
    public List<Student> getStudents(){
        return dao.getStudents();
    }
    public void add (Student student){
        dao.add(student);
    }
    public  void updateStudent (Student student){
        dao.updateStudent(student);
    }
    public  void deleteStudent (Student student){
        dao.deleteStudent(student);
    }
    public  List<Student> getStudents (String name){
        return dao.getStudents(name);
    }
    public Student getStudentById (int id){
        return dao.getStudentById(id);
    }
   public List<Student> getStudents (int id_group){
        return dao.getStudents(id_group);
    }
}
