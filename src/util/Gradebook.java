package util;

import java.util.ArrayList;
import java.util.Arrays;

public class Gradebook {
    private ArrayList<Student> listOfStudents = new ArrayList<Student>();

    //average scores and letters
    public double calculateAvg() {

        double sum = 0;
        for(Student s: listOfStudents)
            sum += s.getGrade().getScore();

        return sum / listOfStudents.size();
    }
    public String letterAvg() {
        int avg = (int)calculateAvg();
        Grade average = new Grade(avg);

        return average.getLetterGrade();
    }

    //medians and letters
    public float calculateMedian() {

        int i = 0, n = listOfStudents.size();
        int[] scores = new int[n];

        for(Student s: listOfStudents) {
            scores[i++] = s.getGrade().getScore();
        }

        Arrays.sort(scores);

        if (n % 2 == 0) {
            return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
        }
        else {
            return scores[n / 2];
        }
    }
    public String letterMedian() {
        int med = (int)calculateMedian();
        Grade median = new Grade(med);

        return median.getLetterGrade();
    }

    //min scores and letters
    public int minScore()
    {
        //variable declaration - 100 is the max value a grade can be anyways
        int min = 100;
        int curr;

        for (Student s: listOfStudents)
        {
            curr = s.getGrade().getScore();
            if (curr < min)
            {
                min = curr;
            }
        }

        return min;
    }
    public String letterMin() {
        int min = minScore();
        Grade minimum = new Grade(min);

        return minimum.getLetterGrade();
    }

    //max scores and letters
    public int maxScore()
    {
        //variable declaration - 0 is the min value a grade can be anyways
        int max = 0;
        int curr;

        for (Student s: listOfStudents)
        {
            curr = s.getGrade().getScore();
            if (curr > max)
            {
                max = curr;
            }
        }

        return max;
    }
    public String letterMax()
    {
        int max = maxScore();
        Grade maximum = new Grade(max);

        return maximum.getLetterGrade();
    }

    //table scores and letters
    public void tableScores() {
        System.out.println("First Name" + "\t\t" + "Last Name" + "\t\t" + "PID" + "\t\t" + "Score");
        //enhanced for loop to step through the array of students
        for (Student s: listOfStudents)
        {
            System.out.println(s.getFirstName() + "\t\t" + s.getLastName() + "\t\t" + s.getPid() + "\t\t" + s.getGrade().getScore());
        }
    }
    public void tableLetters() {
        System.out.println("First Name" + "\t\t" + "Last Name" + "\t\t" + "PID" + "\t\t" + "Score");
        //enhanced for loop to step through the array of students
        for (Student s: listOfStudents)
        {
            System.out.println(s.getFirstName() + "\t\t" + s.getLastName() + "\t\t" + s.getPid() + "\t\t" + s.getGrade().getLetterGrade());
        }
    }

    //change method
    public void changeScore(int num, int score){
        //variables for search
        int search, target = 0;
        int i = 0;

        //enhanced for loop to search through array
        for (Student s: listOfStudents)
        {
            search = s.getPid();
            if (num == search)
            {
                target = i;
            }
            i++;
        }

        String fName, lName;
        int id;

        fName = listOfStudents.get(target).getFirstName();
        lName = listOfStudents.get(target).getLastName();
        id = listOfStudents.get(target).getPid();

        //replaces the element with the upgraded score
        listOfStudents.set(target, new Student(fName, lName, id, score));
    }

    //getters
    public String getidLetter(int num){
        int search, target = 0;
        int i = 0;
        for (Student s: listOfStudents)
        {
            search = s.getPid();
            if (num == search)
            {
                target = i;
            }
            i++;
        }

        return listOfStudents.get(target).getGrade().getLetterGrade();
    }
    public String getName(int num)
    {
        int search, target = 0;
        int i = 0;
        //search through the array to find the PID and then get the name from that
        for (Student s: listOfStudents)
        {
            search = s.getPid();
            if (num == search)
            {
                target = i;
            }
            i++;
        }
        //call method with index number to make it one full string
        return getFull(target);
    }

    //make a String with the Student's full name
    public String getFull(int target){
        String fullname = listOfStudents.get(target).getFirstName() + " " + listOfStudents.get(target).getLastName();
        return fullname;
    }

    //print
    public void printAllStudents() {
        for(Student s: listOfStudents)
            System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
    }

    //add student to array
    public void addStudent (String fName, String lName, int id, int num)
    {
        listOfStudents.add(new Student(fName, lName, id, num));
    }

}
