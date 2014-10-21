
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Units {
    static HashMap<String, HashMap<String, Integer>> factors;
    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt())
        {
            int n = sc.nextInt();
            if (n == 0) return;
            sc.nextLine();
            factors = new HashMap<String, HashMap<String, Integer>>();
            for(int i = 0; i < n; i++)
            {
                if (i == 0)
                {
                    String line = sc.nextLine();
                    StringTokenizer st = new StringTokenizer(line);
                    for(int j = 0; j < n; j++)
                    {
                        String from = st.nextToken();
                        factors.put(from, new HashMap<String, Integer>());
                    }
                }
                else
                {
                    String line = sc.nextLine();
                    StringTokenizer st = new StringTokenizer(line);
                    String from = st.nextToken();
                    st.nextToken();
                    int f = Integer.parseInt(st.nextToken());
                    String to = st.nextToken();
                    factors.get(from).put(to, f);
                    System.out.printf("%s -> %d %s\n", from, f, to);
                }

            }
        }
    }
}
