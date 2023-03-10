import java.util.Scanner;

public class Question1182 {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int s = sc.nextInt();
    static int[] arr = new int[n];
    static int cnt = 0;

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0, 0);
        if (s == 0) {
            cnt--;
        }
        System.out.println(cnt);


    }

    public static void dfs(int index, int sum) {
        if (index == n) {
            if (sum == s) {
                cnt++;
            }
            return;
        }
        dfs(index + 1, sum + arr[index]);
        dfs(index + 1, sum);
    }
}
