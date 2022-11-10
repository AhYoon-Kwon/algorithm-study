import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준7562_유동윤 {

	static boolean[][] map;
	static int cnt, n, sR, sC, eR, eC;

	static public class pos {
		int r, c;

		public pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			n = sc.nextInt();
			cnt = 0;
			map = new boolean[n][n];
			sR = sc.nextInt();
			sC = sc.nextInt();
			eR = sc.nextInt();
			eC = sc.nextInt();
			bfs(new pos(sR, sC));
			System.out.println(cnt);
		}
	}// main

	static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2 };

	static public void bfs(pos pos) {
		Queue<pos> q = new LinkedList<>();
		q.add(pos);
		map[pos.r][pos.c] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				pos curr = q.poll();
				if (curr.r == eR && curr.c == eC) {
					return;
				}
				for (int j = 0; j < 8; j++) {
					int nr = curr.r + dr[j];
					int nc = curr.c + dc[j];
					if (nr < 0 || nc < 0 || nr >= n || nc >= n)
						continue;
					if (!map[nr][nc]) {
						map[nr][nc] = true;
						q.add(new pos(nr, nc));
					}
				}

			} // size
			cnt++;
		}
	}

}
