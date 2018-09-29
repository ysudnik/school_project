package by.TeachMeSkills.school.controllers;

import by.TeachMeSkills.school.dao.GroupDao;
import by.TeachMeSkills.school.dao.GroupDaoImpl;
import by.TeachMeSkills.school.entity.Group;
import by.TeachMeSkills.school.entity.Student;

import java.util.List;

public class GroupController {
    private GroupDao dao = new GroupDaoImpl();
    public List<Group> getGroups(){
        return dao.getGroups();
    }
    public  void add (Group group){
        dao.add(group);
    }
    public void updateGroup (Group group){
        dao.updateGroup(group);
    }
    public void deleteGroup (Group group){
        dao.deleteGroup(group);
    }
    public  List<Student> getStudents (Group group){
        return dao.getStudents(group);
    }
   public Group getGroupById(int number){
        return dao.getGroupById(number);
   }
}
