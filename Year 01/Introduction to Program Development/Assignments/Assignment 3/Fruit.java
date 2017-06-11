package assignments.assignment3;

import java.util.*;

/*******************************************************************************
 * Question  1 - Switch to Fruit
 * 
 * Program Names : Fruit.java
 * Example Input/Output: 
 * 
 * A Apple
 * B Blueberry
 * C Currant
 * D Dragon Fruit
 * E Elderberry
 * F Finger Lime
 * Choose a fruit from menu above: d
 * You chose "Dragon Fruit"
 *
 * This is a main/driver class. 
 * Use a switch statement to pick a novel by entering the correct character. 
 *
 * Allow the user to enter upper or lower case.
 * 
 * If the fruit is not on the list the program should output this exact string
 * That fruit is not on the list


 *****************************************************************************/
public class Fruit {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] fruit = new String[6];
        fruit[0] = "Apple";
        fruit[1] = "Blueberry";
        fruit[2] = "Currant";
        fruit[3] = "Dragon Fruit";
        fruit[4] = "Elderberry";
        fruit[5] = "Finger Lime";
        String[] letter = new String[6];
        letter[0] = "A ";
        letter[1] = "B ";
        letter[2] = "C ";
        letter[3] = "D ";
        letter[4] = "E ";
        letter[5] = "F ";

        String output;

        for (int val = 0; val <= 5; val += 1) {
            System.out.print(letter[val]);
            System.out.println(fruit[val]);
        }

        System.out.print("Choose a fruit from menu above: ");
        String selection = scan.nextLine();
        selection.toLowerCase();
        char first = selection.charAt(0);

        //char[] charray1 = selection.toCharArray();


        switch (first) {
            case 'a':
                output = (fruit[0]);
                break;
            case 'b':
                output = (fruit[1]);
                break;
            case 'c':
                output = (fruit[2]);
                break;
            case 'd':
                output = (fruit[3]);
                break;
            case 'e':
                output = (fruit[4]);
                break;
            case 'f':
                output = (fruit[5]);
                break;
            default:
                output = "That fruit is not on the list";
                break;
        }

        System.out.println("You chose \"" + output + "\"");


    }
}
