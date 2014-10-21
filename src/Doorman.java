
import java.util.Scanner;

public class Doorman {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        int max = sc.nextInt(); sc.nextLine();
        String l = sc.nextLine();
        StringBuilder line = new StringBuilder(l);

        int balance = 0;
        while(line.length() > 0)
        {
            char c1 = line.charAt(0);
            if (line.length() == 1)
            {
                line.deleteCharAt(0);
                balance += genderValue(c1);
            }
            else
            {
                char c2 = line.charAt(1);
                if (balance > 0)
                {
                    if (c1 == 'W')
                    {
                        line.deleteCharAt(0);
                        balance += genderValue(c1);
                    } else
                    {
                        line.deleteCharAt(1);
                        balance += genderValue(c2);
                    }
                } else if (balance < 0)
                {
                    if (c1 == 'M')
                    {
                        line.deleteCharAt(0);
                        balance += genderValue(c1);
                    } else
                    {
                        line.deleteCharAt(1);
                        balance += genderValue(c2);
                    }
                } else
                {
                    line.deleteCharAt(0);
                    balance += genderValue(c1);
                }
            }
            if (Math.abs(balance) > max)
            {
                System.out.println(peopleLetIn-1);
                return;
            }
        }
        System.out.println(peopleLetIn);
    }
    static int peopleLetIn = 0;
    static int genderValue(char g)
    {
        peopleLetIn++;
        if (g == 'M') return 1;
        else if (g == 'W') return -1;
        return 0;
    }
}
