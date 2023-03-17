import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1182 {

    private static int N;
    private static int S;
    private static int[] numArray;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numArray = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }
        solution(0,0);

        if (S == 0) {
            answer--;
        }

        System.out.println(answer);
    }

    private static void solution(int start, int sum) {
        if (start == N) {
            if (sum == S) {
                answer++;
            }
            return;
        }
        solution(start + 1, sum + numArray[start]);
        solution(start + 1, sum);
    }
}

