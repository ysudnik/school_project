package by.TeachMeSkills.school.entity;

public class Group {
  private int id;
  private String number;

    @Override
    public String toString() {
        return "id = " + id + "; номер = " + number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Group(String number) {
        this.number = number;
    }

    public Group() {
    }

    public Group(int id, String number) {
        this.id = id;
        this.number = number;
    }
}
