
import java.util.ArrayList;
import java.util.Scanner;

public class RaggedRight {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        int longest = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(true)
        {
            String line = sc.nextLine();
            int len = line.length();
            if (len > longest) longest = len;
            if (!sc.hasNextLine())
                break;
            list.add(len);
        }
        long penalty = 0;
        for(int i : list)
        {
            penalty += (longest - i) * (longest - i);
        }
        System.out.println(penalty);
    }
}
