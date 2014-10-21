
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Tractor {
    static boolean[][] grid;
    static HashMap<Integer, HashSet<Integer>> mapOfSets;
    static int a, b;
    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n;i++)
        {
            a = sc.nextInt() + 1;
            b = sc.nextInt() + 1;
            count = 0;
            //grid = new boolean[a][b];
            mapOfSets = new HashMap<Integer, HashSet<Integer>>();
            recurse(0,0,1);
            System.out.println(count);
        }
    }
    static int count = 0;
    static void recurse(int x, int y, int level)
    {
        if (x >= a || y >= b)
        {
            return;
        }
        if ((mapOfSets.containsKey(x) && mapOfSets.get(x).contains(y)))
        {
            System.out.printf("OVERLAP: %d %d\n", x, y);
            return;
        }
        if (!mapOfSets.containsKey(x)) mapOfSets.put(x, new HashSet<Integer>());
        mapOfSets.get(x).add(y);
        //grid[x][y] = true;
        //System.out.printf("%d %d\n",x, y);
        count++;
        int moves = (int)Math.pow(2, level-1);
        recurse(x + moves, y, level + 1);
        recurse(x, y + moves, level + 1);
    }
}
