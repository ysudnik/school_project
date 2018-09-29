package by.TeachMeSkills.school.actions;

import by.TeachMeSkills.school.controllers.GroupController;
import by.TeachMeSkills.school.controllers.StudentController;
import by.TeachMeSkills.school.entity.Group;
import by.TeachMeSkills.school.entity.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportAction {
    public static StudentController controllerStudent = new StudentController();
    public static GroupController controllerGroup = new GroupController();
    public static Scanner scanner = new Scanner(System.in);

    public static void report() {
        List<Group> groups = controllerGroup.getGroups();
        for (int i = 0; i < groups.size(); i++) {
            Group group = groups.get(i);
            List<Student> students = controllerGroup.getStudents(group);
            String str = "*************** Группа " + group.getNumber() + " , кол-во = " + students.size() + "***************";
            writeStr(str);
            for (Student student : students) {
                String str2 = "Имя: " + student.getName() + "; Возраст: " + student.getAge() + "; id: " + student.getId();
                writeStr(str2);
            }

        }
    }

    private static void writeStr(String string) {
        try (FileWriter writer = new FileWriter("report.txt", true)) {
            writer.write(string);
            writer.write("\r\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
