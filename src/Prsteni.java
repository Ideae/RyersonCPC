import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zacktibia on 2014-10-30.
 */
public class Prsteni {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int first = sc.nextInt();
        ArrayList<Integer> divs = new ArrayList<>();
        for(int i = first; i > 0; i--)
        {
            if (first % i == 0) divs.add(i);
        }
        for(int i = 1; i < n; i++)
        {
            int next = sc.nextInt();
            for(int a : divs)
            {
                if (next % a == 0)
                {
                    System.out.printf("%d/%d\n", (first / a), (next / a));
                    break;
                }
            }
        }
    }
}
