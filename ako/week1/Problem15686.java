import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem15686 {

    private static int N;
    private static int M;
    private static List<int[]> house = new ArrayList<>();
    private static List<int[]> chicken = new ArrayList<>();
    private static int chickenCnt;
    private static boolean[] chickenPossible;
    private static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 집과 치킨집의 위치를 파악하는 기능
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number == 1) {
                    house.add(new int[]{i, j});
                }
                if (number == 2) {
                    chicken.add(new int[]{i, j});
                    chickenCnt++;
                }
            }
        }
        chickenPossible = new boolean[chickenCnt];
        calculateChickenDistance(0, 0);
        System.out.println(answer);
    }

    private static void calculateChickenDistance(int start, int cnt) {
        if (cnt == M) {
            int chickenDistance = 0;

            for (int[] houseLocation : house) {
                int distance = Integer.MAX_VALUE;

                for (int i = 0; i < chicken.size(); i++) {
                    if (chickenPossible[i]) {
                        int calculate = Math.abs(houseLocation[0] - chicken.get(i)[0]) + Math.abs(houseLocation[1] - chicken.get(i)[1]);
                        distance = Math.min(distance, calculate);
                    }
                }
                chickenDistance += distance;
            }
            answer = Math.min(answer, chickenDistance);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            chickenPossible[i] = true;
            calculateChickenDistance(i + 1, cnt + 1);
            chickenPossible[i] = false;
        }
    }
}