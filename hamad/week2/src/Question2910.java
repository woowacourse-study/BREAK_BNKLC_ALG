import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Question2910 {

    static void input() {
        n = reader.nextInt();
        c = reader.nextInt();
        for (int i = 0; i < n; i++) {
            nums.add(reader.nextInt());
        }

    }

    static Reader reader = new Reader();
    static int n, c;
    static List<Integer> nums = new ArrayList<>();

    public static void main(String[] args) {
        input();

        Map<Integer, Integer> numberContains = new LinkedHashMap<>();

        for (Integer num : nums) {
            if (numberContains.containsKey(num)) {
                numberContains.put(num, numberContains.get(num) + 1);
            } else {
                numberContains.put(num, 1);
            }
        }

        List<Integer> keys = new ArrayList<>(numberContains.keySet());

        Collections.sort(keys, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(numberContains.get(o2), numberContains.get(o1));
            }
        });

        for (int key : keys) {
            for (int i = 0; i < numberContains.get(key); i++) {
                System.out.print(key+" ");
            }
        }

    }

    static class Reader {

        BufferedReader br;
        StringTokenizer st;

        public Reader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
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
