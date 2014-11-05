import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by zacktibia on 2014-11-04.
 */
public class UrgeToMerge {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int cases= 0;
        boolean[] check = new boolean[71];
        while(true){
            cases++;
            final int cols = sc.nextInt();
            if (cols == 0)return;
            int[][] grid = new int[3][cols];
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            int[] threads = new int[8];

            threads[3] = grid[0][0] * grid[1][0];
            threads[6] = grid[1][0] * grid[2][0];
            threads[7] = (threads[3]>threads[6]?threads[3]:threads[6]);

            int i;
            for (i = 0; i < cols-1; i++) {
                int[] oldThreads = threads;
                threads = new int[8];
                int a, b, c, d, e;
                int temp;

                a = grid[0][i] * grid[0][i+1];
                b = grid[1][i] * grid[1][i+1];
                c = grid[2][i] * grid[2][i+1];
                d = grid[0][i] * grid[1][i];
                e = grid[1][i] * grid[2][i];

                threads[7] = oldThreads[0]+a+b+c;
                threads[6] = oldThreads[0]+b+c;
                threads[5] = oldThreads[0]+a+c;
                threads[4] = oldThreads[0]+c+d;
                threads[3] = oldThreads[0]+a+b;
                threads[2] = oldThreads[0]+b;
                threads[1] = oldThreads[0]+a+e;
                threads[0] = oldThreads[0]+(e>d?e:d);


                temp = oldThreads[1]+b+c;           if (temp > threads[6]){threads[6]=temp;}
                temp = oldThreads[1]+c;             if (temp > threads[4]){threads[4]=temp;}
                temp = oldThreads[1]+b;             if (temp > threads[2]){threads[2]=temp;}
                temp = oldThreads[1]+e;             if (temp > threads[0]){threads[0]=temp;}
                temp = oldThreads[2]+a+c;           if (temp > threads[5]){threads[5]=temp;}
                temp = oldThreads[2]+c;             if (temp > threads[4]){threads[4]=temp;}
                temp = oldThreads[2]+a;             if (temp > threads[1]){threads[1]=temp;}
                temp = oldThreads[2];               if (temp > threads[0]){threads[0]=temp;}
                temp = oldThreads[3]+c;             if (temp > threads[4]){threads[4]=temp;}
                temp = oldThreads[2];               if (temp > threads[0]){threads[0]=temp;}
                temp = oldThreads[4]+a+b;           if (temp > threads[3]){threads[3]=temp;}
                temp = oldThreads[4]+b;             if (temp > threads[2]){threads[2]=temp;}
                temp = oldThreads[4]+a;             if (temp > threads[1]){threads[1]=temp;}
                temp = oldThreads[4]+d;             if (temp > threads[0]){threads[0]=temp;}
                temp = oldThreads[5]+b;             if (temp > threads[2]){threads[2]=temp;}
                temp = oldThreads[5];               if (temp > threads[0]){threads[0]=temp;}
                temp = oldThreads[6]+a;             if (temp > threads[1]){threads[1]=temp;}
                temp = oldThreads[6];               if (temp > threads[0]){threads[0]=temp;}
                temp = oldThreads[7];               if (temp > threads[0]){threads[0]=temp;}
            }


            int d, e;

            d = grid[0][i] * grid[1][i];
            e = grid[1][i] * grid[2][i];

            threads[0] += (e>d?e:d);
            threads[4] +=d;
            threads[1] +=e;
            int n = maxValue(threads);
            System.out.println("Case "+ cases+": "+ n);
        }
    }
    private static int maxValue(int[] vals) {
        int max = vals[0];
        for (int ktr = 0; ktr < vals.length; ktr++) {
            if (vals[ktr] > max) {
                max = vals[ktr];
            }
        }
        return max;
    }
}
