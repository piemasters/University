package year2.CSP.Week2;

import java.util.Scanner;

public class SampleCode {

    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        
        System.out.print("What is your name?: "); 
        String name = scan.nextLine();            
        System.out.println("Hello" + name + " \n \"Hello\" Hello");
                  
         int value1, value2;
         System.out.println("Enter a number");
         value1 = scan.nextInt();
         System.out.println("Enter another number");
         value2 = scan.nextInt();
         double total = value1 + value2;
         double average = total / 2;
         System.out.println("Total of Scores = " + (total));
         System.out.println("Total of Scores = " + (int)(total));
         System.out.println("Average of Scores = " + (average));
         
          Float number1;
          System.out.print("Enter Number 1: "); 
        number1 = scan.nextFloat();

         final double FEET_TO_CENT = 30.48;
    }
}
/*  import java.util.Scanner;
 *  import java.lang.Math;
 *  import java.text.DecimalFormat;
 *  import java.util.Random;
 *  
 *  Scanner scan = new Scanner(System.in);
 *  
 *  System.out.print("");
 *  x = scan.nextInt();
 *  x = scan.nextLine();
 *  x = scan.next();
 *  
 *  System.out.println((int)(total)); Displays value 'total' as an integer
 *  
 *  final double FEET_TO_CENT = 30.48;
 *  
 *  double distance = Math.sqrt(Math.pow((x2 - x1),2));
 *  
 *  int userLength = username.length();
 *  
 *  boolean strengthCheck = username.contentEquals(password);
 *  
 *  String prt1 = phonenumber.substring(0, 3);
 *  
 *  DecimalFormat dfCost = new DecimalFormat("£.00");
 *  System.out.println("The cost is: " + dfCost.format(x));
 *  
 *  Random rand = new Random();
 *  int randomInt;
 *  randomInt = rand.nextInt(2) + 1;
 * 
 *  if (myCount > hisCount) {
 *      System.out.println("My coin wins!");
 * } else if (myCount < hisCount) {
 *      System.out.println("His coin wins!");
 * } else {
 * System.out.println("It was a tie!");}
 *  
 *  while (myCount < 3 && hisCount < 3) {}
 *  do {
 *   } while (guess != target && guess > 0);
 *  } while (again.equalsIgnoreCase("y"));
 * 
 *  str = str.toLowerCase();
 *  str = str.replace(" ", "");
 *  x = str.length() -1;
 * 
 * System.out.println("Enter a paragraph: \n");
 * String paragraph = scan.nextLine();
 * StringTokenizer st = new StringTokenizer(paragraph);
 * while (st.hasMoreTokens()) {
 *      word = st.nextToken();
 *      wordCount = wordCount + 1;
 * }
 * charCount = charCount + paragraph.length();
 * sentence = sentence.replace("", "\n");
 *  
 * switch (paragraph.charAt(i)) {
 *      case 'a':
 *          aCount++;
 *          break;
 *      case 'e':
 *          eCount++;
 *          break;
 *      default:
 *          break; }
 * 
 * int [] nums = new int[10];
 * String [] ss = new String[5];
 * ss[3] = "hello";
 * System.out.println("3 is: " + nums[3]);
 * System.out.println("length is " + ss[3].length());
 * 
 * 
 */