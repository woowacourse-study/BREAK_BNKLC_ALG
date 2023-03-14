package baekjoon;

import java.util.*;

public class BOJ2910 {

    /**
     * 2910: 빈도정렬
     *  1 <= N < = 1000
     *  1 <= C <= 1_000_000_000
     *  00:10 ~ 00:23
     *
     */

    private static int N;
    private static int C;
    private static int[] numbers;
    private static LinkedHashMap<Integer, Integer> numberRepository = new LinkedHashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        C = scanner.nextInt();
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            numbers[i] = num;

            if (numberRepository.containsKey(num)) {
                Integer currentCount = numberRepository.get(num);
                numberRepository.put(num, currentCount + 1);
                continue;
            }
            numberRepository.put(num, 1);
        }

        LinkedHashMap<Integer, Integer> sortedValues = sortMapByValue(numberRepository);

        Set<Map.Entry<Integer, Integer>> entries = sortedValues.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print(entry.getKey() + " ");
            }
        }
        scanner.close();
    }


    private static LinkedHashMap<Integer, Integer> sortMapByValue(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
