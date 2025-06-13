package decorate_the_Christmas_tree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 1; i < n+1; i++) {
            sum += Math.pow(2, i-1);

        }
        System.out.println(sum);
    }
}
