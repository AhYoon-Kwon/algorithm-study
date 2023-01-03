import java.util.Scanner;

public class Main {
    static int[] op = new int[4]; // + - * /
    static int[] arr;
    static int N, min, max;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        N = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        for(int i = 0; i < 4; i++)
            op[i] = sc.nextInt();

        dfs(arr[0], 1);

        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int n, int idx) {
        if(idx == N) {
            max = Math.max(max, n);
            min = Math.min(min, n);
            return;
        }

        for(int i = 0; i  < 4; i++) {
            if(op[i] != 0) {
                op[i]--;
                switch (i) {
                    case 0 : dfs(n + arr[idx], idx + 1); break;
                    case 1 : dfs(n - arr[idx], idx + 1); break;
                    case 2 : dfs(n * arr[idx], idx + 1); break;
                    case 3 : dfs(n / arr[idx], idx + 1); break;
                }
                op[i]++;
            }
        }

    }
}
