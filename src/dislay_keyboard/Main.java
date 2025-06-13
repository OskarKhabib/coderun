package dislay_keyboard;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.useLocale(Locale.US);
        String [][] keyboard = new String[4][10];
        String input = in.next();
        char[] chars = input.toCharArray();
        System.out.println(chars.length);

        keyboard[0][0] = "0";
        keyboard[0][1] = "1";
        keyboard[0][2] = "2";
        keyboard[0][3] = "3";
        keyboard[0][4] = "4";
        keyboard[0][5] = "5";
        keyboard[0][6] = "6";
        keyboard[0][7] = "7";
        keyboard[0][8] = "8";
        keyboard[0][9] = "9";

        int pointer = 0;
        for (int i = 0; i < 10; i++) {
            keyboard[1][i] = chars[pointer] + "";
            pointer++;
        }
        for (int i = 0; i < 10; i++) {
            keyboard[2][i] = chars[pointer] + "";
            pointer++;
        }
        keyboard[3][0] = chars[pointer] + "";
        pointer++;
        keyboard[3][1] = chars[pointer] + "";
        pointer++;
        keyboard[3][2] = chars[pointer] + "";
        pointer++;
        keyboard[3][7] = chars[pointer] + "";
        pointer++;
        keyboard[3][8] = chars[pointer] + "";
        pointer++;
        keyboard[3][9] = chars[pointer] + "";
        keyboard[3][3] = " ";
        keyboard[3][4] = " ";
        keyboard[3][5] = " ";
        keyboard[3][6] = " ";

        String final_string = "";

        for (int i = 0; i < n; i++) {
            double x = in.nextDouble();
            double y = in.nextDouble();

            int x_k = (int) Math.floor(x);
            int y_k = (int) Math.floor(y);

            y_k = 3 - y_k;

            final_string += keyboard[y_k][x_k];
        }

        System.out.println(final_string);
    }
}
