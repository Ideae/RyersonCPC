
import java.util.Scanner;

public class CountingStars {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casenum = 1;
        while(sc.hasNextLine())
        {
            int yMax = sc.nextInt(), xMax = sc.nextInt(); sc.nextLine();
            char[][] sky = new char[yMax][xMax];
            for(int i = 0; i < yMax; i++)
            {
                String line = sc.nextLine();
                for(int j = 0; j < xMax; j++)
                {
                    sky[i][j] = line.charAt(j);
                }
            }
            int stars = 0;
            for(int i = 0; i < yMax; i++)
            {
                for(int j = 0; j < xMax; j++)
                {
                    if (sky[i][j] == '-')
                    {
                        stars++;
                        dfs(i,j,sky);
                    }
                }
            }
            System.out.printf("Case %d: %d\n",casenum++, stars);
        }
    }
    static void dfs(int i, int j, char[][] sky)
    {
        sky[i][j] = '.';
        int[] offsets = {1 , 0, -1, 0, 0, 1, 0, -1};
        for(int ii = 0; ii < 4; ii++)
        {
            int x = i + offsets[ii * 2];
            int y = j + offsets[ii * 2 + 1];
            if (x >= 0 && y >= 0 && x < sky.length && y < sky[0].length)
            {
                char c = sky[x][y];
                if (c == '-')
                    dfs(x, y, sky);
            }
        }
    }
}
