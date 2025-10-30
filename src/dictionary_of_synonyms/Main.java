package dictionary_of_synonyms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        HashMap<String, String> dictionary = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String []pair = reader.readLine().split(" ");
            dictionary.put(pair[0], pair[1]);
            dictionary.put(pair[1], pair[0]);

        }
        String word = reader.readLine();
        System.out.println(dictionary.get(word));

    }
}
