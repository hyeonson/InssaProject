package project.hs.inssaproject.Data;

public class profileListData {
    String user_id;
    String major;
    int grade;
    int age;

    public String getUser_id() {
        return user_id;
    }

    public String getMajor() {
        return major;
    }

    public int getGrade() {
        return grade;
    }

    public int getAge() {
        return age;
    }

    public profileListData(String user_id, String _major, int _grade, int _age){
        this.user_id = user_id;
        this.major = _major;
        this.grade = _grade;
        this.age = _age;
    }
}
