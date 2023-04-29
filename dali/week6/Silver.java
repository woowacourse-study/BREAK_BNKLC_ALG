package week6;

import java.io.*;
import java.util.*;

/*
example :
2 3 1 -> 11
 */
public class Silver {
    private static double N;
    private static double r;
    private static double c;
    public static void main(String[] args) throws IOException {
        game(new InputStreamReader(System.in));
    }

    public static void game(InputStreamReader isr) throws IOException {
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Double.parseDouble(st.nextToken());
        r = Double.parseDouble(st.nextToken());
        c = Double.parseDouble(st.nextToken());
        double ans = 0;
        while(N>0){
            N --;
            if(r>= Math.pow(2,N) && c>=Math.pow(2,N)){
                ans += Math.pow(2,N*2) * 3;
                r -= Math.pow(2,N);
                c -= Math.pow(2,N);
            }
            if(r<Math.pow(2,N) && c>=Math.pow(2,N)){
                ans += Math.pow(2,N*2) * 1;
                c -= Math.pow(2,N);
            }
            if(r>=Math.pow(2,N) && c<Math.pow(2,N)){
                ans += Math.pow(2,N*2) * 2;
                r -= Math.pow(2,N);
            }
        }
        System.out.println((int) ans);
    }
}
