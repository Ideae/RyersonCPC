
import java.util.Scanner;

public class EraseSecurely {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        String before = sc.next(), after = sc.next();
        boolean switched = n % 2 != 0;
        for(int i = 0; i < before.length(); i++)
        {
            char c1 = before.charAt(i);
            char c2 = after.charAt(i);
            if ((c1 == c2) == switched)
            {
                System.out.println("Deletion failed");
                return;
            }
        }
        System.out.println("Deletion succeeded");
    }
}
