package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityCount = Integer.parseInt(br.readLine());
        int[] cityDistance = new int[cityCount];
        long[] cityCost = new long[cityCount];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < cityCount - 1; i++) {
            cityDistance[i + 1] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < cityCount; i++) {
            long currentCost = Long.parseLong(input[i]);
            minCost = Math.min(minCost, currentCost);
            cityCost[i] = minCost;
        }

        int currentIndex = 0;
        long cost = 0;

        /**
         * 어디서 기름을 풀 매수하는게 좋을까?
         * -> 자기보다 싼데가 나오기전까지 풀매수
         */

        while (currentIndex < cityCount - 1) {
            int nextIndex = currentIndex + 1;
            long currentCost = cityCost[currentIndex] * cityDistance[nextIndex];
            cost += currentCost;
            currentIndex++;
        }

        System.out.print(cost);
    }
}
