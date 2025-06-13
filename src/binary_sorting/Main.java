package binary_sorting;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение входных данных
        int n = scanner.nextInt();  // Размер последовательности
        int[] arr = new int[n];  // Массив для последовательности

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Список для хранения обменов
        List<String> swaps = new ArrayList<>();

        // Два указателя: left для нулей и right для единиц
        int left = 0;
        int right = n - 1;

        // Ищем, где нужно произвести обмены
        while (left < right) {
            // Пропускаем нули на левой части
            while (arr[left] == 0 && left < right) {
                left++;
            }
            // Пропускаем единицы на правой части
            while (arr[right] == 1 && left < right) {
                right--;
            }

            // Если left < right, то делаем обмен
            if (left < right) {
                // Обмен элементов
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                // Добавляем этот обмен в список
                swaps.add(left + " " + right);  // Индексы начинаются с 0
                left++;
                right--;
            }
        }

        // Выводим результат
        System.out.println(swaps.size());
        for (String swap : swaps) {
            System.out.println(swap);
        }
    }
}
