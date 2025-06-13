package balls_and_baskets;

import java.util.Scanner;

public class balls_and_baskets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] basket = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            basket[i] = in.nextInt();
        }

        int request = in.nextInt();
        int action,left,right,sum;

        for (int i = 0; i < request; i++) {
             action = in.nextInt();
             sum = 1;
            if (action == 1) {
                left = in.nextInt();
                right = in.nextInt();
                for (int j = left; j < right+1; j++) {
                     sum *= basket[j];
                }
                System.out.println(sum%1000000007);
            }
            else {
                left = in.nextInt();
                right = in.nextInt();
                for (int j = left; j < right+1; j++) {
                    basket[j]++;
                }
            }
        }
    }
}
