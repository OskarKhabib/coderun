package Phoenician_messages;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ввод сообщения
        String message = sc.nextLine().trim();

        // Ввод количества слов в словаре
        int n = Integer.parseInt(sc.nextLine().trim());

        // Считывание слов из словаря
        Set<String> dictionary = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dictionary.add(sc.nextLine().trim());
        }

        // Расшифровка сообщения
        String decodedMessage = decodeMessage(message, dictionary);
        System.out.println(decodedMessage);
    }

    // Функция для расшифровки сообщения
    public static String decodeMessage(String message, Set<String> dictionary) {
        // Маппинг для цифр
        Map<String, String> digitToLetterMap = createDigitToLetterMap();

        // Массив для хранения возможных разбиений
        String[] dp = new String[message.length() + 1];
        dp[0] = ""; // Начинаем с пустой строки

        // Динамическое программирование: проходим по всей строке
        for (int i = 1; i <= message.length(); i++) {
            for (int j = 0; j < i; j++) {
                String substring = message.substring(j, i);
                if (digitToLetterMap.containsKey(substring) && dp[j] != null) {
                    String word = digitToLetterMap.get(substring);
                    if (dp[i] == null) {
                        dp[i] = (dp[j].isEmpty() ? "" : dp[j]) + word;
                    }
                }
            }
        }

        // Возвращаем расшифрованное сообщение, удаляя лишние пробелы
        return dp[message.length()] == null ? " " : dp[message.length()].trim();
    }

    // Создаем маппинг для цифр
    public static Map<String, String> createDigitToLetterMap() {
        Map<String, String> map = new HashMap<>();

        map.put("2", "A");
        map.put("22", "B");
        map.put("222", "C");

        map.put("3", "D");
        map.put("33", "E");
        map.put("333", "F");

        map.put("4", "G");
        map.put("44", "H");
        map.put("444", "I");

        map.put("5", "J");
        map.put("55", "K");
        map.put("555", "L");

        map.put("6", "M");
        map.put("66", "N");
        map.put("666", "O");

        map.put("7", "P");
        map.put("77", "Q");
        map.put("777", "R");
        map.put("7777", "S");

        map.put("8", "T");
        map.put("88", "U");
        map.put("888", "V");

        map.put("9", "W");
        map.put("99", "X");
        map.put("999", "Y");
        map.put("9999", "Z");

        return map;
    }
}
