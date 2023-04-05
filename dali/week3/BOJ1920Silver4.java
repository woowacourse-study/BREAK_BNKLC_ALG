package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920Silver4 {
    static int[] arr;
    static int N;
    static int M;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        game(new InputStreamReader(System.in));
    }

    public static void game(InputStreamReader isr) throws IOException {
        BufferedReader br = new BufferedReader(isr);

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        numbers = new int[M];
        for (int i = 0; i < M; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int number : numbers) {
            if (binarySearch(number)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
    static boolean binarySearch(int target) {
        int mid;
        int low = 0;
        int high = N-1;
        while (low<= high){
            mid = (low+high)/2;
            if(target == arr[mid]){
                return true;
            }else if(target<arr[mid]){
                high = mid-1;
            }else if(target >arr[mid]){
                low = mid+1;
            }
        }
        return false;
    }
}
