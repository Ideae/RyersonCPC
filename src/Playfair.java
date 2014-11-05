import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by zacktibia on 2014-11-04.
 */
public class Playfair {
    static boolean debug = false;
    static int replaceLetter = 0;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        for(int cases = 0; cases < n; cases++)
        {
            String key = sc.nextLine();
            String plaintext = sc.nextLine();
            replaceLetter = 0;

            boolean[] alpha = new boolean[26];
            char[][] matrix = new char[5][5];
            HashMap<Character, Point> map = new HashMap<>();

            int counter = 0;
            for(Character c : key.toUpperCase().toCharArray())
            {
                if (!c.isLetter(c)) continue;
                int index = c - 'A';
                if (alpha[index]) continue;
                alpha[index] = true;
                int rows = counter / 5;
                int cols = counter % 5;
                counter++;
                matrix[rows][cols] = c;
                map.put(c, new Point(rows, cols));
            }
            for(int i = 0; i < 26; i++)
            {
                if (alpha[i] || i == 9) continue;
                int rows = counter / 5;
                int cols = counter % 5;
                counter++;
                char c = (char)('A' + i);
                matrix[rows][cols] = c;
                map.put(c, new Point(rows, cols));
            }
            if (debug) {
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 0; j < 5; j++)
                    {
                        System.out.printf("%c ", matrix[i][j]);
                    }
                    System.out.println();
                }
            }
            plaintext = plaintext.toUpperCase();
            plaintext = plaintext.replaceAll("[^A-Z]", "");
            if (debug)
                System.out.println(plaintext);

            ArrayList<char[]> digraphs = new ArrayList<>();

            for(int i = 0; i < plaintext.length();)
            {
                char a = plaintext.charAt(i);
                if (i == plaintext.length() - 1)
                {
                    char r = getReplacement(a);
                    digraphs.add(new char[]{a, r});
                    break;
                }
                else
                {
                    char b = plaintext.charAt(i+1);
                    if (a == b)
                    {
                        char r = getReplacement(a);
                        digraphs.add(new char[]{a, r});
                        i++;
                    }
                    else
                    {
                        digraphs.add(new char[]{a, b});
                        i+=2;
                    }
                }
            }

            String result = "";
            for(char[] cs : digraphs)
            {
                if (debug) {
                    System.out.print(new String(cs) + " ");
                }
                Point p1 = map.get(cs[0]);
                Point p2 = map.get(cs[1]);
                if (p1.y == p2.y)
                {
                    result += matrix[(p1.x + 1) % 5][p1.y];
                    result += matrix[(p2.x + 1) % 5][p2.y];
                }
                else if (p1.x == p2.x)
                {
                    result += matrix[p1.x][(p1.y + 1) % 5];
                    result += matrix[p2.x][(p2.y + 1) % 5];
                }
                else
                {
                    result += matrix[p1.x][p2.y];
                    result += matrix[p2.x][p1.y];
                }
            }
            if (debug) {
                System.out.println();
            }
            System.out.printf("Case %d: %s\n", (cases + 1), result);


        }
    }
    static char getReplacement(char a)
    {
        char r = (char)('A' + replaceLetter);
        replaceLetter = (replaceLetter + 1) % 26;
        if (replaceLetter == 9) replaceLetter++;
        if (r == a) {
            r = (char) ('A' + replaceLetter);
            replaceLetter = (replaceLetter + 1) % 26;
            if (replaceLetter == 9) replaceLetter++;
        }
        return r;
    }

}
