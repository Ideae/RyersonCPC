
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Babelfish {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> dict = new HashMap<String, String>();
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            if (line.equals(""))
            {
                break;
            }
            StringTokenizer st = new StringTokenizer(line);
            String v = st.nextToken(), k = st.nextToken();
            dict.put(k, v);

        }
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            if (!dict.containsKey(line))
            {
                System.out.println("eh");
            }
            else
            {
                System.out.println(dict.get(line));
            }
        }
    }
}
