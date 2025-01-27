package average_in_the_window;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        double maxvalue;
        double res = 0;
        int iteratot = 1;
        int resmaxvalue=0;
        int value1 = in.nextInt();
        maxvalue = value1;
        for (int i = 0; i < n-1; i++) {
            int value2 = in.nextInt();
            if ((value1 - value2==0)||(value1 - value2==1)||(value1 - value2==-1)) {
                maxvalue = maxvalue+value2;
                iteratot++;
            }
            else if (iteratot >= k &&maxvalue>resmaxvalue) {
                res = maxvalue/iteratot;
                maxvalue = 0;
                iteratot = 0;

            }
            value1 = value2;
        }
        System.out.println(res);
    }
}
