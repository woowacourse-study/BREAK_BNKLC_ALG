import com.sun.nio.sctp.SendFailedNotification;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem3020 {

    private static int N;
    private static int H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[] top = new int[H + 1];
        int[] bottom = new int[H + 1];
        for (int i = 0; i < N/2; i++) {
            bottom[Integer.parseInt(br.readLine())]++;
            top[Integer.parseInt(br.readLine())]++;
        }

        for (int i = H-1; i >0 ; i--) {
            top[i] += top[i+1];
            bottom[i] += bottom[i+1];
        }

        int[] obstacle = new int[H+1];
        int min = N+1;

        for (int i = 1; i <= H ; i++) {
            obstacle[i] = bottom[i] + top[H-i+1];
            min = Math.min(min, obstacle[i]);
        }
        int cnt = 0;
        for (int i = 1; i <= H ; i++) {
            if(obstacle[i] == min)
                cnt++;
        }
        System.out.println(min + " " + cnt);
    }
}
