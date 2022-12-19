import java.util.*;
import java.io.*;

public class Main {
	static int n, k, ans;
	static boolean[] used;
	static int[] kit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		kit = new int[n];
		used= new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		ans = 0 ;
		dfs(0,500);
		System.out.println(ans);
		br.close();
		
	}
	static void dfs(int depth, int sum) {
		if (depth == n) {
			ans++;
			return;
		}
		
		for (int i=0; i<n; i++) {
			if (!used[i] && (sum + kit[i] -k ) >= 500) {
				used[i] = true;
				dfs(depth+1, sum + kit[i] - k);
				used[i] = false;
			}
		}
	}
}
