import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] dp = new int[41];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 40; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        int result = 1;
        if(M != 0) {
            int[] arr = new int[41];

            int prev = sc.nextInt();
            arr[prev - 1]++;
            for (int i = 1; i < M; i++) {
                int cur = sc.nextInt();
                arr[cur - prev - 1]++;
                prev = cur;
            }
            arr[N - prev]++;


            for (int i = 1; i <= 40; i++) {
                if (arr[i] != 0)
                    result *= Math.pow(dp[i], arr[i]);
            }
        }
        else
            result = dp[N];

        System.out.println(result);

    }
}
