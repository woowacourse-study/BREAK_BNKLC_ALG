package divdeandconquel;

import java.util.Scanner;

public class BOJ1074 {
    static int N;
    static int r, c;
    static int orderCount = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        int size = (int) Math.pow(2, N);

        divide(0, 0, size);
    }

    public static void divide(int startRow, int startCol, int size) {
        if (size == 2) {
            count(startRow, startCol);
            return;
        }

        int nextSize = size / 2;
        int midRow = startRow + nextSize;
        int midCol = startCol + nextSize;

        if (r < midRow && c < midCol) {
            divide(startRow, startCol, nextSize);
            return;
        }
        orderCount += nextSize * nextSize;

        if (r < midRow && c >= midCol) {
            divide(startRow, startCol + nextSize, nextSize);
            return;
        }
        orderCount += nextSize * nextSize;

        if (r >= midRow && c < midCol) {
            divide(startRow + nextSize, startCol, nextSize);
            return;
        }
        orderCount += nextSize * nextSize;

        if (r >= midRow && c >= midCol) {
            divide(startRow + nextSize, startCol + nextSize, nextSize);
        }
    }


    public static void count(int row, int col) {
        if (row == r && col == c) {
            System.out.print(orderCount);
            return;
        }
        orderCount++;
        if (row == r && col + 1 == c) {
            System.out.print(orderCount);
            return;
        }
        orderCount++;
        if (row + 1 == r && col == c) {
            System.out.print(orderCount);
            return;
        }
        orderCount++;
        if (row + 1 == r && col + 1 == c) {
            System.out.print(orderCount);
            return;
        }
        orderCount++;
    }
}
