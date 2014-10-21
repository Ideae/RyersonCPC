
import java.util.Scanner;

public class ArmyStrength {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for(int t = 0; t < tests; t++)
        {
            int nG = sc.nextInt();
            int nM = sc.nextInt();
            int hG = 0, hM = 0;
            for(int i = 0; i < nG; i++)
            {
                int next = sc.nextInt();
                if (next > hG) hG = next;
            }
            for(int i = 0; i < nM; i++)
            {
                int next = sc.nextInt();
                if (next > hM) hM = next;
            }
            if (hG >= hM)
            {
                System.out.println("Godzilla");
            }
            else
            {
                System.out.println("MechaGodzilla");
            }

        }
    }
}
