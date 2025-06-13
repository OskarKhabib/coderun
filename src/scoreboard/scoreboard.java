package scoreboard;

import java.util.HashMap;
import java.util.Scanner;

public class scoreboard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = 0;
        String maxname = "";
        HashMap<String, Integer> names = new HashMap<>();

        in.nextLine(); // съесть \n после числа

        // считываем имена игроков и инициализируем их счёт
        for (int i = 0; i < n; i++) {
            String player = in.nextLine().trim();
            names.put(player, 0);
        }

        int score = in.nextInt();
        in.nextLine(); // снова съесть \n

        for (int i = 0; i < score; i++) {
            String line = in.nextLine();
            String[] parts = line.split(" ");
            if (parts.length < 2) continue;

            String name = parts[1].trim();
            if (!names.containsKey(name)) continue;

            names.put(name, names.get(name) + 1);

            if (names.get(name) > max) {
                max = names.get(name);
                maxname = name;
            }
        }

        System.out.println(maxname);
    }
}
