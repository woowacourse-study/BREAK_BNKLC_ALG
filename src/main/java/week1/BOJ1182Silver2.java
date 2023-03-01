package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BOJ1182Silver2 {
    public static void main(String[] args) {
        game(new Scanner(System.in));
    }

    static void game(Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);

        List<Integer> arr = new ArrayList<>();
        for (String str : scanner.nextLine().split(" ")) {
            arr.add(Integer.parseInt(str));
        }
        boolean[] visited = new boolean[N];
        Cnt cnt = new Cnt(0);
        for (int r = 1; r < N + 1; r++) {
            backTracking(arr, visited, 0, N, r, cnt, S);
        }
        System.out.println(cnt.get());
    }

    static void backTracking(List<Integer> arr, boolean[] visited, int start, int n, int r, Cnt cnt, int S) {
        if (r == 0) {
            if (isEqualWithS(arr, visited, S)) {
                cnt.add();
            }
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            backTracking(arr, visited, i + 1, n, r - 1, cnt, S);
            visited[i] = false;
        }
    }

    static boolean isEqualWithS(List<Integer> arr, boolean[] visited, int S) {
        int s = 0;
        for (int i = 0, end = arr.size(); i < end; i++) {
            if (visited[i]) {
                s += arr.get(i);
            }
        }
        if (s == S) {
            return true;
        }
        return false;
    }
    static class Cnt{
        private int value;
        Cnt(int value){
            this.value = value;
        }
        void add(){
            value++;
        }
        int get(){
            return this.value;
        }
    }
}
