
import java.util.Scanner;
@ProblemName(name = "8queens")
public class EightQueens {
    static int[] cols;
    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        cols = new int[8];
        for(int i = 0; i < 8; i++)
        {
            cols[i] = -1;
        }
        String line = "";
        for(int r = 0; r < 8; r++)
        {
            line = sc.nextLine();
            boolean found = false;
            for(int c = 0; c < 8; c++)
            {
                char ch = line.charAt(c);
                if (ch == '*')
                {
                    if (found)
                    {
                        System.out.println("invalid");
                        return;
                    }
                    else if (cols[c] != -1)
                    {
                        System.out.println("invalid");
                        return;
                    }
                    cols[c] = r;
                    found = true;
                }
            }
            if (!found)
            {
                System.out.println("invalid");
                return;
            }
        }
        for(int i = 0; i < 8; i++)
        {
            if (backtrack(i))
            {
                return;
            }
        }
        System.out.println("valid");
    }

    static boolean backtrack(int c)
    {
        for(int cc = 0; cc < c; cc++)
        {
            if (Math.abs(cols[cc] - cols[c]) == Math.abs(cc - c))
            {
                System.out.println("invalid");
                return true;
            }
        }
        return false;
    }
}
