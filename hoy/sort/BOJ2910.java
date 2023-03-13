package sort;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BOJ2910 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();

        List<Integer> numbers = new ArrayList<>(N);
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int value = sc.nextInt();
            numbers.add(value);
            count.put(value, count.getOrDefault(value, 0) + 1);
        }

        numbers = numbers.stream()
            .distinct()
            .sorted((n1, n2) -> Integer.compare(count.get(n2), count.get(n1)))
            .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        for (Integer number : numbers) {
            sb.append((number + " ").repeat(count.get(number)));
        }

        System.out.print(sb);
    }
}
