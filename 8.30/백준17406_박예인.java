package Gold;

import java.util.Scanner;

public class ����17406_�ڿ��� {
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
		// ���̵�� : ���� ���� ������ ���� ������ �Ʒ� �׸��� �ٽ� ���� �������� list�� ���
		// ���� ��ó�� +1 �ؼ� �ٽ� �������
		// ���� ���� ���� �� x+1 y+1�� ���� ������ �Ʒ� -1 -1 �� ���� ������ �ٽ� list �����ؼ� ����
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

	//�ּҰ��� ��Ÿ���� row ��������
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
