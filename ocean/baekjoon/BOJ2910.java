package ocean.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2910 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Map<Integer,Integer> sequence= new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int count =0; count<N; count++){
            int nextValue = Integer.parseInt(st.nextToken());
            if(!sequence.containsKey(nextValue)){
                sequence.put(nextValue,0);
            }
            else if(sequence.containsKey(nextValue)){
                int oldValue = sequence.get(nextValue);
                sequence.replace(nextValue,oldValue+1);
            }
        }

        ArrayList<Integer> keySet = new ArrayList<Integer>(sequence.keySet());

        Collections.sort(keySet, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(sequence.get(b), sequence.get(a));
            }
        });

        for(int i=0; i< keySet.size(); i++){
            for(int j=0; j<= sequence.get(keySet.get(i)); j++)
                System.out.print(keySet.get(i)+" ");
        }
    }
}
