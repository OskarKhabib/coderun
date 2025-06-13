package window;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int size = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if (n == 1) {
                System.out.println(arr[0]);
                return;
            }

            if (i >= size - 1)
                {
                    System.out.println(Math.min(arr[i], Math.min(arr[i-1], arr[i-2])));
                }
        }
    }
}
