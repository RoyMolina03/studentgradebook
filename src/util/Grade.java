package util;

public class Grade {

    private int score;
    private String letterGrade;

    //constructors
    public Grade(){
        //hi
    }
    public Grade(int num){
        this.score = num;
    }

    //getters
    public int getScore() {

        return score;
    }

    public String getLetterGrade() {

        //comically huge if statement for those sweet sweet letter grades (is there a better way to do this)
        if (score >= 95)
        {
            letterGrade = "A";
        }
        else if (score >= 90)
        {
            letterGrade = "A-";
        }
        else if (score >= 87)
        {
            letterGrade = "B+";
        }
        else if (score >= 83)
        {
            letterGrade = "B";
        }
        else if (score >= 80)
        {
            letterGrade = "B-";
        }
        else if (score >= 77)
        {
            letterGrade = "C+";
        }
        else if (score >= 70)
        {
            letterGrade = "C";
        }
        else if (score >= 60)
        {
            letterGrade = "D";
        }
        else
        {
            letterGrade = "F";
        }

        return letterGrade;
    }
}
