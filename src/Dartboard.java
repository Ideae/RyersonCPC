

import java.util.Scanner;

/**
 * Created by ZackLapt on 2015-10-18.
 */
public class Dartboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[] rads = new float[6];
        for(int i = 0; i < 6; i++) {
            rads[i] = sc.nextFloat();
        }
        float dev = sc.nextFloat();
        float pointSum = 0;
        float[] totalProbs = new float[6];
        float[] actualProbs = new float[6];
        float[] values = {50f,25f,1f,3f,1f,2f};
        for(int i = 0; i < 6; i++) {
            totalProbs[i] = prob(rads[i], dev);
            if (i > 0) {
                actualProbs[i] = totalProbs[i] - totalProbs[i-1];
            } else {
                actualProbs[i] = totalProbs[i];

            }
            System.out.println(i + " : " + actualProbs[i]);
            if (i < 2) {
                pointSum += actualProbs[i] * values[i];
            } else {
                float subProb = actualProbs[i] / 20f;
                for(int j = 1; j <= 20; j++) {
                    pointSum += subProb * j * values[i];
                }
            }
        }
        System.out.println(pointSum);
    }

    public static float prob(float rad, float dev) {
        float dev2 = dev * dev;
        float a = 1f / (2f * (float)Math.PI * dev2);
        float exp = -((rad * rad)/(2*dev2));
        return a * (float)Math.pow(Math.E,exp);
    }
}
