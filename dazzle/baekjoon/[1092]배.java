import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static void input() {
        N = scan.nextInt();
        for (int i = 1; i <= N; i++) {
            crane.add(scan.nextInt());
        }
        M = scan.nextInt();
        for (int i = 1; i <= M; i++) {
            cargo.add(scan.nextInt());
        }
    }

    static FastReader scan = new FastReader();
    static int N, M, answer;
    static List<Integer> crane = new ArrayList<>();
    static List<Integer> cargo = new ArrayList<>();

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(answer);
    }

    static void pro() {
        crane.sort(Collections.reverseOrder());
        cargo.sort(Collections.reverseOrder());

        if (crane.get(0) < cargo.get(0)) {
            answer = -1;
            return;
        }

        while (!cargo.isEmpty()) {
            for (Integer integer : crane) {
                if (!isPossibleCrane(integer)) {
                    break;
                }
            }
            answer += 1;
        }
    }

    static boolean isPossibleCrane(Integer crane) {
        for (int i = 0; i < cargo.size(); i++) {
            if (crane >= cargo.get(i)) {
                return cargo.remove(cargo.get(i));
            }
        }
        return false;
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
