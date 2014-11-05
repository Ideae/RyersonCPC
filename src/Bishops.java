import java.util.Scanner;

/**
 * Created by zacktibia on 2014-10-30.
 */
public class Bishops {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt())
        {
            int n = sc.nextInt();
            if (n == 1)
            {
                System.out.println(1);
            }
            else {
                System.out.println(n + (n - 2));
            }

        }
    }
}
