import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Question1920 {

    static int n;
    static List<Integer> numberBox = new ArrayList<>();
    static int m;
    static List<Integer> targetNumbers = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        n = sc.nextInt();
        while (n-- > 0) {
            numberBox.add(sc.nextInt());
        }
        m = sc.nextInt();
        while (m-- > 0) {
            targetNumbers.add(sc.nextInt());
        }

        Collections.sort(numberBox);

        for (Integer targetNumber : targetNumbers) {
            boolean result = bSearch(numberBox, targetNumber);
            if (result) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }
    }

    public static boolean bSearch(List<Integer> numberBox, int n) {
        int left = 0;
        int right = numberBox.size() - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (numberBox.get(mid) < n) {
                left = mid + 1;
            } else if (numberBox.get(mid) > n) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
