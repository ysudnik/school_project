package by.TeachMeSkills.school.dao;

import by.TeachMeSkills.school.connections.MyaqlConnection;
import by.TeachMeSkills.school.entity.Group;
import by.TeachMeSkills.school.entity.Student;

import javax.management.remote.SubjectDelegationPermission;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> getStudents() {
        try {
            Connection connection = MyaqlConnection.getConnection();
            Statement statement = connection.createStatement();
            List<Student> students = new ArrayList<>();
            ResultSet result = statement.executeQuery("SELECT s.*,g.number FROM students s LEFT JOIN gruppa g ON s.group_id = g.id");
            while (result.next()) {
                Student student = new Student();
                student.setId(result.getInt("id"));
                student.setName(result.getString("name"));
                student.setAge(result.getInt("age"));
                student.setGroup(new Group(result.getInt("group_id"), result.getString("number")));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void add(Student student) {

        try {
            Connection connection = MyaqlConnection.getConnection();
            String sql = "INSERT INTO students VALUES (null, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setInt(3, student.getGroup().getId());
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name = ?, age = ?, group_id = ? WHERE id = ?";
        try {
            Connection connection = MyaqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setInt(3, student.getGroup().getId());
            statement.setInt(4, student.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(Student student) {
        String sql = "DELETE FROM students WHERE id = ?";
        try {
            Connection connection = MyaqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, student.getId());
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Student> getStudents(String name) {
        String sql = "SELECT s.*, g.number FROM students s LEFT JOIN gruppa g ON s.group_id = g.id WHERE s.name = ?";
        try {
            Connection connection = MyaqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            List<Student> students = new ArrayList<>();

            while (result.next()) {
                Student student = new Student();
                student.setId(result.getInt("id"));
                student.setName(result.getString("name"));
                student.setAge(result.getInt("age"));
                student.setGroup(new Group(result.getInt("group_id"), result.getString("number")));
                students.add(student);
            }
            connection.close();

            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();

        }
    }

    @Override
    public  Student getStudentById(int id_student) {
        String sql = "SELECT s.*, g.number FROM students s LEFT JOIN gruppa g ON s.group_id = g.id WHERE s.id = ?";

        try {
            Connection connection = MyaqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_student);
            ResultSet result = statement.executeQuery();
            Student student = new Student();
            result.next();
                student.setId(result.getInt("id"));
                student.setName(result.getString("name"));
                student.setAge(result.getInt("age"));
                student.setGroup(new Group(result.getInt("group_id"), result.getString("number")));
                connection.close();

            return student;
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println("Ошибка в методе getStudentById ");
            return new Student();
        }
    }

    @Override
    public List<Student> getStudents(int id_group) {
        String sql = "SELECT s.*, g.number FROM students s LEFT JOIN gruppa g ON s.group_id = g.id WHERE s.group_id = ?";
        try {
            Connection connection = MyaqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_group);
            ResultSet result = statement.executeQuery();
            List<Student> students = new ArrayList<>();

            while (result.next()) {
                Student student = new Student();
                student.setId(result.getInt("id"));
                student.setName(result.getString("name"));
                student.setAge(result.getInt("age"));
                student.setGroup(new Group(result.getInt("group_id"), result.getString("number")));
                students.add(student);
            }
            connection.close();

            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();

        }
    }


}
