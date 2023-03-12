import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Question1092 {

    static void input() {
        n = reader.nextInt();
        crains = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            crains.add(reader.nextInt());
        }
        boxes = new ArrayList<>();
        m = reader.nextInt();
        for (int i = 0; i < m; i++) {
            boxes.add(reader.nextInt());
        }
        cnt = 0;

    }

    static Reader reader = new Reader();
    static int n;
    static int m;
    static int cnt;
    static List<Integer> crains;
    static List<Integer> boxes;

    public static void main(String[] args) {
        input();
        crains.sort(Comparator.reverseOrder());
        boxes.sort(Comparator.reverseOrder());
        if (crains.get(0) < boxes.get(0)) {
            System.out.println(-1);
        } else {
            while (boxes.size() > 0) {
                for (int crain : crains){
                    if (boxes.size()==0){
                        break;
                    }
                    else if (crain<boxes.get(boxes.size()-1)){
                        break;
                    } else {
                        for (int j =0;j<boxes.size();j++){
                            if (crain>=boxes.get(j)){
                                boxes.remove(j);
                                break;
                            }
                        }
                    }
                }
                cnt++;
            }
            System.out.println(cnt);
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
