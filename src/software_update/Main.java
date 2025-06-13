package software_update;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] d = new int[n]; // Время получения обновления
        int[] s = new int[n]; // Время передачи обновления
        List<Integer>[] graph = new ArrayList[n]; // Граф зависимостей

        for (int i = 0; i < n; i++) {
            d[i] = scanner.nextInt();
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }

        // Считываем граф обновлений
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            for (int j = 0; j < k; j++) {
                graph[i].add(scanner.nextInt() - 1);
            }
        }

        // Очередь для BFS: [номер телефона, время получения обновления]
        Queue<long[]> queue = new ArrayDeque<>();
        queue.add(new long[]{0, d[0]}); // Первый телефон обновлен в момент d[0]

        long maxTime = 0; // Итоговое время обновления всех телефонов

        while (!queue.isEmpty()) {
            long[] cur = queue.poll();
            int phone = (int) cur[0];   // Текущий телефон
            long time = cur[1];         // Время его обновления

            maxTime = Math.max(maxTime, time);

            long curTime = time; // Начинаем передачу с момента получения обновления
            for (int next : graph[phone]) {
                curTime += Math.max(s[phone], d[next]); // Учитываем передачу и установку
                queue.add(new long[]{next, curTime});
            }
        }

        System.out.println(maxTime-d[0]);
    }
}
