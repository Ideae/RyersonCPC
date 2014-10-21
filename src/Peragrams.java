
import java.util.HashMap;
import java.util.Scanner;

public class Peragrams {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (!map.containsKey(c))
            {
                map.put(c, 1);
            }
            else
            {
                map.put(c, map.get(c) + 1);
            }
        }
        int odds = 0;
        for(Character c : map.keySet())
        {
            int amount = map.get(c);
            if (amount % 2 != 0) odds++;
        }
        int r = Math.max(0, odds - 1);
        System.out.println(r);
    }
}
