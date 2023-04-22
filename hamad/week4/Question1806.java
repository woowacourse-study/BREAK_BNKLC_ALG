package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question1806 {

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
        int left = 0;
        int right = 0;
        int sum = numbers.get(0);
        int minSize = Integer.MAX_VALUE;
        while (left <= right && right < n) {
            if (sum >= m) {
                minSize = Math.min(minSize, right - left +1);
                sum -= numbers.get(left);
                left++;
            }
            else {
                right++;
                if (right <n){
                    sum += numbers.get(right);
                }
            }
        }
        if (minSize == Integer.MAX_VALUE){
            System.out.println(0);
        }else {
            System.out.println(minSize);
        }
    }

}
