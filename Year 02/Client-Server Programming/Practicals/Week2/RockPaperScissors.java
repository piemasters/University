package year2.CSP.Week2;

import java.util.Scanner;

public class RockPaperScissors {

    private final int ROCK = 0;
    private final int PAPER = 1;
    private final int SCISSORS = 2;
    private int choice;
    private String choiceChosen;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String userChoice, compChoice, winner;

        RockPaperScissors user = new RockPaperScissors();
        RockPaperScissors comp = new RockPaperScissors();

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

        System.out.print("User Shows: \t");
        userChoice = scan.nextLine();
        System.out.println("Computer Shows: " + compChoice);

        if ("rock".equalsIgnoreCase(compChoice)) {
            if ("rock".equalsIgnoreCase(userChoice)) {
                winner = "Tie";
            } else if ("scissors".equalsIgnoreCase(userChoice)) {
                winner = "You Lose";
            } else if ("paper".equalsIgnoreCase(userChoice)) {
                winner = "You Win!";
            } else {
                winner = "Please enter a valid choice.";
            }
        } else if ("scissors".equalsIgnoreCase(compChoice)) {
            if ("rock".equalsIgnoreCase(userChoice)) {
                winner = "You Win!";
            } else if ("scissors".equalsIgnoreCase(userChoice)) {
                winner = "Tie";
            } else if ("paper".equalsIgnoreCase(userChoice)) {
                winner = "You Lose";
            } else {
                winner = "Please enter a valid choice.";
            }
        } else if ("paper".equalsIgnoreCase(compChoice)) {
            if ("rock".equalsIgnoreCase(userChoice)) {
                winner = "You Lose";
            } else if ("scissors".equalsIgnoreCase(userChoice)) {
                winner = "You Win!";
            } else if ("paper".equalsIgnoreCase(userChoice)) {
                winner = "Tie";
            } else {
                winner = "Please enter a valid choice.";
            }
        } else {
            winner = "Error";
        }

        //-----Display Result------

        System.out.println("Result: \t" + winner + "\n");
    }

    public void select() {
        choice = (int) (Math.random() * 3);
    }

    public boolean isRock() {
        return (choice == ROCK);
    }

    public boolean isScissors() {
        return (choice == SCISSORS);
    }

    public boolean isPaper() {
        return (choice == PAPER);
    }
}
