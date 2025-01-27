package frequent_element;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int pointer;
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxkey= 0, maxvalue = 0;
        for (int i = 0; i < n; i++) {
            pointer = in.nextInt();
            if (map.containsKey(pointer)) {
                map.put(pointer,map.get(pointer)+1);
                if (map.get(pointer)>maxvalue) {

                    maxvalue = map.get(pointer);
                    maxkey = pointer;
                }
                else if (map.get(pointer)>=maxvalue) {
                        if (pointer>maxkey) {
                            maxvalue = map.get(pointer);
                            maxkey = pointer;
                        }
                    }
            }
            else {
                map.put(pointer,1);
                if (map.get(pointer)>=maxvalue) {
                    if (pointer > maxkey) {
                        maxvalue = map.get(pointer);
                        maxkey = pointer;
                    }
                }
            }
        }
        System.out.println(maxkey);

    }

}
