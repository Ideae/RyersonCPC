
import java.util.Scanner;

public class Alex3n1 {
    public static void main(String[] args) {
        for (Scanner s = new Scanner(System.in); s.hasNext();) { //loops lines of file
            int i = s.nextInt();
            int j = s.nextInt();
            int maxCycleLength = 0;

//           if (i > j) {
//               int temp = i;
//               i = j;
//               j = temp;
//           }

            for (int x = Math.min(i, j); x <= Math.max(i, j); x++) { //loops between [i, j]
                int cycleLength = 1;
                for (int n = x; n != 1; cycleLength++) { //loops 3n+1 problem

                    if (n % 2 == 0) n /= 2;
                    else n = 3 * n + 1;
                }
                if (maxCycleLength < cycleLength) maxCycleLength = cycleLength;
            }
            System.out.println(i+" "+j+" "+maxCycleLength);
        }
    }
}
