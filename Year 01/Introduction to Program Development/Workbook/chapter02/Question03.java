package chapter02;
import java.util.Scanner;

/*******************************************************************************
 * Question  2.3 (page 135)     
 * Write an application that prompts for and reads a person's name, age, 
 * college and pets name. Then print the following paragraph, inserting the
 * appropriate data:
 * Hello, my name is <name> and I am <age> years
 * old. I'm enjoying my time at <college>, though
 * I miss my pet <petname> very much!
******************************************************************************/

public class Question03 {
   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("What is your name?: "); 
        String name = scan.nextLine();
        System.out.print("How old are you?: ");
        String age = scan.nextLine();
        System.out.print("Where did you go to college?: ");
        String college = scan.nextLine();
        System.out.print("What is your pets name?: ");
        String pet = scan.nextLine();
        System.out.println("");
        System.out.println("Hello, my name is " + name + " and I "
                + "am " + age + " years \nold. I'm enjoying my time "
                + "at " + college + ", though \nI miss my "
                + "pet " + pet + " very much!");        
}
}