
import java.util.Scanner;

public class AlienNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = Integer.parseInt(sc.next());
        for(int t = 1; t <= tests; t++)
        {
            String number = sc.next();
            String sourceLang = sc.next();
            String destLang = sc.next();

            long sourceBase = sourceLang.length();
            long destBase = destLang.length();

            long decimal = 0;
            for(int i = 0; i < number.length(); i++)
            {
                char c = number.charAt(i);
                long power = number.length() - i - 1;
                decimal += sourceLang.indexOf(c) * Math.pow(sourceBase, power);
            }
            StringBuilder destNumber = new StringBuilder();
            while(true)
            {
                long remainder = decimal % destBase;
                destNumber.insert(0, destLang.charAt((int)remainder));
                decimal = decimal / destBase;
                if (decimal == 0)
                {
                    break;
                }
            }
            System.out.printf("Case #%d: %s\n", t, destNumber.toString());
        }
    }
}
