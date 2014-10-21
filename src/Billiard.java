
import java.util.Scanner;

public class Billiard {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt())
        {
            int horzSize = sc.nextInt();
            int vertSize = sc.nextInt();
            int seconds = sc.nextInt();
            int vertBounces = sc.nextInt();
            int horzBounces = sc.nextInt();
            if (horzSize == 0 && vertSize == 0 && seconds == 0 && vertBounces == 0 && horzBounces == 0) return;
            double x = horzSize * vertBounces;
            double y = vertSize * horzBounces;
            double dist = Math.sqrt(x * x + y * y);
            double angle = Math.toDegrees(Math.atan2(y, x));
            double speed = dist / seconds;
            System.out.printf("%.2f %.2f\n",angle, speed);

        }

    }
}
