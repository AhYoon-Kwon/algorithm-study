import java.io.*;
import java.util.*;

public class Main {

	static int[] parent;
	static boolean[] knowing;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		knowing = new boolean[51];
		
		parent = new int[n+1];
		int total = 0;
		
		//초기화
		for (int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		
		//진실을 아는 사람들 저장
		for (int i=0; i<a; i++) {
			int test = Integer.parseInt(st.nextToken());
			knowing[test] = true;
		}
		
		// 진실을 아는 사람들 입력 받음
		ArrayList<Integer>[] pt = new ArrayList[m];
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			pt[i] = new ArrayList<>();
			
			int num = Integer.parseInt(st.nextToken());
			int pre = Integer.parseInt(st.nextToken());
			pt[i].add(pre);
			for (int j=0; j<num-1; j++) {
				int nt = Integer.parseInt(st.nextToken());
				union(pre, nt);
				pt[i].add(nt);
				pre = nt;
			}
		}
		//받아둔 애들 돌면서 1아닌 애들 구하기
		
		for (int i=0; i<m; i++) {
			if (pt[i].size() > 0) {
				if (!knowing[find(pt[i].get(0))]) {
					total++;
				} 
			}	
		}
		
		System.out.println(total);
		
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}

	static void union (int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			if (knowing[x] == true) {
				parent[y] = x;
				knowing[y] = true;
			}
			else if (knowing[y] == true) {
				parent[x] = y;
				knowing[x] = true;
			} else
				parent[y] = x;
		}
	}
	
}
