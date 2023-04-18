import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question1520 {
    static int m;
    static int n;
    static List<List<Integer>> map;
    static List<List<Integer>> dp;

    static List<Integer> xRange = List.of(-1, 0, 1, 0);
    static List<Integer> yRange = List.of(0, 1, 0, -1);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        m = Integer.parseInt(numbers[0]);
        n = Integer.parseInt(numbers[1]);
        map = new ArrayList<>();
        dp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> line = Arrays.stream(br.readLine().split(" "))
                    .map(num -> Integer.parseInt(num)).collect(Collectors.toList());
            map.add(line);
            List<Integer> dpLine = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                dpLine.add(-1);
            }
            dp.add(dpLine);
        }
        dfs(0, 0);
        System.out.println(dp.toString());
        System.out.println(dp.get(0).get(0));
    }

    private static int dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (dp.get(x).get(y) != -1) {
            return dp.get(x).get(y);
        }
        dp.get(x).set(y, 0);
        for (int i = 0; i < 4; i++) {
            int dx = x + xRange.get(i);
            int dy = y + yRange.get(i);
            if (dx < 0 || dy < 0 || dx >= m || dy >= n) {
                continue;
            }
            if (map.get(x).get(y) > map.get(dx).get(dy)) {
                dp.get(x).set(y, dp.get(x).get(y) + dfs(dx, dy));
            }
        }
        return dp.get(x).get(y);
    }
}

