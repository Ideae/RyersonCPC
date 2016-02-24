
import java.util.Scanner;

public class HelioCentric {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        while(sc.hasNextInt())
        {
            int earth = sc.nextInt();
            int mars = sc.nextInt();
            long days = 0;
            while (true)
            {
                if (earth == 0 && mars == 0)
                {
                    System.out.println("Case " + counter++ + ": " + days);
                    break;
                }
                int diff = 687 - mars;
                days += diff;
                earth = (earth + diff) % 365;
                mars = (mars + diff) % 687;
            }
        }
    }
}
