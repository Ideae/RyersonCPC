
import java.util.BitSet;
import java.util.Scanner;

public class PrimeSieve {

    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        BitSet sieve = new BitSet(n+1);
        //boolean[] sieve = new boolean[n+1];
        sieve.set(0); sieve.set(1);
        //sieve[0] = sieve[1] = true;
        int p = 3, count = 0;
        while(true)
        {
            int mult = (int)Math.pow(p, 2);//p * 2; //p^2 ?
            while(mult <= n)
            {
                if (!sieve.get(mult))
                {
                    count++;
                    sieve.set(mult);
                    //System.out.println(mult);
                }
                mult += 2 * p;
            }
            int next = p + 2;
            boolean found = false;
            while(next <= n)
            {
                if (!sieve.get(next))
                {
                    p = next;
                    found = true;
                    break;
                }
                next+=2;
            }
            if (!found) break;
        }
        System.out.println((n - count - (n / 2)));
        System.out.println(System.currentTimeMillis() - time);
        for(int i = 0; i < q; i++)
        {
            int num = sc.nextInt();
            int output = num % 2 == 0 && num != 2 ? 0 : sieve.get(num) ? 0 : 1;
            System.out.println(output);
        }
    }
}
//long mem = Runtime.getRuntime().freeMemory();
////boolean[] a = new boolean[10000];
//BitSet bs = new BitSet(100000);
//bs.set(9999);
//System.out.println(bs.get(998));
//System.out.println("mem :" + (mem - Runtime.getRuntime().freeMemory()));
