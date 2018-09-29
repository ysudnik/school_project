package by.TeachMeSkills.school.dao;

import by.TeachMeSkills.school.connections.MyaqlConnection;
import by.TeachMeSkills.school.entity.Group;
import by.TeachMeSkills.school.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDaoImpl implements GroupDao {
    @Override
    public List<Group> getGroups() {
        try {
            Connection connection = MyaqlConnection.getConnection();
            Statement statement = connection.createStatement();
            List<Group> groups = new ArrayList<>();
            ResultSet result = statement.executeQuery("SELECT * FROM gruppa");
            while (result.next()) {
                groups.add(new Group(result.getInt("id"), result.getString("number")));

            }
            connection.close();

            return groups;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public void add(Group group) {
        try {
            Connection connection = MyaqlConnection.getConnection();
            String sql = "INSERT INTO gruppa VALUES (null,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, group.getNumber());
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateGroup(Group group) {
        String sql = "UPDATE gruppa SET number = ? WHERE id = ?";
        try {
            Connection connection = MyaqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, group.getNumber());
            statement.setInt(2, group.getId());
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteGroup(Group group) {
        String sql = "DELETE FROM gruppa WHERE id = ?";
        try {
            Connection connection = MyaqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, group.getId());
            statement.execute();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getStudents(Group group) {
        String sql = "SELECT s.*, g.number FROM students s LEFT JOIN gruppa g ON s.group_id = g.id WHERE s.group_id = ?";
        try {
            Connection connection = MyaqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, group.getId());
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
    public Group getGroupById(int number) {
        String sql = "SELECT * FROM gruppa WHERE id = ?";
        try {
            Connection connection = MyaqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, number);
            ResultSet result = statement.executeQuery();
            Group group = new Group();
            result.next();
                group.setId(result.getInt("id"));
                group.setNumber(result.getString("number"));
                connection.close();


            return group;
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println("Ошибка из getGroupById");
            return new Group();
        }
    }
}
