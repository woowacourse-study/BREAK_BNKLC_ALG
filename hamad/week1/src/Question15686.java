import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question15686 {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int m = sc.nextInt();
    static List<List<Integer>> arr = new ArrayList<>();
    static List<Point> homeList = new ArrayList<>();
    static List<Point> chickenList = new ArrayList<>();
    static int result;
    static boolean[] visited;

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                line.add(sc.nextInt());
            }
            arr.add(line);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr.get(i).get(j) == 1) {
                    homeList.add(new Point(i, j));
                }
                if (arr.get(i).get(j) == 2) {
                    chickenList.add(new Point(i, j));
                }

            }
        }

        result = Integer.MAX_VALUE;
        visited = new boolean[chickenList.size()];
        dfs(0,0);
        System.out.println(result);

    }

    public static void dfs(int start, int cnt) {
        if (cnt == m) {
            int sumAll = 0;
            for (int i = 0; i < homeList.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chickenList.size(); j++) {
                    if (visited[j]) {
                        int distance = Math.abs(homeList.get(i).x - chickenList.get(j).x) + Math.abs(
                            homeList.get(i).y - chickenList.get(j).y);
                        temp = Math.min(temp, distance);
                    }
                }
                sumAll += temp;
            }
            result = Math.min(result, sumAll);
            return;
        }
        for (int i = start; i < chickenList.size(); i++) {
            visited[i] = true;
            dfs(i + 1, cnt + 1);
            visited[i] = false;
        }
    }

}
