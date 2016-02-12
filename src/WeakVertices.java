
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by ZackLapt on 2016-02-10.
 */
public class WeakVertices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == -1) break;
            HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
            for (int r = 0; r < n; r++) {
                ArrayList<Integer> adjacents = new ArrayList<>();
                for(int c = 0; c < n; c++) {
                    int isAdjacent = sc.nextInt();
                    if (isAdjacent == 1) adjacents.add(c);
                }
                graph.put(r, adjacents);
            }
            HashSet<Integer> strong = new HashSet<>();
            ArrayList<Integer> weak = new ArrayList<>();
            for (int v = 0; v < n; v++) {
                if (strong.contains(v)) continue;
                ArrayList<Integer> adjacents = graph.get(v);
                boolean found = false;
                for(int i = 0; i < adjacents.size(); i++) {
                    for(int j = i + 1; j < adjacents.size(); j++) {
                        int neighbour1 = adjacents.get(i);
                        int neighbour2 = adjacents.get(j);
                        if (graph.get(neighbour1).contains(neighbour2)
                         || graph.get(neighbour1).contains(neighbour2)) {
                            strong.add(v);
                            strong.add(neighbour1);
                            strong.add(neighbour2);
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }
                if (!found) weak.add(v);
            }
            for (int i = 0; i < weak.size(); i++) {
                System.out.print(weak.get(i));
                if (i != weak.size() - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}







/*int[][] matrix = new int[n][n];
            for (int r = 0; r < n; r++) {
                for(int c = 0; c < n; c++) {
                    matrix[c][r] = sc.nextInt();
                }
            }*/
