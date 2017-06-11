package year2.CSP.Week3;

public class GoTooFar {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        for (int i = 0; i <= 10; i++) {

            try {
                System.out.println("Array value is " + nums[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Now you've gone to far!");
            }
        }
    }
}

