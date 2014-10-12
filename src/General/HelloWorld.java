package General;

/**
 * Created by David on 20/08/2014.
 */
class HelloWorld {
    public static void main(String[] args) {

        int val = 8;

        while (Math.sqrt(val) % 1 != 0 && val < 100) {
            val += 11;
        }

        double ans = Math.sqrt(val) % 11;

        if ((ans % 1) == 0) {
            int x = (int)ans;
            System.out.print(x);
        } else {
            int x = 0;
            System.out.print(x);
        }
    }
}
