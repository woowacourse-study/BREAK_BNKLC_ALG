package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question2003 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        n = Integer.parseInt(input.split(" ")[0]);
        m = Integer.parseInt(input.split(" ")[1]);
        String inputList = br.readLine();
        numbers = Arrays.stream(inputList.split(" "))
            .map(number -> Integer.parseInt(number))
            .collect(Collectors.toList());
        int right = 0;
        int sum = 0;
        int cnt = 0;
        for (int left = 0; left < n; left++) {
            while (sum < m && right < n) {
                sum += numbers.get(right);
                right++;
            }
            if (sum == m){
                cnt++;
            }
            sum -= numbers.get(left);
        }
        System.out.println(cnt);
    }

}
