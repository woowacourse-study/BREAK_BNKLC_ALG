import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2003{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> numbers = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers.add(number);
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int answer = 0;
        while(end <= N) {
            if (sum >= M) {
                sum -= numbers.get(start++);
            } else if (end == N) {
                break;
            } else if (sum < M) {
                sum += numbers.get(end++);
            }
            if (sum == M){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
