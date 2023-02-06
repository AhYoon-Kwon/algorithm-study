import java.io.*;

public class BOJ_17425 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long dp [] = new long [1000001];
		for(int i=1; i<1000001; i++) {
			for(int j=1; i*j<1000001; j++) {
				dp[i*j]+=i;
			}
			dp[i]=dp[i]+dp[i-1];
		}
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=0; tc<TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append("\n");
		}
		System.out.print(sb.toString());
	}

}
