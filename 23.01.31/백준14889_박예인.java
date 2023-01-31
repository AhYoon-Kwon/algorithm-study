import java.io.*;
import java.util.*;
public class Main {
	static int n, min;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		arr = new int[n][n];
		visited = new boolean[n];
		
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; st.hasMoreTokens(); j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		
		System.out.println(min);
	}
	//조합짜기
	public static void dfs(int count, int i) {
		if (count == n/2) {
			func();
			return;
		}
		
		for (int a = i; a<n; a++) {
			visited[a] = true;
			dfs(count+1, a+1);
			visited[a] = false;
		}
	}
	
	//계산하기
	public static void func() {
		int start = 0;
		int link = 0;
		for(int i = 0 ; i < n-1 ; i++) {
			for(int j = i+1 ; j < n ; j++) {
				if(visited[i]==true && visited[j]==true) {
					start += arr[i][j];
					start += arr[j][i];
				}
				else if(visited[i]==false && visited[j]==false) {
					link += arr[i][j];
					link += arr[j][i];
				}
			}
		}
		
		int val = Math.abs(start - link);
		
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		min=Math.min(min,val);
	}
}
