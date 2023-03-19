package search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {

    /**
     * 수 찾기
     * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
     */
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = (Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int X = Integer.parseInt(st.nextToken());
            if (binarySearch(0, N - 1, X)) {
                bw.write(1 + "\n");
                continue;
            }
            bw.write(0 + "\n");
        }
        bw.flush();
    }

    public static boolean binarySearch(int start, int end, int x) {
        int idx = (start + end) / 2;
        if (start > end) {
            return false;
        }
        if (A[idx] == x) {
            return true;
        }
        if (A[idx] < x) {
            return binarySearch(idx + 1, end, x);
        }
        return binarySearch(start, idx - 1, x);
    }
}
