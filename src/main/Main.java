/**
 * Created by Roy Molina on 01-30-24
 * Professor Bahreini - COP 3337
 * Florida International University
 * Spring 2024
 */

package main;
import util.*;
import java.util.*;

public class Main {

    //static Scanner object for use in multiple methods
    public static Scanner keyboard = new Scanner(System.in);
    public static Gradebook gradebook = new Gradebook();

    public static void main(String[] args) {

        //variables for user input
        String user;
        int pid, score;
        String[] input = new String[4];

        //introduction message
        System.out.print("Welcome to my Grade Book!\n"
                + "Please enter the information of the first student using the following format:\n"
                + "\"firstName lastName PID grade\"\n"
                + "Press Enter when you are done\n");

        //Student input loop - will not exit until the user enters the keyword
        do {
            user = keyboard.nextLine();
            input = user.split(" ", 4);

            //if branch - if user enters "done" the loop goes to the else branch and breaks the loop
            if (user.compareToIgnoreCase("done") != 0) {

                // sends info to be checked and made sure input is correct
                nameCheck(input);
                pid =  checkID(input);
                score = checkGrade(input);
                gradebook.addStudent(input[0], input[1], pid, score);

                System.out.print("Please enter the information of the next student using the same format.\n"
                        + "If there are no more students, please enter the keyword \"DONE\"\n"
                        + "Press Enter when you are done.\n");
            }
            else
            {
                break;
            }

        } while (user.compareToIgnoreCase("done") != 0); //loop will not terminate until the command done is entered

        //new string array
        String[] command = new String[3];

        System.out.print("Please enter a new command: ");

        do
        {
            user = keyboard.nextLine();
            command = user.split(" ", 3);
            String check = command[0].toLowerCase();

            //switch statement that checks the first string and routes it to the proper method that will then route it to the proper command
            //based on the second word of the command
            switch(check)
            {
                case "min":
                    runMin(command);
                    break;
                case "max":
                    runMax(command);
                    break;
                case "letter":
                    runLetter(command);
                    break;
                case "name":
                    runName(command);
                    break;
                case "change":
                    runChange(command);
                    break;
                case "average":
                    runAverage(command);
                    break;
                case "median":
                    runMedian(command);
                    break;
                case "tab":
                    runTab(command);
                    break;
                case "help":
                    runHelp();
                    break;
                case "quit":
                    System.out.println("Thanks for using the program! Goodbye!");
                    break;
                default:
                    System.out.println("Not a valid Command. Type \'Help\' to see a list of commands. Or type \'Quit\' to exit program");
            }

        }while (user.compareToIgnoreCase("quit") != 0);

    }

    //check name for Capitalized letters
    public static String[] nameCheck (String[] s)
    {
        String name;

        //loop to step through the string array from main
        for (int i = 0; i < 2; i++)
        {
            // set name value for ease of use in displaying message later in loop
            if (i == 0)
                name = "First";
            else
                name = "Last";

           if (Character.isUpperCase(s[i].charAt(0)) == false)
           {
               //keep looping until user properly inputs name
               do {
                   System.out.print(name + " Name must be capitalized. Please Enter it again: ");
                   s[i] = keyboard.nextLine();
               } while (Character.isUpperCase(s[i].charAt(0)) == false);
           }
        }

        return s;
    }

    //check PID to make sure it's seven digits and not negative
    public static int checkID (String[] s)
    {
        //convert string into integers
        int pID;
        pID = Integer.parseInt(s[2]);

        //pid check
        if ( (s[2].length() != 7) || (pID < 0) ) //will not accept a value less than 7 digits or negative
        {
            do {
                System.out.print("PID must be seven digits and cannot be negative. Please re-enter PID: ");
                s[2] = keyboard.next();
                pID = Integer.parseInt(s[2]);
            } while ( (s[2].length() != 7) || (pID < 0) );
        }

        return pID;
    }

    //check grade value to make sure it's between 0 and 100
    public static int checkGrade (String[] s)
    {
        //convert string into integers
        int score;
        score = Integer.parseInt(s[3]);

        //grade check
        if ( (score < 0) || (score > 100)) // will not accept negative or above 100
        {
            do {
                System.out.print("Grade cannot be less than 0 or more than 100. Please re-enter Grade: ");
                score = keyboard.nextInt();
            } while ( (score < 0) || (score > 100));
        }

        return score;
    }

    //enter a new command methods
    public static void runMin(String[] s)
    {
        String check = s[1].toLowerCase();
        //switch case to check the second word of command input
        switch(check)
        {
            case "score":
                System.out.println("Minimum Score is: " + gradebook.minScore());
                break;
            case "letter":
                System.out.println("Minimum Letter Grade is: " + gradebook.letterMin());
                break;
            default:
        }
    }


    //enter more commands methods: they all take a string array as input and direct it to the proper method
    public static void runMax(String[] s)
    {
        String check = s[1].toLowerCase();
        //switch case to check the second word of command input
        switch(check)
        {
            case "score":
                System.out.println("Maximum Score is: " + gradebook.maxScore());
                break;
            case "letter":
                System.out.println("Maximum Letter Grade is: " + gradebook.letterMax());
                break;
            default:
        }
    }

    public static void runLetter(String[] s)
    {
        int num = Integer.parseInt(s[1]);
        System.out.println("Student " + num + "'s Letter grade is: " + gradebook.getidLetter(num));
    }

    public static void runName(String[] s)
    {
        int num = Integer.parseInt(s[1]);
        System.out.println("Student " + num + "'s Name is: " + gradebook.getName(num));
    }

    public static void runChange(String[] s)
    {
        int num = Integer.parseInt(s[1]);
        int score = Integer.parseInt(s[2]);
        gradebook.changeScore(num, score);
        System.out.println("Student " + num + "'s Score has been updated to: " + score);
    }

    public static void runAverage(String[] s)
    {
        String check = s[1].toLowerCase();
        //switch case to check the second word of command input
        switch(check)
        {
            case "score":
                System.out.println("Average Score is: " + gradebook.calculateAvg());
                break;
            case "letter":
                System.out.println("Average Letter Grade is: " + gradebook.letterAvg());
                break;
            default:
        }
    }

    public static void runMedian(String[] s)
    {
        String check = s[1].toLowerCase();
        //switch case to check the second word of command input
        switch(check)
        {
            case "score":
                System.out.println("Median Score is: " + gradebook.calculateMedian());
                break;
            case "letter":
                System.out.println("Median Letter Grade is: " + gradebook.letterMedian());
                break;
            default:
        }
    }

    public static void runTab(String[] s)
    {
        String check = s[1].toLowerCase();
        //switch case to check the second word of command input
        switch(check)
        {
            case "scores":
                gradebook.tableScores();
                break;
            case "letters":
                gradebook.tableLetters();
                break;
            default:
        }
    }

    public static void runHelp()
    {
        System.out.println("Here are a list of Commands you can use: \n"
                + "min score\n" + "min letter\n" + "max score\n" + "max letter\n"
                + "letter XXXXXXX\n" + "name XXXXXXX\n" + "change XXXXXXX YY\n"
                + "average score\n" + "average letter\n" + "median score\n" + "median letter\n"
                + "tab scores\n" + "tab letters\n" + "quit");
    }


}

