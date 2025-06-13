package Awake_Apartments;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        scanner.nextLine();

        int totalAwake = 0;
        int apartmentHeight = x;
        int apartmentWidth = y;
        int threshold = (x * y + 1) / 2;

        char[][] house = new char[n * x][m * y];
        for (int i = 0; i < n * x; i++) {
            house[i] = scanner.nextLine().toCharArray();
        }

        for (int floor = 0; floor < n; floor++) {
            for (int apartment = 0; apartment < m; apartment++) {
                int lightCount = 0;

                for (int i = 0; i < apartmentHeight; i++) {
                    for (int j = 0; j < apartmentWidth; j++) {
                        if (house[floor * x + i][apartment * y + j] == 'X') {
                            lightCount++;
                        }
                    }
                }

                if (lightCount >= threshold) {
                    totalAwake++;
                }
            }
        }

        System.out.println(totalAwake);
    }
}
