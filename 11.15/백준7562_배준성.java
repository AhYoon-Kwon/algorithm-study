import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준7562 {
	static int[][] map;
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			map = new int[301][301];
			
			int l = sc.nextInt();
//			나이트 위치
			int nx = sc.nextInt();
			int ny = sc.nextInt();
//			목표 위치
			int desx = sc.nextInt();
			int desy = sc.nextInt();
			
			bfs(nx, ny, desx, desy, l);
			
			System.out.println(ans);
		}
	}
	public static void bfs(int nx, int ny, int desx, int desy, int l) {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] init = {nx, ny};
		q.add(init);
		map[nx][ny] = 1;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			if(p[0] == desx && p[1] == desy)break;
			
			for(int i = 0; i < 8; i++) {
				int x = p[0] + dx[i];
				int y = p[1] + dy[i];
				
				if(0 <= x && x < l && 0 <= y && y < l && (map[x][y] == 0 || map[p[0]][p[1]] + 1 < map[x][y])) {
					map[x][y] = map[p[0]][p[1]] + 1;
					int[] next = {x, y};
					q.add(next);
				}
			}
		}
		ans = map[desx][desy]-1;
	}
}
