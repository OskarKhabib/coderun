package Checkers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        String[][] checkers = new String[N+4][M+4];
        int W = in.nextInt();
        for (int i = 0; i < N+4; i++) {
            for (int j = 0; j < M+4; j++) {
                checkers[i][j] = "0";
            }
        }
        for (int x = 2; x < N+2; x++) {
            for (int y = 2; y < M+2; y++) {
                checkers[x][y] = "1";
            }
            }
        for (int i = 0; i < W; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            checkers[x+1][y+1] = "W";
        }
        int B = in.nextInt();
        for (int i = 0; i < B; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            checkers[x+1][y+1] = "B";
        }
        String move = in.next();
        if (move.equals("white")){
            for (int x = 2; x < N+2; x++) {
                for (int y = 2; y < M+2; y++) {
                    if (checkers[x][y].equals("W") && ((checkers[x - 1][y - 1].equals("B") && checkers[x - 2][y - 2].equals("1")) || (checkers[x + 1][y + 1].equals("B") && checkers[x + 2][y + 2].equals("1")) || (checkers[x - 1][y + 1].equals("B") && checkers[x - 2][y + 2].equals("1")) || (checkers[x + 1][y - 1].equals("B") && checkers[x + 2][y - 2].equals("1")))){
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        else {
            for (int x = 2; x < N+2; x++) {
                for (int y = 2; y < M+2; y++) {
                    if (checkers[x][y].equals("B") && ((checkers[x - 1][y - 1].equals("W") && checkers[x - 2][y - 2].equals("1")) || (checkers[x + 1][y + 1].equals("W") && checkers[x + 2][y + 2].equals("1")) || (checkers[x - 1][y + 1].equals("W") && checkers[x - 2][y + 2].equals("1")) || (checkers[x + 1][y - 1].equals("W") && checkers[x + 2][y - 2].equals("1")))){
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");





    }
}
