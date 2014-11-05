import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ClosestSums {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        while(sc.hasNextInt())
        {
            int n = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < n; i++)
            {
                list.add(sc.nextInt());
            }
            Collections.sort(list);
            int m = sc.nextInt();
            System.out.printf("Case %d:\n", counter++);
            for(int i = 0; i < m; i++)
            {
                int sum = sc.nextInt();
                int a = 0;
                int b = list.size()-1;
                int total = 0;
                int lastTotal = total;
                int closestSum = 0;
                int lowestDiff = Integer.MAX_VALUE;
                while(b != a)
                {
                    lastTotal = total;
                    total = list.get(a) + list.get(b);
                    int diff = Math.abs(sum - total);
                    if (diff <= lowestDiff)
                    {
                        lowestDiff = diff;
                        closestSum = total;
                    }

                    if(total > sum)
                        b--;
                    else if(total < sum)
                        a++;
                    else if(total == sum)
                        break;
                }
                System.out.printf("Closest sum to %d is %d.\n", sum, closestSum);
            }
        }

    }
}
