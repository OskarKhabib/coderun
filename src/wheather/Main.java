package wheather;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int a = 0, b = 0,c = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i)>0) {
                a++;
            }
            if (line.charAt(i)<0) {
                b++;
            }
            if (line.charAt(i)==0) {
                c++;
            }
        }
        System.out.println("выше нуля: "+a+", ниже нуля: "+b+", равна нулю: "+c);


    }

}
