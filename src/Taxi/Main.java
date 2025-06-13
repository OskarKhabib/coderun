package Taxi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Чтение входных данных
        int N = sc.nextInt(); // Количество событий
        int L = sc.nextInt(); // Длина круга
        int S = sc.nextInt(); // Максимальная скорость
        sc.nextLine(); // Пропуск оставшейся части строки

        // Хранение последних известных позиций таксистов
        Map<Integer, TaxiInfo> taxiMap = new HashMap<>();

        // Обработка событий
        for (int i = 0; i < N; i++) {
            String eventType = sc.next();
            if (eventType.equals("TAXI")) {
                // Обработка события TAXI
                long timestamp = sc.nextLong();
                int taxiId = sc.nextInt();
                int taxiPosition = sc.nextInt();
                sc.nextLine(); // Пропуск оставшейся части строки

                // Обновляем информацию о таксисте
                taxiMap.put(taxiId, new TaxiInfo(timestamp, taxiPosition));
            } else if (eventType.equals("ORDER")) {
                // Обработка события ORDER
                long timestamp = sc.nextLong();
                int orderId = sc.nextInt();
                int orderPosition = sc.nextInt();
                int orderTime = sc.nextInt();
                sc.nextLine(); // Пропуск оставшейся части строки

                // Список подходящих таксистов
                List<Integer> availableTaxis = new ArrayList<>();

                // Проверяем каждого таксиста
                for (Map.Entry<Integer, TaxiInfo> entry : taxiMap.entrySet()) {
                    int taxiId = entry.getKey();
                    TaxiInfo taxiInfo = entry.getValue();

                    // Вычисляем возможный диапазон позиций таксиста
                    long deltaTime = timestamp - taxiInfo.timestamp;
                    int minPosition = (int) (taxiInfo.position - S * deltaTime) % L;
                    int maxPosition = (int) (taxiInfo.position + S * deltaTime) % L;

                    // Нормализация позиций
                    if (minPosition < 0) minPosition += L;
                    if (maxPosition >= L) maxPosition -= L;

                    // Вычисляем минимальное время до точки заказа
                    int minTime = Integer.MAX_VALUE;
                    for (int pos = minPosition; pos <= maxPosition; pos++) {
                        int distance = (orderPosition - pos + L) % L;
                        minTime = Math.min(minTime, distance);
                    }

                    // Если минимальное время <= orderTime, таксист подходит
                    if (minTime <= orderTime) {
                        availableTaxis.add(taxiId);
                    }
                }

                // Вывод результата
                if (availableTaxis.isEmpty()) {
                    System.out.println(-1);
                } else {
                    // Ограничиваем количество таксистов до 5
                    int count = Math.min(5, availableTaxis.size());
                    for (int j = 0; j < count; j++) {
                        System.out.print(availableTaxis.get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    // Класс для хранения информации о таксисте
    static class TaxiInfo {
        long timestamp; // Время последнего обновления
        int position; // Последняя известная позиция

        TaxiInfo(long timestamp, int position) {
            this.timestamp = timestamp;
            this.position = position;
        }
    }
}