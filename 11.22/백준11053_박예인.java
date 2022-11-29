import java.util.*;
import java.io.*;

public class Q11053_가장긴증가하는부분수열 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 int []input = new int [n+1];
		 for(int i=0; i<n; i++)
			 input[i] = sc.nextInt();
		 int [] dp = new int [n+1];
		 
		 int max=1;
		 dp[1]=1;
		 for(int i=2; i<n+1; i++) {
			 dp[i]=1;
			 for(int j=1; j<i; j++) {
				if(input[i]>input[j]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
				max=Math.max(max, dp[i]);
			 }
		 }
		 System.out.println(max);
		
		 
	}
}
