package The_largest_multiplication;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String[] numbers = s.split(" ");

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            if (number < min) {
                min1 = Math.min(min2,min1);
                min2 = number;
                min = Math.max(min2,min1);
            }
            if  (number > max) {
                max1 = Math.max(max2,max1);
                max2 = number;
                max = Math.min(max2,max1);
            }
        }
        long m = (long) max1 * max2;
        long mi = (long) min1 * min2;
        if (m > mi) {
            System.out.println(Math.min(max2,max1) + " " + Math.max(max2,max1));
        }
        else {
            System.out.println(Math.min(min2,min1) + " " + Math.max(min2,min1));
        }

    }
}
