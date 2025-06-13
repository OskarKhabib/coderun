package Cha_cha_cha;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String liters = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
//        ZYXWVUTSRQPONMLKJIHGFEDCBA
//        ABCDEFGHIJKLMNOPQRSTUVWXYZ
        String [] score = sc.nextLine().split("");
        int sum = score.length;
        double result = 0;
        for (int i = 0; i < score.length; i++) {
            sum+= liters.indexOf(score[i]);
        }
        System.out.println(sum);
        result = Math.round(sum/(score.length));
        sum = (int)result;
        System.out.println(sum);
        System.out.println(liters.charAt(sum-1));

    }

}
