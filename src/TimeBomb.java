
import java.util.HashMap;
import java.util.Scanner;

public class Timebomb {

    public static void main(String[] args) {
	// write your code here
        HashMap<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
        numberMap.put(31599,0);
        numberMap.put(4681, 1);
        numberMap.put(29671,2);
        numberMap.put(29647,3);
        numberMap.put(23497,4);
        numberMap.put(31183,5);
        numberMap.put(31215,6);
        numberMap.put(29257,7);
        numberMap.put(31727,8);
        numberMap.put(31695,9);


        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int numberCount = (line.length() + 1) / 4;
        int[] numbers = new int[numberCount];
        for(int i = 0; i < 5; i++)
        {
            if (i != 0)
                line = sc.nextLine();
            for(int j = 0; j < numberCount; j++)
            {
                int start = j * 4;
                numbers[j] <<= 1; numbers[j] |= ((line.length() > start && (line.charAt(start) == '*')) ? 1 : 0);
                numbers[j] <<= 1; numbers[j] |= ((line.length() > start+1 && (line.charAt(start+1) == '*')) ? 1 : 0);
                numbers[j] <<= 1; numbers[j] |= ((line.length() > start+2 && (line.charAt(start+2) == '*')) ? 1 : 0);
            }
        }
        int total = 0;
        for(int j = 0; j < numberCount; j++)
        {
            //System.out.printf("%d : %d\n", j, numbers[j]);
            if (!numberMap.containsKey(numbers[j]))
            {
                System.out.println("BOOM!!");
                return;
            }
            int power = numberCount - j - 1;
            total += numberMap.get(numbers[j]) * Math.pow(10, power);
        }
        if (total % 6 == 0)
        {
            System.out.println("BEER!!");
        }
        else
        {
            System.out.println("BOOM!!");
        }
    }
}
