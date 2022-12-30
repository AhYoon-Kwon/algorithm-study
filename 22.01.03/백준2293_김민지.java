import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [] dp = new int [k+1];
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			for (int j=1; j<k+1; j++) {
		        if (j-x>0) {
		          dp[j]=dp[j]+dp[j-x];
		        } else if (j==x){
		          dp[j]++;
		        }
		      }
		}
			
		System.out.println(dp[k]);
	}

}
