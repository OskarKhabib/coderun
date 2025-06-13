package Think_about_it_first;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] T = new String[n+1];
        T[1] ="1";
        int pointer = 2;
        for (int i = 1; i <n; i++) {
            T[pointer] = T[i]+(pointer)+T[i];
            pointer++;

        }
        String final_str = T[n];
//        char[] final_char = final_str.toCharArray();
//        long sum = 0;
//        int l = in.nextInt();
//        int r = in.nextInt();
//        for (int i = l; i < r+1; i++) {
//            sum += Character.getNumericValue( final_char[i]);
//            }
        System.out.println(final_str);



    }
}
