import java.util.Scanner;

/**
 * Created by zacktibia on 2014-10-23.
 */
public class AnotherCandies {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            long kids = sc.nextLong();
            long sum = 0;
            for(int j = 0; j < kids; j++)
            {
                sum += sc.nextLong() % kids;
                sum %= kids;
            }
            String result = (sum % kids == 0) ? "YES" : "NO";
            System.out.println(result);
        }
    }
}
