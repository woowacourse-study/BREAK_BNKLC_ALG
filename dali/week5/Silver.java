package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    private static int N;
    private static long[] dis;
    private static long[] price;
    private static long total;
    public static void main(String[] args) throws IOException {
        game(new InputStreamReader(System.in));
    }

    public static void game(InputStreamReader isr) throws IOException {
        BufferedReader br = new BufferedReader(isr);

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        dis = new long[N-1];
        for (int i = 0; i < N-1; i++) {
            dis[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        price = new long[N];
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        total = 0;
        total += price[0] * dis[0];
        long now = price[0];
        if(N==2){
            System.out.println(total);
            return;
        }
        for (int i = 1; i < N-1; i++) {
            if(price[i]>now){
                total+= now * dis[i];
                continue;
            }
            now = price[i];
            total+= now * dis[i];
        }
        System.out.println(total);
    }
}
