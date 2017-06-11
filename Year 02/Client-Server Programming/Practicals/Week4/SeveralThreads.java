package year2.CSP.Week4;

import java.util.Scanner;

public class SeveralThreads {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter 1 or 2: ");
        int option = scan.nextInt();
        switch (option) {
            case 1:
                Question1();
                break;
            case 2:
                Question2();
                break;
            default:
                System.out.println("Wrong Input");
                break;
        }

    }//main

    private static void Question1() {

        MyThread t1, t2;

        //create threads	
        t1 = new MyThread("t1");
        t2 = new MyThread("t2");

        //start threads
        t1.start();
        t2.start();

    }

    private static void Question2() {

        MyThread t3 = new MyThread("t3");
        MyThread t4 = new MyThread("t4");

        Thread tt3 = new Thread(t3);
        Thread tt4 = new Thread(t4);

        tt3.start();
        tt4.start();
    }
}//SeveralThreads
