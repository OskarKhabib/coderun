package Trans;

import java.util.ArrayList;
import java.util.Iterator;

public class Trans_1 {
    public static void main(String[] args) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            al.add(chars[i] + String.valueOf(i+1));
        }
        System.out.println(al);
        Iterator<String> itr = al.iterator();
        while (itr.hasNext()) {
            if (itr.next().contains("1")) {
                itr.remove();
            }
        }
        System.out.println(al);


    }
}
