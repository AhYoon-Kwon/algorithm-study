package Gold;

import java.util.*;
import java.io.*;

public class Q13549_숨바꼭질3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		boolean visited[] = new boolean[100001];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(n,0));
		
		while (!q.isEmpty()) {
			Node nd = q.poll();
			visited[nd.x] = true;
			if (nd.x == m) {
				System.out.println(nd.level);
				return;
			}
			if (nd.x * 2 <= 100000 && !visited[nd.x*2])
				q.add(new Node(nd.x * 2, nd.level));
			if (nd.x -1 >= 0 && !visited[nd.x-1])
				q.add(new Node(nd.x -1, nd.level+1));
			if (nd.x + 1 <= 100000 && !visited[nd.x+1])
				q.add(new Node(nd.x + 1, nd.level+1));
		}
	}
	
	public static class Node{
		int x;
		int level;
		
		Node(int x, int level){
			this.x = x;
			this.level = level;
		}
	}
}
