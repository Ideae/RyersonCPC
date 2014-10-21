
public class SeveralBits {

    public static void main(String[] args) {
	// write your code here

        int j = 3;
        int a = 1 << j;
        a |= 1 << 2;
        System.out.println(a);

        System.out.println((a & (1 << 2)) != 0);
    }
}
