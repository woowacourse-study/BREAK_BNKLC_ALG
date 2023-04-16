package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2910SIlver3 {
    static int N;
    static int C;
    static HashMap<String,Integer> hashMap;
    static String[] key;
    public static void main(String[] args) throws IOException {
        game(new InputStreamReader(System.in));
    }
    public static void game(InputStreamReader isr) throws IOException {
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        //.split(" ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        hashMap = new LinkedHashMap<>();
        Set<String> keySet = hashMap.keySet();
        int l = keySet.size();
        String num;
        key = hashMap.keySet().toArray(keySet.toArray(new String[0]));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N; i++) {
            num = st.nextToken();
            if(keySet.contains(num)){
                hashMap.put(num,hashMap.get(num)+1);
            }
            else{
                hashMap.put(num,1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new LinkedList<>(hashMap.entrySet());
        Collections.sort(entries,((o1, o2) -> o2.getValue().compareTo(o1.getValue())));

        List<String> output = new ArrayList<>();
        for(Map.Entry<String,Integer> entry: entries){
            for (int i = 0; i < entry.getValue(); i++) {
                output.add(entry.getKey());
            }
        }
        System.out.println(String.join(" ",output));
    }
}
