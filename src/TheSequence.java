
import java.util.Scanner;

public class TheSequence {
    static int[] memo = new int[10100];
    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        for(int i = start; i <= end; i++)
        {
            findLength(i);
        }
    }
    static void findLength(int a)
    {
        if (memo[a] == 0)
        {
            int steps = 0, val = a;
            while(val > 1)
            {
                if (val % 2 == 0) val /= 2;
                else val = 3 * val + 1;
                steps++;
            }
            memo[a] = steps;
        }
        System.out.println(memo[a]);
    }
}
