import java.util.*;
import java.io.*;

public class Main {
	
	static int target;
	static boolean[] check;
	static int[] num;
	static LinkedList<Integer> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		num = new int[n+1];
		check = new boolean[n+1];
		for (int i=1; i<=n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		list = new LinkedList<Integer>();
		for (int i=1; i<=n; i++) {
			check[i] = true;
			target = i;
			dfs(target);
			check[i] =false;
		}
		Collections.sort(list);
		
		sb.append(list.size()).append('\n');
		
		for (int x : list) {
			sb.append(x+"\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int x) {

		int a = num[x];
		
		if (!check[a]) {
			check[a] = true;
			dfs(a);
			check[a] = false;
		}
		
		if (num[x] == target)
			list.add(target);
		
	}
}
