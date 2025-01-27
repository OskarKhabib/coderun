package Programmer_on_the_beach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner in = new Scanner(System.in);
        int Test = in.nextInt();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Callable<Integer>> tasks = new ArrayList<>();

        for (int i = 0; i < Test; i++) {
            final int n = in.nextInt();
            int[] sun_beds = new int[n];
            for (int j = 0; j < n; j++) {
                sun_beds[j] = in.nextInt();
            }

            // Создаем задачу для вычисления минимального XOR
            tasks.add(() -> {
                Arrays.sort(sun_beds);
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < n - 1; j++) {
                    int xor = sun_beds[j] ^ sun_beds[j + 1];
                    if (xor < min) {
                        min = xor;
                    }
                }
                return min;
            });
        }

        // Запуск задач параллельно
        List<Future<Integer>> results = executor.invokeAll(tasks);

        // Выводим результаты
        for (Future<Integer> result : results) {
            System.out.println(result.get());
        }

        // Завершаем работу пула потоков
        executor.shutdown();
    }
}
