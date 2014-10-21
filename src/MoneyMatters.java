
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MoneyMatters {
    static HashSet<Integer> visited;
    static HashMap<Integer, ArrayList<Integer>> graph;
    static int[] owes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int friends = sc.nextInt();
        int relationships = sc.nextInt();
        owes = new int[friends];
        graph = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < friends; i++)
        {
            owes[i] = sc.nextInt();
            graph.put(i, new ArrayList<Integer>());
        }
        for(int i = 0; i < relationships; i++)
        {
            int a = sc.nextInt(), b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        visited = new HashSet<Integer>();
        for(int i = 0; i < friends; i++)
        {
            dfs(i);
            if (cost != 0)
            {
                System.out.println("IMPOSSIBLE");
                return;
            }
            cost = 0;
        }
        System.out.println("POSSIBLE");
    }
    static int cost = 0;
    static void dfs(int f)
    {
        if (visited.contains(f)) return;
        visited.add(f);
        cost += owes[f];
        for(int ff : graph.get(f))
        {
            dfs(ff);
        }
    }
}
