

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ZackLapt on 2015-10-30.
 */
public class BabsBoxBungaloo {

    static int[][] boxes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casenum = 1;
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            boxes = new int[n][];
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                boxes[n] = new int[]{a,b,c};
                Arrays.sort(boxes[n]);
            }

            Set<Integer> others = new HashSet<>();
            for (int i = 0; i < n; i++) {
                others.add(n);
            }

            traverse(others, 20, 20, 1);
        }


    }

    private static void traverse(Set<Integer> others, int x, int y, int height) {
        for(Integer i : others){
            if (((boxes[i][0] <= x) && (boxes[i][1] <=y || boxes[i][2] <= y)) ||
                    (boxes[i][1] <= x && boxes[i][2] <= y)){
                
            }
        }
    }
}
