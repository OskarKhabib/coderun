package Polyglots;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int pointer = 0;
        int allLanguage = 0;
        List<String> alwaysLanguage = new ArrayList<>();
        int children = Integer.parseInt(br.readLine());
        for (int i = 0; i < children; i++) {
            int nubberOfLanguage =  Integer.parseInt(br.readLine());
            for (int j = 0; j < nubberOfLanguage; j++) {
                String language = br.readLine();
                if (map.containsKey(language)) {
                    map.put(language, map.get(language) + 1);
                    if(map.get(language) == children) {
                        alwaysLanguage.add(language);
                        pointer++;

                    }
                }
                else {
                    map.put(language, 1);
                    allLanguage++;
                }
            }
        }
        System.out.println(pointer);
        for(String language : alwaysLanguage) {
            System.out.println(language);
        }
        System.out.println(allLanguage);
        for(String key : map.keySet()) {
            System.out.println(key);
        }



    }
}
