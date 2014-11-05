
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by zacktibia on 2014-10-30.
 */
public class Tourdefrance {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt())
        {
            int f = sc.nextInt();
            if (f == 0) return;
            int r = sc.nextInt();
            int[] front = new int[f];
            for(int i = 0;i < f; i++)
            {
                front[i] = sc.nextInt();
            }
            int[] rear = new int[r];
            for(int i = 0;i < r; i++)
            {
                rear[i] = sc.nextInt();
            }
            ArrayList<Double> spreads = new ArrayList<>();
            for(int i = 0; i < f; i++)
            {
                for(int j = 0; j < r; j++)
                {
                    spreads.add(rear[j] / (double)front[i]);
                }
            }
            Collections.sort(spreads);
            double max = 0;
            for(int i = 0; i < spreads.size() - 1; i++)
            {
                double a = spreads.get(i);
                double b = spreads.get(i+1);
                double c = b / a;
                if (c > max) max = c;
            }
            //max = (double)Math.round(max * 100) / 100;
            System.out.printf("%.2f\n",max);
        }
    }
}
