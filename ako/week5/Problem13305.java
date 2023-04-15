import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Long> distances = new ArrayList<>();
        List<Long> cityExpense = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distances.add(Long.parseLong(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cityExpense.add(Long.parseLong(st.nextToken()));
        }

        // 처음 이동
        long answer = distances.get(0) * cityExpense.get(0);
        int index = 0;
        for (int i = 1; i < distances.size(); i++) {
            long preExpense = cityExpense.get(index);
            long nowExpense = cityExpense.get(i);

            if (preExpense < nowExpense) {
                answer += preExpense * distances.get(i);
            } else {
                index = i;
                answer += nowExpense * distances.get(i);
            }
        }

        System.out.println(answer);
    }
}
