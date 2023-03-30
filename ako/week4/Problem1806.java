import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1806{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        List<Integer> numbers = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers.add(number);
        }

        int start = 0;
        int end = 0;
        long sum = 0;
        int answer = Integer.MAX_VALUE;
        while(end <= N) {
            if (sum >= S) {
                answer = Math.min(answer, end - start);
                sum -= numbers.get(start++);
            } else if (end == N) {
                break;
            } else if (sum < S) {
                sum += numbers.get(end++);
            }
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
