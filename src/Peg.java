
import java.util.Scanner;

public class Peg {
    static char[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new char[7][7];
        for(int i = 0; i < 7; i++)
        {
            String line = sc.nextLine();
            for(int j = 0; j < 7; j++)
            {
                board[i][j] = line.charAt(j);
            }
        }
        int moves = 0;
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                if (board[i][j] == '.')
                {
                    if (i + -2 >= 0) moves += checkDirection(i,j,-1,0);
                    if (i + 2 < 7) moves += checkDirection(i,j,1,0);
                    if (j + -2 >= 0) moves += checkDirection(i,j,0,-1);
                    if (j + 2 < 7) moves += checkDirection(i,j,0,1);
                }
            }
        }
        System.out.println(moves);
    }
    static int checkDirection(int xpos, int ypos, int xdir, int ydir)
    {
        if (board[xpos + xdir][ypos + ydir] == 'o' && board[xpos + xdir * 2][ypos + ydir * 2] == 'o')
        {
            return 1;
        }
        return 0;
    }
}
