package Plus_City;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Чтение входных данных
        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        sc.nextLine(); // Пропуск оставшейся части строки

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        // Вычисление префиксных сумм
        int[][] prefix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
                if (grid[i - 1][j - 1] == 'x') {
                    prefix[i][j]++;
                }
            }
        }

        // Бинарный поиск по размеру квадрата
        int left = 0, right = Math.min(n, m);
        int maxSize = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canPlaceSquare(prefix, n, m, d, mid)) {
                maxSize = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(maxSize);
    }

    // Проверка, можно ли разместить квадрат размера k
    private static boolean canPlaceSquare(int[][] prefix, int n, int m, int d, int k) {
        if (k == 0) return true;

        // Область, в которой не должно быть жилых объектов
        int buffer = d;

        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {
                // Координаты области, отстоящей на d клеток от квадрата
                int x1 = Math.max(0, i - buffer);
                int y1 = Math.max(0, j - buffer);
                int x2 = Math.min(n - 1, i + k - 1 + buffer);
                int y2 = Math.min(m - 1, j + k - 1 + buffer);

                // Количество жилых объектов в области
                int count = prefix[x2 + 1][y2 + 1] - prefix[x1][y2 + 1] - prefix[x2 + 1][y1] + prefix[x1][y1];

                // Если в области нет жилых объектов, квадрат можно разместить
                if (count == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}