/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package year2.CSP.Week3;

/**
 *
 * @author David
 */
public class excep {

    public static void main(String[] args) {
        try {
            method();
            System.out.println("After the method call");
        } catch (RuntimeException ex) {
            System.out.println("RuntimeException");
        } catch (Exception ex) {
            System.out.println("Exception");
        }
    }

    static void method() {
        try {
            String s = "5.6";
            Integer.parseInt(s); //Cause a NumberFormatException 
            int i = 0;
            int y = 2 / i;
            System.out.println("Welcome to Java");
        } catch (RuntimeException ex) {
            System.out.println("RuntimeException");
        } catch (Exception ex) {
            System.out.println("Exception");
        }
    }
}

