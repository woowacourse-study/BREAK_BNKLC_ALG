import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Integer> numbers = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers.add(number);
        }
        numbers.sort(Comparator.naturalOrder());

        List<Integer> checkNumbers = new ArrayList<>();
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int checkNumber = Integer.parseInt(st.nextToken());
            checkNumbers.add(checkNumber);
        }

        for (int i = 0; i < checkNumbers.size(); i++) {
            System.out.println(solution(numbers, checkNumbers.get(i)));
        }
    }

    private static int solution(List<Integer> numbers, Integer checkNumber) {
        int start = 0;
        int last = numbers.size() - 1;
        int mid;

        while(start <= last) {
            mid = (start + last)/2;

            if (numbers.get(mid) > checkNumber) {
                last = mid - 1;
            } else if (numbers.get(mid) < checkNumber) {
                start = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
