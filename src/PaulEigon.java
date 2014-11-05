import java.util.Scanner;

/**
 * Created by zacktibia on 2014-10-30.
 */
public class PaulEigon {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), p = sc.nextLong(), q = sc.nextLong();
        long a = (p + q) / n;
        if (a % 2 == 0) System.out.println("paul");
        else System.out.println("opponent");
    }
}
