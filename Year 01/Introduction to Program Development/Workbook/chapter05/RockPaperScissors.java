package chapter05;

import java.util.Scanner;

/*******************************************************************************
 * Question  5.7 (page 290)     
 * Design and implement an application that plays the Rock-Paper-Scissors game
 * against the computer. When played between two people, each person picks one 
 * of three options(usually shows as a hand gesture) at the same time, and a
 * winner is determined. In the game, Rock beats Scissors, Scissors beats Paper,
 * Paper beats Rock. The program should randomly choose one of the three 
 * options, (without revealing it) then prompt for the user's selection. At that
 * point, the program reveals both choices and prints a statement indicating if
 * the user won, the computer won, or if it was a tie. Continue playing until 
 * the user chooses to stop, then print the number of user wins, loses and ties.
 ******************************************************************************/
public class RockPaperScissors {

    private final int ROCK = 0;
    private final int PAPER = 1;
    private final int SCISSORS = 2;
    private int choice;
    private String choiceChosen;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        RockPaperScissors user = new RockPaperScissors();
        RockPaperScissors comp = new RockPaperScissors();

        String again = "y", userChoice, compChoice, winner = "Blank";
        int wins = 0, ties = 0, loses = 0;

        System.out.print("----------Rock, Paper, Scissors----------\n"
                + "\n The aim of the game is to pick the option that beats "
                + "the computer's selection."
                + "\n In the game Rock beats Scissors, Scissors beats Paper,"
                + " Paper beats Rock. \n To make a selection, type either: "
                + "'Rock', 'Scissors' or 'Paper'.\n Enter 'n' to quit.\n\n");

        do {

            // -----Get Computer Input-----

            comp.select();

            if (comp.isRock()) {
                compChoice = "Rock";
            } else if (comp.isScissors()) {
                compChoice = "Scissors";
            } else if (comp.isPaper()) {
                compChoice = "Paper";
            } else {
                compChoice = "Error";
            }

            // -----Get User Input-----


            System.out.print("User Shows: \t");
            userChoice = scan.nextLine();
            System.out.println("Computer shows: " + compChoice);

//            if ("rock".equals(userChoice)) {
//                userChoice = "Rock";
//            }
//            else if ("scissors".equals(userChoice)) {
//                userChoice = "Scissors";
//            }

            // -----Find Winner-----
            if ("rock".equalsIgnoreCase(compChoice)) {
                if ("rock".equalsIgnoreCase(userChoice)) {
                    winner = "Tie";
                    ties = ties + 1;
                } else if ("scissors".equalsIgnoreCase(userChoice)) {
                    winner = "You Lose";
                    loses = loses + 1;
                } else if ("paper".equalsIgnoreCase(userChoice)) {
                    winner = "You Win!";
                    wins = wins + 1;
                } else {
                    winner = "Please enter a valid choice.";
                }
            } else if ("scissors".equalsIgnoreCase(compChoice)) {
                if ("rock".equalsIgnoreCase(userChoice)) {
                    winner = "You Win!";
                    wins = wins + 1;
                } else if ("scissors".equalsIgnoreCase(userChoice)) {
                    winner = "Tie";
                    ties = ties + 1;
                } else if ("paper".equalsIgnoreCase(userChoice)) {
                    winner = "You Lose";
                    loses = loses + 1;
                } else {
                    winner = "Please enter a valid choice.";
                }
            } else if ("paper".equalsIgnoreCase(compChoice)) {
                if ("rock".equalsIgnoreCase(userChoice)) {
                    winner = "You Lose";
                    loses = loses + 1;
                } else if ("scissors".equalsIgnoreCase(userChoice)) {
                    winner = "You Win!";
                    wins = wins + 1;
                } else if ("paper".equalsIgnoreCase(userChoice)) {
                    winner = "Tie";
                    ties = ties + 1;
                } else {
                    winner = "Please enter a valid choice.";
                }
            } else {
                winner = "Error";
            }

            //-----Display Result------

            System.out.println("Result: \t" + winner + "\n");

        } while (!userChoice.equalsIgnoreCase("n"));

        //Session Roundup
        System.out.println("Wins: \t" + wins + "\tTies: \t" + ties
                + "\tLoses: \t" + loses);

    }
    //-----------------------------------------------------------------
    //  Constructer
    //-----------------------------------------------------------------

    public RockPaperScissors() {
        select();
    }

    //-----------------------------------------------------------------
    //  Randomly selects a hand gesture.
    //-----------------------------------------------------------------
    public void select() {
        choice = (int) (Math.random() * 3);
    }

    //-----------------------------------------------------------------
    //  Returns true if the hand gesture is Rock.
    //-----------------------------------------------------------------
    public boolean isRock() {
        return (choice == ROCK);
    }

    //-----------------------------------------------------------------
    //  Returns true if the hand gesture is Scissors.
    //-----------------------------------------------------------------
    public boolean isScissors() {
        return (choice == SCISSORS);
    }

    //-----------------------------------------------------------------
    //  Returns true if the hand gesture is Paper.
    //-----------------------------------------------------------------
    public boolean isPaper() {
        return (choice == PAPER);
    }

    //-----------------------------------------------------------------
    //  Returns the current gesture as a string.
    //-----------------------------------------------------------------
    public String toString() {

        if (choice == ROCK) {
            choiceChosen = "Rock";
        } else if (choice == SCISSORS) {
            choiceChosen = "Scissors";
        } else if (choice == PAPER) {
            choiceChosen = "Paper";
        } else {
            choiceChosen = "Error";
        }

        return choiceChosen;
    }
}