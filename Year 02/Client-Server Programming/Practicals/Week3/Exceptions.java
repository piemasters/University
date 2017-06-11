/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package year2.CSP.Week3;

public class Exceptions {

    public static void main(String[] args) {
        int k = 10;
        int[] A = {1, 2, 3}; 
        String S = "hey";
        
        int j = 1 / k;
        int len = A.length + 1;
        char c;

        try {
            c = S.charAt(0);
            if (k == 10) {
                j = A[3];
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("array error");
        } catch (ArithmeticException ex) {
            System.out.println("arithmetic error");
        } catch (NullPointerException ex) {
            System.out.println("null ptr");
        } finally {
            System.out.println("in finally clause");
        }
        System.out.println("after try block");

    }
}
