
import java.util.Scanner;

public class TheEasiestProblemisThisOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt())
        {
            int N = sc.nextInt();
            if (N == 0)
            {
                return;
            }
            int NSum = checkSum(N);
            for(int i = 11; true; i++)
            {
                int p = i * N;
                int sum = checkSum(p);
                if (sum == NSum)
                {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    static int checkSum(int a)
    {
        int sum = 0;
        while(a != 0)
        {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }
}
