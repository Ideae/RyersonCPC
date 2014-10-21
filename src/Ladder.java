
import java.util.Scanner;

public class Ladder {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        double height = sc.nextDouble();
        double angle = sc.nextDouble();
        double hyp = height / (Math.sin(Math.toRadians(angle)));
        System.out.println((int)Math.ceil(hyp));
    }
}
