package by.TeachMeSkills.school.actions;

import by.TeachMeSkills.school.connections.MyaqlConnection;
import by.TeachMeSkills.school.controllers.GroupController;
import by.TeachMeSkills.school.controllers.StudentController;
import by.TeachMeSkills.school.entity.Group;
import by.TeachMeSkills.school.entity.Student;
import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentAction {
    public static StudentController controllerStudent = new StudentController();
    public static GroupController controllerGroup = new GroupController();
    public static Scanner scanner = new Scanner(System.in);

    public static void getStudents() {
        List<Student> students = controllerStudent.getStudents();
        System.out.println("Все студенты: ");
        showStudents(students);
    }

    private static void showStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void addStudent() {
//
        System.out.println("Введите имя студента: ");
        String name = scanner.next();
        System.out.println("Введите возраст студента: ");
        int age = scanner.nextInt();
        List<Group> groups = controllerGroup.getGroups();
        System.out.println("Все группы:");
        showGroups(groups);
        System.out.println("Введите id группы: ");
        int number = scanner.nextInt();
        Student student = new Student(name, age, controllerGroup.getGroupById(number));
        controllerStudent.add(student);
    }

    private static void showGroups(List<Group> groups) {
        for (Group group : groups) {
            System.out.println(group);
        }
    }

    public static void updateStudent() {
        List<Student> students = controllerStudent.getStudents();
        System.out.println("Все студенты: ");
        showStudents(students);
        System.out.println("Введите id студента для редактирования: ");
        int id_student = scanner.nextInt();
        System.out.println("Введите новое имя:");
        String name = scanner.next();
        System.out.println("Введите возраст: ");
        int age = scanner.nextInt();
        List<Group> groups = controllerGroup.getGroups();
        System.out.println("Все группы:");
        showGroups(groups);
        System.out.println("Введите id группы: ");
        int id_group = scanner.nextInt();
        Student student = controllerStudent.getStudentById(id_student);
        student.setGroup(controllerGroup.getGroupById(id_group));
        student.setId(id_student);
        student.setAge(age);
        student.setName(name);
        controllerStudent.updateStudent(student);

    }

    public static void deleteStudent() {
        List<Student> students = controllerStudent.getStudents();
        System.out.println("Все студенты: ");
        showStudents(students);
        System.out.println("Введите id студента для удаления: ");
        int id_student = scanner.nextInt();
        Student student = controllerStudent.getStudentById(id_student);
        controllerStudent.deleteStudent(student);
    }


    public static void getStudentsByName() {
//        List<Student> students = controllerStudent.getStudents();
//        System.out.println("Все студенты: ");
//        showStudents(students);
        System.out.println("Введите имя для поиска:");
        String name = scanner.next();
        List<Student> fullstudents = controllerStudent.getStudents(name);
        for (Student student : fullstudents) {
            System.out.println(student);
        }
    }
}
