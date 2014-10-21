
import java.util.Scanner;

public class NumbersOnaTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = Integer.parseInt(sc.next());
        //long total = (long)Math.pow(2, height+1) - 1;
        long total = 1;
        total <<= (height + 1);
        total -= 1;

        if (!sc.hasNext())
        {
            System.out.println(total);
            return;
        }
        String path = sc.next();
        long pos = 1;
        for(int i = 0; i < path.length(); i++)
        {
            char c = path.charAt(i);
            if (c == 'L')
            {
                //pos = pos * 2;
                pos <<= 1;
            }
            else if (c == 'R')
            {
                //pos = pos * 2 + 1;
                pos <<= 1;
                pos |= 1;
            }
        }
        long val = total - pos + 1;
        System.out.println(val);
    }
}
