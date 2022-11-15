import java.util.*;

public class 백준1904_김민지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int [] dp = new int [num+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2; i<num+1; i++)
			dp[i]=(dp[i-1]+dp[i-2])%15746;
		System.out.println(dp[num]);
	}
}
