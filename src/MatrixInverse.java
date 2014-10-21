
import java.util.Scanner;

public class MatrixInverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = 1;
        while(sc.hasNextInt())
        {
            int a = sc.nextInt(), b = sc.nextInt(),
                c = sc.nextInt(), d = sc.nextInt();
            int div = a * d - b * c;
            System.out.printf("Case %d:\n%d %d\n%d %d\n", cases++, d / div, -b / div, -c / div, a / div);
        }
    }
}
