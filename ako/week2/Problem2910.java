import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem2910 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] numArr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> numbers = new LinkedHashMap<>();

        for (int i = 0; i < N; i++) {
            int key = numArr[i];
            if (numbers.containsKey(key)) {
                numbers.replace(key, numbers.get(key) + 1);
            } else {
                numbers.put(key, 1);
            }
        }

        List<Integer> keys = new ArrayList<>(numbers.keySet());

        keys.sort(
            (o1, o2) -> numbers.get(o2).compareTo(numbers.get(o1))
        );

        StringBuilder sb = new StringBuilder();

        for (Integer key : keys) {
            String s = String.valueOf(key)+ " ";
            sb.append(s.repeat(numbers.get(key)));
        }
        System.out.println(sb.toString());
    }
}