
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class FlexibleSpaces {

    public static void main(String[] args) {
	// write your code here
        TreeSet<Integer> set = new TreeSet<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int n = sc.nextInt();
        list.add(0);
        for (int i = 0; i < n; i++)
        {
            list.add(sc.nextInt());
        }
        list.add(max);

        for(int i = 0; i < list.size(); i++)
        {
            for(int j = i + 1; j < list.size(); j++)
            {
                set.add(list.get(j) - list.get(i));
            }
        }
        for(int i : set)
        {
            System.out.printf("%d ", i);
        }
    }
}
