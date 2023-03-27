import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question3020 {
    static int n;
    static int h;
    static int[] top;
    static int[] down;
    static int min;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        top = new int[h + 1];
        down = new int[h + 1];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                top[num]++;
            } else {
                down[num]++;
            }
        }

        min = n;
        cnt = 0;
        sum();

        System.out.println(min + " " + cnt);


    }

    private static void sum() {

        int[] sumOfTop = new int[h + 1];
        int[] sumOfDown = new int[h + 1];

        for (int i = 1; i < h + 1; i++) {
            sumOfTop[i] = sumOfTop[i - 1] + top[i];
            sumOfDown[i] = sumOfDown[i - 1] + down[i];
        }

        for (int i = 1; i < h + 1; i++) {
            int hit = 0;

            hit += sumOfTop[h] - sumOfTop[h - i];
            hit += sumOfDown[h] - sumOfDown[i - 1];

            if (min > hit) {
                min = hit;
                cnt = 1;
            } else if (min == hit) {
                cnt++;
            }
        }


    }
}
