package by.TeachMeSkills.school.entity;

public class Student  {
    private int id;
    private String name;
    private int age;
    private Group group;

    public Student(int id, String name, int age, Group group) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public Student(String name, int age, Group group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "id=" + id + "; Имя: " + name + "; Возраст: " + age + "; Группа: " + group.getNumber();

    }

}
