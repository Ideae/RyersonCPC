
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PlantingTrees {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        int highest = 0;
        for(int i = list.size() - 1; i >= 0; i--)
        {
            int days = list.get(i);
            if (days > highest) highest = days;
            highest--;
        }
        System.out.println(highest + 2 + list.size());
    }
}
