package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1092Gold5 {
    static int N;
    static int M;
    static int[] crainArr;
    static int[] boxArr;
    public static void main(String[] args) throws IOException {
        game(new InputStreamReader(System.in));
    }

    public static void game(InputStreamReader isr) throws IOException {
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        crainArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crainArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        boxArr = new int[M];
        for (int i = 0; i < M; i++) {
            boxArr[i] = Integer.parseInt(st.nextToken());
        }


        quickSort(crainArr,0,N-1);
        quickSort(boxArr,0,M-1);


        if(crainArr[0]<boxArr[0]){
            System.out.print(-1);
            return;
        }
        List<Integer> arr =  new ArrayList<>();
        for(int box:boxArr){
            arr.add(box);
        }
        int crainWeight;
        int cnt = 0;
        while(!arr.isEmpty()){
            cnt++;
            for(int crain:crainArr){
                crainWeight = crain;
                for (int i = 0; i < arr.size(); i++) {
                    if(crainWeight>=arr.get(i)){
                        crainWeight = crainWeight - arr.remove(i);
                        break;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
    public static void quickSort(int array[], int start, int end){
        if(start>=end)
            return;
        int pivot = start;
        int left = start+1;
        int right = end;
        while ( left <= right){
            while (left <= end && array[left] >= array[pivot])
                left+=1;

            while(right > start && array[right] <= array[pivot])
                right-=1;

            if(left > right){
                int tmp = array[right];
                array[right] = array[pivot];
                array[pivot] = tmp;
            }else{
                int tmp = array[right];
                array[right] = array[left];
                array[left] = tmp;
            }
            quickSort(array, start, right -1);
            quickSort(array, right +1, end);
        }
    }
}
