import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ1092 {

    /**
     * 1092: 배
     * N < 50 (크레인 수)
     * CRANE_WEIGHT < 1_000_000
     * M < 10_000 (박스 수)
     * BOX_WEIGHT < 1_000_000
     */

    private static int N;
    private static int M;
    private static List<Integer> cranes = new ArrayList<>();
    private static List<Integer> containers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int craneValue = scanner.nextInt();
            cranes.add(craneValue);
        }

        M = scanner.nextInt();
        for (int i = 0; i < M; i++) {
            int containerValue = scanner.nextInt();
            containers.add(containerValue);
        }

        cranes.sort(Comparator.reverseOrder());
        containers.sort(Comparator.reverseOrder());

        if (containers.get(0) > cranes.get(0)) {
            System.out.println(-1);
            return;
        }

        int ans = 0;

        while (!containers.isEmpty()) {
            int containerIndex = 0;
            int craneIndex = 0;

            while (craneIndex < N) {
                if (cranes.get(craneIndex) >= containers.get(containerIndex)) {
                    containers.remove(containerIndex);
                    craneIndex++;

                } else {
                    containerIndex++;
                }

                if (containerIndex == containers.size()) {
                    break;
                }
            }
            ans++;
        }
        System.out.println(ans);
    }
}
