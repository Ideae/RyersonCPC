
import java.util.Scanner;

public class MixedFractions {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt())
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0)
            {
                return;
            }
            int whole = a / b;
            int mod = a % b;
            System.out.printf("%d %d / %d\n", whole, mod, b);
        }
    }
}
