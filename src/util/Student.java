package util;

public class Student {

    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade = new Grade();

    //constructor
    public Student(String fName, String lName, int id, int num)
    {
        this.firstName = fName;
        this.lastName = lName;
        this.pid = id;
        this.grade = new Grade(num);
    }

    //getters
    public String getFirstName() {

        return firstName;
    }
    public String getLastName() {

        return lastName;
    }
    public int getPid() {

        return pid;
    }
    public Grade getGrade() {

       return grade;
    }
}
