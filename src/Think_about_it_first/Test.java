package Think_about_it_first;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();

        System.out.println(getSum(n, l, r));
    }

    // Метод для вычисления суммы элементов на интервале [l, r]
    private static long getSum(int n, int l, int r) {
        if (l > r) return 0;
        if (n == 1) return 1; // T1 = [1]

        int lenPrev = (1 << (n - 1)) - 1; // Длина T[n-1]

        long sum = 0;

        // 1. Если часть интервала лежит в первом T[n-1]
        if (l < lenPrev) {
            sum += getSum(n - 1, l, Math.min(r, lenPrev - 1));
        }

        // 2. Если центральный элемент n входит в интервал
        if (l <= lenPrev && r >= lenPrev) {
            sum += n;
        }

        // 3. Если часть интервала лежит во втором T[n-1]
        if (r > lenPrev) {
            sum += getSum(n - 1, Math.max(0, l - lenPrev - 1), r - lenPrev - 1);
        }

        return sum;
    }
}
