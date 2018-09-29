package by.TeachMeSkills.school.dao;

import by.TeachMeSkills.school.entity.Group;
import by.TeachMeSkills.school.entity.Student;

import java.util.List;

public interface GroupDao {
   List<Group> getGroups();
   void add (Group group);
   void updateGroup (Group group);
   void deleteGroup (Group group);
   List<Student> getStudents (Group group);
   Group getGroupById(int number);
}
