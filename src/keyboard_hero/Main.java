package keyboard_hero;

import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> ch = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (ch.containsKey(chars[i])) {
                ch.put(chars[i], ch.get(chars[i]) + 1);
            }
            else {
                ch.put(chars[i],1);
            }
        }
    }
}
