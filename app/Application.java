package by.TeachMeSkills.school.app;

import by.TeachMeSkills.school.actions.GroupAction;
import by.TeachMeSkills.school.actions.ReportAction;
import by.TeachMeSkills.school.actions.StudentAction;
import by.TeachMeSkills.school.entity.Student;
import by.TeachMeSkills.school.exceptions.AppStopException;

import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);
    public static void start(){
        System.out.println("Добро пожаловать");
        run();
        System.out.println("До свидания");
    }

    private static void run() {
        while (true){
            try{
                action();
            }catch (AppStopException e){
                break;
            }
        }
    }

    private static void action() throws AppStopException {
        showMenu();
        int action = 999;
        if (scanner.hasNextInt()){
            action = scanner.nextInt();
        }else{
            scanner.next();
        }
        switch (action){
            case 1:
                StudentAction.getStudents();
                break;
            case 2:
                StudentAction.addStudent();
                break;
            case 3:
                StudentAction.updateStudent();
                break;
            case 4:
                StudentAction.deleteStudent();
                break;
            case 5:
                StudentAction.getStudentsByName();
                break;
            case 6:
                GroupAction.getGroups();
                break;
            case 7:
                GroupAction.addGroup();
                break;
            case 8:
                GroupAction.updateGroup();
                break;
            case 9:
                GroupAction.deleteGroupById();
                break;
            case 10:
                GroupAction.getStudentsByGroup();
                break;
            case 11:
                ReportAction.report();
                break;
            case 0:
                throw new AppStopException();

        }
    }
    private static void showMenu() {
        System.out.println("Выберите дейтсвие");
        System.out.println("1 - вывод всех студентов");
        System.out.println("2 - добавление студента");
        System.out.println("3 - редактирование студента");
        System.out.println("4 - удаление студента");
        System.out.println("5 - поиск студента по имени");
        System.out.println("6 - вывод всех групп");
        System.out.println("7 - добавление группы");
        System.out.println("8 - редактирование группы");
        System.out.println("9 - удаление группы");
        System.out.println("10 - вывод студентов определённой группы");
        System.out.println("11 - формирование отчёта");
        System.out.println("0 - Выход");
    }
}
