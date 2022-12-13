import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int n, m, max;
	static int[] dx = {-1, 0, 0, 1, -1, -1, 1, 1};
	static int[] dy = {0, -1, 1, 0, -1, 1, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		LinkedList<Node> list = new LinkedList<>();

		map = new int[n][m];
		visited = new boolean[n][m];

		// 결과 초기화
		max = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int a = Integer.parseInt(st.nextToken());
				// 1이면 list에 추가
				if (a == 1) {
					list.add(new Node(i, j, 0));
				}
				map[i][j] = a;
			}
		}

		bfs(list);

		System.out.println(max);
	}

	public static void bfs(LinkedList<Node> list) {
		Queue<Node> q = new LinkedList<>();
		// list에 있는 모든 node를 queue에 추가
		for (Node m : list) {
			q.add(new Node(m.x, m.y, 0));
			visited[m.x][m.y] = true;
		}
		
		while (!q.isEmpty()) {
			Node nd = q.poll();
			
			for (int i = 0; i < 8; i++) {
								
				int dr = nd.x + dx[i];
				int dc = nd.y + dy[i];

				if (!(dr < n && dc < m && dr >= 0 && dc >= 0) || visited[dr][dc] == true)
					continue;

				visited[dr][dc] = true;

				q.add(new Node(dr, dc, nd.level + 1));

				max = Math.max(max, nd.level + 1);
			}
		}
	}

	public static class Node {
		int x;
		int y;
		int level;

		Node(int x, int y, int level) {
			this.x = x;
			this.y = y;
			this.level = level;
		}
	}
}
