import java.util.Scanner;

public class 백준1904 {
	public static int[] dp = new int[1000001];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		int ans = check(N);
		System.out.println(ans);
	}
	public static int check(int N) {
		if(dp[N] == 0 && N > 0) {
			dp[N] = (check(N - 1) + check((N - 2))) % 15746;
		}
		return dp[N];
	}
}
	
