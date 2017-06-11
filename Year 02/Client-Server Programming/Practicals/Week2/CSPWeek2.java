package year2.CSP.Week2;

import java.util.Scanner;

public class CSPWeek2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Boolean quit = false;

        while (quit == false) {

            System.out.println("Which would you like to run?\n"
                    + "1	 Calculating Total \n"
                    + "2	 Calculating Total Extension \n"
                    + "3	 Option Menu \n"
                    + "4	 Array Example \n"
                    + "5	 Rock, Paper, Scissors \n"
                    + "5	 Exit");
            System.out.print("\nPlease enter your choice: ");

            int option = scan.nextInt();
            System.out.println("");
            String display;
            switch (option) {
                case 1:
                    Question1();
                    break;
                case 2:
                    Question2();
                    break;
                case 3:
                    Question3();
                    break;
                case 4:
                    Question4();
                    break;
                case 5:
                    Question5();
                    break;
                default:
                    quit = true;
                    break;
            }
        }
        System.out.println("Quit");
    }

    private static void Question1() {

        Scanner scan = new Scanner(System.in);

        int total = 0, input = 1, count = 1;

        System.out.println("Enter integers with a final negative to total.");


        while (input > 0) {
            System.out.print("Please enter number " + count + ": ");
            input = scan.nextInt();
            total = total + input;
            count++;
        }

        System.out.println("The total of your input is: " + total + "\n");

    }

    private static void Question2() {

        Scanner scan = new Scanner(System.in);

        int total = 0, input = 1, count = 1, loopcount = 1;

        System.out.println("How many numbers would you like to total?");
        count = scan.nextInt();
        while (count > 0) {
            System.out.print("Please enter number " + loopcount + ": ");
            input = scan.nextInt();
            total = total + input;
            loopcount++;
            count--;
        }
        System.out.println("The total of your input is: " + total);
    }

    private static void Question3() {

        Scanner scan = new Scanner(System.in);

        System.out.println("1	 Java Programming \n"
                + "2	 Soft Engineering \n"
                + "3	 Requirement Engineering \n"
                + "4	 Project Management");
        System.out.println("Please enter your choice:");

        int option = scan.nextInt();
        String display;
        switch (option) {
            case 1:
                display = "Java Programming";
                break;
            case 2:
                display = "Soft Engineering";
                break;
            case 3:
                display = "Requirement Engineering";
                break;
            case 4:
                display = "Project Management";
                break;
            default:
                display = "Invalid value";
                break;
        }

        System.out.println(display + "\n");
    }

    private static void Question4() {

        Scanner scan = new Scanner(System.in);

        int[] marks = new int[10];
        int total = 0, input = 1, count = 10, i = 0, sum = 0, average;

        while (count > 0) {
            System.out.print("Enter student " + (i + 1) + "s marks: ");
            marks[i] = scan.nextInt();
            total = total + input;
            i++;
            count--;
        }
        for (int j : marks) {
            sum += j;
        }
        average = sum / 10;
        System.out.println("The average marks are: " + average + "\n");

    }

    private static void Question5() {
        
//        RockPaperScissors();
        
    }
}
