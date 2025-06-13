package scalar_multiplication;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();


        int[] Q = new int[N];
        for (int i = 0; i < N; i++) {
            Q[i] = sc.nextInt();
        }


        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = sc.nextInt();
        }


        int A = sc.nextInt();
        int B = sc.nextInt();


        long dotProduct = 0;
        for (int i = 0; i < N; i++) {
            int D_i = (A == B) ? A : A + (C[i] * (B - A)) / 255;
            dotProduct += (long) Q[i] * (long)D_i;
        }


        System.out.println(dotProduct);
    }
}
