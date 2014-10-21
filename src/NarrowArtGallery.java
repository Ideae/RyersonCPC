
import java.util.Scanner;

public class NarrowArtGallery {
    static int[][] gallery;
    static boolean[][] closed;
    static int totalWorth = 0, lowestCost = Integer.MAX_VALUE, rows, k;
    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt())
        {
            totalWorth = 0;
            lowestCost = Integer.MAX_VALUE;
            rows = sc.nextInt();
            k = sc.nextInt();
            if (rows == 0 && k == 0)
            {
                return;
            }
            gallery = new int[rows][2];
            closed = new boolean[rows][2];
            for(int r = 0; r < rows; r++)
            {
                gallery[r][0] = sc.nextInt();
                gallery[r][1] = sc.nextInt();
                totalWorth += gallery[r][0] + gallery[r][1];
            }
            recurse(0, 0, k);
            System.out.printf("%d\n", totalWorth - lowestCost);
        }
    }

    static void recurse(int row, int currentCost, int currentK)
    {
        if (row >= rows)
        {
            if (currentK <= 0 && currentCost < lowestCost)
            {
                lowestCost = currentCost;
            }
        }
        else
        {
            if (currentK == 0)
            {
                recurse(row + 1, currentCost, currentK);
            }
            else
            {
                if (row == 0 || !closed[row - 1][0])
                {
                    closed[row][1] = true;
                    int subcost = currentCost + gallery[row][1];
                    if (subcost < lowestCost)
                    {
                        recurse(row + 1, subcost, currentK - 1);
                    }
                }
                if (row == 0 || !closed[row - 1][1])
                {
                    closed[row][1] = false;
                    closed[row][0] = true;
                    int subcost = currentCost + gallery[row][0];
                    if (subcost < lowestCost)
                    {
                        recurse(row + 1, subcost, currentK - 1);
                    }
                }
                closed[row][1] = false;
                closed[row][0] = false;
                recurse(row + 1, currentCost, currentK);
            }
        }
    }
}
