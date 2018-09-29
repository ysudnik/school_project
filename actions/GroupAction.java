package by.TeachMeSkills.school.actions;

import by.TeachMeSkills.school.controllers.GroupController;
import by.TeachMeSkills.school.controllers.StudentController;
import by.TeachMeSkills.school.entity.Group;
import by.TeachMeSkills.school.entity.Student;

import java.util.List;
import java.util.Scanner;

public class GroupAction {
    public static StudentController controllerStudent = new StudentController();
    public static GroupController controllerGroup = new GroupController();
    public static Scanner scanner = new Scanner(System.in);

    public static void getGroups() {
        List<Group> groups = controllerGroup.getGroups();
        System.out.println("Все группы: ");
        showGroups(groups);
    }

    private static void showGroups(List<Group> groups) {
        for (Group group : groups) {
            System.out.println(group);
        }
    }

    public static void addGroup() {
//        List<Group> groups = controllerGroup.getGroups();
//        System.out.println("Все группы:");
//        showGroups(groups);
        System.out.println("Введите номер группы: ");
        if (scanner.hasNext()) {
            String number = scanner.next();
            Group group = new Group(number);
            controllerGroup.add(group);
        }else{
            System.out.println("Ошибка, повторите ввод!");
        }
    }

    public static void updateGroup() {
        List<Group> groups = controllerGroup.getGroups();
        System.out.println("Все группы:");
        showGroups(groups);
        System.out.println("Введите id группы для редактирования: ");
        int id_group = scanner.nextInt();
        System.out.println("Введите новый номер группы: ");
        String number = scanner.next();
        Group group = controllerGroup.getGroupById(id_group);
        group.setNumber(number);
        controllerGroup.updateGroup(group);

    }

    public static void getStudentsByGroup() {
        List<Group> groups = controllerGroup.getGroups();
        System.out.println("Все группы:");
        showGroups(groups);
        System.out.println("Введите id группы для вывода всех ее участников: ");
        int id_group = scanner.nextInt();
        Group group = controllerGroup.getGroupById(id_group);
        List<Student> fullstudents = controllerGroup.getStudents(group);
        for (Student student:fullstudents){
            System.out.println(student);
        }
    }

    public static void deleteGroupById() {
        List<Group> groups = controllerGroup.getGroups();
        System.out.println("Все группы:");
        showGroups(groups);
        System.out.println("Введите id группы для ее удаления: ");
        int id_group = scanner.nextInt();
        Group group = controllerGroup.getGroupById(id_group);
        List<Student> students = controllerStudent.getStudents(id_group);
        if (students.size() == 0) {
            controllerGroup.deleteGroup(group);
        } else {
            System.out.println("В данной группе есть учащиеся, ее нельзя удалять");
        }
    }
}
