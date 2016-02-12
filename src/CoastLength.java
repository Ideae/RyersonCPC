

import java.awt.*;
import java.util.*;

/**
 * Created by ZackLapt on 2016-02-10.
 */
public class CoastLength {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        total = 0;
        n = Integer.parseInt(sc.next());
        m = Integer.parseInt(sc.next());
        grid = new int[n][m];
        offsetsX = new int[]{-1,1,0,0};
        offsetsY = new int[]{0,0,-1,1};

        for (int r = 0; r < n; r++) {
            String s = sc.next();
            for (int c = 0; c < m; c++) {
                char ch = s.charAt(c);
                grid[r][c] = ch - '0';
            }
        }
        for(int i = 0; i < n; i++) {
            bfs(i, 0);
            if (m > 1) {
                bfs(i, m - 1);
            }
        }
        for(int i = 1; i < m-1; i++) {
            bfs(0, i);
            if (n > 1) {
                bfs(n - 1, i);
            }
        }
        System.out.println(total);
    }
    public static int n, m, total;
    public static int[][] grid;
    public static int[] offsetsX, offsetsY;
    public static Queue<Point> queue = new LinkedList<>();
    //2 = borderwater, 3 = borderland
    public static void bfs(int r, int c) {
        if (grid[r][c] == 1 || grid[r][c] == 3) {
            grid[r][c] = 3;
            if (r == 0) total++;
            if (r == n-1) total++;
            if (c == 0) total++;
            if (c == m-1) total++;
        }
        if (grid[r][c] != 0) return;
        queue.add(new Point(r, c));
        while(!queue.isEmpty()) {
            Point p = queue.remove();
            grid[p.x][p.y] = 2;
            for(int i = 0; i < offsetsX.length; i++) {
                int x = p.x + offsetsX[i];
                int y = p.y + offsetsY[i];
                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }
                int val = grid[x][y];
                if (val == 1 || val == 3) {
                    total++;
                    grid[x][y] = 3;
                }
                else if (val == 0) {
                    //grid[x][y] = 2;
                    queue.add(new Point(x,y));
                }
            }

        }
    }
}
