

import java.util.Scanner;

public class EightQueens2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rows = new int[8];
        int[] cols = new int[8];
        int[] diags = new int[16];
        int[] diags2 = new int[16];
        for(int row = 0; row < 8; row++){
            String line = sc.nextLine();
            for(int col = 0; col < 8; col++) {
                if (line.charAt(col) == '*') {
                    int a = ++rows[row];
                    int b = ++cols[col];
                    int c = ++diags[row+col];
                    int d = ++diags2[row-col+8];
                    if (a > 1 || b > 1 || c > 1 || d > 1){
                        System.out.println("invalid");
                        return;
                    }
                }
            }
        }
        System.out.println("valid");
    }
}
