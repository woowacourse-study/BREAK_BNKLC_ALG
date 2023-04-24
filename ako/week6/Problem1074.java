import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1074 {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);
        find(size, r, c);
        System.out.println(answer);
    }

    private static void find(int size, int r, int c) {
        if (size == 1) {
            return;
        }
        int half = size / 2;
        if (r < half && c < half) {
            find(half, r, c);
        } else if (r < half && c >= half) {
            answer += half * half;
            find(half, r, c - half);
        } else if (r >= half && c < half) {
            answer += half * half * 2;
            find(half, r - half, c);
        } else {
            answer += half * half * 3;
            find(half, r - half, c - half);
        }
    }

}
