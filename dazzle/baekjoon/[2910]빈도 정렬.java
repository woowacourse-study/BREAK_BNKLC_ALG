import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static void input() {
        N = scan.nextInt();
        C = scan.nextInt();
        for (int i = 1; i <= N; i++) {
            int input = scan.nextInt();
            counts.put(input, counts.getOrDefault(input, 0) + 1);
        }
    }

    static FastReader scan = new FastReader();
    static int N, C;
    static Map<Integer, Integer> counts = new LinkedHashMap<>();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        List<Element> elements = new ArrayList<>();
        for (Integer key : counts.keySet()) {
            elements.add(new Element(key, counts.get(key)));
        }
        Collections.sort(elements, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (Element element : elements) {
            sb.append((element.num + " ").repeat(element.count));
        }
        System.out.println(sb.toString());
    }

    static class Element implements Comparable<Element> {

        public final int num;
        public final int count;

        public Element(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Element element) {
            return count - element.count;
        }
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
