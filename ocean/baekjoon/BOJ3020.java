package ocean.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3020 {

    static int N, H;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[] bot = new int[H + 2];
        int[] top = new int[H + 2];

        for (int i = 0; i < N / 2; i++) {
            bot[Integer.parseInt(br.readLine())]++;
            top[H - Integer.parseInt(br.readLine()) + 1]++;
        }

        for (int i = H-1; i >0 ; i--) {
            top[i] += top[i+1];
            bot[i] += bot[i+1];
        }

        int[] result = new int[H+2];
        int min = N+1;

        for (int i = 1; i <= H ; i++) {
            result[i] = bot[i] + top[H-i+1];
            min = Math.min(min, result[i]);
        }

        int cnt = 0;
        for (int i = 1; i <= H ; i++) {
            if(result[i] == min)
                cnt++;
        }

        System.out.println(min + " " + cnt);
    }
}
