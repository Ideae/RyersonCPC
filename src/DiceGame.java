
import java.util.ArrayList;
import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> gSums = getSums(sc);
        ArrayList<Integer> eSums = getSums(sc);

        int gWins = 0;
        for(int i = 0; i < gSums.size(); i++)
        {
            for(int j = 0; j < eSums.size(); j++)
            {
                int g = gSums.get(i);
                int e = eSums.get(j);
                if (g > e) gWins++;
                else if (g < e) gWins--;
            }
        }
        if (gWins > 0)
        {
            System.out.println("Gunnar");
        }
        else if (gWins < 0)
        {
            System.out.println("Emma");
        }
        else
        {
            System.out.println("Tie");
        }
    }

    static ArrayList<Integer> getSums(Scanner sc)
    {
        int ga1 = sc.nextInt();
        int ga2 = sc.nextInt();
        int ga3 = sc.nextInt();
        int ga4 = sc.nextInt();
        ArrayList<Integer> sums = new ArrayList<Integer>();
        for(int i = ga1; i <= ga2; i++)
        {
            for(int j = ga3; j <= ga4; j++)
            {
                sums.add(i+j);
            }
        }
        return sums;
    }
}
