import java.io.*;
import java.util.*;

class Node {
	int x;
	int y;
	int level;
	
	Node(int x, int y, int level){
		this.x = x;
		this.y = y;
		this.level = level;
	}
}

public class Main {

	static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
	static int n;
	static int[] target;
	static boolean[][] visited;
  
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t<tc; t++) {
			n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			visited = new boolean[n][n];
			String[] str = br.readLine().split(" ");
			int[] start = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
			str = br.readLine().split(" ");
			target = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
			if (start[0] == target[0] && start[1] == target[1])
				{System.out.println(0);
				continue;}
			System.out.println(bfs(start[0], start[1]));
			
		}
	}

	private static int bfs(int x, int y) {
  
		Queue<Node> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new Node(x,y,0));
		while (!q.isEmpty()) {
			Node nd = q.poll();
			for (int i=0; i<8; i++) {
				int dr = dx[i] + nd.x;
				int dc = dy[i] + nd.y;
				if (dr < 0 || dc<0 || dr >= n || dc >= n || visited[dr][dc]) {
					continue;
				}
				if (dr == target[0] && dc == target[1])
					return nd.level+1;
				visited[dr][dc] = true;
				q.add(new Node(dr,dc,nd.level+1));
			}
		}
		return -1;
	}
	
	
}
