

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ZackLapt on 2015-10-30.
 */
public class FlashMob{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casenum = 1;
        while(true){
            int n = sc.nextInt();
            if (n==0) break;
            int[] xs = new int[n];
            int[] ys = new int[n];
            for (int i = 0; i < n; i++) {
                xs[i] = sc.nextInt();
                ys[i] = sc.nextInt();
            }
            Arrays.sort(xs);
            Arrays.sort(ys);

            int midx = xs[(n / 2 + n % 2) - 1];
            int midy = ys[(n / 2 + n % 2) - 1];
            int dif = 0;
            for (int i = 0; i < n; i++) {
                int dx = xs[i] - midx;
                if(dx<0)dx = -dx;
                int dy = ys[i] - midy;
                if(dy<0)dy = -dy;
                dif += dx+dy;
            }
            System.out.println("Case " + casenum++ + ": ("+midx + "," + midy + ") " + dif);
        }
    }
}
