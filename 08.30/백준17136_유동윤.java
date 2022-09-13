import java.util.Arrays;
import java.util.Scanner;

//색종이를 5짜리부터 하나씩 덮어보자
//반례 : 큰걸로 먼저 덮는다고 무조건 좋은게 아니다!!
// -> 5개부터 붙혔다가 땠다가 하자.

public class 백준17136_유동윤 {

	static int[][] map;
	// 색종이 배열
	static int[] paper = {0, 5, 5, 5, 5, 5 };
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(0, 0, 0);
		if (result == Integer.MAX_VALUE)
			result = -1;
		System.out.println(result);
		
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}

	}// main

	// dfs
	static public void dfs(int row, int col, int cnt) {
		// 끝났다.
		if (row >= 9 && col > 9) {
			result = Math.min(result, cnt);
			return;
		}
			

		// 백트래킹
		if (cnt >= result)
			return;

		// 아래 줄로 이동.
		if (col > 9) {
			dfs(row + 1, 0, cnt);
			return;
		}

		// 재귀
		if (map[row][col] == 1) {
			// 5짜리부터 붙혀봄
			for (int i = 5; i >= 1; i--) {
				if (paper[i] > 0 && canPut(row, col, i)) {
//					System.out.println(i+"짜리 붙혀보자");
					// i짜리 붙히기
					putOnOff(row, col, i, 0);
					paper[i]--;
					dfs(row, col + 1, cnt + 1);
					// i짜리 때기
					putOnOff(row, col, i, 1);
					paper[i]++;
				}
			}
		} else { // 오른쪽으로 이동.
			dfs(row, col + 1, cnt);
		}

	}

	// 색종이 붙히고 때기
	static public void putOnOff(int row, int col, int size, int condition) {
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				map[i][j] = condition;
			}
		}
	}

	// 붙힐수 있나 확인하기
	static public boolean canPut(int row, int col, int size) {
		boolean flag = true;
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (i > 9 || j > 9 || map[i][j] != 1) {
					flag = false;
					return flag;
				}
			}
		}
		return flag;
	}

}
