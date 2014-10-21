
import java.util.Scanner;

public class ReversedBinaryNumbers {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = 0;
        boolean found = false;
        int counter = 1;
        for(int i = 0; i < 32; i++)
        {
            int s = 1 << (32-i-1);
            if (!found)
            {
                if ((a & s) == s)
                {
                    found = true;
                    //b <<= 1;
                    b |= 1;
                }
            }
            else
            {
                b |= (((a & s) == s) ? 1 : 0) << counter++;
            }
        }
        //printBits(a);
        //System.out.println();
        //printBits(b);
        //System.out.println();

        System.out.println(b);
    }

    //static void printBits(int a)
    //{
    //    for(int i = 0; i < 32; i++)
    //    {
    //        int s = 1 << (32 - i - 1);
    //        System.out.printf("%d", ((a  & s)== s) ? 1 : 0);
    //    }
    //}
}
