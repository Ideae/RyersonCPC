
import java.util.Scanner;

public class TrainPassengers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int stops = sc.nextInt();
        int current = 0;

        for(int i = 0; i < stops; i++)
        {
            int off = sc.nextInt();
            int on = sc.nextInt();
            int waiting = sc.nextInt();

            current -= off;
            if (current < 0)
            {
                System.out.println("impossible");
                return;
            }
            current+= on;
            if (current > capacity)
            {
                System.out.println("impossible");
                return;
            }
            if ((i == stops - 1 || current != capacity) && waiting > 0)
            {
                System.out.println("impossible");
                return;
            }

        }
        if (current != 0)
        {
            System.out.println("impossible");
            return;
        }
        System.out.println("possible");
    }
}
