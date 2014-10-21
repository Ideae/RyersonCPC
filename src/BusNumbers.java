
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BusNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> l = new ArrayList<Integer>();
        for(int i = 0; i < n; i++)
        {
            l.add(sc.nextInt());
        }
        Collections.sort(l);
        int start = 0, last = 0;
        boolean nextStart = true;
        for(int i = 0; i < l.size();i++)
        {
            int num = l.get(i);

            if (nextStart)
            {
                start = num;
                last = num;
                nextStart = false;
            }
            else
            {
                last = num;
            }
            if (i == l.size() - 1 || l.get(i+1) - num > 1)
            {
                if (last == start)
                {
                    System.out.printf("%d ", start);
                }
                else if (last - start == 1)
                {
                    System.out.printf("%d %d ", start, last);
                }
                else
                {
                    System.out.printf("%d-%d ", start, last);
                }
                nextStart = true;
            }
        }
    }
}
