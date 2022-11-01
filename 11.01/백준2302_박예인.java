import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2302_극장좌석 {
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i=3; i<=N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		int mul = 1;
		int cnt; 
		int pre = 0;
		for (int i =0; i<m; i++) {
			cnt = Integer.parseInt(br.readLine());
			mul *= dp[cnt - pre-1];
			pre = cnt;
		}
		if (N==m) 
			System.out.println(mul);
		else
			System.out.println(mul * dp[N-pre]);
			
	}
}
