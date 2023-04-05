package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ1092 {

    static int[] cranes;
    static int N;
    static int M;

    static int result = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // 입력
        cranes = new int[N];
        for (int i = 0; i < N; i++) {
            cranes[i] = sc.nextInt();
        }

        M = sc.nextInt();
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            input.add(sc.nextInt());
        }

        // 정렬
        Arrays.sort(cranes);
        input.sort(Integer::compareTo);

        // 예외 케이스
        if (cranes[N - 1] < input.get(M - 1)) {
            System.out.print(-1);
            return;
        }

        Boxes boxes = new Boxes(input);
        int min = 0;

        // 포크레인 큰 순에서 자기가 지울 수 있는 가장 큰 박스부터 제거
        // 포크레인이 제거 못한다면 해당 포크레인 빼버리기 (min = i + 1)
        while (!boxes.isEmpty()) {
            for (int i = N-1; i >= min; i--) {
                if (!boxes.removeMax(cranes[i])) {
                    min = i + 1;
                }
            }
            result++;
        }
        System.out.print(result);

    }

    static class Boxes{
        List<Integer> boxes;

        public Boxes(List<Integer> boxes) {
            this.boxes = boxes;
        }

        public boolean removeMax(int craneWeight) {
            for (int i = boxes.size() - 1; i >= 0; i--) {
                Integer boxWeight = boxes.get(i);
                if (boxWeight <= craneWeight) {
                    return boxes.remove(boxWeight);
                }
            }
            return false;
        }

        public boolean isEmpty() {
            return boxes.isEmpty();
        }
    }
}
