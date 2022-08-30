package Gold;

import java.util.Scanner;

public class 백준17406_박예인 {
	static int N, M, K, result;
	static int[][] map, copy;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		map = new int[N + 1][M + 1];
		copy = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
				copy[i][j] = map[i][j];
			}
		} // endOfMap

		int[][] rotation = new int[K][];
		// 아이디어 : 가장 왼쪽 위부터 가장 오른쪽 아래 그리고 다시 왼쪽 위까지를 list에 담고
		// 돌린 것처럼 +1 해서 다시 집어넣음
		// 다음 가장 왼쪽 위 x+1 y+1한 값과 오른쪽 아래 -1 -1 한 값을 가지고 다시 list 저장해서 돌림
		for (int i = 0; i < K; i++) {
			rotation[i] = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() };
		}
		visited = new boolean[K];

		rotate(rotation);

	}// endOfMain

	public static int rotate(int[][] rotation) {

		dfs(0, rotation, map);

		return result;
	}// endOfRotate

	public static void dfs(int cnt, int[][] rotation, int[][] map) {
		if (cnt == K) {
			result = Math.min(result, getMin(map));
		}
		
		 for(int i = 0; i < rotation.length; i++){
	            if(!visited[i]){
	            
	                int[] op = rotation[i];
	                int r = op[0], c = op[1], s = op[2];
	                int dr = r - s, dc = c - s;
	                int fr = r + s, fc = c + s;
	                
	            }
	        }
	}// endOfDfs

	//최소값을 나타내는 row 가져오깅
	private static int getMin(int[][] board) {
		int max = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += board[i][j];
			}
			max = Math.min(max, sum);
		}
		return max;
	}// endOfGetMin

}// endOfClass
