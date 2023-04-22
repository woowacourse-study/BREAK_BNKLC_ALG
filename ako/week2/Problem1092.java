import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> crain = new ArrayList<Integer>();
        ArrayList<Integer> boxs = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            crain.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            boxs.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crain, Collections.reverseOrder());
        Collections.sort(boxs,Collections.reverseOrder());
        int answer = 0;
        if(crain.get(0) < boxs.get(0)){
            System.out.println(-1);
            return;
        }
        while(boxs.size() > 0){
            int index = 0;
            for(int i = 0; i < crain.size();){// crain에 대해서
                if(index == boxs.size())break;
                if(crain.get(i) >= boxs.get(index)){
                    boxs.remove(index);
                    i++;
                }
                else{
                    index++;
                }
            }
            answer += 1;
        }
        System.out.println(answer);
    }
}
