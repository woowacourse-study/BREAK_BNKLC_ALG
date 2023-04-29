package week6;

import java.io.*;
import java.util.*;


public class Gold {
    private static int N;
    private static double B;
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        game(new InputStreamReader(System.in));
    }

    public static void game(InputStreamReader isr) throws IOException {
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Double.parseDouble(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int[] a: dd(B)){
            for(int b: a){
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
    private static int[][] multiply(int[][] arr1, int[][] arr2){
        int[][] newArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    newArr[i][j] = (newArr[i][j]+arr1[k][j] * arr2[i][k]) %1000;
                }
            }
        }
        return newArr;
    }
    private static int[][] pow(int[][] arr){
        int[][] newArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    newArr[i][j] = (newArr[i][j]+arr[k][j] * arr[i][k]) %1000;
                }
            }
        }
        return newArr;
    }
    private static int[][] dd(double count){
        if(count == 1){
            return arr;
        }
        if(count%2 != 0){
            return multiply(dd(count-1),arr);
        }
        return pow(dd(count/2));
    }
}

